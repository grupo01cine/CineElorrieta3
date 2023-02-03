package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bbdd.pojos.Cliente;
import controlador.GestorUsuarios;

public class panelLogin extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnAceptarInicioSesion;
	private JButton btnCancelarInicioSesion;
	private JPasswordField textFieldContrasenaInicioSesion;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public panelLogin(ArrayList<Cliente> clientes) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 632, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInicioSesion = new JLabel("Inicio de sesión");
		lblInicioSesion.setBounds(250, 66, 133, 14);
		contentPane.add(lblInicioSesion);
		
		JLabel lblUsuarioInicioSesion = new JLabel("DNI:");
		lblUsuarioInicioSesion.setBounds(154, 121, 109, 14);
		contentPane.add(lblUsuarioInicioSesion);
		
		JLabel lblContrasenaInicioSesion = new JLabel("Contraseña:");
		lblContrasenaInicioSesion.setBounds(154, 165, 109, 14);
		contentPane.add(lblContrasenaInicioSesion);
		
		JTextField textFieldUsuarioInicioSesion = new JTextField();
		textFieldUsuarioInicioSesion.setBounds(250, 118, 171, 20);
		contentPane.add(textFieldUsuarioInicioSesion);
		textFieldUsuarioInicioSesion.setColumns(10);
		
		textFieldContrasenaInicioSesion = new JPasswordField();
		textFieldContrasenaInicioSesion.setBounds(250, 162, 171, 20);
		contentPane.add(textFieldContrasenaInicioSesion);
		
		btnAceptarInicioSesion = new JButton("Aceptar");
		btnAceptarInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorUsuarios gestor = new GestorUsuarios();
				String contrasena = String.valueOf(textFieldContrasenaInicioSesion.getPassword());
				gestor.loginUsuario(clientes, textFieldUsuarioInicioSesion.getText(), contrasena);
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnAceptarInicioSesion.setBounds(204, 245, 89, 23);
		contentPane.add(btnAceptarInicioSesion);
		
		btnCancelarInicioSesion = new JButton("Cancelar");
		btnCancelarInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnCancelarInicioSesion.setBounds(346, 245, 89, 23);
		contentPane.add(btnCancelarInicioSesion);
	}
}
