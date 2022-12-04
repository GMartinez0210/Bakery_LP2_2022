<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Inicia Sesion</title>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="assets/styles.css">
  <link rel="stylesheet" href="assets/login.css">
</head>
<body>
  <div class="login__wrapper">

    <div class="login">
      <picture class="login__img">
        <source media="(min-width: 768px)" srcset="assets/utils/logo2.svg">
        <img src="assets/utils/logo1.svg" class="login__img" alt="hero">
      </picture>
      
      <form class="login__form" action="Session?tipo=iniciar" method="post" enctype="multipart/login">
        <label class="label" for="dni">
          DNI:
          <input type="text" name="dni" id="dni" placeholder="Introduce tu DNI">
        </label>
        
        <label class="label" for="contra">
          Contraseña:
          <input type="text" name="contrasenna" id="contrasenna" placeholder="Introduce tu contraseÃ±a">
        </label>
        
        <div class="login__group">
          <button class="button solid" type="submit">Iniciar sesión</button>
          <a class="button link" href="">Crear una cuenta</a>
        </div>
      </form>
    </div>
  </div>
${aviso}
</body>
</html>