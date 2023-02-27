package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import bbdd.pojos.Cine;
import bbdd.pojos.Cliente;
import bbdd.pojos.Entrada;
import bbdd.pojos.Pelicula;
import bbdd.pojos.Proyeccion;
import bbdd.pojos.Sala;
import bbdd.utils.BBDDUtils;

public class GestorBasesDeDatos {

	private java.sql.Date conversionFecha(java.util.Date fecha) {
		java.sql.Date ret = new java.sql.Date(fecha.getTime());
		return ret;
	}

	public ArrayList<Cine> sacarTodosLosCines() {
		ArrayList<Cine> ret = null;

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);

			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);

			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Cine");

			while (resultSet.next()) {

				// Si es necesario, inicializamos la lista
				if (null == ret) {
					ret = new ArrayList<Cine>();
				}

				Cine cine = new Cine();
				// Sacamos las columnas del RS
				int id = resultSet.getInt("Codigo");
				String nombre = resultSet.getString("Nombre");
				String direccion = resultSet.getString("Direccion");

				// Metemos los datos a Ejemplo
				cine.setCodigo(id);
				cine.setNombre(nombre);
				cine.setDireccion(direccion);

				ret.add(cine);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
		}
		return ret;
	}

	public ArrayList<Pelicula> sacarTodasLasPeliculas(String cine) {
		ArrayList<Pelicula> ret = null;
		String sql = "SELECT p.* " + "FROM Pelicula p " + "join Proyeccion pr on p.Codigo=pr.Pelicula_Codigo "
				+ "join Sala s on pr.Sala_Codigo=s.Codigo " + "join Cine c on s.Cine_Codigo = c.Codigo "
				+ "WHERE c.Nombre = '" + cine + "' " + "GROUP BY p.Titulo ORDER BY pr.Fecha, pr.Horario";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);

			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);
			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				if (null == ret)
					ret = new ArrayList<Pelicula>();

				Pelicula pelicula = new Pelicula();

				int codigo = resultSet.getInt("Codigo");
				LocalTime duracion = resultSet.getTime("Duracion").toLocalTime();
				String genero = resultSet.getString("Genero");
				double coste = resultSet.getDouble("CosteProduccion");
				String titulo = resultSet.getString("Titulo");

				pelicula.setCodigo(codigo);
				pelicula.setDuracion(duracion);
				pelicula.setGenero(genero);
				pelicula.setCoste(coste);
				pelicula.setTitulo(titulo);

				ret.add(pelicula);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return ret;
	}

	public ArrayList<Proyeccion> sacarTodasLasFechas(String cine, String pelicula) {
		ArrayList<Proyeccion> ret = null;

		String sql = "SELECT pr.* " + "FROM Pelicula p " + "join Proyeccion pr on p.Codigo=pr.Pelicula_Codigo "
				+ "join Sala s on pr.Sala_Codigo=s.Codigo " + "join Cine c on s.Cine_Codigo = c.Codigo "
				+ "WHERE c.Nombre = '" + cine + "' and p.Titulo = '" + pelicula
				+ "' GROUP BY Fecha ORDER BY pr.Fecha, pr.Horario";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);

			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);
			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				if (null == ret)
					ret = new ArrayList<Proyeccion>();

				Proyeccion proyeccion = new Proyeccion();

				int codigo = resultSet.getInt("Codigo");
				java.util.Date fecha = resultSet.getDate("Fecha");
				LocalTime horario = resultSet.getTime("Horario").toLocalTime();

				proyeccion.setCodigo(codigo);
				proyeccion.setFecha(fecha);
				proyeccion.setHorario(horario);

				ret.add(proyeccion);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}

		return ret;
	}

	public ArrayList<Proyeccion> sacarTodasLasSesiones(String cine, String pelicula, Date fechaSeleccionada) {

		java.sql.Date fechasql = conversionFecha(fechaSeleccionada);
		ArrayList<Proyeccion> ret = null;

		String sql = "SELECT pr.*, s.Codigo " + "FROM Pelicula p "
				+ "join Proyeccion pr on p.Codigo=pr.Pelicula_Codigo " + "join Sala s on pr.Sala_Codigo=s.Codigo "
				+ "join Cine c on s.Cine_Codigo = c.Codigo " + "WHERE c.Nombre = '" + cine + "' and p.Titulo = '"
				+ pelicula + "' and pr.Fecha = '" + fechasql + "' ORDER BY pr.Fecha, pr.Horario";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);

			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);
			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				if (null == ret)
					ret = new ArrayList<Proyeccion>();

				Proyeccion proyeccion = new Proyeccion();

//				int codigo = resultSet.getInt("Codigo");
				java.util.Date fecha = conversionFecha(resultSet.getDate("Fecha"));

