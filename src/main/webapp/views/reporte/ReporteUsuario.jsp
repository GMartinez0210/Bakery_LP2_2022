<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.Usuario_DTO" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 
 <%
    ArrayList<Usuario_DTO> datos = new ArrayList<Usuario_DTO>();
    Class.forName("com.mysql.jdbc.Driver");
    try {
    	Connection miCX = DriverManager.getConnection("/bd_bakery_lp2","root","mysql");
    	Statement miStatement = miCX.createStatement();
    	String comandoSQL = "select * from usuario";
    	ResultSet rs = miStatement.executeQuery(comandoSQL);
    	while (rs.next()) {
    		datos.add(new Usuario_DTO(
    				rs.getInt(1),
    				rs.getString(2),
    				rs.getString(3),
    				rs.getString(4),
    				rs.getString(5)));
    				
    	}
    	rs.close();
    	miCX.close();
    }
    catch (Exception e) {
    	out.println("Ocurrio un error!!!");
    }
	pageContext.setAttribute("los usuarios", datos);
		
 %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
.cabecera{
font-weight:bold;
}
</style>

</head>
<body>

<table border="1">
<tr class ="cabecera">
<td>Codigo</td>
<td>Usuario</td>
<td>Clave</td>
<td>Nombre</td>
<td>Apellidos</td>


<c:forEach var="Usuariotemporal" items="${losUsuarios}"><br/>
<tr>
<td>${Usuariotemporal.codigo}</td>
<td>${Usuariotemporal.usuario}</td>
<td>${Usuariotemporal.clave}</td>
<td>${Usuariotemporal.nombre}</td>
<td>${Usuariotemporal.apellidos}</td>
</c:forEach>

</table>

</body>
</html>