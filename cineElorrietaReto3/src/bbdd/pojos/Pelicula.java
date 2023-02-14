package bbdd.pojos;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 * POJO - Describe la tabla Pelicula
 */
public class Pelicula implements Serializable {

	private static final long serialVersionUID = 2447190224074521651L;

	// Clave primaria
	private int codigo = 0;

	// Atributos
	private String titulo = null;
	private LocalTime duracion = null;
	private String genero = null;
	private double coste = 0;

	// Atributo de la relacion
	// Relacion 1:N con la tabla Proyeccion (una Pelicula tiene de 1 a N
	// Proyecciones)
	private ArrayList<Proyeccion> proyecciones = null;

	// Setters y Getters
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

	public LocalTime getDuracion() {
		return duracion;
	}

	public void setDuracion(LocalTime duracion) {
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

	public ArrayList<Proyeccion> getProyecciones() {
		return proyecciones;
	}

	public void setProyecciones(ArrayList<Proyeccion> proyecciones) {
		this.proyecciones = proyecciones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, coste, duracion, genero, proyecciones, titulo);
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
				&& Objects.equals(duracion, other.duracion) && Objects.equals(genero, other.genero)
				&& Objects.equals(proyecciones, other.proyecciones) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", duracion=" + duracion + ", genero=" + genero
				+ ", coste=" + coste + ", proyecciones=" + proyecciones + "]";
	}
}
