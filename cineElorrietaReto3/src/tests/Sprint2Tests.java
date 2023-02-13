package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import bbdd.pojos.Cine;
import bbdd.pojos.Pelicula;
import bbdd.pojos.Proyeccion;
import controlador.GestorBasesDeDatos;

class Sprint2Tests {

	private GestorBasesDeDatos metodos = new GestorBasesDeDatos();

	// ** TEST CINES **
	@Test
	void testCinesDiponibles() {

		ArrayList<Cine> listaCines = metodos.sacarTodosLosCines();
		if (null == listaCines) {
			fail("El metodo no devuelve ningun cine");
		} else {
			assertEquals(3, listaCines.size());
		}
	}

	// ** TEST PELICULAS **
	@Test
	void testPeliculasDeUnCine() {
		ArrayList<Pelicula> listaPeliculas = metodos.sacarTodasLasPeliculas("Cine Bilbao");
		if (null == listaPeliculas) {
			fail("El metodo no devuelve ninguna pelicula");
		} else {
			assertEquals(2, listaPeliculas.size());
		}
	}

	@Test
	void testOrdenarPeliculas() {
		ArrayList<Pelicula> listaPeliculas = metodos.sacarTodasLasPeliculas("Cine Bilbao");
		if (null == listaPeliculas) {
			fail("El metodo no devuelve ninguna pelicula");
		} else {
			if (!listaPeliculas.get(0).getTitulo().equals("Handia")) {
				fail("Las peliculas no estan ordenadas");
			}
		}
	}

	// ** TEST FECHA Y SESION **
	@Test
	void testFechasDeUnaPelicula() {
		ArrayList<Proyeccion> listaProyecciones = metodos.sacarTodasLasFechas("Cine Bilbao", "Handia");
		if (null == listaProyecciones) {
			fail("El metodo no devuelve ninguna proyeccion");
		} else {
			assertEquals(4, listaProyecciones.size());

			Format formatter = new SimpleDateFormat("yyyy-MM-dd");
			String fecha = formatter.format(listaProyecciones.get(0).getFecha());

			assertEquals("2023-03-01", fecha);
		}
	}

	@Test
	void testSesionesDeUnaFechaDeUnaPelicula() {
		ArrayList<Proyeccion> listaProyecciones = metodos.sacarTodasLasFechas("Cine Bilbao", "Handia");
		ArrayList<Proyeccion> listaSesiones = metodos.sacarTodasLasSesiones("Cine Bilbao", "Handia",
				listaProyecciones.get(0).getFecha());
		if (null == listaSesiones) {
			fail("El metodo no devuelve ninguna Sesion");
		} else {
			assertEquals(5, listaSesiones.size());

			assertEquals("09:00", listaSesiones.get(0).getHorario().toString());
		}
	}

	@Test
	void testPrecioDeUnaPelicula() {
		ArrayList<Proyeccion> listaProyecciones = metodos.sacarTodasLasFechas("Cine Bilbao", "Handia");
		ArrayList<Proyeccion> listaSesiones = metodos.sacarTodasLasSesiones("Cine Bilbao", "Handia",
				listaProyecciones.get(0).getFecha());
		if (null == listaSesiones) {
			fail("El metodo no devuelve ninguna Sesion");
		} else {
			assertEquals(5.5, listaSesiones.get(0).getPrecio());
		}
	}

	@Test
	void testSalasDeUnaPeliculaYFecha() {
		ArrayList<Proyeccion> listaProyecciones = metodos.sacarTodasLasFechas("Cine Bilbao", "Handia");
		ArrayList<Proyeccion> listaSesiones = metodos.sacarTodasLasSesiones("Cine Bilbao", "Handia",
				listaProyecciones.get(0).getFecha());
		if (null == listaSesiones) {
			fail("El metodo no devuelve ninguna Sesion");
		} else {
			assertEquals(1, listaSesiones.get(0).getSala().getCodigo());
		}
	}

}
