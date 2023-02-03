package controlador;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bbdd.pojos.Cliente;


public class GestorUsuarios {
	
	public void registroUsuario(Cliente cliente) {
		
//				Meter en la BD
		System.out.println("Falta la BD");
		

		//Meter esta info en el array y en la BD
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
