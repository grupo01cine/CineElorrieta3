package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import bbdd.pojos.Entrada;

public class GestorFicheros {

	// private static final String RUTA_CARPETA =
	// "C://Users//in1dw3//eclipse-workspace//BBDDyFicheros//src//BackUps//";
	private static final String RUTA_CARPETA = System.getProperty("user.home") + "/Desktop/";
	// private static final File RUTA_CARPETA =
	// FileSystemView.getFileSystemView().getHomeDirectory();

	File file = null;

	// Leer
	// FileReader fileReader = null;
	// BufferedReader bufferedReader = null;

	// Escribir
	FileWriter fileWriter = null;
	PrintWriter printWriter = null;

	public GestorFicheros() {

	}

	

	public void crearNuevoTicket(ArrayList<Entrada> entradaDada) {
		if (null == entradaDada) {
			return;
		}

		// Vamos a añadirle la fecha de creacion del Ticket al nombre del Ticket
		Date date = new Date();
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fech = dateFormat.format(date);

		File fich = new File(RUTA_CARPETA + "Entradas_Cine_" + fech + ".txt");

		int acum = 1;

		try {
			fileWriter = new FileWriter(fich);
			printWriter = new PrintWriter(fileWriter);

			for (Entrada entrada : entradaDada) {
				printWriter.println("Entrada " + acum);
				printWriter.println(" Datos Cine");
				printWriter.println("	- Cine: " + entrada.getProyeccion().getSala().getCine().getNombre());
				printWriter.println("	- Direccion: " + entrada.getProyeccion().getSala().getCine().getDireccion());
				printWriter.println("	- Pelicula: " + entrada.getProyeccion().getPelicula().getTitulo());
				printWriter.println("	  > Duraccion: " + entrada.getProyeccion().getPelicula().getDuracion());
				printWriter.println("	  > Gemero: " + entrada.getProyeccion().getPelicula().getGenero());
				printWriter.println("	- Sala: " + entrada.getProyeccion().getSala().getNombre());
				printWriter.println("	- Precio: " + entrada.getProyeccion().getPrecio() + "€");
				printWriter.println(" Datos Cliente");
				printWriter.println("	- DNI: " + entrada.getCliente().getDni());
				printWriter.println("	- Nombre: " + entrada.getCliente().getNombre());
				printWriter.println("	- Apellido: " + entrada.getCliente().getApellido());
				printWriter.println("	- Sexo: " + entrada.getCliente().getSexo());
				printWriter.println(" Fecha compra: " + entrada.getFechaCompra());
				printWriter.println(" Hora compra: " + entrada.getHoraCompra());
				printWriter.println("");

				acum++;
			}

			printWriter.println("Descuento: " + sacarDescuento(entradaDada));
			printWriter.println("Precio Final: " + sacarPrecioFinal(entradaDada) + "€");

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

	private String sacarDescuento(ArrayList<Entrada> entradaDada) {
		String ret = "";
		switch (entradaDada.size()) {
		case 0:
			ret = "Sin descuento";			
			break;
		case 1:
			ret = "Sin descuento";			
			break;
		case 2:
			ret = "20%";
			break;
		case 3:
			ret = "30%";
			break;
		case 4:
			ret = "40%";
			break;
		default:
			ret="50%";
			break;
		}
		
		return ret;
	}
	
	private double sacarPrecioFinal(ArrayList<Entrada> entradaDada) {
		double sumaPrecios = 0;
		for(Entrada entrada : entradaDada) {
			sumaPrecios += entrada.getProyeccion().getPrecio();
		}
		
		return sumaPrecios;
	}
}
