package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	public static Connection getConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3310/bd_bakery_lp2?useSSL=false&useTimezone=true&serverTimezone=UTC";
			String usr = "root";
			String psw = "admin";
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error >> de conexi�n con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> general : " + e.getMessage());
		}
		return con;
	}

	public static void closeConexion(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Problemas al cerrar la conexion");
		}
	}

}
