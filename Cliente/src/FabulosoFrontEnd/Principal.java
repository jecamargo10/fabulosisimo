package FabulosoFrontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import FabulosoBackEnd.BackEnd;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class Principal {

	private BackEnd mundo;
	private JFrame frame;


	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		mundo = new BackEnd();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Cutes Client Ever");

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(309, 24, 125, 183);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstado.setBounds(0, 32, 46, 14);
		panel_1.add(lblEstado);
		
		JLabel lblNoConectado = new JLabel("No conectado");
		lblNoConectado.setForeground(Color.WHITE);
		lblNoConectado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNoConectado.setBounds(44, 32, 81, 14);
		panel_1.add(lblNoConectado);
		
		JButton btnRefrescar = new JButton("Refrescar");
		btnRefrescar.setBackground(Color.PINK);
		btnRefrescar.setForeground(Color.WHITE);
		btnRefrescar.setBounds(10, 134, 105, 22);
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(btnRefrescar);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setBackground(Color.PINK);
		btnConectar.setForeground(Color.WHITE);
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		btnConectar.setBounds(10, 82, 105, 22);
		panel_1.add(btnConectar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(Color.PINK);
		panel_2.setBounds(0, 0, 308, 26);
		panel.add(panel_2);
		
		JLabel lblFileToReceive = new JLabel("Archivo a recibir");
		lblFileToReceive.setForeground(Color.WHITE);
		panel_2.add(lblFileToReceive);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(Color.PINK);
		panel_3.setBounds(0, 24, 308, 79);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBackground(Color.PINK);
		panel_4.setBounds(0, 102, 308, 26);
		panel.add(panel_4);
		
		JLabel lblMisArchivos = new JLabel("Mis archivos");
		lblMisArchivos.setForeground(Color.WHITE);
		panel_4.add(lblMisArchivos);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBackground(Color.PINK);
		panel_6.setBounds(309, 0, 125, 22);
		panel.add(panel_6);
		
		JLabel lblConexin = new JLabel("Conexi\u00F3n");
		lblConexin.setForeground(Color.WHITE);
		panel_6.add(lblConexin);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBackground(Color.PINK);
		panel_7.setBounds(0, 128, 308, 79);
		panel.add(panel_7);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBackground(Color.PINK);
		panel_5.setBounds(0, 206, 434, 55);
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
		btnNewButton.setBounds(99, 21, 89, 23);
		panel_5.add(btnNewButton);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBackground(Color.PINK);
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniciar.setBounds(234, 21, 89, 23);
		panel_5.add(btnIniciar);
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
