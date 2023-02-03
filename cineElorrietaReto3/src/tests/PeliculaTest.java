package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bbdd.pojos.Entrada;
import bbdd.pojos.Pelicula;

class PeliculaTest {

	@Test
	public void testGettersAndSetters() {
		Pelicula peli = new Pelicula();
		
		peli.setCodigo(0);
		assertEquals(peli.getCodigo(), 0);
		
		peli.setGenero("Drama");
		assertEquals(peli.getGenero(), "Drama");
	}

	@Test
	public void testPeliculaEquals() {
		Pelicula peli1 = new Pelicula();
		peli1.setCodigo(10);
		peli1.setDuracion(4);
		peli1.setGenero("Horror");
		peli1.setCoste(5.50);
		
		Pelicula peli2 = new Pelicula();
		peli2.setCodigo(10);
		peli2.setDuracion(4);
		peli2.setGenero("Horror");
		peli2.setCoste(5.50);
		
		// Las fechas no son iguales
		assertFalse(peli1.equals(peli2));
	}
	
	@Test
	public void testPeliculaToString() {
		Entrada peliculaToString = new Entrada();
		peliculaToString.setCodigo(1);
		peliculaToString.setFechaCompra(null);
		peliculaToString.setPelicula(null);
		peliculaToString.setHorario(null);
		peliculaToString.setSala(null);
		peliculaToString.setPrecio(5.76);
		
		String peli = peliculaToString.toString();
		
		assertEquals(peli, peliculaToString.toString());
		
	}

	@Test
	public void testHasCode() {
		Entrada pelicula1 = new Entrada();
		pelicula1.setCodigo(1);
		pelicula1.setPrecio(5.76);
		
		Entrada pelicula2 = new Entrada();
		pelicula2.setCodigo(1);
		pelicula2.setPrecio(5.76);
		
		assertEquals(pelicula1.hashCode(), pelicula2.hashCode());
	}

}
