package bbdd.pojos;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO - Describe la tabla Cine
 * 
 * Relacion 1:N con la tabla Sala
 */
public class Cine implements Serializable{
	
	private static final long serialVersionUID = -4280170159871175756L;

	// Clave primaria
	private int codigo = 0;
	
	// Atributos
	private String nombre = "";
	private String direccion = "";
	private int telefono = 0;

	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Cine [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo, direccion, nombre, telefono);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return codigo == other.codigo && Objects.equals(direccion, other.direccion)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}
	
}
