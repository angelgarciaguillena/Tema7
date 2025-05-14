package boletin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio5 {
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar la conexion con la base de datos*/
		final String CONEXION = "jdbc:mysql://localhost/institutodb";
		
		/*Creamos una variable para almacenar el nombre de usuario*/
		final String USUARIO = "root";
		
		/*Creamos una variable para almacenar la contraseña*/
		final String CONTRASEÑA = "AngelSQL1234";
		
		/*Creamos un try catch para avisar al usuario en caso de que se produzca un error*/
		try(Connection con = DriverManager.getConnection(CONEXION, USUARIO, CONTRASEÑA)){
			
			/*Creamos la consulta con los datos de las calificaciones*/
			String consulta = "INSERT INTO calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion)" + 
			" VALUES (1, 3, 1, 'Examen', 9.40, '2025-04-03')";
			consulta += ",(3, 7, 2, 'Trabajo', 6.30, '2025-02-01')";
			consulta += ",(2, 4, 1, 'Participacion', 7.10, '2025-01-03')";
			consulta += ",(2, 2, 2, 'Examen', 6.50, '2025-02-03')";
			
			/*Añadimos un mensaje de que se ha realizado la conexion con la base de datos*/
			System.out.println("La conexion se ha realizado");
			
			/*Creamos una sentencia*/
			Statement sentencia = con.createStatement();
			
			/*Ejecutamos la consulta*/
			sentencia.executeUpdate(consulta);	
			
		} catch(SQLException e) {
			System.out.println("Error con la base de datos " + e.getMessage());
		}
	}
}