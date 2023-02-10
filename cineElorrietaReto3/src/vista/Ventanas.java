package vista;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import bbdd.pojos.Cine;
import bbdd.pojos.Pelicula;
import bbdd.pojos.Proyeccion;
import controlador.GestorBasesDeDatos;
import controlador.GestorUsuarios;

public class Ventanas {

	private String cineSeleccionado=null;
	private ArrayList<Cine> cines = null;

	
	public JFrame frame;
	public JPanel panelInicio;
	public JPanel panelSeleccionCine;
	public JPanel panelSeleccionPelicula;
	public JPanel panelSeleccionSesion;
	public JPanel panelResumenCompra;
	public JPanel panelRegistro;
	public JPanel panelLogin;
	private JTable tablePeliculas;
	private JComboBox<String> comboBoxCines;
	private JComboBox<Date> comboBoxFechas;
	private JTable tableSesiones;



	/**
	 * Create the application.
	 */
	public Ventanas() {
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
		
//		Panel Inicio
		panelInicio = new JPanel();
		panelInicio.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelInicio);
		panelInicio.setLayout(null);
		
		JTextField textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(51, 99, 220, 185);
		textField.setText("Logo");
		textField.setColumns(10);
		panelInicio.add(textField);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelInicio.setVisible(false);
				panelRegistro.setVisible(true);
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
				panelInicio.setVisible(false);
				panelSeleccionCine.setVisible(true);
			}
		});
		btnIniciar.setBounds(338, 170, 190, 68);
		panelInicio.add(btnIniciar);
		
//		panel Seleccion Cine
		panelSeleccionCine = new JPanel();
		panelSeleccionCine.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelSeleccionCine);
		panelSeleccionCine.setLayout(null);
		panelSeleccionCine.setVisible(false);
		
		Label labelSeleccionCine = new Label("Seleccione un cine...");
		labelSeleccionCine.setBounds(57, 102, 202, 22);
		panelSeleccionCine.add(labelSeleccionCine);
		
		comboBoxCines = new JComboBox<String>();
		comboBoxCines.setBounds(265, 102, 246, 22);
		panelSeleccionCine.add(comboBoxCines);
		GestorBasesDeDatos gestorbbdd= new GestorBasesDeDatos();
		cines = gestorbbdd.sacarTodosLosCines();
		for(int i=0; i<cines.size();i++) {
			String nombre = cines.get(i).getNombre();
			comboBoxCines.addItem(nombre);
		}
		
		JButton btnAceptarSeleccionCine = new JButton("Aceptar");
		btnAceptarSeleccionCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorBasesDeDatos gestorbbdd= new GestorBasesDeDatos();
				cineSeleccionado = (String) comboBoxCines.getSelectedItem();
				ArrayList<Pelicula> peliculas= gestorbbdd.sacarTodasLasPeliculas(cineSeleccionado);
		
				//Creación de la tabla de películas por cine (en panel PELICULA)
				tablePeliculas.removeAll();
				DefaultTableModel model = (DefaultTableModel) tablePeliculas.getModel();
				model.setRowCount(0);
				for (int i = 0; i < peliculas.size(); i++) {
					Pelicula pelicula = peliculas.get(i);
					String titulo = pelicula.getTitulo();

					model.addRow(new String[] { titulo });
				}
				
				panelSeleccionCine.setVisible(false);
				panelSeleccionPelicula.setVisible(true);
			}
		});
		btnAceptarSeleccionCine.setBounds(94, 208, 188, 23);
		panelSeleccionCine.add(btnAceptarSeleccionCine);
		
		JButton btnFinalizarCompra = new JButton("Finalizar compra");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSeleccionCine.setVisible(false);
				panelResumenCompra.setVisible(true);
			}
		});
		btnFinalizarCompra.setBounds(323, 208, 188, 23);
		panelSeleccionCine.add(btnFinalizarCompra);
		
