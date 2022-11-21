<%@ page import="beans.Producto_DTO" %>

<%@ include file="./partials/head.jsp" %>

<%@ include file="./components/nav/nav.jsp" %>

<% Producto_DTO producto = (Producto_DTO) request.getAttribute("producto"); %>

<div class="container my-5">
	<h1>Agregar Producto</h1>
	<p>Rellene el formulario</p>
	<form action="Producto?tipo=modificar" method="post" enctype="multipart/form-data">
		<div class="mb-3">
		    <label for="codigo" class="form-label">Codigo</label>
		    <input type="number" readonly="readonly" class="form-control" id="codigo" name="codigo" value="<%= producto.getCodigo() %>">
		</div>
		<div class="mb-3">
		    <label for="nombre" class="form-label">Nombre del Producto</label>
		    <input type="text" class="form-control" id="nombre" name="nombre" value="<%= producto.getNombre() %>">
		</div>
		<div class="mb-3">
		    <label for="precio" class="form-label">Precio</label>
		    <input type="number" class="form-control" id="precio" name="precio" value="<%= producto.getPrecio() %>">
	    </div>
		<div class="mb-3">
		    <label for="stock" class="form-label">Stock</label>
		    <input type="number" class="form-control" id="stock" name="stock" value="<%= producto.getStock() %>">
	    </div>
	    	<div class="mb-3">
		    <label for="estrellas" class="form-label">Estrellas</label>
		    <input type="number" class="form-control" id="estrellas" name="estrellas" value="<%= producto.getEstrellas() %>">
	    </div>
	    <div class="mb-3">
		  	<label for="imagen" class="form-label">Imagen</label>
		  	<input class="form-control" type="file" id="imagen" name="imagen">
		</div>
	    
	  	<button type="submit" class="btn btn-primary">Agregar</button>
	</form>
</div>

<%@ include file="./partials/foot.jsp" %>