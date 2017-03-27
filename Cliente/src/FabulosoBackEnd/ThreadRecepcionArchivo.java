package FabulosoBackEnd;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ThreadRecepcionArchivo  implements Runnable {

	private 		        FileOutputStream fos;
	private   BufferedOutputStream bos ;
	private   byte[] contents ;
	private InputStream is;
	private  DataOutputStream output ;
	private boolean pausa;
	private boolean cumpli;
	public ThreadRecepcionArchivo ( FileOutputStream pfos,BufferedOutputStream pbos, byte[] pcontents,InputStream pis,DataOutputStream poutput)
	{
		pausa =false;
		fos=pfos;
		bos=pbos ;
		contents=pcontents ;
		is=pis;
		output =poutput ;
		cumpli = false;
		
		
	}
	
	public void pausar()
	{
		
		pausa=true;
	}
	public void despausar()
	{
		
		pausa=false;
	}
	

	@Override
    public void run() {
       
	
		try
		{


				 //No of bytes read in one read() call
				        int bytesRead = 0; 
				        int valorRead = 0;
				        while(valorRead != -1 && !pausa )
				        {

				        	output.writeUTF("NEXT_PACKAGE");
							
							valorRead=(	bytesRead=is.read(contents));

				        	System.out.println("Paquete recibido: " + bytesRead);
				            bos.write(contents, 0, bytesRead); 
				            
				    
				        }
			
				        bos.flush(); 
				        
				        
				 
				
			} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
		
              }

	
}
