<%-- 
    Document   : crearUsuario
    Created on : 2/09/2021, 03:30:19
    Author     : baquiax
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../HeadesrAndFooters/headerGeneral.jsp"></jsp:include>
        <body>
        <% if ((int) request.getSession().getAttribute("tipo") == 3) {%>
        <jsp:include page="navegacionAdministracion.jsp"></jsp:include>
            <div class="container">
                <center>            
                    <h1>Crear Usuario</h1>
                </center>    
            </div>
            <div class="container">
                <form classs="form-control mr-auto" action="${pageContext.request.contextPath}/CrearUsuario" method="post">
                <h1 class="h3 mb-3 fw-normal">Ingrese los datos del Usuario</h1>
                <div class="form-floating">
                    <input type="text" name="usuario" class="form-control" id="floatingInput" placeholder="usuario">
                    <label for="floatingInput">Usuario</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>
                <input type="number" name="tipo" min="1" max="3" class="form-control">
                <button class="w-100 btn btn-lg btn-primary" type="submit">Ingresar</button>
            </form>
        </div>
        <c:if test="${Error == false}">
            <div class="container alert alert-primary" role="alert">
                ${mensaje}
            </div>
        </c:if>
        <c:if test="${Error == true}">
            <div class="container alert alert-warning" role="alert">
                ${mensaje}
            </div>
        </c:if>
        <jsp:include page="../HeadesrAndFooters/footerGeneral.jsp"></jsp:include>
        <% } else if ((int) request.getSession().getAttribute("tipo") == 2) { %>
        <% response.sendRedirect(request.getContextPath() + "/JSP/Ventas/inicioVentas.jsp"); %>
        <% } else if ((int) request.getSession().getAttribute("tipo") == 1) { %>
        <% response.sendRedirect(request.getContextPath() + "/JSP/Fabrica/inicioFabrica.jsp"); %>
        <% } else { %>
        <% response.sendRedirect(request.getContextPath() + "/JSP/inicioSesion.jsp");
        %>
        <% }%>
    </body>
</html>
