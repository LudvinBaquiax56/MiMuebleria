<%-- 
    Document   : crearPieza
    Created on : 2/09/2021, 20:46:34
    Author     : baquiax
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../HeadesrAndFooters/headerGeneral.jsp"></jsp:include>
        <body>
        <% if ((int) request.getSession().getAttribute("tipo") == 1) {%>
        <jsp:include page="navegacionFabrica.jsp"></jsp:include>
            <div class="container">
                <center>            
                    <h1>Crear Pieza</h1>
                </center>    
            </div>
            <div class="container">
                <form classs="form-control mr-auto" action="${pageContext.request.contextPath}/CrearPieza" method="post">
                <label>Tipo Piezas</label>
                <input type="text" name="tipoPieza" class="form-control" step=0.1>    
                <br> 
                <label>Costo:</label>
                <input type="number" name="costo" class="form-control" step=0.1>
                <br>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Crear</button>
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
        <% } else if ((int) request.getSession().getAttribute("tipo") == 3) { %>
        <% response.sendRedirect(request.getContextPath() + "/JSP/Administracion/inicioAdministracion.jsp"); %>
        <% } else { %>
        <% response.sendRedirect(request.getContextPath() + "/JSP/inicioSesion.jsp");
        %>
        <% }%>

    </body>
</html>
