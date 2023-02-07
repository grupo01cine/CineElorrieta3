package bbdd.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * POJO - Describe la tabla Sala
 * 
 * Relacion N:1 con la tabla Cine 
 * Relacion 1:N con la tabla Proyeccion 
 */
public class Sala implements Serializable{

	private static final long serialVersionUID = -9008053608731348826L;

	// Clave primaria
	private int codigo = 0;
	
	// Atributos
	private String nombre = "";
	
	// Atributo de la relacion
	private ArrayList<Pelicula> pelicula = null;

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

	public ArrayList<Pelicula> getPelicula() {
		return pelicula;
	}

	public void setPelicula(ArrayList<Pelicula> pelicula) {
		this.pelicula = pelicula;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nombre, pelicula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return codigo == other.codigo && Objects.equals(nombre, other.nombre)
				&& Objects.equals(pelicula, other.pelicula);
	}

	@Override
	public String toString() {
		return "Sala [codigo=" + codigo + ", nombre=" + nombre + ", pelicula=" + pelicula + "]";
	}	
	
}
