<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Cliente_DTO" %>
<%@ page import="dao.DAO_Factory" %>

<% String[] tableHeads = {"Dni", "Avatar", "Nombre", "Apellidos", "Email", "Acciones"}; %>
<% DAO_Factory factory = DAO_Factory.getDAO_Factory(1); %>
<% ArrayList<Cliente_DTO> clientes = factory.getCliente().listar(); %>	

<div class="d-flex justify-content-between align-items-center mb-4">
	<h1> Tabla de Clientes </h1>
	<a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/Cliente?tipo=listar">Agregar un nuevo Cliente</a>
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
	  		<% for(Cliente_DTO cliente : clientes) { %>
	  			<tr>
	  				<th scope="row"> <%= cliente.getDni() %> </th>
		      		<td>
		      			<img src="${pageContext.request.contextPath}/Imagen?tipo=cliente&&dni=<%= cliente.getDni() %>" 
		      				class="listar-img" alt="<%= cliente.getNombre() %>" title="<%= cliente.getNombre() %>">
		      		</td>
		      		<td> <%= cliente.getNombre() %> </td>
	  				<td> <%= cliente.getApellidos() %> </td>
		      		<td> <%= cliente.getEmail() %> </td>
		      		<td class="text-center align-middle">
		      			<a href="${pageContext.request.contextPath}/Cliente?tipo=buscar&&dni=<%= cliente.getDni()%>">
							<i class="bi bi-pencil-square"></i>
		      			</a>
		      		</td>
	  			</tr>
	  		<% } %>
	  </tbody>
</table>