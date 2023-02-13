package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import bbdd.pojos.Cliente;

class ClienteTest {

	@Test
	public void testGettersAndSetters() {
		Cliente metodos = new Cliente();
		
		metodos.setCodigo(0);
		assertEquals(metodos.getCodigo(), 0);
		
		metodos.setNombre("Jose Maria");
		assertEquals(metodos.getNombre(), "Jose Maria");
	}

	@Test
	public void testClienteEquals() {
		Cliente cliente1 = new Cliente();
		cliente1.setCodigo(1);
		cliente1.setDni("12345678A");
		cliente1.setNombre("Marcos");
		cliente1.setApellido("Lopez");
		cliente1.setSexo('V');
		cliente1.setPasswd("contra123");
		
		Cliente cliente2 = new Cliente();
		cliente2.setCodigo(1);
		cliente2.setDni("12345678A");
		cliente2.setNombre("Marcos");
		cliente2.setApellido("Lopez");
		cliente2.setSexo('V');
		cliente2.setPasswd("contra123");
		
		assertTrue(cliente1.equals(cliente2));
	}
	
	@Test
	public void testClienteToString() {
		Cliente clienteToString = new Cliente();
		clienteToString.setCodigo(1);
		clienteToString.setDni("12345678A");
		clienteToString.setNombre("Marcos");
		clienteToString.setApellido("Lopez");
		clienteToString.setSexo('V');
		clienteToString.setPasswd("contra123");
		
		assertEquals("Cliente [codigo=" + 1 + ", dni=" + "12345678A" + ", nombre=" + "Marcos" + ", apellido=" + "Lopez"
				+ ", sexo=" + "V" + ", passwd=" + "contra123" + "]", clienteToString.toString());
				
	}

	@Test
	public void testHasCode() {
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setNombre("Elorrieta");
		
		assertNotNull(cliente.hashCode());
	}

}
