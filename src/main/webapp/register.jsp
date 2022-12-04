<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register</title>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="assets/styles.css">
  <link rel="stylesheet" href="assets/register.css">
</head>
<body>
  <div class="register__wrapper">

    <div class="register">
      <img src="assets/utils/logo2.svg" class="register__img" alt="hero">
      
      <form class="register__form" action="Cliente?tipo=registrarse" method="post" enctype="multipart/Register">
        <div class="register__inputs">
          <label class="label" for="nombre">
            Nombre:
            <input type="text" name="nombre" required id="nombre" placeholder="Introduce tu nombre">
          </label>

          <label class="label" for="apellido">
            Apellido:
            <input type="text" name="apellido" required id="apellido" placeholder="Introduce tu apellido">
          </label>

          <label class="label" for="email">
            Email:
            <input type="text" name="email" required id="email" placeholder="Introduce tu email">
          </label>

          <label class="label" for="dni">
            DNI:
            <input type="text" name="dni" required id="dni" placeholder="Introduce tu DNI">
          </label>
        </div>

        <div class="register__inputs">
          <label class="label" for="contra">
            Contrase�a:
            <input type="password" name="contra" id="contra" placeholder="Introduce tu contrase�a">
          </label>
          
          <label class="label" for="repetir">
            Repetir contrase�a:
            <input type="password" name="repetir" id="repetir" placeholder="Repite la contraseña">
          </label>
        </div>
        
        <div class="register__group">
          <button class="button outline" disabled type="submit">Registrarse</button>
          <a class="button link border__primary" href="login.jsp">Iniciar sesion</a>
        </div>
      </form>
    </div>
	${aviso}
  </div>

<script
  src="https://code.jquery.com/jquery-3.6.1.min.js"
  integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
  crossorigin="anonymous"></script>
<script src="./assets/register.js"></script>
</body>
</html>