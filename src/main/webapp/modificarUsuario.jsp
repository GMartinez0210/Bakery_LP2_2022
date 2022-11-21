<%@ page import="beans.Usuario_DTO" %>

<%@ include file="./partials/head.jsp" %>

<%@ include file="./components/nav/nav.jsp" %>

<% Usuario_DTO usuario = (Usuario_DTO) request.getAttribute("usuario"); %>

<div class="container my-5">
	<h1>Modificar usuario</h1>
	<p>Rellene el formulario</p>
	<form action="Usuario?tipo=modificar" method="post">
		<div class="mb-3">
		    <label for="codigo" class="form-label">Codigo</label>
		    <input type="number" readonly="readonly" class="form-control" id="codigo" name="codigo" value="<%= usuario.getCodigo() %>">
		</div>
		<div class="mb-3">
		    <label for="usuario" class="form-label">Usuario</label>
		    <input type="text" class="form-control" id="usuario" name="usuario" value="<%= usuario.getUsuario() %>">
	    </div>
		<div class="mb-3">
		    <label for="clave" class="form-label">Clave</label>
		    <input type="password" class="form-control" id="clave" name="clave" value="<%= usuario.getClave() %>">
	    </div>
		<div class="mb-3">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text" class="form-control" id="nombre" name="nombre" value="<%= usuario.getNombre() %>">
		</div>
		<div class="mb-3">
		    <label for="apellidos" class="form-label">Apellidos</label>
		    <input type="text" class="form-control" id="apellidos" name="apellidos" value="<%= usuario.getApellidos() %>">
	    </div>
	    
	  	<button type="submit" class="btn btn-primary">Agregar</button>
	</form>
</div>

<%@ include file="./partials/foot.jsp" %>