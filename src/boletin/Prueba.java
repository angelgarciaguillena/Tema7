package boletin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prueba {
	public static void main(String[] args) {
		
		String conexion = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String contraseña = "AngelSQL1234";
		
		try(Connection con = DriverManager.getConnection(conexion, usuario, contraseña)){
			System.out.println("La conexion se ha realizado");
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("select * from estudiantes");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}
		} catch(SQLException e) {
			System.out.println("Error con la base de datos " + e);
		}
	}
}