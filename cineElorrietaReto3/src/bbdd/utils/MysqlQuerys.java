package bbdd.utils;

public class MysqlQuerys {

	public MysqlQuerys() {
		
	}
	
	// Películas que más dinero hayan generado, ordenadas de mayor al menor
	public static final String PELICULAS_MAS_DINERO = "SELECT p.*,  FROM Pelicula WHERE ";
	
	// Los 10 usuarios que más películas han visto
	public static final String TOP_10_USUARIOS = "";
	
	// Cines que más clientes distintos tienen, con su conteo 
	public static final String CINES_CON_MAS_CLIENTES = "";
	
	/* Por cada género (de película), cuántas películas han visto los hombres y las mujeres, junto
	con el porcentaje que supone sobre el total de películas vistas */
	public static final String PELICULAS_POR_GENERO = "";
	
	/* Obtener una consulta que contiene un listado con el DNI y nombre de los clientes, junto con
	el nombre de las películas que han visto, el nombre de la sala en la que lo vieron, la hora y el
	nombre del cine */
	public static final String TODOS_CLIENTES_CON_TODAS_PELIS_VISTAS= "";

}
