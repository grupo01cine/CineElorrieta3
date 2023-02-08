package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bbdd.pojos.Cine;
import bbdd.utils.BBDDUtils;

public class GestorBasesDeDatos {

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
}
