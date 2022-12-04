<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Codigo_Nombre_DTO" %>
<%@ page import="dao.DAO_Factory" %>

<% DAO_Factory factory = DAO_Factory.getDAO_Factory(1); %>
<% ArrayList<Codigo_Nombre_DTO> categorias = factory.getCategoriaProducto().listar(); %>

<form action="${pageContext.request.contextPath}/Producto?tipo=agregar" method="post" enctype="multipart/form-data">
	  <div class="mb-3">
		    <label for="codigoCategoria" class="form-label">Categoria</label>
		    <select class="form-control validation-number" id="codigoCategoria" name="codigoCategoria" required="required">
		    	<option selected="selected" value="0"> - SELECCIONE - </option>
		    	<% for (Codigo_Nombre_DTO categoria : categorias) { %>
		    		<option value="<%= categoria.getCodigo() %>"> 
		    			<%= categoria.getNombre() %> 
		    		</option>
		    	<% } %>
		    </select>
	  </div>
	  <div class="mb-3">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text" class="form-control validation-alphabetic" id="nombre" name="nombre" required="required">
	  </div>
	  <div class="mb-3">
		    <label for="precio" class="form-label">Precio</label>
		    <input type="number" class="form-control validation-number" id="precio" name="precio" required="required">
	  </div>
	  <div class="mb-3">
		    <label for="stock" class="form-label">Stock</label>
		    <input type="number" class="form-control validation-number" id="stock" name="stock" required="required">
	  </div>
	  <div class="mb-3">
		    <label for="estrellas" class="form-label">Estrellas</label>
		    <input type="number" class="form-control validation-number" id="estrellas" name="estrellas" required="required">
	  </div>
	  <div class="mb-3">
		    <label for="imagen" class="form-label">Imagen</label>
		    <input type="file" class="form-control" id="imagen" name="imagen" required="required">
	  </div>
	  <button type="submit" class="btn btn-primary">Agregar</button>
</form>