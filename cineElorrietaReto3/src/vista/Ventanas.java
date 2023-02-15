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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import bbdd.pojos.Cine;
import bbdd.pojos.Cliente;
import bbdd.pojos.Entrada;
import bbdd.pojos.Pelicula;
import bbdd.pojos.Proyeccion;
import controlador.GestorBasesDeDatos;
import controlador.GestorFicheros;
import controlador.GestorUsuarios;
import controlador.GestorVentanas;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Ventanas {
	
	private GestorUsuarios gestor=null;
	private GestorBasesDeDatos gestorbbdd=null;
	private GestorVentanas gestorventanas=null;

	private String peliculaSeleccionada = null;
	private String cineSeleccionado = null;
	private Date fechaSeleccionada = null;
	//private LocalTime horaSeleccionada = null;
	private ArrayList<Cine> cines = null;
	private Cliente cliente = null;
	private ArrayList<Proyeccion> proyeccionesSeleccionadas = null;

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
	private JTable tableResumen;
	
	private JLabel lblSesiones = null;			
	private JTextField textFieldTotal;
	private JTextField textFieldDescuento;
	private JTextField textFieldPrecioFinal;

	/**
	 * Create the application.
	 */
	public Ventanas() {
		gestor = new GestorUsuarios();
		gestorbbdd = new GestorBasesDeDatos();
		gestorventanas = new GestorVentanas();

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventanas.class.getResource("/img/logo.png")));
		frame.setBounds(100, 100, 632, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

//		Panel Inicio
		panelInicio = new JPanel();
		panelInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelInicio.setVisible(false);
				panelSeleccionCine.setVisible(true);
			}
		});
		panelInicio.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelInicio);
		panelInicio.setLayout(null);

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

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Ventanas.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(45, 61, 305, 279);
		panelInicio.add(lblNewLabel);

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
		cines = gestorbbdd.sacarTodosLosCines();
		for (int i = 0; i < cines.size(); i++) {
			String nombre = cines.get(i).getNombre();
			comboBoxCines.addItem(nombre);
		}

		JButton btnAceptarSeleccionCine = new JButton("Aceptar");
		btnAceptarSeleccionCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cineSeleccionado = (String) comboBoxCines.getSelectedItem();
				ArrayList<Pelicula> peliculas = gestorbbdd.sacarTodasLasPeliculas(cineSeleccionado);

				// Creación de la tabla de películas por cine (en panel PELICULA)
				DefaultTableModel model = (DefaultTableModel) tablePeliculas.getModel();
				model.setRowCount(0);
				for (int i = 0; i < peliculas.size(); i++) {
					Pelicula pelicula = peliculas.get(i);
					String titulo = pelicula.getTitulo();
					String duracion = pelicula.getDuracion().toString();

					model.addRow(new String[] { titulo, duracion });
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

				if (proyeccionesSeleccionadas == null) {
					  Thread t1 = new Thread(new Runnable() {
			                public void run() {
			                    try {
			                        Thread.sleep(2000);
			                    } catch (InterruptedException e) {
			                        e.printStackTrace();
			                    }               
			                    JOptionPane.getRootFrame().dispose();
			                }
			            });
			            t1.start();
			            JOptionPane.showOptionDialog(null, "No hay películas seleccionadas. Cerrando sesión...",""
								+ "Aviso", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
			            System.exit(0);
				} else {
					// Creamos la tabla resumen
					gestorventanas.vaciarTabla(tableResumen);

					tableResumen.setModel(
							new DefaultTableModel(new Object[][] {}, new String[] { "T\u00EDtulo", "Sesion", "Sala", "Precio" }));
					DefaultTableModel model = (DefaultTableModel) tableResumen.getModel();
					model.setRowCount(0);
					for (int i = 0; i < proyeccionesSeleccionadas.size(); i++) {
						Proyeccion proyeccion = proyeccionesSeleccionadas.get(i);
						String titulo = proyeccion.getPelicula().getTitulo();
						String horario = proyeccion.getHorario().toString();
						int salaPr = proyeccion.getSala().getCodigo();
						String precio = proyeccion.getPrecio().toString();

						model.addRow(new String[] { titulo, horario, Integer.toString(salaPr), precio });
						
						//Rellenamos PRECIO
						Double precioTotal = gestorventanas.sacarPrecioTotal(tableResumen);
						textFieldTotal.setText(precioTotal.toString());
						textFieldDescuento.setText(gestorventanas.sacarPorcentaje(tableResumen));
						textFieldPrecioFinal.setText(gestorventanas.sacarPrecioFinal(tableResumen).toString());

						panelSeleccionCine.setVisible(false);
						panelResumenCompra.setVisible(true);
					}

				}
			}
		});
		btnFinalizarCompra.setBounds(401, 25, 188, 23);
		panelSeleccionCine.add(btnFinalizarCompra);

		JButton btnCancelarSeleccionCine = new JButton("Cancelar");
		btnCancelarSeleccionCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente = null;
		    	proyeccionesSeleccionadas.clear();
				panelSeleccionCine.setVisible(false);
				panelInicio.setVisible(true);
			}
		});
		btnCancelarSeleccionCine.setBounds(341, 208, 188, 23);
		panelSeleccionCine.add(btnCancelarSeleccionCine);

