package bbdd.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * POJO - Describe la tabla Cine
 * 
 * Relacion 1:N con la tabla Sala
 */
public class Cine implements Serializable {

	private static final long serialVersionUID = -4280170159871175756L;

	// Clave primaria
	private int codigo = 0;

	// Atributos
	private String nombre = "";
	private String direccion = "";

	// Atributo de la relacion
	// Relacion 1:N con la tabla Sala (en un cine hay N salas)
	private ArrayList<Cine> cines = null;

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

	public ArrayList<Cine> getCines() {
		return cines;
	}

	public void setCines(ArrayList<Cine> cines) {
		this.cines = cines;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cines, codigo, direccion, nombre);
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
		return Objects.equals(cines, other.cines) && codigo == other.codigo
				&& Objects.equals(direccion, other.direccion) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Cine [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", cines=" + cines + "]";
	}

	

}
