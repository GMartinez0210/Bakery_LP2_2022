package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import utils.MySQLConexion;

public class MySQL_Imagen_DAO{

	public void buscarImagenProducto(int codigo, HttpServletResponse res) {		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			outputStream = res.getOutputStream();
			
			connection = MySQLConexion.getConexion();
			String sql = "call USP_ImagenProducto(?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, codigo);
			
			result = preparedStatement.executeQuery();
			
			res.setContentType("image/*");
			
			if(result.next()) {
				inputStream = result.getBinaryStream("imagen");				
			}
			
			bufferedInputStream = new BufferedInputStream(inputStream);
			bufferedOutputStream = new BufferedOutputStream(outputStream);

			int i;
			
			while((i = bufferedInputStream.read()) != -1) {
				bufferedOutputStream.write(i);
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
	}
	
	public void buscarImagenCliente(String dni, HttpServletResponse res) {		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			outputStream = res.getOutputStream();
			
			connection = MySQLConexion.getConexion();
			String sql = "call USP_ImagenCliente(?);";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dni);
			
			result = preparedStatement.executeQuery();
			
			res.setContentType("image/*");
			
			if(result.next()) {
				inputStream = result.getBinaryStream("avatar");				
			}
			
			bufferedInputStream = new BufferedInputStream(inputStream);
			bufferedOutputStream = new BufferedOutputStream(outputStream);

			int i;
			
			while((i = bufferedInputStream.read()) != -1) {
				bufferedOutputStream.write(i);
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
	}
}