//		Panel Selección Pelicula
		panelSeleccionPelicula = new JPanel();
		panelSeleccionPelicula.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelSeleccionPelicula);
		panelSeleccionPelicula.setLayout(null);
		panelSeleccionPelicula.setVisible(false);

		JLabel lblSeleccionPelicula = new JLabel("Seleccione una película...");
		lblSeleccionPelicula.setBounds(47, 62, 180, 14);
		panelSeleccionPelicula.add(lblSeleccionPelicula);

		JButton btnAceptarSeleccionPelicula = new JButton("Aceptar");
		btnAceptarSeleccionPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Sacamos las fechas de la peli seleccionada en el cine seleccionado
				int fila = tablePeliculas.getSelectedRow();
				peliculaSeleccionada = (String) tablePeliculas.getValueAt(fila, 0);
				ArrayList<Proyeccion> proyecciones = gestorbbdd.sacarTodasLasFechas(cineSeleccionado,
						peliculaSeleccionada);
				comboBoxFechas.removeAllItems();
				for (int i = 0; i < proyecciones.size(); i++) {
					Date fecha = proyecciones.get(i).getFecha();
					comboBoxFechas.addItem(fecha);
				}
				
				gestorventanas.vaciarTabla(tableSesiones);
				panelSeleccionPelicula.setVisible(false);
				lblSesiones.setText("Seleccione una sesión para la película '"+ peliculaSeleccionada +"'...");
				panelSeleccionSesion.setVisible(true);
			}
		});
		btnAceptarSeleccionPelicula.setBounds(172, 270, 130, 23);
		panelSeleccionPelicula.add(btnAceptarSeleccionPelicula);

		JButton btnCancelarSeleccionPelicula = new JButton("Cancelar");
		btnCancelarSeleccionPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelSeleccionPelicula.setVisible(false);
				panelSeleccionCine.setVisible(true);
			}
		});
		btnCancelarSeleccionPelicula.setBounds(346, 270, 142, 23);
		panelSeleccionPelicula.add(btnCancelarSeleccionPelicula);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(47, 87, 531, 160);
		panelSeleccionPelicula.add(scrollPane_1);

		tablePeliculas = new JTable();
		scrollPane_1.setViewportView(tablePeliculas);
		tablePeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePeliculas.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Titulo", "Duracion" }));

