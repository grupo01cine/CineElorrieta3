package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import bbdd.pojos.Cine;
import bbdd.pojos.Cliente;
import bbdd.pojos.Pelicula;
import bbdd.pojos.Proyeccion;
import bbdd.pojos.Sala;
import bbdd.pojos.Entrada;
import bbdd.utils.BBDDUtils;

public class GestorBasesDeDatos {

	private java.sql.Date conversionFecha(java.util.Date fecha) {
		java.sql.Date ret = new java.sql.Date(fecha.getTime());
		return ret;
	}

	private String getJavaTime(java.sql.Time duracion) {
		String ret = null;
		ret = duracion.toString();
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

	public ArrayList<Cine> ejemplo(String nombreDado) {
		ArrayList<Cine> ret = null;

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM Cine Where Nombre = ?";

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);

			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);

			statement = connection.createStatement();

			preparedStatement = connection.prepareStatement(sql);
			// preparedStatement.setInt(1, codigo);
			preparedStatement.setString(2, nombreDado);
			resultSet = statement.executeQuery(sql);

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

				int codigo = resultSet.getInt("Codigo");
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

	public void insertarEntrada(Cliente cliente, Proyeccion proyeccion) {

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);
			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);
			statement = connection.createStatement();

			Date date = new Date();

			String sql = "insert into Entrada (Proyeccion_Codigo, Cliente_Codigo, Fecha_compra) VALUES ('" + date
					+ "', '" + proyeccion.getCodigo() + "', '" + cliente.getCodigo() + "')";
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
		+ "WHERE c.Nombre = '" + nuevoCliente.getNombre()
		+ "' and c.DNI = '" + nuevoCliente.getDni() + "' and c.Apellido = '" + nuevoCliente.getApellido() + "'";

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
}
