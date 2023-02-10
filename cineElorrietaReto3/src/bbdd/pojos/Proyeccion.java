package bbdd.pojos;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

/**
 * POJO - Describe la tabla Proyeccion
 */
public class Proyeccion implements Serializable{

	private static final long serialVersionUID = -7358141752621918212L;

	// Clave primaria
	private int codigo = 0;
	
	// Atributos
	private Date fecha = null;
	private LocalTime horario = null;
	private Double precio = (double) 0;
	
	// Atributos de la relacion
	//  Relacion N:1 con la tabla Sala
	private Sala sala = null;
	//  Relacion N:1 con la tabla Pelicula
	private Pelicula pelicula = null;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
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
	public int hashCode() {
		return Objects.hash(codigo, fecha, horario, pelicula, precio, sala);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyeccion other = (Proyeccion) obj;
		return codigo == other.codigo && Objects.equals(fecha, other.fecha) && Objects.equals(horario, other.horario)
				&& Objects.equals(pelicula, other.pelicula) && Objects.equals(precio, other.precio)
				&& Objects.equals(sala, other.sala);
	}
	@Override
	public String toString() {
		return "Proyeccion [codigo=" + codigo + ", fecha=" + fecha + ", horario=" + horario + ", precio=" + precio
				+ ", sala=" + sala + ", pelicula=" + pelicula + "]";
	}
	
	
	
}
