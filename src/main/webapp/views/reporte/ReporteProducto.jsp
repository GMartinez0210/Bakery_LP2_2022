<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.Producto_DTO" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 
 <%
    ArrayList<Producto_DTO> datos = new ArrayList<Producto_DTO>();
    Class.forName("com.mysql.jdbc.Driver");
    try {
    	Connection miCX = DriverManager.getConnection("/bd_bakery_lp2","root","mysql");
    	Statement miStatement = miCX.createStatement();
    	String comandoSQL = "select * from producto";
    	ResultSet rs = miStatement.executeQuery(comandoSQL);
    	while (rs.next()) {
    		datos.add(new Producto_DTO(
    				rs.getInt(1),
    				rs.getInt(2),
    				rs.getDouble(3),
    				rs.getImpu(4),
    				rs.getString(5),
    				rs.getDouble(6)));
    				
    	}
    	rs.close();
    	miCX.close();
    }
    catch (Exception e) {
    	out.println("Ocurrio un error!!!");
    }
	pageContext.setAttribute("los Productos", datos);
		
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
<td>Stock</td>
<td>estrellas</td>
<td>imagen</td>
<td>nombre</td>
<td>precio</td>


<c:forEach var="Productotemporal" items="${losProductos}"><br/>
<tr>
<td>${Productotemporal.codigo}</td>
<td>${Productotemporal.stock}</td>
<td>${Productotemporal.estrellas}</td>
<td>${Productotemporal.imagen}</td>
<td>${Productotemporal.nombre}</td>
<td>${Productotemporal.precio}</td>
</c:forEach>

</table>

</body>
</html>