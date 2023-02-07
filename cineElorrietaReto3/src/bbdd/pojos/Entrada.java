package bbdd.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * POJO - Describe la tabla Entrada 
 * 
 * Relacion N:1 con la tabla Cliente
 * Relacion N:1 con la tabla Proyeccion
 */
public class Entrada implements Serializable{

	private static final long serialVersionUID = 5803034015734968201L;

	// Clave primaria
	private int codigo = 0;
	
	// Atributos
	private Date fechaCompra;
	private Date horario;	
	private double precio = 0;
	
	// Atributos de la Relacion 
	private Sala sala = null;	
	private Pelicula pelicula = null;
	
	
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo, fechaCompra, horario, pelicula, precio, sala);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return codigo == other.codigo && Objects.equals(fechaCompra, other.fechaCompra)
				&& Objects.equals(horario, other.horario) && Objects.equals(pelicula, other.pelicula)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(sala, other.sala);
	}
	
	@Override
	public String toString() {
		return "Entrada [codigo=" + codigo + ", fechaCompra=" + fechaCompra + ", pelicula=" + pelicula + ", horario="
				+ horario + ", sala=" + sala + ", precio=" + precio + "]";
	}
	
}
