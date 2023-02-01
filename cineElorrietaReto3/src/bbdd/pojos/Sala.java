package bbdd.pojos;

import java.io.Serializable;

/**
 * POJO - Describe la tabla Sala
 */
public class Sala implements Serializable{

	private static final long serialVersionUID = -9008053608731348826L;

	private int codigo = 0;
	
	private String nombre = "";
	
	// Atributo relacion Pelicula
	private Pelicula pelicula = null;

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

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Sala [codigo=" + codigo + ", nombre=" + nombre + ", pelicula=" + pelicula + "]";
	}
	

	
	
}
