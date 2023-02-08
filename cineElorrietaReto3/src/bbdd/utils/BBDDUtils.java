package bbdd.utils;

// Configuraciones necesarias para la Base de Datos de MySql
public class BBDDUtils {

// ** Utils para conexion con Base de datos REMOTA **
	// La URL donde esta la Base de Datos. Se descompone en:
	// driver : bbd : // IP : Puerto / Schema
	public static final String URL_REMOTO = "jdbc:mysql://10.5.14.125:3306/CinesElorrieta";

	// El Driver que vamos a usar
	public static final String DRIVER_REMOTO = "com.mysql.cj.jdbc.Driver";

	// Nombre y Pass de acceso a la Base de Datos
	public static final String USER_REMOTO = "userSelectsJava";
	public static final String PASS_REMOTO = "Grupo01.reto";

// ** Utils para trabajar de forma LOCAL **
	//public static final String URL_LOCAL = "jdbc:mysql://localhost:3306/cineselorrieta";

	//public static final String DRIVER_LOCAL = "com.mysql.cj.jdbc.Driver";

	//public static final String USER_LOCAL = "root";
	//public static final String PASS_LOCAL = "";

}
