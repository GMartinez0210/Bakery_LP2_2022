<%@ page import="beans.Empleado_DTO" %>

<%@ include file="./partials/head.jsp" %>

<%@ include file="./components/nav/nav.jsp" %>

<% Empleado_DTO empleado = (Empleado_DTO) request.getAttribute("empleado"); %>

<div class="container my-5">
	<h1>Modificar empleado</h1>
	<p>Rellene el formulario</p>
	<form action="Empleado?tipo=modificar" method="post">
		<div class="mb-3">
		    <label for="codigo" class="form-label">Codigo</label>
		    <input type="number" readonly="readonly" class="form-control" id="codigo" name="codigo" value="<%= empleado.getCodigo() %>">
		</div>
		<div class="mb-3">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text" class="form-control" id="nombre" name="nombre" value="<%= empleado.getNombre() %>">
		</div>
		<div class="mb-3">
		    <label for="apellidos" class="form-label">Apellidos</label>
		    <input type="text" class="form-control" id="apellidos" name="apellidos" value="<%= empleado.getApellidos() %>">
	    </div>
		<div class="mb-3">
		    <label for="clave" class="form-label">Clave</label>
		    <input type="password" class="form-control" id="clave" name="clave" value="<%= empleado.getClave() %>">
	    </div>
	    
	  	<button type="submit" class="btn btn-primary">Agregar</button>
	</form>
</div>

<%@ include file="./partials/foot.jsp" %>