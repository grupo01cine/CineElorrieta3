package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;

import bbdd.pojos.Cine;
import bbdd.pojos.Cliente;
import bbdd.pojos.Entrada;
import bbdd.pojos.Pelicula;
import bbdd.pojos.Proyeccion;
import bbdd.pojos.Sala;
import bbdd.utils.BBDDUtils;

public class GestorFicheros {

	//private static final String RUTA_CARPETA = "C://Users//in1dw3//eclipse-workspace//BBDDyFicheros//src//BackUps//";
	private static final String RUTA_CARPETA = System.getProperty("user.home") + "/Desktop/";
	//private static final File RUTA_CARPETA = FileSystemView.getFileSystemView().getHomeDirectory();

	File file = null;

	// Leer 
	//FileReader fileReader = null;
	//BufferedReader bufferedReader = null;

	// Escribir
	FileWriter fileWriter = null;
	PrintWriter printWriter = null;

	public GestorFicheros() {

	}
	
	public ArrayList<Entrada> PRUEBA_SacarEntradas() {
		ArrayList<Entrada> ret = null;

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(BBDDUtils.DRIVER_REMOTO);

			connection = DriverManager.getConnection(BBDDUtils.URL_REMOTO, BBDDUtils.USER_REMOTO,
					BBDDUtils.PASS_REMOTO);

			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Cine");
			
			String sql = "SELECT e.Codigo AS CodEntrada, e.Fecha AS FechaEntrada, e.Horario AS HorarioEntrada, "
					+ "p.Codigo AS CodProyeccion, p.Fecha AS FechaProyeccion, p.Horario AS HorarioProyeccion, p.Precio AS PrecioProyeccion, "
					+ "s.Codigo AS CodSala, s.Nombre AS NomSala, "
					+ "c.Codigo AS CodCine, c.Nombre AS NomCine, c.Direccion AS DirCine, "
					+ "pe.Codigo AS CodPelicula, pe.Coste AS CostePelicula, pe.Duraccion AS DuracionPelicula, pe.Genero AS GeneroPelicula, pe.Titulo AS TituloPelicula,"
					+ "cl.Codigo AS CodCliente, cl.DNI AS DNICliente, cl.Nombre AS NomCliente, cl.Apellido AS ApellidoCliente, cl.Sexo AS SexoCliente"
					+ "FROM Entrada AS e "
					+ "JOIN Proyeccion AS p ON e.ProyeccionCodigo = p.Codigo"
					+ "JOIN Cliente AS cl ON e.ClienteCodigo = cl.Codigo"
					+ "JOIN Pelicula AS pe ON p.PeliculaCodigo = pe.Codigo"
					+ "JOIN Sala AS s ON p.SalaCodigo = s.Codigo"
					+ "JOIN Cine AS c ON s.CineCodigo = c.Codigo"
					+ "WHERE CodEntrada = 1";
			
			while (resultSet.next()) {

				// Si es necesario, inicializamos la lista
				if (null == ret) {
					ret = new ArrayList<Entrada>();
				}

				Entrada entrada = new Entrada();
				
				entrada.setCodigo(resultSet.getInt(1));		
				entrada.setFechaCompra(resultSet.getDate(2)); // En el POJO guardamos SQL Date por lo que no hace falta comvertirla
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

	public void crearNuevoTicket(ArrayList<Entrada> entradaDada) {
		// Vamos a añadirle la fecha de creacion del Ticket al nombre del Ticket
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String fech = dateFormat.format(date);

		File fich = new File(RUTA_CARPETA + "Ticket_Cine_" + fech + ".txt");

		try {
			fileWriter = new FileWriter(fich);
			printWriter = new PrintWriter(fileWriter);

			for (Entrada entrada : entradaDada) {
				printWriter.println(" Datos Cine");
				printWriter.println("	- Cine: " + entrada.getProyeccion().getSala().getCine().getNombre() + " - Direccion: " + entrada.getProyeccion().getSala().getCine().getDireccion());
				printWriter.println("	- Pelicula: " + entrada.getProyeccion().getPelicula().getTitulo());
				printWriter.println("	  > Duraccion: " + entrada.getProyeccion().getPelicula().getDuracion());
				printWriter.println("	  > Gemero: " + entrada.getProyeccion().getPelicula().getGenero());
				printWriter.println("	- Sala: " + entrada.getProyeccion().getSala().getNombre());
				printWriter.println("	- Precio: " + entrada.getProyeccion().getPrecio());
				printWriter.println(" Datos Cliente");
				printWriter.println("	- DNI: " + entrada.getCliente().getDni());
				printWriter.println("	- Nombre: " + entrada.getCliente().getNombre());
				printWriter.println("	- Apellido: " + entrada.getCliente().getApellido());
				printWriter.println("	- Sexo: " + entrada.getCliente().getSexo());
				printWriter.println(" Fecha compra: " + entrada.getFechaCompra());
				
			}

		} catch (IOException e) {
			System.out.println("IOException - Error de escritura en el fichero " + RUTA_CARPETA);
		} finally {
			printWriter.close();
			try {
				fileWriter.close();

			} catch (IOException e) {
				// Nada
			}
		}
	}

}
