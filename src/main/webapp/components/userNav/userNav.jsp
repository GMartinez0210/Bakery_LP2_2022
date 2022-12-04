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