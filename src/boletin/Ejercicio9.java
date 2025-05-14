package boletin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio9 {
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar la conexion con la base de datos*/
		final String CONEXION = "jdbc:mysql://localhost/institutodb";
		
		/*Creamos una variable para almacenar el nombre de usuario*/
		final String USUARIO = "root";
		
		/*Creamos una variable para almacenar la contraseña*/
		final String CONTRASEÑA = "AngelSQL1234";
		
		/*Creamos un try catch para avisar al usuario en caso de que se produzca un error*/
		try(Connection con = DriverManager.getConnection(CONEXION, USUARIO, CONTRASEÑA)){
			
			/*Creamos la consulta con los datos de los alumnos*/
			String consulta = "SELECT nombre, fecha_nacimiento FROM estudiantes";
			
			/*Añadimos un mensaje de que se ha realizado la conexion con la base de datos*/
			System.out.println("La conexion se ha realizado");
			
			/*Creamos una sentencia*/
			Statement sentencia = con.createStatement();
			
			/*Ejecutamos la consulta*/
			ResultSet rs = sentencia.executeQuery(consulta);
			
			/*Mostramos los campos de los alumnos*/
			System.out.println("\n" + "Nombre" + "  " + "Fecha de nacimiento");
			
			/*Creamos un bucle while para mostrar la informacion de la consulta*/
			while(rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getString(2));
			}
			
		} catch(SQLException e) {
			System.out.println("Error con la base de datos " + e.getMessage());
		}
	}
}