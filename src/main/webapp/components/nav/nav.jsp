<nav class="navbar navbar-expand-lg py-0 bg-khaki">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img class="nav-brand-image" src="${pageContext.request.contextPath}/images/bakery.jpg" alt="" title="">
        </a>
        <button class="navbar-toggler nav-btn-toggle" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="bi bi-list nav-icon-toggle"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item px-3">
                    <a class="nav-link" href="${pageContext.request.contextPath}/views/producto/listar.jsp?tipo=listar" role="button"> Productos </a>
                </li>
                <li class="nav-item px-3">
                    <a class="nav-link" href="${pageContext.request.contextPath}/views/cliente/listar.jsp?tipo=listar" role="button"> Clientes </a>
                </li>
                <li class="nav-item px-3">
                    <a class="nav-link" href="${pageContext.request.contextPath}/views/empleado/listar.jsp?tipo=listar" role="button"> Empleados </a>
                </li>
                <li class="nav-item px-3">
                    <a class="nav-link" href="${pageContext.request.contextPath}/views/reporte/listar.jsp?tipo=listar">Reportes</a>
                </li>              
            </ul>
        </div>
    </div>
</nav>