//		Panel Seleccion Sesion
		panelSeleccionSesion = new JPanel();
		panelSeleccionSesion.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelSeleccionSesion);
		panelSeleccionSesion.setLayout(null);
		panelSeleccionSesion.setVisible(false);

		lblSesiones = new JLabel();
		lblSesiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblSesiones.setBounds(10, 18, 596, 14);
		panelSeleccionSesion.add(lblSesiones);

		JButton btnAceptarSesion = new JButton("Aceptar");
		btnAceptarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = tableSesiones.getSelectedRow();
				String hora = (String) tableSesiones.getValueAt(fila, 0);
				JOptionPane.showMessageDialog(btnAceptarSesion, "Ha seleccionado la película " + peliculaSeleccionada
						+ " a fecha de " + fechaSeleccionada + " a las " + hora, "Confirmación", 1);				
				Proyeccion proyeccion = gestorbbdd.sacarResumen(peliculaSeleccionada, fechaSeleccionada, hora);
				if (null == proyeccionesSeleccionadas) {
					proyeccionesSeleccionadas = new ArrayList<Proyeccion>();
				}
				proyeccionesSeleccionadas.add(proyeccion);				
				
				panelSeleccionSesion.setVisible(false);
				panelSeleccionCine.setVisible(true);
				
			}
		});
		btnAceptarSesion.setBounds(211, 287, 89, 23);
		panelSeleccionSesion.add(btnAceptarSesion);

		JButton btnSesion = new JButton("Cancelar");
		btnSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				fechaSeleccionada = (Date) comboBoxFechas.getSelectedItem();
				ArrayList<Proyeccion> proyecciones = gestorbbdd.sacarTodasLasSesiones(cineSeleccionado,
						peliculaSeleccionada, fechaSeleccionada);

				// Creamos la tabla de sesiones disponibles para el cine y peli elegidas en la
				// fecha seleccionada				
				tableSesiones.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Horario", "Precio", "Sala" }));
				DefaultTableModel model = (DefaultTableModel) tableSesiones.getModel();
				model.setRowCount(0);
				for (int i = 0; i < proyecciones.size(); i++) {
					Proyeccion proyeccion = proyecciones.get(i);
					String horarioPr = proyeccion.getHorario().toString();
					int salaPr = proyeccion.getSala().getCodigo();
					String precioPr = proyeccion.getPrecio().toString();

					model.addRow(new String[] { horarioPr, precioPr, Integer.toString(salaPr) });
				}
			}
		});
		btnConfirmarFecha.setBounds(42, 175, 119, 23);
		panelSeleccionSesion.add(btnConfirmarFecha);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(236, 43, 370, 227);
		panelSeleccionSesion.add(scrollPane);

		tableSesiones = new JTable();
		scrollPane.setViewportView(tableSesiones);
		

