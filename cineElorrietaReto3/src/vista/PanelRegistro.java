package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bbdd.pojos.Cliente;
import controlador.GestorUsuarios;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

public class PanelRegistro extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textFieldDNI;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JComboBox<String> comboBoxSexo;
	private JTextField textFieldPasswd;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PanelRegistro(ArrayList<Cliente> clientes) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 632, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroUsuario = new JLabel("Resgistro de usuario");
		lblRegistroUsuario.setBounds(227, 34, 165, 14);
		contentPane.add(lblRegistroUsuario);
		
		JLabel lblDniRegistro = new JLabel("DNI:");
		lblDniRegistro.setBounds(106, 93, 119, 14);
		contentPane.add(lblDniRegistro);
		
		JLabel lblNombreRegistro = new JLabel("Nombre:");
		lblNombreRegistro.setBounds(106, 118, 127, 14);
		contentPane.add(lblNombreRegistro);
		
		JLabel lblApellidoRegistro = new JLabel("Apellido:");
		lblApellidoRegistro.setBounds(104, 143, 119, 14);
		contentPane.add(lblApellidoRegistro);
		
		JLabel lblSexoRegistro = new JLabel("Sexo:");
		lblSexoRegistro.setBounds(106, 168, 127, 14);
		contentPane.add(lblSexoRegistro);
		
		JLabel lblContrasenaRegistro = new JLabel("Contraseña:");
		lblContrasenaRegistro.setBounds(106, 193, 119, 14);
		contentPane.add(lblContrasenaRegistro);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(233, 90, 183, 20);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(233, 115, 183, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(233, 140, 183, 20);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldPasswd = new JPasswordField();
		textFieldPasswd.setBounds(233, 190, 183, 20);
		contentPane.add(textFieldPasswd);
		
		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setBounds(233, 164, 183, 22);
		contentPane.add(comboBoxSexo);
		comboBoxSexo.addItem("Hombre");
		comboBoxSexo.addItem("Mujer");
		
		JButton btnAceptarRegistro = new JButton("Aceptar");
		btnAceptarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				Aquí puedo controlar si ya existe el usuario
				Cliente cliente = generarNuevoCliente();
				
				GestorUsuarios gestor = new GestorUsuarios();
				gestor.registroUsuario(cliente);
				
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnAceptarRegistro.setBounds(200, 271, 89, 23);
		contentPane.add(btnAceptarRegistro);
		
		JButton btnCancelarRegistro = new JButton("Cancelar");
		btnCancelarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnCancelarRegistro.setBounds(350, 271, 89, 23);
		contentPane.add(btnCancelarRegistro);
		
		
	}
	
	private Cliente generarNuevoCliente() {
		Cliente nuevoCliente = new Cliente();
		nuevoCliente.setCodigo(0);
		nuevoCliente.setNombre(textFieldDNI.getText());
		nuevoCliente.setApellido(textFieldApellido.getText());
		String sexo = (String) comboBoxSexo.getSelectedItem();
		nuevoCliente.setSexo(sexo);
		String contrasena = String.valueOf(((JPasswordField) textFieldPasswd).getPassword());
		nuevoCliente.setPasswd(contrasena);
		return nuevoCliente;
	}
}
