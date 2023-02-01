package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class panelInicioSesion {

	private JFrame frame;
	private JTextField textFieldUsuarioInicioSesion;
	private JTextField textFieldContrasenaInicioSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panelInicioSesion window = new panelInicioSesion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public panelInicioSesion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelInicioSesion = new JPanel();
		panelInicioSesion.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelInicioSesion);
		panelInicioSesion.setLayout(null);
		
		JLabel lblInicioSesion = new JLabel("Inicio de sesión");
		lblInicioSesion.setBounds(250, 66, 133, 14);
		panelInicioSesion.add(lblInicioSesion);
		
		JLabel lblUsuarioInicioSesion = new JLabel("Usuario:");
		lblUsuarioInicioSesion.setBounds(154, 121, 109, 14);
		panelInicioSesion.add(lblUsuarioInicioSesion);
		
		JLabel lblContrasenaInicioSesion = new JLabel("Contraseña:");
		lblContrasenaInicioSesion.setBounds(154, 165, 109, 14);
		panelInicioSesion.add(lblContrasenaInicioSesion);
		
		textFieldUsuarioInicioSesion = new JTextField();
		textFieldUsuarioInicioSesion.setBounds(250, 118, 171, 20);
		panelInicioSesion.add(textFieldUsuarioInicioSesion);
		textFieldUsuarioInicioSesion.setColumns(10);
		
		textFieldContrasenaInicioSesion = new JTextField();
		textFieldContrasenaInicioSesion.setBounds(250, 162, 171, 20);
		panelInicioSesion.add(textFieldContrasenaInicioSesion);
		textFieldContrasenaInicioSesion.setColumns(10);
		
		JButton btnAceptarInicioSesion = new JButton("Aceptar");
		btnAceptarInicioSesion.setBounds(204, 245, 89, 23);
		panelInicioSesion.add(btnAceptarInicioSesion);
		
		JButton btnCancelarInicioSesion = new JButton("Cancelar");
		btnCancelarInicioSesion.setBounds(346, 245, 89, 23);
		panelInicioSesion.add(btnCancelarInicioSesion);
	}

}
