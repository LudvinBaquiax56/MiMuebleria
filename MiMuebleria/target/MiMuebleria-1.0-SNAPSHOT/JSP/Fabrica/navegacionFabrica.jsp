<%-- 
    Document   : HeaderFabrica
    Created on : 31/08/2021, 01:12:23
    Author     : baquiax
--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/JSP/Fabrica/inicioFabrica.jsp"><i class="fab fa-medium-m" style="color: brown;"></i> Mi Muebleria</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Piezas
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/VerPiezas">Ver Piezas</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/JSP/Fabrica/crearPieza.jsp">Crear Piezas</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Piezas por Tipo
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/VerPiezasPorTipo?accion=mostrar">Ver Piezas</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/VerPiezasPorTipo?accion=descendente">Ver Piezas Descendente</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/VerPiezasPorTipo?accion=ascendente">Ver Piezas Ascendente</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Piezas por Cantidad
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/VerPiezasPorTipo?accion=cantidadDescendente">Ver Piezas Descendente</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/VerPiezasPorTipo?accion=cantidadAscendente">Ver Piezas Ascendente</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Mueble
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/EnsamblarMuebles">Ensamblar Mueble</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/VerMuebles">Muebles Creados</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Mueble Detalles
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/VerMueblesDetalle?accion=detalle">Muebles Detalle</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/VerMueblesDetalle?accion=nombreAscendente">Muebles Ascendente</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/VerMueblesDetalle?accion=nombreDescendente">Muebles Descendente</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/VerMueblesDetalle?accion=cantidadAscendente">Muebles por cantidad Ascendente</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/VerMueblesDetalle?accion=cantidadDescendente">Muebles por cantidad Descendente</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" action="${pageContext.request.contextPath}/CerrarSesion" method="post">
                <button class="btn btn-outline-danger" type="submit">Salir</button>
            </form>
        </div>
    </div>
</nav>