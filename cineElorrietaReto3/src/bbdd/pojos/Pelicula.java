package bbdd.pojos;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO - Describe la tabla Pelicula
 */
public class Pelicula implements Serializable{

	private static final long serialVersionUID = 2447190224074521651L;
	
	// Clave primaria
	private int codigo = 0;
	
	// Atributos
	private String titulo = null;
	private int duracion = 0;
	private String genero = null;
	private double coste = 0;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public double getCoste() {
		return coste;
	}
	public void setCoste(double coste) {
		this.coste = coste;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo, coste, duracion, genero, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return codigo == other.codigo && Double.doubleToLongBits(coste) == Double.doubleToLongBits(other.coste)
				&& duracion == other.duracion && Objects.equals(genero, other.genero)
				&& Objects.equals(titulo, other.titulo);
	}
	@Override
	public String toString() {
		return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", duracion=" + duracion + ", genero=" + genero
				+ ", coste=" + coste + "]";
	}
	

}
