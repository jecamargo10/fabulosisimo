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
					JOptionPane.showMessageDialog(frame, "No ha sido posible la conexion exitosamente");


					
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
		panel_3.setBounds(0, 24, 308, 79);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 1, 0, 0));
		
		 lbl1ArchivoRecibir = new JLabel("");
		panel_3.add(lbl1ArchivoRecibir);
		
		JLabel lbl2ArchivoRecibir = new JLabel("");
		panel_3.add(lbl2ArchivoRecibir);
		
		JLabel lbl3ArchivoRecibir = new JLabel("");
		panel_3.add(lbl3ArchivoRecibir);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		panel_4.setBackground(Color.PINK);
		panel_4.setBounds(0, 102, 308, 26);
		panel.add(panel_4);
		
		JLabel lblMisArchivos = new JLabel("Mis archivos");
		lblMisArchivos.setForeground(Color.WHITE);
		panel_4.add(lblMisArchivos);
		
		JPanel panel_6 = new JPanel();
		panel_6.setForeground(Color.WHITE);
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		panel_6.setBackground(Color.PINK);
		panel_6.setBounds(309, 0, 154, 26);
		panel.add(panel_6);
		
		JLabel lblConexin = new JLabel("Conexi\u00F3n");
		lblConexin.setForeground(Color.WHITE);
		panel_6.add(lblConexin);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBackground(Color.PINK);
		panel_7.setBounds(0, 128, 308, 79);
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblmisarchivos1 = new JLabel("");
		panel_7.add(lblmisarchivos1);
		
		JLabel lblmisarchivos2 = new JLabel("");
		panel_7.add(lblmisarchivos2);
		
		JLabel lblmisarchivos3 = new JLabel("");
		panel_7.add(lblmisarchivos3);
		
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
			}
		});
		btnNewButton.setBounds(186, 21, 89, 23);
		panel_5.add(btnNewButton);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBackground(Color.PINK);
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniciar.setBounds(312, 21, 89, 23);
		panel_5.add(btnIniciar);
		
		JButton btnRefrescar = new JButton("Pedir Archivo");
		btnRefrescar.setBounds(26, 21, 127, 22);
		panel_5.add(btnRefrescar);
		btnRefrescar.setBackground(Color.PINK);
		btnRefrescar.setForeground(Color.WHITE);
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		        String aPedir= JOptionPane.showInputDialog("Ingrese el nombre del archivo a descargar");
		        
System.out.println(aPedir);
String papitas [] = archivos.split(";");
for (int i = 0; i < papitas.length; i++) {
	String archivo [] = papitas[i].split(",");
	if(archivo[0].toLowerCase().startsWith(aPedir))
	{
		aPedir=archivo[0];
		break;
	}
	
}
mundo.solicitarArchivo(aPedir);
		
		 
			}
		});
		JButton btnArchivosDisponibles = new JButton("Archivos Disponibles");

		btnArchivosDisponibles.setForeground(Color.WHITE);
		btnArchivosDisponibles.setBackground(Color.PINK);
		btnArchivosDisponibles.setBounds(0, 135, 154, 22);
		panel_1.add(btnArchivosDisponibles);
		btnArchivosDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				  archivos =		mundo.pedirArchivos();
					 String papitas [] = archivos.split(";");
					 for (int i = 0; i < papitas.length; i++) {
						String archivo [] = papitas[i].split(",");
						lblMisArchivos.setText("Nombre: " + archivo[0] + "Peso: " + archivo[1]);
						
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
