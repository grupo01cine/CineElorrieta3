package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import bbdd.pojos.Cine;
import bbdd.pojos.Pelicula;
import bbdd.pojos.Proyeccion;
import bbdd.utils.BBDDUtils;

public class GestorBasesDeDatos {
	
	private java.sql.Date conversionFecha(java.util.Date fecha) {
		java.sql.Date ret = new java.sql.Date(fecha.getTime());
	    return ret;
	}
	
	private String getJavaTime(java.sql.Time duracion) {
		String ret=null;
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
			//preparedStatement.setInt(1, codigo);
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
	
	public ArrayList<Pelicula> sacarTodasLasPeliculas(String cine){
		ArrayList<Pelicula> ret = null;
		String sql = "SELECT p.* "
				+ "FROM pelicula p "
				+ "join proyeccion pr on p.Codigo=pr.Pelicula_Codigo "
				+ "join sala s on pr.Sala_Codigo=s.Codigo "
				+ "join cine c on s.Cine_Codigo = c.Codigo "
				+ "WHERE c.Nombre = '" +cine+"' "
				+ "GROUP BY p.Titulo ORDER BY pr.Fecha, pr.Horario";

		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);
			
			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO, BBDDUtils.PASS_REMOTO);
			statement = connection.createStatement();
			
			
			resultSet = statement.executeQuery(sql);

			while(resultSet.next()) {
				if (null == ret)
					ret = new ArrayList<Pelicula>();
			
				Pelicula pelicula = new Pelicula();
				
				int codigo = resultSet.getInt("Codigo");
				String duracion = getJavaTime(resultSet.getTime("Duracion"));
                String genero = resultSet.getString("Genero");
                double coste = resultSet.getDouble("Coste");
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
		} catch(Exception e){ 
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null) 
					resultSet.close(); 
			} catch(Exception e){ 
			};
			try {
				if (statement != null) 
					statement.close(); 
			} catch(Exception e){ 
			};
			try {
				if (connection != null) 
					connection.close(); 
			} catch(Exception e){ 
			};					
		}
		return ret;
	}
	
	public ArrayList<Proyeccion> sacarTodasLasFechas (String cine, String pelicula){
		ArrayList<Proyeccion> ret=null;
		
		String sql = "SELECT pr.* "
				+ "FROM pelicula p "
				+ "join proyeccion pr on p.Codigo=pr.Pelicula_Codigo "
				+ "join sala s on pr.Sala_Codigo=s.Codigo "
				+ "join cine c on s.Cine_Codigo = c.Codigo "
				+ "WHERE c.Nombre = '" +cine+"' and p.Titulo = '"+pelicula+"' GROUP BY p.Titulo ORDER BY pr.Fecha, pr.Horario";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);
			
			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO, BBDDUtils.PASS_REMOTO);
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);

			while(resultSet.next()) {
				if (null == ret)
					ret = new ArrayList<Proyeccion>();
			
				Proyeccion proyeccion = new Proyeccion();
                
                int codigo = resultSet.getInt("Codigo");
                java.util.Date fecha = conversionFecha(resultSet.getDate("Fecha"));
				Date horario = conversionFecha(resultSet.getTime("Horario"));
				
				proyeccion.setCodigo(codigo);
				proyeccion.setFecha(fecha);
				proyeccion.setHorario(horario);
                
                ret.add(proyeccion);
			}
		} catch (SQLException sqle) {  
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch(Exception e){ 
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null) 
					resultSet.close(); 
			} catch(Exception e){ 
			};
			try {
				if (statement != null) 
					statement.close(); 
			} catch(Exception e){ 
			};
			try {
				if (connection != null) 
					connection.close(); 
			} catch(Exception e){ 
			};					
		}
		
		return ret;
	}
}