//		Panel Selección Pelicula
		panelSeleccionPelicula = new JPanel();
		panelSeleccionPelicula.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelSeleccionPelicula);
		panelSeleccionPelicula.setLayout(null);
		panelSeleccionPelicula.setVisible(false);
		
		JLabel lblSeleccionPelicula = new JLabel("Seleccione una película...");
		lblSeleccionPelicula.setBounds(47, 34, 180, 14);
		panelSeleccionPelicula.add(lblSeleccionPelicula);
		
		JButton btnAceptarSeleccionPelicula = new JButton("Aceptar");
		btnAceptarSeleccionPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sacamos las fechas de la peli seleccionada en el cine seleccionado
				GestorBasesDeDatos gestorbbdd= new GestorBasesDeDatos();
				String pelicula = (String) tablePeliculas.getValueAt(tablePeliculas.getSelectedRow(), tablePeliculas.getSelectedColumn());
				ArrayList<Proyeccion> proyecciones = gestorbbdd.sacarTodasLasFechas(cineSeleccionado, pelicula);
				
				for(int i=0; i<proyecciones.size();i++) {
					Date fecha = proyecciones.get(i).getFecha();
					comboBoxFechas.addItem(fecha);
				}
				
				panelSeleccionPelicula.setVisible(false);
				panelSeleccionSesion.setVisible(true);
			}
		});
		btnAceptarSeleccionPelicula.setBounds(172, 270, 130, 23);
		panelSeleccionPelicula.add(btnAceptarSeleccionPelicula);
		
		JButton btnCancelarSeleccionPelicula = new JButton("Cancelar");
		btnCancelarSeleccionPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				GestorVentanas ventanas = new GestorVentanas();
//				mostrarPanelSeleccionCine();
				
				panelSeleccionPelicula.setVisible(false);
				panelSeleccionCine.setVisible(true);
			}
		});
		btnCancelarSeleccionPelicula.setBounds(346, 270, 142, 23);
		panelSeleccionPelicula.add(btnCancelarSeleccionPelicula);
		
		tablePeliculas = new JTable();
		tablePeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePeliculas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo"
			}
		));
		tablePeliculas.setBounds(47, 64, 531, 160);
		panelSeleccionPelicula.add(tablePeliculas);

//		Panel Seleccion Sesion
		panelSeleccionSesion = new JPanel();
		panelSeleccionSesion.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelSeleccionSesion);
		panelSeleccionSesion.setLayout(null);
		panelSeleccionSesion.setVisible(false);
		
		JLabel lblSesiones = new JLabel("Seleccione una sesión...");
		lblSesiones.setBounds(236, 18, 179, 14);
		panelSeleccionSesion.add(lblSesiones);
		
		tableSesiones = new JTable();
		tableSesiones.setBounds(236, 43, 370, 227);
		panelSeleccionSesion.add(tableSesiones);
		
		JButton btnAceptarSesion = new JButton("Aceptar");
		btnAceptarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnAceptarSesion, "Ha seleccionado la película -meter título o info-", "Confirmación", 1);
//				GestorVentanas ventanas = new GestorVentanas();
//				mostrarPanelSeleccionCine();
				
				panelSeleccionSesion.setVisible(false);
				panelSeleccionCine.setVisible(true);
			}
		});
		btnAceptarSesion.setBounds(211, 287, 89, 23);
		panelSeleccionSesion.add(btnAceptarSesion);
		
		JButton btnSesion = new JButton("Cancelar");
		btnSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				GestorVentanas ventanas = new GestorVentanas();
//				mostrarPanelSeleccionPelicula();
				
				panelSeleccionSesion.setVisible(false);
				panelSeleccionPelicula.setVisible(true);
			}
		});
		btnSesion.setBounds(350, 287, 89, 23);
		panelSeleccionSesion.add(btnSesion);
		
		JLabel lblElegirFecha = new JLabel("Seleccione una fecha:");
		lblElegirFecha.setBounds(10, 107, 190, 14);
		panelSeleccionSesion.add(lblElegirFecha);
		
		comboBoxFechas = new JComboBox<Date>();
		comboBoxFechas.setBounds(10, 132, 190, 22);
		panelSeleccionSesion.add(comboBoxFechas);
		
		JButton btnConfirmarFecha = new JButton("Confirmar");
		btnConfirmarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Select select = new Select();
				//Creamos la tabla de sesiones disponibles para el cine y peli elegidas en la fecha seleccionada
//				String pelicula = (String) tablePeliculas.getValueAt(tablePeliculas.getSelectedRow(), tablePeliculas.getSelectedColumn());
//				ArrayList <Proyeccion> = select.getAllProyecciones(cineSeleccionado, pelicula);
				
				
				
			}
		});
		btnConfirmarFecha.setBounds(42, 175, 119, 23);
		panelSeleccionSesion.add(btnConfirmarFecha);
		
