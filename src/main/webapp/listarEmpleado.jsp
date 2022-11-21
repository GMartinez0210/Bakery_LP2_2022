<%@ page import="java.util.ArrayList"  %>
<%@ page import="beans.Empleado_DTO"  %>

<%@ include file="./partials/head.jsp" %>

<%@ include file="./components/nav/nav.jsp" %>

<% String[] tableHeads = {"Codigo", "Clave", "Nombre", "Apellido", "Acciones"}; %>
<% ArrayList<Empleado_DTO> empleados = (ArrayList<Empleado_DTO>) request.getAttribute("empleados"); %>

<main class="container my-5">
	<h1>Lista de Empleados</h1>

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
	  			<th scope="row"> <%= empleado.getCodigo() %> </th>
		      	<td> <%= empleado.getClave() %> </td>
		      	<td> <%= empleado.getNombre() %> </td>
		      	<td> <%= empleado.getApellidos() %> </td>
		      	<td class="d-flex justify-center align-items-center gap-3">
		      		<a href="Empleado?tipo=buscar&&codigo=<%= empleado.getCodigo()%>">
		      			<img class="listar-img-accion" src="${pageContext.request.contextPath}/images/update.png" alt="Modificar" title="Modificar">
		      		</a>
		      		<a href="Empleado?tipo=borrar&&codigo=<%= empleado.getCodigo()%>">
		      			<img class="listar-img-accion" src="${pageContext.request.contextPath}/images/remove.png" alt="Borrar" title="Borrar">
		      		</a>
		      	</td>
	  		</tr>
	  	<% } %>
	  </tbody>
	</table>
</main>

<%@ include file="./partials/foot.jsp" %>