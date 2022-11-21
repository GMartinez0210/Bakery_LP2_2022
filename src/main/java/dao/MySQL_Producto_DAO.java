package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Producto_DTO;
import interfaces.Producto_DAO;
import utils.MySQLConexion;

public class MySQL_Producto_DAO implements Producto_DAO {

	@Override
	public int agregar(Producto_DTO producto) {
		int agregar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_AgregarProducto(?,?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setBlob(1, producto.getImagen());
			preparedStatement.setString(2, producto.getNombre());
			preparedStatement.setDouble(3, producto.getPrecio());
			preparedStatement.setInt(4, producto.getStock());
			preparedStatement.setDouble(5, producto.getEstrellas());
			
			agregar = preparedStatement.executeUpdate();
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
				System.out.println(">>>ERROR en la BD: "+ e2.getMessage());
			}
		}
		
		return agregar;
	}

	@Override
	public ArrayList<Producto_DTO> listar() {
		ArrayList<Producto_DTO> productos = new ArrayList<Producto_DTO>();
		
		Producto_DTO producto;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_LeerProducto();";
			
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				producto = new Producto_DTO();
				producto.setCodigo(result.getInt(1));
				producto.setImagen(result.getBinaryStream(2));
				producto.setNombre(result.getString(3));
				producto.setPrecio(result.getDouble(4));
				producto.setStock(result.getInt(5));
				producto.setEstrellas(result.getDouble(6));
				
				productos.add(producto);
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
				System.out.println(">>>ERROR en la BD: "+ e2.getMessage());
			}
		}
		
		return productos;
	}

	@Override
	public Producto_DTO buscar(int codigo) {		
		Producto_DTO producto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_BuscarProducto(?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, codigo);
			
			result = preparedStatement.executeQuery();
			
			if(result.next()) {
				producto = new Producto_DTO();
				producto.setCodigo(result.getInt(1));
				producto.setImagen(result.getBinaryStream(2));
				producto.setNombre(result.getString(3));
				producto.setPrecio(result.getDouble(4));
				producto.setStock(result.getInt(5));
				producto.setEstrellas(result.getDouble(6));
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
				System.out.println(">>>ERROR en la BD: "+ e2.getMessage());
			}
		}
		
		return producto;
	}

	@Override
	public int modificar(Producto_DTO producto) {
		int modificar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_ModificarProducto(?,?,?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setBlob(1, producto.getImagen());
			preparedStatement.setString(2, producto.getNombre());
			preparedStatement.setDouble(3, producto.getPrecio());
			preparedStatement.setInt(4, producto.getStock());
			preparedStatement.setDouble(5, producto.getEstrellas());
			preparedStatement.setInt(6, producto.getCodigo());
			
			modificar = preparedStatement.executeUpdate();
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
				System.out.println(">>>ERROR en la BD: "+ e2.getMessage());
			}
		}
		
		return modificar;
	}

	@Override
	public int borrar(int codigo) {
		int borrar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_BorrarProducto(?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, codigo);

			
			borrar = preparedStatement.executeUpdate();
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
				System.out.println(">>>ERROR en la BD: "+ e2.getMessage());
			}
		}
		
		return borrar;
	}
}
