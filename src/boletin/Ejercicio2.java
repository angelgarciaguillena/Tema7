package boletin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio2 {
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar la conexion con la base de datos*/
		final String CONEXION = "jdbc:mysql://localhost/institutodb";
		
		/*Creamos una variable para almacenar el nombre de usuario*/
		final String USUARIO = "root";
		
		/*Creamos una variable para almacenar la contraseña*/
		final String CONTRASEÑA = "AngelSQL1234";
		
		/*Creamos un try catch para avisar al usuario en caso de que se produzca un error*/
		try(Connection con = DriverManager.getConnection(CONEXION, USUARIO, CONTRASEÑA)){
			
			/*Creamos la consulta*/
			String consulta1 = "UPDATE estudiantes SET nombre = 'Ana modificado' WHERE nombre = 'Ana'";
			
			/*Creamos la segunda consulta*/
			String consulta2 = "UPDATE profesores SET nombre = 'Javier modificado' WHERE nombre = 'Javier'";
			
			/*Creamos la tercera consulta*/
			String consulta3 = "UPDATE cursos SET nombre = 'Lengua 2º' WHERE nombre = 'Lengua 1º'";
			
			/*Añadimos un mensaje de que se ha realizado la conexion con la base de datos*/
			System.out.println("La conexion se ha realizado");
			
			/*Creamos una sentencia*/
			Statement sentencia = con.createStatement();
			
			/*Ejecutamos la consulta 1*/
			sentencia.executeUpdate(consulta1);	
			
			/*Ejecutamos la consulta 2*/
			sentencia.executeUpdate(consulta2);
			
			/*Ejecutamos la consulta 3*/
			sentencia.executeUpdate(consulta3);
			
		} catch(SQLException e) {
			System.out.println("Error con la base de datos " + e.getMessage());
		}
	}
}