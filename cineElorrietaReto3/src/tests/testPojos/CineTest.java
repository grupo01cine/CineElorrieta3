package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bbdd.pojos.Cine;

class CineTest {

	@Test
	public void testGettersAndSetters() {
		Cine metodos = new Cine();
		
		metodos.setCodigo(0);
		assertEquals(metodos.getCodigo(), 0);
		
		metodos.setNombre("elorrieta");
		assertEquals(metodos.getNombre(), "elorrieta");
	}

	@Test
	public void testCineEquals() {
		Cine cine1 = new Cine();
		cine1.setCodigo(1);
		cine1.setNombre("Elorrieta cines");
		cine1.setDireccion(null);
		cine1.setTelefono(0);
		
		Cine cine2 = new Cine();
		cine2.setCodigo(1);
		cine2.setNombre("Elorrieta cines");
		cine2.setDireccion(null);
		cine2.setTelefono(0);
		
		assertTrue(cine1.equals(cine2));
	}
	
	@Test
	public void testCineToString() {
		Cine cineToString = new Cine();
		cineToString.setCodigo(1);
		cineToString.setNombre("Elorrieta cines");
		cineToString.setDireccion("Calle abando");
		cineToString.setTelefono(654626462);
		
		assertEquals("Cine [codigo=" + 1 + ", nombre=" + "Elorrieta cines" + ", direccion=" + "Calle abando" + ", telefono=" + 654626462 + "]", cineToString.toString());
		
	}

	@Test
	public void testHasCode() {
		Cine elorrieta = new Cine();
		elorrieta.setCodigo(1);
		elorrieta.setNombre("Elorrieta");
		
		assertNotNull(elorrieta.hashCode());
	}

}