//		Panel Resumen Compra
		panelResumenCompra = new JPanel();
		panelResumenCompra.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelResumenCompra);
		panelResumenCompra.setLayout(null);
		panelResumenCompra.setVisible(false);
		
		JLabel lblResumenCompra = new JLabel("Resumen de compra");
		lblResumenCompra.setBounds(238, 23, 179, 14);
		panelResumenCompra.add(lblResumenCompra);
		
		JTable tableResumen = new JTable();
		tableResumen.setBounds(10, 43, 596, 154);
		panelResumenCompra.add(tableResumen);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(412, 208, 73, 14);
		panelResumenCompra.add(lblTotal);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(412, 233, 73, 14);
		panelResumenCompra.add(lblDescuento);
		
		JLabel lblPrecioTotal = new JLabel("Precio total:");
		lblPrecioTotal.setBounds(412, 258, 73, 14);
		panelResumenCompra.add(lblPrecioTotal);
		
		JButton btnComprarResumen = new JButton("Finalizar compra");
		btnComprarResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				GestorVentanas ventanas = new GestorVentanas();
//				mostrarPanelLogin();
				
				panelResumenCompra.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		btnComprarResumen.setBounds(150, 287, 150, 23);
		panelResumenCompra.add(btnComprarResumen);
		
		JButton btnCancelarResumen = new JButton("Cancelar");
		btnCancelarResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				GestorVentanas ventanas = new GestorVentanas();
//				mostrarPanelInicio();
				
				panelResumenCompra.setVisible(false);
				panelInicio.setVisible(true);
			}
		});
		btnCancelarResumen.setBounds(350, 287, 150, 23);
		panelResumenCompra.add(btnCancelarResumen);
		
		JTextField textFieldTotal = new JTextField();
		textFieldTotal.setEditable(false);
		textFieldTotal.setBounds(495, 208, 86, 20);
		panelResumenCompra.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		JTextField textFieldDescuento = new JTextField();
		textFieldDescuento.setEditable(false);
		textFieldDescuento.setBounds(495, 230, 86, 20);
		panelResumenCompra.add(textFieldDescuento);
		textFieldDescuento.setColumns(10);
		
		JTextField textFieldPrecioTotal = new JTextField();
		textFieldPrecioTotal.setEditable(false);
		textFieldPrecioTotal.setBounds(495, 255, 86, 20);
		panelResumenCompra.add(textFieldPrecioTotal);
		textFieldPrecioTotal.setColumns(10);
		
//		Panel Registro
		panelRegistro = new JPanel();
		panelRegistro.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelRegistro);
		panelRegistro.setLayout(null);
		panelRegistro.setVisible(false);
		
		JLabel lblRegistroUsuario = new JLabel("Resgistro de usuario");
		lblRegistroUsuario.setBounds(227, 34, 165, 14);
		panelRegistro.add(lblRegistroUsuario);
		
		JLabel lblDniRegistro = new JLabel("DNI:");
		lblDniRegistro.setBounds(106, 93, 119, 14);
		panelRegistro.add(lblDniRegistro);
		
		JLabel lblNombreRegistro = new JLabel("Nombre:");
		lblNombreRegistro.setBounds(106, 118, 127, 14);
		panelRegistro.add(lblNombreRegistro);
		
		JLabel lblApellidoRegistro = new JLabel("Apellido:");
		lblApellidoRegistro.setBounds(104, 143, 119, 14);
		panelRegistro.add(lblApellidoRegistro);
		
		JLabel lblSexoRegistro = new JLabel("Sexo:");
		lblSexoRegistro.setBounds(106, 168, 127, 14);
		panelRegistro.add(lblSexoRegistro);
		
		JLabel lblContrasenaRegistro = new JLabel("Contraseña:");
		lblContrasenaRegistro.setBounds(106, 193, 119, 14);
		panelRegistro.add(lblContrasenaRegistro);
		
		JTextField textFieldDNI = new JTextField();
		textFieldDNI.setBounds(233, 90, 183, 20);
		panelRegistro.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JTextField textFieldNombre = new JTextField();
		textFieldNombre.setBounds(233, 115, 183, 20);
		panelRegistro.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JTextField textFieldApellido = new JTextField();
		textFieldApellido.setBounds(233, 140, 183, 20);
		panelRegistro.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JPasswordField textFieldPasswd = new JPasswordField();
		textFieldPasswd.setBounds(233, 190, 183, 20);
		panelRegistro.add(textFieldPasswd);
		
		JComboBox<String> comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setBounds(233, 164, 183, 22);
		panelRegistro.add(comboBoxSexo);
		comboBoxSexo.addItem("Hombre");
		comboBoxSexo.addItem("Mujer");
		comboBoxSexo.addItem("Otro");
		
		JButton btnAceptarRegistro = new JButton("Aceptar");
		btnAceptarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Aquí puedo controlar si ya existe el usuario
