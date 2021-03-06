package FabulosoBackEnd;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class BackEnd {

	private Socket s = null; 
	private   int serverPort = 6880;
	private   String ip = "localhost";
	private final String saludo = "ZUPP";
	private final String archivos = "ARCHIVOS";
	private String donwloadDirectory ;
	private   DataInputStream input;
	private  DataOutputStream output ;
	private ArrayList<String> misarchivos;
	private boolean pausa;
	private 		        FileOutputStream fos;
	private   BufferedOutputStream bos ;
	private   byte[] contents ;
	private InputStream is;
	private String arch;
	
private ThreadRecepcionArchivo superThread;
	
	public BackEnd ()
	{
		  File directory = new File(".");
		  misarchivos = new ArrayList<String>();
		  pausa = false;
		  try {
			donwloadDirectory = directory.getCanonicalPath() ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public boolean conectar() {
		boolean exito = true;
		  		  try{ 
				 
		  		  s = new Socket(ip, serverPort); 
		  		input = new DataInputStream( s.getInputStream()); 
		  		output = new DataOutputStream( s.getOutputStream()); 

		}
		catch (Exception e){ 
			System.out.println("Sock:"+e.getMessage());
			exito = false;
			if (s != null)
			{
			  try {s.close();
			  } 
			  catch (IOException x) {/*close failed*/}
			}
}
				  return exito;

		}
	public void iniciarArchivo(String aPedir)
	{
		  try {
				 System.out.println("Writing.......");
				 arch= aPedir;
			output.writeUTF("ARCHIVO:"+aPedir);
			  int tamanio = input.readInt();
		      System.out.println("LONGITUD: " +tamanio);
			  contents = new byte[tamanio];
			     //Initialize the FileOutputStream to the output file's full path.
		         fos = new FileOutputStream(donwloadDirectory + "/"+aPedir);
		         bos = new BufferedOutputStream(fos);
		         is = s.getInputStream();
			  		superThread = new ThreadRecepcionArchivo(fos, bos, contents, is, output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}


	public void solicitarArchivo() 
	{
		  Thread t = new Thread(superThread);
          t.start();
	}
	
				
	
	
	public String pedirArchivos()
	{
		  String archivosDisponibles = "";	
try
{

		
		  
			  //Step 1 
			
		      System.out.println("Writing.......");
			 // output.writeBytes(saludo); // UTF is a string encoding

			  output.writeUTF(saludo);
			  output.flush();


			  String salDevueta = input.readUTF();
		      System.out.println("RECIBO: " +salDevueta);

			  if (salDevueta.equals("ZUPP"))
			  {
				  // Ya estoy hablando con el servidor
				  output.writeUTF(archivos); // UTF is a string encoding
				   archivosDisponibles = input.readUTF();
				  System.out.println("Received: "+ archivosDisponibles ); 
			  }
			  
			  
			
		  }
catch(Exception e)
{
	e.printStackTrace();
}
return archivosDisponibles;
		 
	}


	public  boolean estaVivo()
	  { 
	      boolean disponible = true; 
		  try {  
	             
			  output.writeUTF("VIVE");
			  output.flush();

	           
	          } 
	      catch (Exception e) 
	          {   disponible = false;
				if (s != null)
				{
				  try {s.close();
				  } 
				  catch (IOException x) {/*close failed*/}
				}
			  
			  
	          } 


	      return disponible;   
	  }
public ArrayList <String> getMisarchivos()
{
return misarchivos;	
}
public void pausar()
{
	superThread.pausar();	
}
public void despausar()
{
	superThread.despausar();	
}
public String darRuta()
{
	return  donwloadDirectory;
}
}

