<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Codigo_Nombre_DTO" %>
<%@ page import="beans.Empleado_DTO" %>
<%@ page import="dao.DAO_Factory" %>

<% DAO_Factory factory = DAO_Factory.getDAO_Factory(1); %>
<% ArrayList<Codigo_Nombre_DTO> cargos = factory.getCargoEmpleado().listar(); %>
<% Empleado_DTO empleado = (Empleado_DTO) request.getAttribute("empleado"); %>

<form action="${pageContext.request.contextPath}/Empleado?tipo=modificar" method="post">
	  <div class="mb-3">
		    <label for="dni" class="form-label">DNI</label>
		    <input type="text" class="form-control validation-number" id="dni" name="dni" 
		    	readonly="readonly" required="required" value="<%= empleado.getDni() %>">
	  </div>
	  <div class="mb-3">
		    <label for="codigoCargo" class="form-label">Cargo</label>	  
		    <select class="form-control" id="codigoCargo" name="codigoCargo" required="required">
		    	<% for (Codigo_Nombre_DTO cargo : cargos) { %>
		    		<% if(cargo.getCodigo() == empleado.getCodigoCargo()) { %>
		    			<option selected="selected" value="<%= cargo.getCodigo() %>"> 
			    			<%= cargo.getNombre() %> 
			    		</option>
		    		<% } else { %>
			    		<option value="<%= cargo.getCodigo() %>"> 
			    			<%= cargo.getNombre() %> 
			    		</option>
		    		<% } %>
		    	<% } %>
		    </select>
	  </div>
	  <div class="mb-3">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text" class="form-control validation-alphabetic" id="nombre" name="nombre" 
		    	required="required" value="<%= empleado.getNombre() %>">
	  </div>
	  <div class="mb-3">
		    <label for="apellidos" class="form-label">Apellidos</label>
		    <input type="text" class="form-control validation-alphabetic" id="apellidos" name="apellidos" 
		    	required="required" value="<%= empleado.getApellidos() %>">
	  </div>
	  <div class="mb-3">
		    <label for="email" class="form-label">Email</label>
		    <input type="email" class="form-control validation-alphabetic" id="email" name="email" 
		    	required="required" value="<%= empleado.getEmail() %>">
	  </div>
	  <div class="mb-3">
		    <label for="clave" class="form-label">Clave</label>
		    <input type="password" class="form-control validation-alphabetic" id="clave" name="clave" 
		    	required="required" value="<%= empleado.getClave() %>">
	  </div>
	  <div class="mb-3">
		    <label for="sueldo" class="form-label">Sueldo</label>
		    <input type="number" class="form-control validation-number" id="sueldo" name="sueldo" 
		    	required="required" value="<%= empleado.getSueldo() %>">
	  </div>
	  <div class="d-flex gap-3 mt-3">
		  <button type="submit" class="btn btn-primary">Modificar</button>
		  <a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/Producto?tipo=borrar&&dni=<%= empleado.getDni() %>">Borrar</a>
	  </div>
</form>