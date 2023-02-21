package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.Test;

import bbdd.pojos.Cliente;
import bbdd.pojos.Pelicula;
import bbdd.pojos.Proyeccion;
import bbdd.pojos.Sala;
import controlador.GestorBasesDeDatos;
import controlador.GestorVentanas;

class Sprint3Tests {

	GestorBasesDeDatos metodosBaseDatos = new GestorBasesDeDatos();
	GestorVentanas metodosVentanas = new GestorVentanas();

	// ** TESTS RESUMEN COMPRA **
	@Test
	void testCalculoResumen() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	void testCreacionCorrectaDelArchivo() {
		fail("Not yet implemented");
	}

}
