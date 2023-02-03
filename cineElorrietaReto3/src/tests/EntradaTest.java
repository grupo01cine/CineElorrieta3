package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import bbdd.pojos.Entrada;

class EntradaTest {

	@Test
	public void testGettersAndSetters() {
		Entrada entrada = new Entrada();
		
		entrada.setCodigo(0);
		assertEquals(entrada.getCodigo(), 0);
		
		entrada.setPrecio(5.56);
		assertEquals(entrada.getPrecio(), 5.56);
	}

	@Test
	public void testEntradaEquals() {
		Entrada entrada1 = new Entrada();
		entrada1.setCodigo(1);
		entrada1.setFechaCompra(null);
		entrada1.setPelicula(null);
		entrada1.setHorario(null);
		entrada1.setSala(null);
		entrada1.setPrecio(5.76);
		
		Entrada entrada2 = new Entrada();
		entrada2.setCodigo(1);
		entrada2.setFechaCompra(null);
		entrada2.setPelicula(null);
		entrada2.setHorario(null);
		entrada2.setSala(null);
		entrada2.setPrecio(5.76);
		
		// Las fechas no son iguales
		assertFalse(entrada1.equals(entrada2));
	}
	
	@Test
	public void testEntradaToString() {
		Entrada entradaToString = new Entrada();
		entradaToString.setCodigo(1);
		entradaToString.setFechaCompra(null);
		entradaToString.setPelicula(null);
		entradaToString.setHorario(null);
		entradaToString.setSala(null);
		entradaToString.setPrecio(5.76);
		
		assertNotEquals("Entrada [codigo=" + 1 + ", fechaCompra=" + null + ", pelicula=" + null + ", horario=" + null +
				 ", sala=" + null + ", precio=" + 5.76 + "]", entradaToString.toString());
				
	}

	@Test
	public void testHasCode() {
		Entrada entrada1 = new Entrada();
		entrada1.setCodigo(1);
		entrada1.setPrecio(5.76);
		
		Entrada entrada2 = new Entrada();
		entrada2.setCodigo(1);
		entrada2.setPrecio(5.76);
		
		assertEquals(entrada1.hashCode(), entrada2.hashCode());
	}

}
