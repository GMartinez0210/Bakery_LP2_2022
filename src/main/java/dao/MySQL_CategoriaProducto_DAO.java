package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Codigo_Nombre_DTO;
import interfaces.Codigo_Nombre_DAO;
import utils.MySQLConexion;

public class MySQL_CategoriaProducto_DAO implements Codigo_Nombre_DAO {

	@Override
	public ArrayList<Codigo_Nombre_DTO> listar() {
		ArrayList<Codigo_Nombre_DTO> categorias = new ArrayList<Codigo_Nombre_DTO>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "SELECT * FROM categorias_producto";
			
			preparedStatement = connection.prepareStatement(sql);
			
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				Codigo_Nombre_DTO categoria = new Codigo_Nombre_DTO();
				categoria.setCodigo(result.getInt("codigo"));
				categoria.setNombre(result.getString("nombre"));
				
				categorias.add(categoria);
			}
			
		}
		catch (Exception e) {
			System.out.println(">>> ERROR en el query: " + e.getMessage());
		}
		finally {
			try {
				if(preparedStatement != null ) preparedStatement.close();
				if(connection != null) connection.close();
				
			} 
			catch (SQLException e2) {
				System.out.println(">>> ERROR en la BD: "+ e2.getMessage());
			}
		}
		
		return categorias;
	}

}
