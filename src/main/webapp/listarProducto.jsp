<%@ page import="java.util.ArrayList"  %>
<%@ page import="beans.Producto_DTO"  %>

<%@ include file="./partials/head.jsp" %>

<%@ include file="./components/nav/nav.jsp" %>

<% String[] tableHeads = {"Codigo", "Imagenes", "Producto", "Precio", "Stock", "Estrellas", "Acciones"}; %>
<% ArrayList<Producto_DTO> productos = (ArrayList<Producto_DTO>) request.getAttribute("productos"); %>

<main class="container my-5">
	<h1>Lista de Productos</h1>

	<table class="table">
	  <thead class="bg-khaki text-white">
	    <tr>
	    	<% for(String tableHead : tableHeads) { %>
	    		<th scope="col"> <%= tableHead %> </th>
	    	<% } %>
	    </tr>
	  </thead>
	  <tbody>
	  	<% for(Producto_DTO producto : productos) { %>
	  		<tr>
	  			<th scope="row"> <%= producto.getCodigo() %> </th>
		      	<td>
		      		<img class="listar-img-accion" src="Imagen?codigo=<%= producto.getCodigo() %>" alt="<%= producto.getNombre() %>" title="<%= producto.getNombre() %>">
		      	</td>
		      	<td> <%= producto.getNombre() %> </td>
		      	<td> <%= producto.getPrecio() %> </td>
		      	<td> <%= producto.getStock() %> </td>
		      	<td> <%= producto.getEstrellas() %> </td>
		      	<td class="d-flex justify-center align-items-center gap-3">
		      		<a href="Producto?tipo=buscar&&codigo=<%= producto.getCodigo()%>">
		      			<img class="listar-img-accion" src="${pageContext.request.contextPath}/images/update.png" alt="Modificar" title="Modificar">
		      		</a>
		      		<a href="Producto?tipo=borrar&&codigo=<%= producto.getCodigo()%>">
		      			<img class="listar-img-accion" src="${pageContext.request.contextPath}/images/remove.png" alt="Borrar" title="Borrar">
		      		</a>
		      	</td>
	  		</tr>
	  	<% } %>
	  </tbody>
	</table>
</main>

<%@ include file="./partials/foot.jsp" %>