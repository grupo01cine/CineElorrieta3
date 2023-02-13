package controlador;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	
	
	public void loginUsuario(ArrayList<Cliente> listaClientes, String dni, String passwrd) {
		for(Cliente cliente : listaClientes) {
			if((dni.equals(cliente.getDni()))&&(passwrd.equals(cliente.getPasswd()))) {
				Component btnAceptarInicioSesion = null;
				JOptionPane.showMessageDialog(btnAceptarInicioSesion, "Usuario o contraseña incorrectos", "Error", 0);
			}
		}
	}
		
		

}
