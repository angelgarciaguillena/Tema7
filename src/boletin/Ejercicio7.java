package boletin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar la conexion con la base de datos*/
		final String CONEXION = "jdbc:mysql://localhost/institutodb";
		
		/*Creamos una variable para almacenar el nombre de usuario*/
		final String USUARIO = "root";
		
		/*Creamos una variable para almacenar la contraseña*/
		final String CONTRASEÑA = "AngelSQL1234";
		
		/*Creamos una variable para almacenar el nombre del alumno*/
		String nombre;
		
		/*Creamos una variable para almacenar el apellido del alumno*/
		String apellido;
		
		/*Creamos una variable para almacenar la fecha de nacimiento del alumno*/
		String fechaNacimiento;
		
		/*Creamos una variable para almacenar el email del alumno*/
		String email;
		
		/*Creamos una variable para almacenar el telefono del alumno*/
		String telefono;
		
		/*Creamos un Scanner*/
		Scanner sc = new Scanner(System.in);
		
		/*Pedimos al usuario que introduzca el nombre del alumno*/
		System.out.println("Introduce el nombre del alumno");
		
		/*Leemos el nombre del alumno*/
		nombre = sc.nextLine();
		
		/*Pedimos al usuario que introduzca el apellido del alumno*/
		System.out.println("Introduce el apellido del alumno");
		
		/*Leemos el apellido del alumno*/
		apellido = sc.nextLine();
		
		/*Pedimos al usuario que introduzca la fecha de nacimiento del alumno*/
		System.out.println("Introduce la fecha de nacimiento del alumno");
		
		/*Leemos la fecha de nacimiento del alumno*/
		fechaNacimiento = sc.nextLine();
		
		/*Pedimos al usuario que introduzca el email del alumno*/
		System.out.println("Introduce el email del alumno");
		
		/*Leemos el email del alumno*/
		email = sc.nextLine();
		
		/*Pedimos al usuario que introduzca el telefono del alumno*/
		System.out.println("Introduce el telefono del alumno");
		
		/*Leemos el telefono del alumno*/
		telefono = sc.nextLine();
		
		/*Creamos un try catch para avisar al usuario en caso de que se produzca un error*/
		try(Connection con = DriverManager.getConnection(CONEXION, USUARIO, CONTRASEÑA)){
			
			/*Creamos la consulta con los datos del alumno*/
			String consulta = "INSERT INTO estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) VALUES" 
					+ "('" + nombre + "'" + ", '" + apellido + "'" + ", '" + fechaNacimiento + "'" + ", '" + email + "'" + ", '" + telefono + "')";
			
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