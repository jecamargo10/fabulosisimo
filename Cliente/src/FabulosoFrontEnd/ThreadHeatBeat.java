package FabulosoFrontEnd;

import FabulosoBackEnd.BackEnd;

public class ThreadHeatBeat implements Runnable {
	
	private BackEnd mundo;
	private Principal ppal;
	public ThreadHeatBeat (BackEnd pMundo, Principal pPpal)
	{
		mundo = pMundo;
				ppal = pPpal;
	}
	
	
	@Override
    public void run() {
       
		while(true){
		try{
			boolean algo  =	mundo.estaVivo();

			
		Thread.sleep(3000); 
		//sleep for 3 seconds

		if (!algo)
		{
			ppal.lblNoConectado.setText("No conectado");

			
		}
		else
		{
			ppal.lblNoConectado.setText("Conectado");

			 
		}
			//print something else here
			}
			catch(InterruptedException e){   
				System.out.println("Error repeticion");
			}
		}
		
              }

}
