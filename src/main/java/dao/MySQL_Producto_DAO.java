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
			String sql = "call USP_AgregarProducto(?,?,?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, producto.getCodigoCategoria());
			preparedStatement.setBlob(2, producto.getImagen());
			preparedStatement.setString(3, producto.getNombre());
			preparedStatement.setDouble(4, producto.getPrecio());
			preparedStatement.setInt(5, producto.getStock());
			preparedStatement.setDouble(6, producto.getEstrellas());
			
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
				producto.setCodigo(result.getInt("codigo"));
				producto.setCodigoCategoria(result.getInt("codigoCategoria"));
				producto.setImagen(result.getBinaryStream("imagen"));
				producto.setNombre(result.getString("nombre"));
				producto.setPrecio(result.getDouble("precio"));
				producto.setStock(result.getInt("stock"));
				producto.setEstrellas(result.getDouble("estrellas"));
				producto.setNombreCategoria(result.getString("nombreCategoria"));
				
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
				producto.setCodigo(result.getInt("codigo"));
				producto.setCodigoCategoria(result.getInt("codigoCategoria"));
				producto.setImagen(result.getBinaryStream("imagen"));
				producto.setNombre(result.getString("nombre"));
				producto.setPrecio(result.getDouble("precio"));
				producto.setStock(result.getInt("stock"));
				producto.setEstrellas(result.getDouble("estrellas"));
				producto.setNombreCategoria(result.getString("nombreCategoria"));
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
			String sql = "call USP_ModificarProducto(?,?,?,?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, producto.getCodigo());
			preparedStatement.setInt(2, producto.getCodigoCategoria());
			preparedStatement.setBlob(3, producto.getImagen());
			preparedStatement.setString(4, producto.getNombre());
			preparedStatement.setDouble(5, producto.getPrecio());
			preparedStatement.setInt(6, producto.getStock());
			preparedStatement.setDouble(7, producto.getEstrellas());
			
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
