package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.Test;

import bbdd.pojos.Cine;
import bbdd.pojos.Cliente;
import bbdd.pojos.Entrada;
import bbdd.pojos.Pelicula;
import bbdd.pojos.Proyeccion;
import bbdd.pojos.Sala;
import controlador.GestorBasesDeDatos;
import controlador.GestorFicheros;
import controlador.GestorVentanas;

class Sprint3Tests {

	GestorBasesDeDatos metodosBaseDatos = new GestorBasesDeDatos();
	GestorVentanas metodosVentanas = new GestorVentanas();

	// ** TESTS RESUMEN COMPRA **
	@Test
	void testCalculoResumen() {
//		fail("Not yet implemented");
	}

	@Test
	void testCalculoDescuentos() {
		JTable tablaDescuento = new JTable();
		ArrayList<Proyeccion> proyeccionesSeleccionadas = new ArrayList<Proyeccion>();

		// Creacion de Proyeccion1
		Proyeccion proyeccion1 = new Proyeccion();
		proyeccion1.setCodigo(1);
		LocalTime time = LocalTime.now();
		proyeccion1.setHorario(time);
		proyeccion1.setPrecio(5.5);

		Pelicula pelicula1 = new Pelicula();
		pelicula1.setTitulo("Handia");
		proyeccion1.setPelicula(pelicula1);

		Sala sala1 = new Sala();
		sala1.setCodigo(1);
		proyeccion1.setSala(sala1);

		proyeccionesSeleccionadas.add(proyeccion1);

		// Creacion de Proyeccion2
		Proyeccion proyeccion2 = new Proyeccion();
		proyeccion2.setCodigo(1);
		proyeccion2.setHorario(time);
		proyeccion2.setPrecio(6.5);

		Pelicula pelicula2 = new Pelicula();
		pelicula2.setTitulo("El cisne negro");
		proyeccion2.setPelicula(pelicula1);

		Sala sala2 = new Sala();
		sala2.setCodigo(1);
		proyeccion2.setSala(sala1);

		proyeccionesSeleccionadas.add(proyeccion2);

		tablaDescuento.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "T\u00EDtulo", "Sesion", "Sala", "Precio" }));
		DefaultTableModel model = (DefaultTableModel) tablaDescuento.getModel();
		model.setRowCount(0);

		for (Proyeccion proyec : proyeccionesSeleccionadas) {
			model.addRow(new String[] { proyec.getPelicula().getTitulo(), proyec.getHorario().toString(),
					Integer.toString(proyec.getSala().getCodigo()), proyec.getPrecio().toString() });
		}

		assertEquals("20%", metodosVentanas.sacarPorcentaje(tablaDescuento));
	}

	// ** TESTS LOGIN **
	@Test
	void testComprobacionLogIn() {
		Cliente cliente = new Cliente();

		cliente.setCodigo(0);
		cliente.setDni("12345678A");
		cliente.setNombre("Pepe");
		cliente.setApellido("Lopez Martin");
		cliente.setPasswd("admin");
		cliente.setSexo("Hombre");

		assertTrue(metodosBaseDatos.comprobarClienteExiste(cliente));
	}

	// ** TESTS COMPRA + FACTURA **
	@Test
	void testGuardadoCorrecto() {
		Cliente cliente = new Cliente();
		cliente.setCodigo(13);
		cliente.setDni("87654321B");
		cliente.setNombre("Pepe");
		cliente.setApellido("Martin");
		cliente.setSexo("Hombre");
		cliente.setPasswd("admin");
		cliente.setEntradas(null);

		String fechaDada = "2023-03-01";
		Date fecha = null;
		try {
			fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaDada);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String horaDada = "18:00";
		LocalTime hora = LocalTime.parse(horaDada);

		ArrayList<Proyeccion> proyeccionesSeleccionadas = new ArrayList<Proyeccion>();
		Proyeccion proyec = new Proyeccion();
		proyec.setCodigo(1);
		proyec.setFecha(fecha);
		proyec.setHorario(hora);
		Pelicula pelicula = new Pelicula();
		pelicula.setCodigo(1);
		proyec.setPelicula(pelicula);
		proyec.setPrecio(5.5);
		Sala sala = new Sala();
		sala.setCodigo(1);
		proyec.setSala(sala);

		proyeccionesSeleccionadas.add(proyec);

		metodosBaseDatos.insertarEntrada(cliente, proyeccionesSeleccionadas);

		assertTrue(metodosBaseDatos.comprobarEntrada(cliente, proyeccionesSeleccionadas));
	}

	@Test
	void testCreacionCorrectaDelArchivo() {
//		Creo un arrayList con una entrada
		// Primero creo la entrada
		Entrada entrada = new Entrada();

		entrada.setCodigo(324);
		java.util.Date fecha2 = new java.util.Date();
		entrada.setFechaCompra(fecha2); // En el POJO guardamos SQL Date por lo que no hace falta
										// comvertirla
		String hora = "12:00";
		entrada.setHoraCompra(LocalTime.parse(hora));

		Proyeccion proyeccion = new Proyeccion();
		proyeccion.setCodigo(6546);
		java.util.Date fecha1 = new java.util.Date();
		proyeccion.setFecha(fecha1);
		String hora1 = "22:00";
		proyeccion.setHorario(LocalTime.parse(hora1));
		proyeccion.setPrecio((double) 4);

		Sala sala = new Sala();
		sala.setCodigo(867);
		sala.setNombre("3");

		Cine cine = new Cine();
		cine.setCodigo(5654);
		cine.setNombre("JUnit");
		cine.setDireccion("c/a");

		sala.setCine(cine);

		proyeccion.setSala(sala);

		Pelicula pelicula = new Pelicula();
		pelicula.setCodigo(213);
		pelicula.setCoste(234);
		String duracion1 = "01:00";
		pelicula.setDuracion(LocalTime.parse(duracion1));
		pelicula.setGenero("Drama");
		pelicula.setTitulo("Prueba JUnit");

		proyeccion.setPelicula(pelicula);

		Cliente cliente = new Cliente();
		cliente.setCodigo(34545);
		cliente.setDni("5562343B");
		cliente.setNombre("JUnit");
		cliente.setApellido("Test");
		cliente.setSexo("Mujer");

		entrada.setCliente(cliente);
		entrada.setProyeccion(proyeccion);

		ArrayList<Entrada> entradas = new ArrayList<Entrada>();
		entradas.add(entrada);

		GestorFicheros gestorficheros = new GestorFicheros();
		gestorficheros.crearNuevoTicket(entradas);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fech = dateFormat.format(date);

		String RUTA_CARPETA = System.getProperty("user.home") + "/Desktop/";
		File fich = new File(RUTA_CARPETA + "Entradas_Cine_" + fech + ".txt");

		assertEquals(true, fich.exists());
	}

}
