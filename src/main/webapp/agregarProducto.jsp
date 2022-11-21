<%@ include file="./partials/head.jsp" %>

<%@ include file="./components/nav/nav.jsp" %>

<div class="container my-5">
	<h1>Agregar Producto</h1>
	<p>Rellene el formulario</p>
	<form action="Producto?tipo=agregar" method="post" enctype="multipart/form-data">
		<div class="mb-3">
		    <label for="nombre" class="form-label">Nombre del Producto</label>
		    <input type="text" class="form-control" id="nombre" name="nombre">
		</div>
		<div class="mb-3">
		    <label for="precio" class="form-label">Precio</label>
		    <input type="number" class="form-control" id="precio" name="precio">
	    </div>
		<div class="mb-3">
		    <label for="stock" class="form-label">Stock</label>
		    <input type="number" class="form-control" id="stock" name="stock">
	    </div>
	    	<div class="mb-3">
		    <label for="estrellas" class="form-label">Estrellas</label>
		    <input type="number" class="form-control" id="estrellas" name="estrellas">
	    </div>
	    <div class="mb-3">
		  	<label for="imagen" class="form-label">Imagen</label>
		  	<input class="form-control" type="file" id="imagen" name="imagen">
		</div>
	    
	  	<button type="submit" class="btn btn-primary">Agregar</button>
	</form>
</div>

<%@ include file="./partials/foot.jsp" %>