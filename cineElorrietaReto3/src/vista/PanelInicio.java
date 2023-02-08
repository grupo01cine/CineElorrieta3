package vista;

import bbdd.pojos.Cliente;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class panelInicio {
	
	private ArrayList<Cliente> clientes;

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					panelInicio window = new panelInicio();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public panelInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelInicio = new JPanel();
		panelInicio.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelInicio);
		panelInicio.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(51, 99, 220, 185);
		textField.setText("Logo");
		textField.setColumns(10);
		panelInicio.add(textField);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistro registro = new panelRegistro(clientes);
				registro.setVisible(true);
			}
		});
		btnRegistro.setBounds(445, 11, 148, 42);
		panelInicio.add(btnRegistro);
		
		JLabel lblCinesElorrieta = new JLabel("Cines Elorrieta");
		lblCinesElorrieta.setBounds(356, 115, 153, 31);
		lblCinesElorrieta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCinesElorrieta.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 28));
		panelInicio.add(lblCinesElorrieta);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSeleccionCine cines = new panelSeleccionCine();
				cines.setVisible(true);
			}
		});
		btnIniciar.setBounds(338, 170, 190, 68);
		panelInicio.add(btnIniciar);
	}
}
