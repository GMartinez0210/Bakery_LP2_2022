package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Cliente_DTO;
import interfaces.Cliente_DAO;
import utils.MySQLConexion;

public class MySQL_Cliente_DAO implements Cliente_DAO {

	@Override
	public int agregar(Cliente_DTO cliente) {
		int agregar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;		
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_AgregarCliente(?,?,?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cliente.getDni());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getClave());
			preparedStatement.setString(4, cliente.getNombre());
			preparedStatement.setString(5, cliente.getApellidos());
			preparedStatement.setBlob(6, cliente.getAvatar());
			
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
		
		return agregar;
	}

	@Override
	public ArrayList<Cliente_DTO> listar() {
		ArrayList<Cliente_DTO> clientes = new ArrayList<Cliente_DTO>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_LeerCliente();";
			
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				Cliente_DTO cliente = new Cliente_DTO();
				cliente.setDni(result.getString("dni"));
				cliente.setEmail(result.getString("email"));
				cliente.setClave(result.getString("clave"));
				cliente.setNombre(result.getString("nombre"));
				cliente.setApellidos(result.getString("apellido"));
				cliente.setAvatar(result.getBinaryStream("avatar"));
			
				clientes.add(cliente);
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
		
		return clientes;
	}

	@Override
	public Cliente_DTO buscar(String dni) {		
		Cliente_DTO cliente = new Cliente_DTO();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_BuscarCliente(?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dni);
			
			result = preparedStatement.executeQuery();
			
			if(result.next()) {
				cliente.setDni(result.getString("dni"));
				cliente.setEmail(result.getString("email"));
				cliente.setClave(result.getString("clave"));
				cliente.setNombre(result.getString("nombre"));
				cliente.setApellidos(result.getString("apellido"));
				cliente.setAvatar(result.getBinaryStream("avatar"));
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
		
		return cliente;
	}

	@Override
	public int modificar(Cliente_DTO cliente) {
		int modificar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_ModificarCliente(?,?,?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cliente.getDni());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getClave());
			preparedStatement.setString(4, cliente.getNombre());
			preparedStatement.setString(5, cliente.getApellidos());
			preparedStatement.setBlob(6, cliente.getAvatar());
			
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
				System.out.println(">>> ERROR en la BD: "+ e2.getMessage());
			}
		}
		
		return modificar;
	}

	@Override
	public int borrar(String dni) {
		int borrar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_BorrarCliente(?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dni);
			
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
				System.out.println(">>> ERROR en la BD: "+ e2.getMessage());
			}
		}
		
		return borrar;
	}

	@Override
	public Cliente_DTO verificar(String dni, String contrasenna) {
		Cliente_DTO cliente = new Cliente_DTO();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_VerificarCliente(?, ?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dni);
			preparedStatement.setString(2, contrasenna);
			
			result = preparedStatement.executeQuery();
			
			if(result.next()) {
				cliente.setDni(result.getString("dni"));
				cliente.setEmail(result.getString("email"));
				cliente.setClave(result.getString("clave"));
				cliente.setNombre(result.getString("nombre"));
				cliente.setApellidos(result.getString("apellido"));
				cliente.setAvatar(result.getBinaryStream("avatar"));
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
		
		return cliente;
	}

}
