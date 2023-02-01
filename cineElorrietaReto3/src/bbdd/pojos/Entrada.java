package bbdd.pojos;

import java.io.Serializable;
import java.util.Date;

/**
 * POJO - Describe la tabla Entrada
 */
public class Entrada implements Serializable{

	private static final long serialVersionUID = 5803034015734968201L;

	private int codigo = 0;
	
	private Date fechaCompra;
	private Pelicula pelicula = null;
	private Date horario;
	private Sala sala = null;
	private float precio = 0;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Entrada [codigo=" + codigo + ", fechaCompra=" + fechaCompra + ", pelicula=" + pelicula + ", horario="
				+ horario + ", sala=" + sala + ", precio=" + precio + "]";
	}

	
	
}
