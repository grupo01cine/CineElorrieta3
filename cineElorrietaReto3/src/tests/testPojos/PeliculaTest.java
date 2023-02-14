package tests.testPojos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bbdd.pojos.Pelicula;

class PeliculaTest {

	@Test
	public void testGettersAndSetters() {
		Pelicula peli = new Pelicula();
		
		peli.setCodigo(0);
		assertEquals(peli.getCodigo(), 0);
		
		peli.setTitulo("Handia");
		assertEquals(peli.getTitulo(), "Handia");
		
		peli.setDuracion(null);
		assertEquals(peli.getDuracion(), null);
		
		peli.setGenero("Drama");
		assertEquals(peli.getGenero(), "Drama");
		
		peli.setCoste(80000);
		assertEquals(peli.getCoste(), 80000);
		
		peli.setProyecciones(null);
		assertEquals(peli.getProyecciones(), null);
	}

	@Test
	public void testPeliculaEquals() {
		Pelicula peli1 = new Pelicula();
		peli1.setCodigo(10);
		peli1.setDuracion(null);
		peli1.setGenero("Horror");
		peli1.setCoste(5.50);
		
		Pelicula peli2 = new Pelicula();
		peli2.setCodigo(10);
		peli2.setDuracion(null);
		peli2.setGenero("Horror");
		peli2.setCoste(5.50);
		
		// Las fechas no son iguales
		assertTrue(peli1.equals(peli2));
	}
	
	@Test
	public void testPeliculaToString() {
		Pelicula peliculaToString = new Pelicula();
		peliculaToString.setCodigo(1);
		peliculaToString.setTitulo("Handia");
		peliculaToString.setDuracion(null);
		peliculaToString.setGenero("Drama");	
		peliculaToString.setCoste(6000);
		peliculaToString.setProyecciones(null);
	
		assertEquals("Pelicula [codigo=" + 1 + ", titulo=" + "Handia" + ", duracion=" + null + ", genero=" + "Drama"
				+ ", coste=" + 6000.0 + ", proyecciones=" + null + "]", peliculaToString.toString());		
	}

	@Test
	public void testHasCode() {
		Pelicula pelicula1 = new Pelicula();
		pelicula1.setCodigo(1);
		pelicula1.setTitulo("Handia");
		pelicula1.setDuracion(null);
		pelicula1.setGenero("Drama");
		
		Pelicula pelicula2 = new Pelicula();
		pelicula2.setCodigo(1);
		pelicula2.setTitulo("Handia");
		pelicula2.setDuracion(null);
		pelicula2.setGenero("Drama");
		
		assertEquals(pelicula1.hashCode(), pelicula2.hashCode());
	}

}