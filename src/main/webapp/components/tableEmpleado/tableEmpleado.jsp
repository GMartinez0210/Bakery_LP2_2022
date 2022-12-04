<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Empleado_DTO" %>
<%@ page import="dao.DAO_Factory" %>

<% String[] tableHeads = {"Dni", "Nombre", "Apellidos", "Email", "Cargo", "Sueldo", "Acciones"}; %>
<% DAO_Factory factory = DAO_Factory.getDAO_Factory(1); %>
<% ArrayList<Empleado_DTO> empleados = factory.getEmpleado().listar(); %>	

<div class="d-flex justify-content-between align-items-center mb-4">
	<h1> Tabla de Empleados </h1>
	<a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/Empleado?tipo=listar">Agregar un nuevo Empleado</a>
</div>

<table class="table">
	  <thead class="bg-khaki text-white">
	    	<tr>
	    		<% for(String tableHead : tableHeads) { %>
	    			<th scope="col"> <%= tableHead %> </th>
	    		<% } %>
	    	</tr>
	  </thead>
	  <tbody>
	  		<% for(Empleado_DTO empleado : empleados) { %>
	  			<tr>
	  				<th scope="row"> <%= empleado.getDni() %> </th>
		      		<td> <%= empleado.getNombre() %> </td>
	  				<td> <%= empleado.getApellidos() %> </td>
		      		<td> <%= empleado.getEmail() %> </td>
		      		<td> <%= empleado.getNombreCargo() %> </td>
		      		<td> <%= empleado.getSueldo() %> </td>
		      		<td class="text-center align-middle">
		      			<a href="${pageContext.request.contextPath}/Empleado?tipo=buscar&&dni=<%= empleado.getDni()%>">
							<i class="bi bi-pencil-square"></i>
		      			</a>
		      		</td>
	  			</tr>
	  		<% } %>
	  </tbody>
</table>