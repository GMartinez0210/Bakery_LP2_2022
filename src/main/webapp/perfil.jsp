<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Perfil</title>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="assets/styles.css">
  <link rel="stylesheet" href="assets/perfil.css">
</head>
<body>
 <%@ include file="./components/userNav/userNav.jsp" %>



  <main class="main">
    <div class="container">
      <form class="perfil" action="Cliente?tipo=editar" method="post">
        <div class="perfil__head">
          <img src="assets/utils/avatarp.png" alt="${user.nombre}">

          <h2 class="perfil__field">${user.nombre} | ${user.dni}</h2>

          <label class="edit button solid" for="avatar">Cambiar Avatar</label>
          <input type="file" name="avatar" id="avatar" style="display: none;">
        </div>

        <div class="perfil__inputs">
          <div class="perfil__input-group">
            <div class="perfil__input">
              <label class="label" for="nombre">Nombre:</label>
              <input type="text" name="nombre" disabled id="nombre" value="${user.nombre}">
            </div>
            
            <div class="perfil__input">
              <label class="label" for="apellido">Apellido:</label>
              <input type="text" name="apellido" disabled id="apellido" value="${user.apellidos}">
            </div>

            <div class="perfil__input">
              <label class="label" for="email">Email:</label>
              <input type="text" name="email" disabled id="email" value="${user.email}">
            </div>
          </div>

          <div class="perfil__input-group">
            <div class="perfil__input">
              <label class="label" for="contrasenna">Contraseña:</label>
              <input type="password" name="contrasenna" disabled id="contrasenna" value="${user.clave}">
              <svg class="perfil__show-pass" width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                <circle cx="8" cy="8" r="7.5" fill="#7D2A0C" stroke="#fff"/>
              </svg>
            </div>
          </div>
        </div>

        <div class="perfil__buttons perfil__field">
          <button class="edit_perfil button outline" type="button">Editar</button>
          <button class="open_modal button danger" type="button">Eliminar</button>
        </div>
        
        <div class="perfil__buttons edit">
          <button class="button solid" type="submit">Confirmar</button>
          <button class="show-normal button outline" type="button">Cancelar</button>
        </div>
      </form>

      <img class="hero" src="assets/utils/logo1.svg" alt="bakery hero">
    </div>
  </main>



  <section class="delete__wrapper">
    <form  action="Cliente?tipo=eliminar" method="post" class="delete">
      <h2>¿Quieres ${user.nombre} eliminar tu cuenta?</h2>

      <label class="delete__label" for="deleteAcount">
        Pon tu DNI para confirmar accion:
        <input type="text" name="deleteAcount" id="deleteAcount" placeholder="DNI">
      </label>
      

      <div class="delete__buttons">
        <button class="button danger" type="submit">Ok</button>
        <button class="close_modal button outline"  type="button">Cancelar</button>
      </div>
    </form>
  </section>
</body>

${aviso }

<script
  src="https://code.jquery.com/jquery-3.6.1.min.js"
  integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
  crossorigin="anonymous"></script>
<script src="assets/common.js"></script>
<script src="assets/perfil.js"></script>
</html>