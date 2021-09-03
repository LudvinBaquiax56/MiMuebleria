<%-- 
    Document   : registrarCliente
    Created on : 2/09/2021, 23:48:28
    Author     : baquiax
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../HeadesrAndFooters/headerGeneral.jsp"></jsp:include>
        <body>
        <% if ((int) request.getSession().getAttribute("tipo") == 2) {%>
        <jsp:include page="navegacionVenta.jsp"></jsp:include>
            <div class="container">
                <center>            
                    <h1>Registrar Cliente</h1>
                </center>    
            </div>
            <div class="container">
                <form classs="form-control mr-auto" action="${pageContext.request.contextPath}/CrearCliente" method="post">
                <h1 class="h3 mb-3 fw-normal">Ingrese los datos del Cliente</h1>
                <div class="form-floating">
                    <input type="text" name="nombre" class="form-control" id="floatingInput" placeholder="usuario">
                    <label for="floatingInput">Nombre</label>
                </div>
                <div class="form-floating">
                    <input type="text" name="NIT" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">NIT</label>
                </div>
                <div class="form-floating">
                    <input type="text" name="direccion" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Direccion</label>
                </div>
                <div class="form-floating">
                    <input type="text" name="municipio" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Municipio</label>
                </div>
                <div class="form-floating">
                    <input type="text" name="departamento" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Departamento</label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Registrar</button>
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
        <% } else if ((int) request.getSession().getAttribute("tipo") == 1) { %>
        <% response.sendRedirect(request.getContextPath() + "/JSP/Fabrica/inicioFabrica.jsp"); %>
        <% } else if ((int) request.getSession().getAttribute("tipo") == 3) { %>
        <% response.sendRedirect(request.getContextPath() + "/JSP/Administracion/inicioAdministracion.jsp"); %>
        <% } else { %>
        <% response.sendRedirect(request.getContextPath() + "/JSP/inicioSesion.jsp");
        %>
        <% }%>
    </body>
</html>