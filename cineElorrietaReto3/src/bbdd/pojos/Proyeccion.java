package bbdd.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * POJO - Describe la tabla Proyeccion
 */
public class Proyeccion implements Serializable{

	private static final long serialVersionUID = -7358141752621918212L;

	private int codigo = 0;
	
	private Date fecha = null;
	private Date horario = null;
	
	private Sala sala = null;
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
		return Objects.hash(codigo, fecha, horario, pelicula, sala);
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
				&& Objects.equals(pelicula, other.pelicula) && Objects.equals(sala, other.sala);
	}
	
	@Override
	public String toString() {
		return "Proyeccion [codigo=" + codigo + ", fecha=" + fecha + ", horario=" + horario + ", sala=" + sala
				+ ", pelicula=" + pelicula + "]";
	}
}
