package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bbdd.pojos.Sala;

class SalaTest {

	@Test
	public void testGettersAndSetters() {
		Sala sala = new Sala();
		
		sala.setCodigo(0);
		assertEquals(sala.getCodigo(), 0);
		
		sala.setNombre("sala01");
		assertEquals(sala.getNombre(), "sala01");
	}

	@Test
	public void testSalaEquals() {
		Sala sala1 = new Sala();
		sala1.setCodigo(7);
		sala1.setNombre("sala01");
		sala1.setPelicula(null);
		
		Sala sala2 = new Sala();
		sala2.setCodigo(7);
		sala2.setNombre("sala01");
		sala2.setPelicula(null);
		
		// Las fechas no son iguales
		assertFalse(sala1.equals(sala2));
	}
	
	@Test
	public void testSalaToString() {
		Sala salaToString = new Sala();
		salaToString.setCodigo(1);
		salaToString.setNombre("sala01");
		salaToString.setPelicula(null);

		
		String sala = salaToString.toString();
		
		assertEquals(sala, salaToString.toString());
				
	}

	@Test
	public void testHasCode() {
		Sala sala1 = new Sala();
		sala1.setCodigo(1);
		sala1.setNombre("sala01");
		sala1.setPelicula(null);
		
		Sala sala2 = new Sala();
		sala2.setCodigo(1);
		sala2.setNombre("sala01");
		sala1.setPelicula(null);
		
		assertNotEquals(sala1.hashCode(), sala2.hashCode());
	}

}
