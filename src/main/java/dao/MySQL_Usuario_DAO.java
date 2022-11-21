package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Usuario_DTO;
import interfaces.Usuario_DAO;
import utils.MySQLConexion;

public class MySQL_Usuario_DAO implements Usuario_DAO {

	@Override
	public int agregar(Usuario_DTO usuario) {
		int agregar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_AgregarUsuario(?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getUsuario());
			preparedStatement.setString(2, usuario.getClave());
			preparedStatement.setString(3, usuario.getNombre());
			preparedStatement.setString(4, usuario.getApellidos());
			
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
	public ArrayList<Usuario_DTO> listar() {
		ArrayList<Usuario_DTO> usuarios = new ArrayList<Usuario_DTO>();
		
		Usuario_DTO usuario;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_LeerUsuario();";
			
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				usuario = new Usuario_DTO();
				usuario.setCodigo(result.getInt(1));
				usuario.setUsuario(result.getString(2));
				usuario.setClave(result.getString(3));
				usuario.setNombre(result.getString(4));
				usuario.setApellidos(result.getString(5));
				
				usuarios.add(usuario);
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
		
		return usuarios;
	}

	@Override
	public Usuario_DTO buscar(int codigo) {
		Usuario_DTO usuario = new Usuario_DTO();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_BuscarUsuario(?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, codigo);
			
			result = preparedStatement.executeQuery();
			
			if(result.next()) {
				usuario.setCodigo(result.getInt(1));
				usuario.setUsuario(result.getString(2));
				usuario.setClave(result.getString(3));
				usuario.setNombre(result.getString(4));
				usuario.setApellidos(result.getString(5));	
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
		
		return usuario;	
	}

	@Override
	public int modificar(Usuario_DTO usuario) {
		int modificar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_ModificarUsuario(?,?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getUsuario());
			preparedStatement.setString(2, usuario.getClave());
			preparedStatement.setString(3, usuario.getNombre());
			preparedStatement.setString(4, usuario.getApellidos());
			preparedStatement.setInt(5, usuario.getCodigo());
			
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
			String sql = "call USP_BorrarUsuario(?);";
			
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
