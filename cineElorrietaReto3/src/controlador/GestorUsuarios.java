package controlador;

import java.util.ArrayList;

import bbdd.pojos.Cliente;


public class GestorUsuarios {
	
	public Cliente generarNuevoCliente(String dni, String nombre, String apellido, String sexo, String passwrd) {
		Cliente ret = new Cliente();
		ret.setDni(dni);
		ret.setNombre(nombre);
		ret.setApellido(apellido);
		ret.setSexo(sexo);
		ret.setPasswd(passwrd);
		return ret;
	}
	
	
	public boolean loginUsuario(String dni, String passwrd) {
		boolean ret = false;
		
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		GestorBasesDeDatos gestorbbdd = new GestorBasesDeDatos();
		listaClientes = gestorbbdd.sacarTodosLosClientes();
		
		for(Cliente cliente : listaClientes) {
			if((dni.equals(cliente.getDni()))&&(passwrd.equals(cliente.getPasswd()))) {
				ret=true;
			}
		}
		
		return ret;
	}
		
		

}