//		Panel Resumen Compra
		panelResumenCompra = new JPanel();
		panelResumenCompra.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelResumenCompra);
		panelResumenCompra.setLayout(null);
		panelResumenCompra.setVisible(false);

		JLabel lblResumenCompra = new JLabel("Resumen de compra");
		lblResumenCompra.setBounds(238, 23, 179, 14);
		panelResumenCompra.add(lblResumenCompra);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(412, 208, 73, 14);
		panelResumenCompra.add(lblTotal);

		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(412, 233, 73, 14);
		panelResumenCompra.add(lblDescuento);

		JLabel lblPrecioFinal = new JLabel("Precio final:");
		lblPrecioFinal.setBounds(412, 258, 73, 14);
		panelResumenCompra.add(lblPrecioFinal);

		JButton btnComprarResumen = new JButton("Finalizar compra");
		btnComprarResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResumenCompra.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		btnComprarResumen.setBounds(150, 287, 150, 23);
		panelResumenCompra.add(btnComprarResumen);

		JButton btnCancelarResumen = new JButton("Cancelar");
		btnCancelarResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResumenCompra.setVisible(false);
				panelSeleccionCine.setVisible(true);
			}
		});
		btnCancelarResumen.setBounds(350, 287, 150, 23);
		panelResumenCompra.add(btnCancelarResumen);

		textFieldTotal = new JTextField();
		textFieldTotal.setEditable(false);
		textFieldTotal.setBounds(495, 208, 86, 20);
		panelResumenCompra.add(textFieldTotal);
		textFieldTotal.setColumns(10);

		textFieldDescuento = new JTextField();
		textFieldDescuento.setEditable(false);
		textFieldDescuento.setBounds(495, 230, 86, 20);
		panelResumenCompra.add(textFieldDescuento);
		textFieldDescuento.setColumns(10);

		textFieldPrecioFinal = new JTextField();
		textFieldPrecioFinal.setEditable(false);
		textFieldPrecioFinal.setBounds(495, 255, 86, 20);
		panelResumenCompra.add(textFieldPrecioFinal);
		textFieldPrecioFinal.setColumns(10);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(41, 48, 540, 144);
		panelResumenCompra.add(scrollPane_2);

		tableResumen = new JTable();
		tableResumen.setEnabled(false);
		scrollPane_2.setViewportView(tableResumen);
		

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
				// Creamos usuario
				String dni = textFieldDNI.getText();
				String nombre = textFieldNombre.getText();
				String apellido = textFieldApellido.getText();
				String sexo = (String) comboBoxSexo.getSelectedItem();
				String contrasena = String.valueOf(textFieldPasswd.getPassword());

				Cliente nuevoCliente = gestor.generarNuevoCliente(dni, nombre, apellido, sexo, contrasena);

				if (gestorbbdd.comprobarClienteExiste(nuevoCliente)) {
					// Comprobamos si el usuario ya existe
					JOptionPane.showMessageDialog(btnAceptarRegistro, "El usuario ya existe", "Aviso", 2);

					textFieldDNI.setText("");
					textFieldNombre.setText("");
					textFieldApellido.setText("");
					textFieldPasswd.setText("");

				} else {
					// Metemos al cliente en la BBDD
					gestorbbdd.insertarClienteBBDD(nuevoCliente);
					// Panel de confirmación
					JOptionPane.showMessageDialog(btnAceptarRegistro, "Usuario creado correctamente", "Confirmación",
							1);

					panelRegistro.setVisible(false);
					panelInicio.setVisible(true);
				}
			}
		});
		btnAceptarRegistro.setBounds(200, 271, 89, 23);
		panelRegistro.add(btnAceptarRegistro);

		JButton btnCancelarRegistro = new JButton("Cancelar");
		btnCancelarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
				String dni = textFieldUsuarioInicioSesion.getText();
				String contrasena = String.valueOf(textFieldContrasenaInicioSesion.getPassword());
				
				if(gestor.loginUsuario(dni, contrasena)==true) {
					int resp=JOptionPane.showConfirmDialog(btnAceptarInicioSesion,"¿Desea comprar las entradas?",  "Finalizar Compra", JOptionPane.YES_NO_OPTION, 1);
				      if (JOptionPane.OK_OPTION == resp){
//				    	  Sí compra las entradas; generamos entradas
				    	  ArrayList<Cliente> todosLosClientes = new ArrayList<Cliente>();
				    	  todosLosClientes = gestorbbdd.sacarTodosLosClientes();
				    	  
				    	  for(int i=0; i<todosLosClientes.size(); i++) {
				    		  if(dni.equalsIgnoreCase(todosLosClientes.get(i).getDni())) {
				    			  cliente = todosLosClientes.get(i);
				    			  
				    			  
				    		  }
				    	  }				    	  				    	  
				    	  gestorbbdd.insertarEntrada(cliente, proyeccionesSeleccionadas);
				    	  JOptionPane.showMessageDialog(null, "Compra realizada. ¡Muchas gracias!", "Confirmación", 1);
				    	  
				    	  GestorFicheros fich = new GestorFicheros();
				    	  ArrayList<Entrada> listaEntradas =  fich.sacarEntradas(cliente, proyeccionesSeleccionadas);
				    	  fich.crearNuevoTicket(listaEntradas);
				    	  
				    	  cliente = null;
				    	  proyeccionesSeleccionadas.clear();
				    	  
				    	  panelLogin.setVisible(false);
				          panelInicio.setVisible(true);
				      }
				      else{
//				    	  No compra las entradas
				    	  cliente = null;
				    	  proyeccionesSeleccionadas.clear();
				    	  
				    	  Thread t1 = new Thread(new Runnable() {
				                public void run() {
				                    try {
				                        Thread.sleep(2000);
				                    } catch (InterruptedException e) {
				                        e.printStackTrace();
				                    }               
				                    JOptionPane.getRootFrame().dispose();
				                }
				            });
				            t1.start();
				            JOptionPane.showOptionDialog(null, "Cerrando sesión...",""
									+ "Aviso", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
				            
				            panelLogin.setVisible(false);
				            panelInicio.setVisible(true);
				   }
				}else {
					JOptionPane.showMessageDialog(btnAceptarRegistro, "Usuario o contraseña incorrectos", "Error", 0);
				}
			}
		});
		btnAceptarInicioSesion.setBounds(204, 245, 89, 23);
		panelLogin.add(btnAceptarInicioSesion);

		JButton btnCancelarInicioSesion = new JButton("Cancelar");
		btnCancelarInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);
				panelInicio.setVisible(true);
			}
		});
		btnCancelarInicioSesion.setBounds(346, 245, 89, 23);
		panelLogin.add(btnCancelarInicioSesion);
		
		JButton btnRegistroLogin = new JButton("Registro");
		btnRegistroLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);
				panelRegistro.setVisible(true);
			}
		});
		btnRegistroLogin.setBounds(442, 10, 154, 37);
		panelLogin.add(btnRegistroLogin);

	}
}
