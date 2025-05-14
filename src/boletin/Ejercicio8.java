package boletin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar la conexion con la base de datos*/
		final String CONEXION = "jdbc:mysql://localhost/institutodb";
		
		/*Creamos una variable para almacenar el nombre de usuario*/
		final String USUARIO = "root";
		
		/*Creamos una variable para almacenar la contraseña*/
		final String CONTRASEÑA = "AngelSQL1234";
		
		/*Creamos una variable para almacenar el id del estudiante*/
		int id;
		
		/*Creamos un Scanner*/
		Scanner sc = new Scanner(System.in);
		
		/*Pedimos al usuario que introduzca el id del alumno que se quiere eliminar*/
		System.out.println("Introduce el id del estudiante");
		
		/*Leemos el id del estudiante*/
		id = sc.nextInt();
		
		/*Creamos un try catch para avisar al usuario en caso de que se produzca un error*/
		try(Connection con = DriverManager.getConnection(CONEXION, USUARIO, CONTRASEÑA)){
			
			/*Creamos la consulta para eliminar al alumno*/
			String consulta = "DELETE FROM estudiantes WHERE id_estudiante = " + id;
			
			/*Añadimos un mensaje de que se ha realizado la conexion con la base de datos*/
			System.out.println("La conexion se ha realizado");
			
			/*Creamos una sentencia*/
			Statement sentencia = con.createStatement();
			
			/*Ejecutamos la consulta*/
			sentencia.executeUpdate(consulta);	
			
		} catch(SQLException e) {
			System.out.println("Error con la base de datos " + e.getMessage());
		}
		
		/*Cerramos el Scanner*/
		sc.close();
	}
}