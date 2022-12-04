<form action="${pageContext.request.contextPath}/Cliente?tipo=agregar" method="post" enctype="multipart/form-data">
	  <div class="mb-3">
		    <label for="dni" class="form-label">DNI</label>
		    <input type="text" class="form-control validation-number" id="dni" name="dni" required="required">
	  </div>
	  <div class="mb-3">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text" class="form-control validation-alphabetic" id="nombre" name="nombre" required="required">
	  </div>
	  <div class="mb-3">
		    <label for="apellidos" class="form-label">Apellidos</label>
		    <input type="text" class="form-control validation-alphabetic" id="apellidos" name="apellidos" required="required">
	  </div>
	  <div class="mb-3">
		    <label for="email" class="form-label">Email</label>
		    <input type="email" class="form-control validation-alphabetic" id="email" name="email" required="required">
	  </div>
	  <div class="mb-3">
		    <label for="clave" class="form-label">Clave</label>
		    <input type="password" class="form-control validation-alphabetic" id="clave" name="clave" required="required">
	  </div>
	  <div class="mb-3">
		    <label for="avatar" class="form-label">Avatar</label>
		    <input type="file" class="form-control" id="avatar" name="avatar" required="required">
	  </div>
	  <button type="submit" class="btn btn-primary">Agregar</button>
</form>