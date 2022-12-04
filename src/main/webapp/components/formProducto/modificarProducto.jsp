<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Codigo_Nombre_DTO" %>
<%@ page import="beans.Producto_DTO" %>
<%@ page import="dao.DAO_Factory" %>

<% DAO_Factory factory = DAO_Factory.getDAO_Factory(1); %>
<% ArrayList<Codigo_Nombre_DTO> categorias = factory.getCategoriaProducto().listar(); %>
<% Producto_DTO producto = (Producto_DTO) request.getAttribute("producto"); %>

<form action="${pageContext.request.contextPath}/Producto?tipo=modificar" method="post" enctype="multipart/form-data">
	  <div class="mb-3">
		    <label for="codigo" class="form-label">Codigo</label>
		    <input type="number" class="form-control validation-number" id="codigo" name="codigo"
		    	readonly="readonly" required="required" value="<%= producto.getCodigo() %>">
	  </div>
	  <div class="mb-3">
		    <label for="codigoCategoria" class="form-label">Categoria</label>
		    <select class="form-control validation-number" id="codigoCategoria" name="codigoCategoria" required="required">
		    	<% for (Codigo_Nombre_DTO categoria : categorias) { %>
		    		<% if(categoria.getCodigo() == producto.getCodigoCategoria()) { %>
		    			<option selected="selected" value="<%= categoria.getCodigo() %>"> 
			    			<%= categoria.getNombre() %> 
			    		</option>
		    		<% } else { %>
			    		<option value="<%= categoria.getCodigo() %>"> 
			    			<%= categoria.getNombre() %> 
			    		</option>
		    		<% } %>
		    	<% } %>
		    </select>
	  </div>
	  <div class="mb-3">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text" class="form-control validation-alphabetic" id="nombre" name="nombre" 
		    	required="required" value="<%= producto.getNombre() %>">
	  </div>
	  <div class="mb-3">
		    <label for="precio" class="form-label">Precio</label>
		    <input type="number" class="form-control validation-number" id="precio" name="precio" 
		    	required="required" value="<%= producto.getPrecio() %>">
	  </div>
	  <div class="mb-3">
		    <label for="stock" class="form-label">Stock</label>
		    <input type="number" class="form-control validation-number" id="stock" name="stock" 
		    	required="required" value="<%= producto.getStock() %>">
	  </div>
	  <div class="mb-3">
		    <label for="estrellas" class="form-label">Estrellas</label>
		    <input type="number" class="form-control validation-number" id="estrellas" name="estrellas" 
		    	required="required" value="<%= producto.getEstrellas() %>">
	  </div>
	  <div class="mb-3">
		    <label for="imagen" class="form-label">Imagen</label>
		    <input type="file" class="form-control" id="imagen" name="imagen" required="required">
	  </div>
	  <div class="d-flex gap-3 mt-3">
	  		<button type="submit" class="btn btn-primary">Modificar</button>
	  		<a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/Producto?tipo=borrar&&codigo=<%= producto.getCodigo() %>">Borrar</a>
	  </div>
</form>