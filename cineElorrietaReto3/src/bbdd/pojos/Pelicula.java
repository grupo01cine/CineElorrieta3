package bbdd.pojos;

import java.io.Serializable;
import java.util.Date;
//import java.sql.Date;

/**
 * POJO - Describe la tabla Pelicula
 */
public class Pelicula implements Serializable{

	private static final long serialVersionUID = 2447190224074521651L;
	
	private int codigo = 0;
	
	private Date duracion;
	private String genero = "";
	private float coste = 0;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getDuracion() {
		return duracion;
	}
	public void setDuracion(Date duracion) {
		this.duracion = duracion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public float getCoste() {
		return coste;
	}
	public void setCoste(float coste) {
		this.coste = coste;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Pelicula [codigo=" + codigo + ", duracion=" + duracion + ", genero=" + genero + ", coste=" + coste
				+ "]";
	}
	
}
