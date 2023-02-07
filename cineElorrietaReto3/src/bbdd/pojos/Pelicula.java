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
	private int duracion = 0;
	private String genero = "";
	private double coste = 0;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
		return Objects.hash(codigo, coste, duracion, genero);
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
				&& duracion == other.duracion && Objects.equals(genero, other.genero);
	}
	
	@Override
	public String toString() {
		return "Pelicula [codigo=" + codigo + ", duracion=" + duracion + ", genero=" + genero + ", coste=" + coste
				+ "]";
	}
}
