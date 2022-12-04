<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.Empleado_DTO" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 
 <%
    ArrayList<Empleado_DTO> datos = new ArrayList<Empleado_DTO>();
    Class.forName("com.mysql.jdbc.Driver");
    try {
    	Connection miCX = DriverManager.getConnection("/bd_bakery_lp2","root","mysql");
    	Statement miStatement = miCX.createStatement();
    	String comandoSQL = "select * from empleados";
    	ResultSet rs = miStatement.executeQuery(comandoSQL);
    	while (rs.next()) {
    		datos.add(new Empleado_DTO(
    				rs.getInt(1),
    				rs.getString(2),
    				rs.getString(3),
    				rs.getString(4)));
    				
    	}
    	rs.close();
    	miCX.close();
    }
    catch (Exception e) {
    	out.println("Ocurrio un error!!!");
    }
	pageContext.setAttribute("los empleados", datos);
		
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
<td>Clave</td>
<td>Nombre</td>
<td>Apellidos</td>


<c:forEach var="Empleadotemporal" items="${losEmpleados}"><br/>
<tr>
<td>${Empleadotemporal.codigo}</td>
<td>${Empleadotemporal.clave}</td>
<td>${Empleadotemporal.nombre}</td>
<td>${Empleadotemporal.apellidos}</td>
</c:forEach>

</table>

</body>
</html>