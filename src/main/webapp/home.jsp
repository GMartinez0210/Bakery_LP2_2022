<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home</title>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="assets/styles.css">
  <link rel="stylesheet" href="assets/home.css">
</head>
<body>
  <!-- Header -->
  <header class="header">
    <div class="container">
      <a href="">
        <img src="assets/utils/logo1.svg" alt="bakery">
      </a>

      <div class="header__group">
        <div class="cart__icon">
          <svg width="24" height="24" viewBox="0 0 510 510" fill="none" xmlns="http://www.w3.org/2000/svg">
            <g clip-path="url(#clip0_104_1656)">
              <path d="M153 408C124.95 408 102 430.95 102 459C102 487.05 124.95 510 153 510C181.05 510 204 487.05 204 459C204 430.95 181.05 408 153 408ZM0 0V51H51L142.8 244.8L107.1 306C104.55 313.65 102 323.85 102 331.5C102 359.55 124.95 382.5 153 382.5H459V331.5H163.2C160.65 331.5 158.1 328.95 158.1 326.4V323.849L181.05 280.499H369.75C390.15 280.499 405.45 270.299 413.1 254.999L504.9 89.25C510 84.15 510 81.6 510 76.5C510 61.2 499.8 51 484.5 51H107.1L84.15 0H0ZM408 408C379.95 408 357 430.95 357 459C357 487.05 379.95 510 408 510C436.05 510 459 487.05 459 459C459 430.95 436.05 408 408 408Z" fill="black"/>
            </g>
            <defs><clipPath id="clip0_104_1656"><rect width="510" height="510" fill="white"/></clipPath></defs>
          </svg>

          <span class="cart__items">0</span>
        </div>

        <img class="header__avatar" src="assets/utils/avatarp.png" alt="${user.nombre}">
        <nav class="nav">
          <ul class="nav__list">
            <li><button type="button" class="nav__close">
              <img src="assets/utils/cancel.svg" alt="daw">
            </button></li>
            <li><a href="perfil.jsp" class="nav__item">Ver Perfil</a></li>
            <li><a href="Session?tipo=cerrar" class="nav__item nav__item--close">Cerrar Sesion</a></li>
          </ul>
        </nav>
      </div>
    </div>
  </header>
  
  <main class="main">
    <div class="container">
      
      <section class="filter_top">
        <!-- todo busqueda y por categoria  -->
        <form action="">
          <div class="filter__search">
            <button type="submit">
              <img src="assets/utils/search.svg" alt="search">
            </button>
            <input type="text" placeholder="Buscar">
          </div>
        </form>

        <select name="categories" id="categories">
          <option value="0">Todas las categorias</option>
          <option value="1">Pan</option>
          <option value="2">Pasteles</option>
        </select>
      </section>

      
      <section>
        <aside class="filter_aside-container">
          <!-- todo filtro de precio y de calificaciones -->
          <button type="button" class="mobile_filter">
            <img src="assets/utils/mobile_burger.svg" alt="burger">
          </button>
          <form class="filter__aside">
            <button type="button" class="mobile_filter-cancel">
              <img src="assets/utils/cancel.svg" alt="cancel">
            </button>

            <h3>Rango de Precio:</h3>

            <div class="filter__price">
              <div class="filter__price--group">
                <label for="minimo">Mínimo:</label>
                <input type="number" id="minimo" placeholder="1">
              </div>
              <div class="filter__price--group">
                <label for="maximo">Máximo:</label>
                <input type="number" id="maximo" placeholder="1200">
              </div>
            </div>
            
            <h3>Puntaje:</h3>
            <div class="filter_score">
                <img src="assets/utils/start.svg" alt="start">
                <img src="assets/utils/start.svg" alt="start">
                <img src="assets/utils/start.svg" alt="start">
                <img src="assets/utils/start.svg" alt="start">
                <img src="assets/utils/start.svg" alt="start">
            </div>    

            <button class="button solid" type="submit">Filtrar</button>
          </form>
        </aside>

        <!-- todo c:foreach de los productos | sin optimizar -->
        <ul class="product_container">
          <li>
            <div class="card">
              <img src="assets/utils/pan_placeholder.jpg" alt="pan_placeholder" />

              <div class="card__content">
                <p class="card__rating">2.5/5</p>
                <p class="card__name">1 docena de Pan de yema</p>
                <p class="card__price">S/ 2</p>

                <form action="">
                  <div class="card__cant-handle">
                    <button type="button">-</button>
                    <input type="number" value="1" min="1" class="card__cant" name="cantidad" id="cantidad">
                    <button type="button">+</button>
                  </div>

                  <button type="submit" class="button solid">Añadir</button>
                </form>
              </div>
            </div>
          </li>
        </ul>
      </section>
    </div>
  </main> 
<script
  src="https://code.jquery.com/jquery-3.6.1.min.js"
  integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
  crossorigin="anonymous"></script>
<script src="assets/common.js"></script>
<script src="assets/home.js"></script>
</body>
</html>