<%@ include file="./partials/head.jsp" %>

<%@ include file="./components/nav/nav.jsp" %>

<div class="container my-5">
	<h1>Agregar empleado</h1>
	<p>Rellene el formulario</p>
	<form action="Empleado?tipo=agregar" method="post">
		<div class="mb-3">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text" class="form-control" id="nombre" name="nombre">
		</div>
		<div class="mb-3">
		    <label for="apellidos" class="form-label">Apellidos</label>
		    <input type="text" class="form-control" id="apellidos" name="apellidos">
	    </div>
		<div class="mb-3">
		    <label for="clave" class="form-label">Clave</label>
		    <input type="password" class="form-control" id="clave" name="clave">
	    </div>
	    
	  	<button type="submit" class="btn btn-primary">Agregar</button>
	</form>
</div>

<%@ include file="./partials/foot.jsp" %>