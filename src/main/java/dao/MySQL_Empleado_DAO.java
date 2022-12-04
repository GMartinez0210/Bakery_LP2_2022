package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Empleado_DTO;
import interfaces.Empleado_DAO;
import utils.MySQLConexion;

public class MySQL_Empleado_DAO implements Empleado_DAO {

	@Override
	public int agregar(Empleado_DTO empleado) {
		int agregar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_AgregarEmpleado(?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, empleado.getClave());
			preparedStatement.setString(2, empleado.getNombre());
			preparedStatement.setString(3, empleado.getApellidos());
			
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
				System.out.println(">>> ERROR en la BD: "+ e2.getMessage());
			}
		}
		
		return agregar;
	}

	@Override
	public ArrayList<Empleado_DTO> listar() {
		ArrayList<Empleado_DTO> empleados = new ArrayList<Empleado_DTO>();
		
		Empleado_DTO empleado;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_LeerEmpleado();";
			
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				empleado = new Empleado_DTO();
				empleado.setDni(result.getString(1));
				empleado.setClave(result.getString(2));
				empleado.setNombre(result.getString(3));
				empleado.setApellidos(result.getString(4));
				
				empleados.add(empleado);
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
		
		return empleados;
	}

	@Override
	public Empleado_DTO buscar(String dni) {		
		Empleado_DTO empleado = new Empleado_DTO();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_BuscarEmpleado(?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dni);
			
			result = preparedStatement.executeQuery();
			
			if(result.next()) {
				empleado.setDni(result.getString(1));
				empleado.setClave(result.getString(2));
				empleado.setNombre(result.getString(3));
				empleado.setApellidos(result.getString(4));	
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
		
		return empleado;
	}

	@Override
	public int modificar(Empleado_DTO empleado) {
		int modificar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_ModificarEmpleado(?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, empleado.getClave());
			preparedStatement.setString(2, empleado.getNombre());
			preparedStatement.setString(3, empleado.getApellidos());
			preparedStatement.setString(4, empleado.getDni());
			
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
			String sql = "call USP_BorrarEmpleado(?);";
			
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
	public Empleado_DTO verificar(String dni, String contrasenna) {
		Empleado_DTO empleado = new Empleado_DTO();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_VerificarEmpleado(?, ?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dni);
			preparedStatement.setString(2, contrasenna);
			
			result = preparedStatement.executeQuery();
			
			if(result.next()) {
				empleado.setDni(result.getString(1));
				empleado.setNombre(result.getString(2));
				empleado.setApellidos(result.getString(3));
				empleado.setNombre(result.getString(4));	
				empleado.setEmail(result.getString(5));	
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
		
		return empleado;
	}

}
