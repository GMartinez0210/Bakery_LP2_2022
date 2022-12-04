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
			String sql = "call USP_AgregarEmpleado(?,?,?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, empleado.getDni());
			preparedStatement.setInt(2, empleado.getCodigoCargo());
			preparedStatement.setString(3, empleado.getEmail());
			preparedStatement.setString(1, empleado.getClave());
			preparedStatement.setString(1, empleado.getNombre());
			preparedStatement.setString(1, empleado.getApellidos());
			preparedStatement.setDouble(1, empleado.getSueldo());
			
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
				empleado.setDni(result.getString("dni"));
				empleado.setCodigoCargo(result.getInt("codigoCargo"));
				empleado.setEmail(result.getString("email"));
				empleado.setClave(result.getString("clave"));
				empleado.setNombre(result.getString("nombre"));
				empleado.setApellidos(result.getString("apellidos"));
				empleado.setSueldo(result.getInt("sueldo"));
				empleado.setNombreCargo(result.getString("nombreCargo"));
				
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
		Empleado_DTO empleado = null;
		
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
				empleado = new Empleado_DTO();
				empleado.setDni(result.getString("dni"));
				empleado.setCodigoCargo(result.getInt("codigoCargo"));
				empleado.setEmail(result.getString("email"));
				empleado.setClave(result.getString("clave"));
				empleado.setNombre(result.getString("nombre"));
				empleado.setApellidos(result.getString("apellidos"));
				empleado.setSueldo(result.getInt("sueldo"));
				empleado.setNombreCargo(result.getString("nombreCargo"));
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

	@Override
	public int modificar(Empleado_DTO empleado) {
		int modificar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String sql = "call USP_ModificarEmpleado(?,?,?,?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, empleado.getDni());
			preparedStatement.setInt(2, empleado.getCodigoCargo());
			preparedStatement.setString(3, empleado.getEmail());
			preparedStatement.setString(4, empleado.getClave());
			preparedStatement.setString(5, empleado.getNombre());
			preparedStatement.setString(6, empleado.getApellidos());
			preparedStatement.setDouble(7, empleado.getSueldo());
			
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

}
