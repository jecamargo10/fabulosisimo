package FabulosoFrontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import FabulosoBackEnd.BackEnd;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;

public class Principal {

	private BackEnd mundo;
	private JFrame frame;
	public JLabel lblNoConectado ;
	public JLabel lbl1ArchivoRecibir ;
public String archivos;
	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		mundo = new BackEnd();
		
		boolean estadoInicial = mundo.conectar();
		if (estadoInicial)
		{
			lblNoConectado.setText("Conectado");
			//lbl1ArchivoRecibir.setText( mundo.pedirArchivos());
		}
		

		   ThreadHeatBeat papitas = new ThreadHeatBeat(mundo,this);
           Thread t = new Thread(papitas);
           t.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 479, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Cutes Client Ever");

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(309, 24, 154, 183);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstado.setBounds(19, 25, 46, 14);
		panel_1.add(lblEstado);
		
		 lblNoConectado = new JLabel("No conectado");
		lblNoConectado.setForeground(Color.WHITE);
		lblNoConectado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNoConectado.setBounds(63, 25, 81, 14);
		panel_1.add(lblNoConectado);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setBackground(Color.PINK);
		btnConectar.setForeground(Color.WHITE);
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean exito = mundo.conectar();
				if(exito)
				{
					lblNoConectado.setText("Conectado");
					JOptionPane.showMessageDialog(frame, "Se ha conectado exitosamente");

				}
				else
				{
					lblNoConectado.setText("No conectado");
					JOptionPane.showMessageDialog(frame, "No ha sido posible la conexion");


					
				}
				
			}
		});
		
		
		btnConectar.setBounds(27, 71, 105, 22);
		panel_1.add(btnConectar);
		

		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		panel_2.setBackground(Color.PINK);
		panel_2.setBounds(0, 0, 308, 26);
		panel.add(panel_2);
		
		JLabel lblFileToReceive = new JLabel("Archivo a recibir");
		lblFileToReceive.setForeground(Color.WHITE);
		panel_2.add(lblFileToReceive);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		panel_3.setBackground(Color.PINK);
		panel_3.setBounds(0, 24, 308, 183);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 1, 0, 0));
		
		 lbl1ArchivoRecibir = new JLabel("");
		panel_3.add(lbl1ArchivoRecibir);
		
		JLabel lbl2ArchivoRecibir = new JLabel("");
		panel_3.add(lbl2ArchivoRecibir);
		
		JLabel lbl3ArchivoRecibir = new JLabel("");
		panel_3.add(lbl3ArchivoRecibir);
		
		JPanel panel_6 = new JPanel();
		panel_6.setForeground(Color.WHITE);
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		panel_6.setBackground(Color.PINK);
		panel_6.setBounds(309, 0, 154, 26);
		panel.add(panel_6);
		
		JLabel lblConexin = new JLabel("Conexi\u00F3n");
		lblConexin.setForeground(Color.WHITE);
		panel_6.add(lblConexin);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBackground(Color.PINK);
		panel_5.setBounds(0, 206, 463, 73);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblOpcionesArchivo = new JLabel("Opciones archivo");
		lblOpcionesArchivo.setForeground(Color.WHITE);
		lblOpcionesArchivo.setBounds(0, 0, 109, 14);
		panel_5.add(lblOpcionesArchivo);
		
		JButton btnNewButton = new JButton("Pausar");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mundo.pausar();
			}
		});
		btnNewButton.setBounds(146, 21, 89, 23);
		panel_5.add(btnNewButton);
		
		JButton btnIniciar = new JButton("Reanudar");
		btnIniciar.setBackground(Color.PINK);
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mundo.despausar();
				mundo.solicitarArchivo();
			}
		});
		btnIniciar.setBounds(235, 21, 89, 23);
		panel_5.add(btnIniciar);
		
		JButton btnRefrescar = new JButton("Pedir Archivos");
		btnRefrescar.setBounds(10, 21, 126, 22);
		panel_5.add(btnRefrescar);
		btnRefrescar.setBackground(Color.PINK);
		btnRefrescar.setForeground(Color.WHITE);
		
		JButton btnVerRespositorio = new JButton("Ver respositorio");
		btnVerRespositorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ruta = mundo.darRuta();
				ruta += "\\src"	;
				try {
					System.out.println(ruta);
					Runtime.getRuntime().exec("explorer.exe /select," + ruta);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnVerRespositorio.setForeground(Color.WHITE);
		btnVerRespositorio.setBackground(Color.PINK);
		btnVerRespositorio.setBounds(334, 21, 126, 23);
		panel_5.add(btnVerRespositorio);
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		        String aPedir= JOptionPane.showInputDialog("Ingrese el nombre del archivo a descargar");
System.out.println(aPedir);
String papitas [] = archivos.split(";");
for (int i = 0; i < papitas.length; i++) {
	String archivo [] = papitas[i].split(",");
    System.out.println("ARCHIVO:"+archivo[0]);

	if(archivo[0].toLowerCase().startsWith(aPedir.toLowerCase()))
	{
		aPedir=archivo[0];
		break;
	}
	
}
mundo.iniciarArchivo(aPedir);
mundo.solicitarArchivo();
		
		 
			}
		});
		JButton btnArchivosDisponibles = new JButton("Archivos Disponibles");

		btnArchivosDisponibles.setForeground(Color.WHITE);
		btnArchivosDisponibles.setBackground(Color.PINK);
		btnArchivosDisponibles.setBounds(0, 134, 154, 22);
		panel_1.add(btnArchivosDisponibles);
		btnArchivosDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				  archivos =		mundo.pedirArchivos();
					 String papitas [] = archivos.split(";");
					 if (papitas.length == 3)
					 {
							String archivo [] = papitas[0].split(",");
							String archivos [] = papitas[1].split(",");
							String archivus [] = papitas[2].split(",");

							lbl1ArchivoRecibir.setText("<html>Nombre: " + archivo[0] + " Peso: " + archivo[1] +"</html>");
							lbl2ArchivoRecibir.setText("<html>Nombre: " + archivos[0] + " Peso: " + archivos[1] +"</html>");
							lbl3ArchivoRecibir.setText("<html>Nombre: " + archivus[0] + " Peso: " + archivus[1] +"</html>");

					 }
					 else if (papitas.length == 2)
					 {
							String archivo [] = papitas[0].split(",");
							String archivos [] = papitas[1].split(",");

							lbl1ArchivoRecibir.setText("<html>Nombre: " + archivo[0] + " Peso: " + archivo[1] +"</html>");
							lbl2ArchivoRecibir.setText("<html>Nombre: " + archivos[0] + " Peso: " + archivos[1] +"</html>");

					 }
					 else
					 {
						 String archivo [] = papitas[0].split(",");
							lbl1ArchivoRecibir.setText("<html>Nombre: " + archivo[0] + " Peso: " + archivo[1] +"</html>");
					 }
				
			}
		});
		
	}
	

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
