package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class panelRegistroUsuario {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panelRegistroUsuario window = new panelRegistroUsuario();
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
	public panelRegistroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelRegistroUsuario = new JPanel();
		panelRegistroUsuario.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelRegistroUsuario);
		panelRegistroUsuario.setLayout(null);
		
		JLabel lblRegistroUsuario = new JLabel("Resgistro de usuario");
		lblRegistroUsuario.setBounds(227, 34, 165, 14);
		panelRegistroUsuario.add(lblRegistroUsuario);
		
		JLabel lblDniRegistro = new JLabel("DNI:");
		lblDniRegistro.setBounds(106, 93, 119, 14);
		panelRegistroUsuario.add(lblDniRegistro);
		
		JLabel lblNombreRegistro = new JLabel("Nombre:");
		lblNombreRegistro.setBounds(106, 118, 127, 14);
		panelRegistroUsuario.add(lblNombreRegistro);
		
		JLabel lblApellido1Registro = new JLabel("Apellido 1:");
		lblApellido1Registro.setBounds(104, 143, 119, 14);
		panelRegistroUsuario.add(lblApellido1Registro);
		
		JLabel lblApellido2Registro = new JLabel("Apellido 2:");
		lblApellido2Registro.setBounds(104, 168, 119, 14);
		panelRegistroUsuario.add(lblApellido2Registro);
		
		JLabel lblSexoRegistro = new JLabel("Sexo:");
		lblSexoRegistro.setBounds(106, 193, 127, 14);
		panelRegistroUsuario.add(lblSexoRegistro);
		
		JLabel lblContrasenaRegistro = new JLabel("Contraseña:");
		lblContrasenaRegistro.setBounds(106, 218, 119, 14);
		panelRegistroUsuario.add(lblContrasenaRegistro);
		
		textField = new JTextField();
		textField.setBounds(233, 90, 183, 20);
		panelRegistroUsuario.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 115, 183, 20);
		panelRegistroUsuario.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(233, 140, 183, 20);
		panelRegistroUsuario.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(233, 165, 183, 20);
		panelRegistroUsuario.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(233, 215, 183, 20);
		panelRegistroUsuario.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(233, 189, 183, 22);
		panelRegistroUsuario.add(comboBox);
		
		JButton btnAceptarRegistro = new JButton("Aceptar");
		btnAceptarRegistro.setBounds(200, 271, 89, 23);
		panelRegistroUsuario.add(btnAceptarRegistro);
		
		JButton btnCancelarRegistro = new JButton("Cancelar");
		btnCancelarRegistro.setBounds(350, 271, 89, 23);
		panelRegistroUsuario.add(btnCancelarRegistro);
	}

}