//				Cliente cliente = generarNuevoCliente();
//				GestorUsuarios gestor = new GestorUsuarios();
//				gestor.registroUsuario(cliente);
				JOptionPane.showMessageDialog(btnAceptarRegistro, "Usuario creado correctamente", "Confirmación", 1);
//				GestorVentanas ventanas = new GestorVentanas();
//				mostrarPanelInicio();
				
				panelRegistro.setVisible(false);
				panelInicio.setVisible(true);
			}
		});
		btnAceptarRegistro.setBounds(200, 271, 89, 23);
		panelRegistro.add(btnAceptarRegistro);
		
		JButton btnCancelarRegistro = new JButton("Cancelar");
		btnCancelarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				GestorVentanas ventanas = new GestorVentanas();
//				mostrarPanelInicio();
				
				panelRegistro.setVisible(false);
				panelInicio.setVisible(true);
			}
		});
		btnCancelarRegistro.setBounds(350, 271, 89, 23);
		panelRegistro.add(btnCancelarRegistro);
		
//		Panel Login
		panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		panelLogin.setVisible(false);
		
		JLabel lblInicioSesion = new JLabel("Inicio de sesión");
		lblInicioSesion.setBounds(250, 66, 133, 14);
		panelLogin.add(lblInicioSesion);
		
		JLabel lblUsuarioInicioSesion = new JLabel("DNI:");
		lblUsuarioInicioSesion.setBounds(154, 121, 109, 14);
		panelLogin.add(lblUsuarioInicioSesion);
		
		JLabel lblContrasenaInicioSesion = new JLabel("Contraseña:");
		lblContrasenaInicioSesion.setBounds(154, 165, 109, 14);
		panelLogin.add(lblContrasenaInicioSesion);
		
		JTextField textFieldUsuarioInicioSesion = new JTextField();
		textFieldUsuarioInicioSesion.setBounds(250, 118, 171, 20);
		panelLogin.add(textFieldUsuarioInicioSesion);
		textFieldUsuarioInicioSesion.setColumns(10);
		
		JPasswordField textFieldContrasenaInicioSesion = new JPasswordField();
		textFieldContrasenaInicioSesion.setBounds(250, 162, 171, 20);
		panelLogin.add(textFieldContrasenaInicioSesion);
		
		JButton btnAceptarInicioSesion = new JButton("Aceptar");
		btnAceptarInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorUsuarios gestor = new GestorUsuarios();
				String contrasena = String.valueOf(textFieldContrasenaInicioSesion.getPassword());
//				gestor.loginUsuario( textFieldUsuarioInicioSesion.getText(), contrasena);
				
				JOptionPane.showMessageDialog(btnAceptarRegistro, "Crear joption de desea finalizar la compra??? y el resto de cosas que piden", "Confirmación", 1);
			}
		});
		btnAceptarInicioSesion.setBounds(204, 245, 89, 23);
		panelLogin.add(btnAceptarInicioSesion);
		
		JButton btnCancelarInicioSesion = new JButton("Cancelar");
		btnCancelarInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				GestorVentanas ventanas = new GestorVentanas();
//				mostrarPanelInicio();
				
				panelLogin.setVisible(false);
				panelInicio.setVisible(true);
			}
		});
		btnCancelarInicioSesion.setBounds(346, 245, 89, 23);
		panelLogin.add(btnCancelarInicioSesion);
		
		
	}
	
//	private Cliente generarNuevoCliente() {
//		Cliente nuevoCliente = new Cliente();
//		nuevoCliente.setCodigo(0);
//		nuevoCliente.setNombre(textFieldDNI.getText());
//		nuevoCliente.setApellido(textFieldApellido.getText());
//		String sexo = (String) comboBoxSexo.getSelectedItem();
//		nuevoCliente.setSexo(sexo.charAt(0));
//		String contrasena = String.valueOf(((JPasswordField) textFieldPasswd).getPassword());
//		nuevoCliente.setPasswd(contrasena);
//		return nuevoCliente;
//	}

}
