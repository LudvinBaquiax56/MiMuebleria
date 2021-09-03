<%-- 
    Document   : navegacionAdministracion
    Created on : 31/08/2021, 04:28:54
    Author     : baquiax
--%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="inicioAdministracion.jsp"><i class="fab fa-medium-m" style="color: brown;"></i> Mi Muebleria</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Reportes
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Reporte de Ventas Mueble</a></li>
                        <li><a class="dropdown-item" href="#">Reporte de Devoluciones</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Ganancias</a></li>
                        <li><a class="dropdown-item" href="#">Usuario con mas Ventas</a></li>
                        <li><a class="dropdown-item" href="#">Usuario con menos Ventas</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Mueble mas vendido</a></li>
                        <li><a class="dropdown-item" href="#">Mueble menos vendido</a></li>
                        <li><a class="dropdown-item" href="#">Mueble mas devuelto</a></li>

                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Usuarios
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/VerUsuarios">Ver Usuarios</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/JSP/Administracion/crearUsuario.jsp">Creacion de Usuario</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Muebles
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Creacion Modelo Mueble</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" action="${pageContext.request.contextPath}/CerrarSesion" method="post">
                <button class="btn btn-outline-danger" type="submit">Salir</button>
            </form>
        </div>
    </div>
</nav>
