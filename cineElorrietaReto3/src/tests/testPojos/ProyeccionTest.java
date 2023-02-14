package tests.testPojos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bbdd.pojos.Proyeccion;
import bbdd.pojos.Sala;

class ProyeccionTest {

	@Test
	public void testGettersAndSetters() {
		Proyeccion proyeccion = new Proyeccion();
		
		proyeccion.setCodigo(0);
		assertEquals(proyeccion.getCodigo(), 0);
	}

	@Test
	public void testProyeccionEquals() {
		Proyeccion proyec1 = new Proyeccion();
		proyec1.setCodigo(7);
		proyec1.setFecha(null);
		proyec1.setHorario(null);
		proyec1.setPelicula(null);
		proyec1.setSala(null);
		
		Proyeccion proyec2 = new Proyeccion();
		proyec2.setCodigo(7);
		proyec2.setFecha(null);
		proyec2.setHorario(null);
		proyec2.setPelicula(null);
		proyec2.setSala(null);
		
		// Las fechas no son iguales
		assertTrue(proyec1.equals(proyec2));
	}
	
	@Test
	public void testSalaToString() {
		Proyeccion proyecToString = new Proyeccion();
		proyecToString.setCodigo(1);
		proyecToString.setFecha(null);
		proyecToString.setHorario(null);
		proyecToString.setPrecio(5.5);
		proyecToString.setPelicula(null);
		proyecToString.setSala(null);

		assertEquals("Proyeccion [codigo=" + 1 + ", fecha=" + null + ", horario=" + null + ", precio=" + 5.5
				+ ", sala=" + null + ", pelicula=" + null + "]", proyecToString.toString());				
	}

	@Test
	public void testHasCode() {
		Sala sala1 = new Sala();
		sala1.setCodigo(1);
		sala1.setNombre("sala01");
		sala1.setCine(null);
		
		Sala sala2 = new Sala();
		sala2.setCodigo(1);
		sala2.setNombre("sala01");
		sala1.setCine(null);
		
		assertEquals(sala1.hashCode(), sala2.hashCode());
	}

}
