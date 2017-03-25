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

public class BackEnd {

	private Socket s = null; 
	private   int serverPort = 6880;
	private   String ip = "localhost";
	private final String saludo = "ZUPP";
	private final String archivos = "ARCHIVOS";
	private String donwloadDirectory ;

	public BackEnd ()
	{
		  File directory = new File(".");
		  try {
			donwloadDirectory = directory.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public boolean conectar() {
		boolean exito = true;
		  		  try{ 
				 
		  		  s = new Socket(ip, serverPort); 

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


	public void solicitarArchivo(String aPedir) 
	{

try
{

		
		 	 DataInputStream input = new DataInputStream( s.getInputStream()); 
		  DataOutputStream output = new DataOutputStream( s.getOutputStream()); 
		  
			  //Step 1 
			  System.out.println("Writing.......");
			  output.writeUTF(aPedir);
			  int tamanio = input.readInt();
		      System.out.println("LONGITUD: " +tamanio);
			  byte[] contents = new byte[tamanio];
		        
			
	            
		        //Initialize the FileOutputStream to the output file's full path.
		        FileOutputStream fos = new FileOutputStream(donwloadDirectory + "/"+aPedir);
		        BufferedOutputStream bos = new BufferedOutputStream(fos);
		        InputStream is = s.getInputStream();
		        
		        //No of bytes read in one read() call
		        int bytesRead = 0; 
		        
		        while((bytesRead=is.read(contents))!=-1)
		        	System.out.println("Paquete recibido" + bytesRead);
		            bos.write(contents, 0, bytesRead); 
		        
		        bos.flush(); 
			  
		
	} 
catch(Exception e)
{
	e.printStackTrace();
}
	}
	
				
	
	
	public String pedirArchivos()
	{
		  String archivosDisponibles = "";	
try
{

		
		 	 DataInputStream input = new DataInputStream( s.getInputStream()); 
		  DataOutputStream output = new DataOutputStream( s.getOutputStream()); 
		  
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
				  output.writeBytes(archivos); // UTF is a string encoding
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
	             
			  DataOutputStream output = new DataOutputStream( s.getOutputStream()); 
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


}

