package bbdd.pojos;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO - Describe la tabla Sala
 */
public class Sala implements Serializable{

	private static final long serialVersionUID = -9008053608731348826L;

	// Clave primaria
	private int codigo = 0;
	
	// Atributos
	private String nombre = "";
	
	// Atributo de la relacion
	// Relacion 1:N con la tabla Cine (en un cine hay N salas; 1 sala pertenece a 1 cine)
	private Cine cine = null;

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

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cine, codigo, nombre);
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
		return Objects.equals(cine, other.cine) && codigo == other.codigo && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Sala [codigo=" + codigo + ", nombre=" + nombre + ", cine=" + cine + "]";
	}

	
	
}
