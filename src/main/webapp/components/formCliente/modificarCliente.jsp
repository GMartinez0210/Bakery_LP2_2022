<%@ page import="beans.Cliente_DTO" %>

<% Cliente_DTO cliente = (Cliente_DTO) request.getAttribute("cliente"); %>

<form action="${pageContext.request.contextPath}/Cliente?tipo=modificar" method="post" enctype="multipart/form-data">
	  <div class="mb-3">
		    <label for="dni" class="form-label">DNI</label>
		    <input type="text" class="form-control validation-number" id="dni" name="dni" 
		    	readonly="readonly" required="required" value="<%= cliente.getDni() %>">
	  </div>
	  <div class="mb-3">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text" class="form-control validation-alphabetic" id="nombre" name="nombre" 
		    	required="required" value="<%= cliente.getNombre() %>">
	  </div>
	  <div class="mb-3">
		    <label for="apellidos" class="form-label">Apellidos</label>
		    <input type="text" class="form-control validation-alphabetic" id="apellidos" name="apellidos" 
		    	required="required" value="<%= cliente.getApellidos() %>">
	  </div>
	  <div class="mb-3">
		    <label for="email" class="form-label">Email</label>
		    <input type="email" class="form-control validation-alphabetic" id="email" name="email" 
		    	required="required" value="<%= cliente.getEmail() %>">
	  </div>
	  <div class="mb-3">
		    <label for="clave" class="form-label">Clave</label>
		    <input type="password" class="form-control validation-alphabetic" id="clave" name="clave" 
		    	required="required" value="<%= cliente.getClave() %>">
	  </div>
	  <div class="mb-3">
		    <label for="avatar" class="form-label">Avatar</label>
		    <input type="file" class="form-control" id="avatar" name="avatar" required="required">
	  </div>
	  <div class="d-flex gap-3 mt-3">
		  	<button type="submit" class="btn btn-primary">Modificar</button>
		  	<a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/Cliente?tipo=borrar&&dni=<%= cliente.getDni() %>">Borrar</a>
	  </div>
</form>