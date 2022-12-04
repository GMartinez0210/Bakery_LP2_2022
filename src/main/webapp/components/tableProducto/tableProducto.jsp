<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Producto_DTO" %>
<%@ page import="dao.DAO_Factory" %>

<% String[] tableHeads = {"Codigo", "Categoria", "Imagen", "Producto", "Precio", "Stock", "Estrellas", "Acciones"}; %>
<% DAO_Factory factory = DAO_Factory.getDAO_Factory(1); %>
<% ArrayList<Producto_DTO> productos = factory.getProducto().listar(); %>	

<div class="d-flex justify-content-between align-items-center mb-4">
	<h1> Tabla de Productos </h1>
	<a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/Producto?tipo=listar">Agregar un nuevo Producto</a>
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
	  		<% for(Producto_DTO producto : productos) { %>
	  			<tr>
	  				<th scope="row"> <%= producto.getCodigo() %> </th>
	  				<td> <%= producto.getNombreCategoria() %> </td>
		      		<td>
		      			<img src="${pageContext.request.contextPath}/Imagen?codigo=<%= producto.getCodigo() %>" 
		      				class="listar-img-accion" alt="<%= producto.getNombre() %>" title="<%= producto.getNombre() %>">
		      		</td>
		      		<td> <%= producto.getNombre() %> </td>
		      		<td> <%= producto.getPrecio() %> </td>
		      		<td> <%= producto.getStock() %> </td>
		      		<td> <%= producto.getEstrellas() %> </td>
		      		<td class="text-center align-middle">
		      			<a href="${pageContext.request.contextPath}/Producto?tipo=buscar&&codigo=<%= producto.getCodigo()%>">
							<i class="bi bi-pencil-square"></i>
		      			</a>
		      		</td>
	  			</tr>
	  		<% } %>
	  </tbody>
</table>