//        		SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");

				LocalTime horario = resultSet.getTime("Horario").toLocalTime();

				Double precio = resultSet.getDouble("Precio");

				proyeccion.setFecha(fecha);
				proyeccion.setHorario(horario);
				proyeccion.setPrecio(precio);

				Sala sala = new Sala();
				sala.setCodigo(resultSet.getInt("Sala_Codigo"));
				proyeccion.setSala(sala);

				ret.add(proyeccion);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}

		return ret;
	}

	public void insertarClienteBBDD(Cliente cliente) {

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);
			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);
			statement = connection.createStatement();

			String sql = "insert into Cliente (DNI, Nombre, Apellido, Sexo, Contrasena) VALUES ('" + cliente.getDni()
					+ "', '" + cliente.getNombre() + "', '" + cliente.getApellido() + "', '" + cliente.getSexo()
					+ "', '" + cliente.getPasswd() + "')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
	}

	public void insertarEntrada(Cliente cliente, ArrayList<Proyeccion> proyecciones) {

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);
			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);
			statement = connection.createStatement();

			java.util.Date date = new java.util.Date();
			java.sql.Date fecha = new java.sql.Date(date.getTime());
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
			String hora = dateFormat.format(date);
			
			String sql = null;
			
			for(Proyeccion proyec : proyecciones) {				
				sql = "insert into Entrada (Cliente_Codigo, Proyeccion_Codigo, Fecha_Compra, Hora_Compra) VALUES ('" + cliente.getCodigo()
				+ "', '" + proyec.getCodigo() + "', '" + fecha + "', '"+hora+ "')";
				statement.executeUpdate(sql);
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
	}

	public ArrayList<Proyeccion> sacarResumen(Cliente cliente) {

		ArrayList<Proyeccion> ret = null;
		String sql = "SELECT pr.*\r\n" + "FROM Proyeccion pr " + "join Sala s on pr.Sala_Codigo=s.Codigo "
				+ "join Entrada e on e.Proyeccion_Codigo = pr.Codigo "
				+ "join Cliente c on e.Cliente_Codigo = c.Codigo\r\n" + "WHERE c.DNI = '" + cliente.getDni() + "'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);

			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);
			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				if (null == ret)
					ret = new ArrayList<Proyeccion>();

				Proyeccion proyeccion = new Proyeccion();

				int codigo = resultSet.getInt("Codigo");
				java.util.Date fecha = conversionFecha(resultSet.getDate("Fecha"));
				LocalTime horario = resultSet.getTime("Horario").toLocalTime();
				Double precio = resultSet.getDouble("Precio");

				proyeccion.setCodigo(codigo);
				proyeccion.setFecha(fecha);
				proyeccion.setHorario(horario);
				proyeccion.setPrecio(precio);

				Pelicula pelicula = new Pelicula();
				pelicula.setCodigo(resultSet.getInt("Pelicula_Codigo"));
				proyeccion.setPelicula(pelicula);

				Sala sala = new Sala();
				sala.setCodigo(resultSet.getInt("Sala_Codigo"));
				proyeccion.setSala(sala);

				ret.add(proyeccion);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}

		return ret;
	}

	public boolean comprobarClienteExiste(Cliente nuevoCliente) {

		String sql = "SELECT * " 
		+ "FROM Cliente as c " 
		+ "WHERE c.DNI = '" + nuevoCliente.getDni() + "'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);

			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);
			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return false;
	}
	
	public Proyeccion sacarResumen(String titulo, java.util.Date fecha, String hora) {
		Proyeccion ret = new Proyeccion();
		String sql = "SELECT pr.* "
				+ "FROM Proyeccion pr "
				+ "join Pelicula p on pr.Pelicula_Codigo = p.Codigo "
				+ "WHERE p.Titulo = '"+ titulo + "' "
				+ "and pr.Fecha = '"+fecha+"' "
				+ "and pr.Horario = '"+hora+":00'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);

			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);
			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				if (null == ret)
					ret = new Proyeccion();

				int codigo = resultSet.getInt("Codigo");
				Double precio = resultSet.getDouble("Precio");
				LocalTime horario = resultSet.getTime("Horario").toLocalTime();

				ret.setCodigo(codigo);
				ret.setFecha(fecha);
				ret.setHorario(horario);
				ret.setPrecio(precio);

				Pelicula pelicula = new Pelicula();
				pelicula.setCodigo(resultSet.getInt("Pelicula_Codigo"));
				pelicula.setTitulo(titulo);
				ret.setPelicula(pelicula);

				Sala sala = new Sala();
				sala.setCodigo(resultSet.getInt("Sala_Codigo"));
				ret.setSala(sala);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}

		return ret;
	}
	
	public ArrayList<Cliente> sacarTodosLosClientes() {
		ArrayList<Cliente> ret = null;

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);

			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);

			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Cliente");

			while (resultSet.next()) {

				if (null == ret) {
					ret = new ArrayList<Cliente>();
				}

				Cliente cliente = new Cliente();
//				int id = resultSet.getInt("Codigo");
//				String nombre = resultSet.getString("Nombre");
//				String direccion = resultSet.getString("Direccion");
				
				int codigo = resultSet.getInt("Codigo");
				String dni = resultSet.getString("DNI");
				String nombre = resultSet.getString("Nombre");
				String apellido = resultSet.getString("Apellido");
				String sexo = resultSet.getString("Sexo");
				String contrasena = resultSet.getString("Contrasena");

				
				cliente.setCodigo(codigo);
				cliente.setDni(dni);
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setSexo(sexo);
				cliente.setPasswd(contrasena);

				ret.add(cliente);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
		}
		return ret;
	}

	public boolean comprobarEntrada(Cliente cliente, ArrayList<Proyeccion> proyeccionesSeleccionadas) {
		String sql = "SELECT * " + "FROM Entrada e "  
				+ "WHERE e.Cliente_Codigo = '" + cliente.getCodigo() + "'"
				+ "AND e.Proyeccion_Codigo = '" + proyeccionesSeleccionadas.get(0).getCodigo() + "'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);

			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);
			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return false;	
	}
	
	public ArrayList<Entrada> sacarEntradas(Cliente clienteDado, ArrayList<Proyeccion> proyeccionesSeleccionadas) {
		// TODO Cambiar codEntrada
		ArrayList<Entrada> ret = null;

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		java.util.Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = dateFormat.format(date);

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);

			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);

			String sql = "SELECT" + " e.Codigo AS CodEntrada," + " e.Fecha_Compra AS FechaEntrada,"
					+ " e.Hora_Compra AS HoraEntrada," + " p.Codigo AS CodProyeccion," + " p.Fecha AS FechaProyeccion,"
					+ " p.Horario AS HorarioProyeccion," + " p.Precio AS PrecioProyeccion," + " s.Codigo AS CodSala,"
					+ " s.Numero_Sala AS NomSala," + " c.Codigo AS CodCine," + " c.Nombre AS NomCine,"
					+ " c.Direccion AS DirCine," + " pe.Codigo AS CodPelicula,"
					+ " pe.CosteProduccion AS CostePelicula," + " pe.Duracion AS DuracionPelicula,"
					+ " pe.Genero AS GeneroPelicula," + " pe.Titulo AS TituloPelicula," + " cl.Codigo AS CodCliente,"
					+ " cl.DNI AS DNICliente," + " cl.Nombre AS NomCliente," + " cl.Apellido AS ApellidoCliente,"
					+ " cl.Sexo AS SexoCliente" + " FROM" + " Entrada AS e"
					+ " JOIN Proyeccion AS p ON e.Proyeccion_Codigo = p.Codigo"
					+ " JOIN Cliente AS cl ON e.Cliente_Codigo = cl.Codigo"
					+ " JOIN Pelicula AS pe ON p.Pelicula_Codigo = pe.Codigo"
					+ " JOIN Sala AS s ON p.Sala_Codigo = s.Codigo" + " JOIN Cine AS c ON s.Cine_Codigo = c.Codigo"
					+ " WHERE" + " cl.Codigo =  '" + clienteDado.getCodigo() + "'" + " AND e.Fecha_Compra = '" + fecha
					+ "'";

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				// Si es necesario, inicializamos la lista
				if (null == ret) {
					ret = new ArrayList<Entrada>();
				}

				Entrada entrada = new Entrada();

				entrada.setCodigo(resultSet.getInt(1));
				entrada.setFechaCompra(resultSet.getDate(2)); // En el POJO guardamos SQL Date por lo que no hace falta
																// comvertirla
				entrada.setHoraCompra(resultSet.getTime(3).toLocalTime());

				Proyeccion proyeccion = new Proyeccion();
				proyeccion.setCodigo(resultSet.getInt(4));
				proyeccion.setFecha(resultSet.getDate(5));
				proyeccion.setHorario(resultSet.getTime(6).toLocalTime());
				proyeccion.setPrecio(resultSet.getDouble(7));

				Sala sala = new Sala();
				sala.setCodigo(resultSet.getInt(8));
				sala.setNombre(resultSet.getString(9));

				Cine cine = new Cine();
				cine.setCodigo(resultSet.getInt(10));
				cine.setNombre(resultSet.getString(11));
				cine.setDireccion(resultSet.getString(12));

				sala.setCine(cine);

				proyeccion.setSala(sala);

				Pelicula pelicula = new Pelicula();
				pelicula.setCodigo(resultSet.getInt(13));
				pelicula.setCoste(resultSet.getDouble(14));
				pelicula.setDuracion(resultSet.getTime(15).toLocalTime());
				pelicula.setGenero(resultSet.getString(16));
				pelicula.setTitulo(resultSet.getString(17));

				proyeccion.setPelicula(pelicula);

				Cliente cliente = new Cliente();
				cliente.setCodigo(resultSet.getInt(18));
				cliente.setDni(resultSet.getString(19));
				cliente.setNombre(resultSet.getString(20));
				cliente.setApellido(resultSet.getString(21));
				cliente.setSexo(resultSet.getString(22));

				entrada.setCliente(cliente);
				entrada.setProyeccion(proyeccion);

				ret.add(entrada);

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
		}
		return ret;
	}
}
