package bbdd.pojos;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO - Describe la tabla Cliente
 */
public class Cliente implements Serializable{

	private static final long serialVersionUID = -994353513114460752L;

	// Clave primaria
	private int codigo = 0;
	
	// Atributos
	private String dni = "";
	private String nombre = "";
	private String apellido = "";
	private char sexo = '\0';
	private String passwd = "";
	
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", sexo=" + sexo + ", passwd=" + passwd + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(apellido, codigo, dni, nombre, passwd, sexo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellido, other.apellido) && codigo == other.codigo && Objects.equals(dni, other.dni)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(passwd, other.passwd) && sexo == other.sexo;
	}	
}
