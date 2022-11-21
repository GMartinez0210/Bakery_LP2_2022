<nav class="navbar navbar-expand-lg bg-khaki">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img class="nav-brand-image" src="${pageContext.request.contextPath}/images/bakery.jpg" alt="" title="">
        </a>
        <button class="navbar-toggler nav-btn-toggle" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="bi bi-list nav-icon-toggle"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown px-3">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Productos
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="Producto?tipo=listar">Listar Productos</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="agregarProducto.jsp">Agregar Producto</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown px-3">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Usuarios
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="Usuario?tipo=listar">Listar Usuarios</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="agregarUsuario.jsp">Agregar Usuario</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown px-3">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Empleados
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="Empleado?tipo=listar">Listar Empleados</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="agregarEmpleado.jsp">Agregar Empleado</a></li>
                    </ul>
                </li>
                <li class="nav-item px-3">
                    <a class="nav-link" href="#">Reportes</a>
                </li>              
            </ul>
            <form class="d-flex" role="search">
                <button class="btn btn-form-search" type="submit">
                    <i class="bi bi-search"></i>
                </button>
                <input class="form-control form-search me-2" type="search" placeholder="Search" aria-label="Search">
            </form>
        </div>
    </div>
</nav>