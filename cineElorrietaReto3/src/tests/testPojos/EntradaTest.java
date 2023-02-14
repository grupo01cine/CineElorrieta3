package tests.testPojos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import bbdd.pojos.Entrada;

class EntradaTest {

	@Test
	public void testGettersAndSetters() {
		Entrada entrada = new Entrada();
		
		entrada.setCodigo(0);
		assertEquals(entrada.getCodigo(), 0);
		
		entrada.setFechaCompra(null);
		assertEquals(entrada.getFechaCompra(), null);
		
		entrada.setHoraCompra(null);
		assertEquals(entrada.getHoraCompra(), null);
		
		entrada.setProyeccion(null);
		assertEquals(entrada.getProyeccion(), null);
		
		entrada.setCliente(null);
		assertEquals(entrada.getCliente(), null);
		
	}

	@Test
	public void testEntradaEquals() {
		Entrada entrada1 = new Entrada();
		entrada1.setCodigo(1);
		entrada1.setFechaCompra(null);
		entrada1.setHoraCompra(null);
		
		Entrada entrada2 = new Entrada();
		entrada2.setCodigo(1);
		entrada2.setFechaCompra(null);
		entrada2.setHoraCompra(null);
		
		// Las fechas no son iguales
		assertTrue(entrada1.equals(entrada2));
	}
	
	@Test
	public void testEntradaToString() {
		Entrada entradaToString = new Entrada();
		entradaToString.setCodigo(1);
		entradaToString.setFechaCompra(null);
		entradaToString.setHoraCompra(null);
		entradaToString.setProyeccion(null);
		entradaToString.setCliente(null);		
		
		assertEquals("Entrada [codigo=" + 1 + ", fechaCompra=" + null + ", horaCompra=" + null + ", proyeccion=" + null + ", cliente=" + null + "]", entradaToString.toString());
		
	}

	@Test
	public void testHasCode() {
		Entrada entrada1 = new Entrada();
		entrada1.setCodigo(1);		
		
		Entrada entrada2 = new Entrada();
		entrada2.setCodigo(1);
		
		assertEquals(entrada1.hashCode(), entrada2.hashCode());
	}

}
