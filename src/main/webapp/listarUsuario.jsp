<%@ page import="java.util.ArrayList"  %>
<%@ page import="beans.Usuario_DTO"  %>

<%@ include file="./partials/head.jsp" %>

<%@ include file="./components/nav/nav.jsp" %>

<% String[] tableHeads = {"Codigo", "Usuario", "Clave", "Nombre", "Apellido", "Acciones"}; %>
<% ArrayList<Usuario_DTO> usuarios = (ArrayList<Usuario_DTO>) request.getAttribute("usuarios"); %>

<main class="container my-5">
	<h1>Lista de Usuarios</h1>

	<table class="table">
	  <thead class="bg-khaki text-white">
	    <tr>
	    	<% for(String tableHead : tableHeads) { %>
	    		<th scope="col"> <%= tableHead %> </th>
	    	<% } %>
	    </tr>
	  </thead>
	  <tbody>
	  	<% for(Usuario_DTO usuario : usuarios) { %>
	  		<tr>
	  			<th scope="row"> <%= usuario.getCodigo() %> </th>
		      	<td> <%= usuario.getUsuario() %> </td>
		      	<td> <%= usuario.getClave() %> </td>
		      	<td> <%= usuario.getNombre() %> </td>
		      	<td> <%= usuario.getApellidos() %> </td>
		      	<td class="d-flex justify-center align-items-center gap-3">
		      		<a href="Usuario?tipo=buscar&&codigo=<%= usuario.getCodigo()%>">
		      			<img class="listar-img-accion" src="${pageContext.request.contextPath}/images/update.png" alt="Modificar" title="Modificar">
		      		</a>
		      		<a href="Usuario?tipo=borrar&&codigo=<%= usuario.getCodigo()%>">
		      			<img class="listar-img-accion" src="${pageContext.request.contextPath}/images/remove.png" alt="Borrar" title="Borrar">
		      		</a>
		      	</td>
	  		</tr>
	  	<% } %>
	  </tbody>
	</table>
</main>

<%@ include file="./partials/foot.jsp" %>