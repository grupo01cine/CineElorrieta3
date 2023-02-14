package tests.testPojos;

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
		
		metodos.setDireccion("av. lib");
		assertEquals(metodos.getDireccion(), "av. lib");
		
		metodos.setSalas(null);
		assertEquals(metodos.getSalas(), null);
	}

	@Test
	public void testCineEquals() {
		Cine cine1 = new Cine();
		cine1.setCodigo(1);
		cine1.setNombre("Elorrieta cines");
		cine1.setDireccion("av. lib");
		cine1.setSalas(null);
		
		Cine cine2 = new Cine();
		cine2.setCodigo(1);
		cine2.setNombre("Elorrieta cines");
		cine2.setDireccion("av. lib");
		cine2.setSalas(null);
		
		assertTrue(cine1.equals(cine2));
	}
	
	@Test
	public void testCineToString() {
		Cine cineToString = new Cine();
		cineToString.setCodigo(1);
		cineToString.setNombre("Elorrieta cines");
		cineToString.setDireccion("Calle abando");
		cineToString.setSalas(null);
		
		assertEquals("Cine [codigo=" + 1 + ", nombre=" + "Elorrieta cines" + ", direccion=" + "Calle abando" + ", salas=" + null + "]", cineToString.toString());		
	}

	@Test
	public void testHasCode() {
		Cine elorrieta = new Cine();
		elorrieta.setCodigo(1);
		elorrieta.setNombre("Elorrieta");
		
		assertNotNull(elorrieta.hashCode());
	}

}
