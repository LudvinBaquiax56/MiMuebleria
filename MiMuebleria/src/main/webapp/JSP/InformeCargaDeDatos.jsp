<%-- 
    Document   : InformeCargaDeDatos
    Created on : 30/08/2021, 21:48:03
    Author     : baquiax
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="HeadesrAndFooters/headerGeneral.jsp"></jsp:include>
        <body>
            <div class="container">
                <center>
                    <h1><i class="fab fa-medium-m" style="color: brown;"></i> Mi Muebleria</h1>
                </center>
            </div>
        <center>
            <a href="inicioSesion.jsp" class="nav-link">Iniciar Sesion</a>
        </center>
        <div class="container">
            <center>
                <h2>Informe de la carga de datos</h2>
            </center>
        ${Informe}
        <c:if test="${!erroresFormato.isEmpty()}">
            <h2>Errores de Formato</h2>
            <c:forEach items="${erroresFormato}" var="errorFormato">
                <tr>
                <p>
                    ${errorFormato}
                </p>
            </tr>
        </c:forEach>
    </c:if>

    <c:if test="${!erroresRecetas.isEmpty()}">
        <h2>Errores de Ensamble Piezas</h2>
        <c:forEach items="${erroresRecetas}" var="erroresReceta">
            <tr>
            <p>
                ${erroresReceta}
            </p>
        </tr>
    </c:forEach>
</c:if>
<c:if test="${!erroresEnsambles.isEmpty()}">
    <h2>Errores de Ensamble Muebles</h2>
    <c:forEach items="${erroresEnsambles}" var="erroresEnsamble">
        <tr>
        <p>
            ${erroresEnsamble}
        </p>
    </tr>
</c:forEach>
</c:if>
<center>
    <a href="inicioSesion.jsp" class="nav-link">Iniciar Sesion</a>
</center>
</div>
<jsp:include page="HeadesrAndFooters/footerGeneral.jsp"></jsp:include>
</body>
</html>
