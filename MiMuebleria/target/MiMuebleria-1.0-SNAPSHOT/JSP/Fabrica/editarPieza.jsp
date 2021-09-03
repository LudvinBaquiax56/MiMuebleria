<%-- 
    Document   : editarPieza
    Created on : 1/09/2021, 20:27:13
    Author     : baquiax
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Modelos.Objetos.Pieza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../HeadesrAndFooters/headerGeneral.jsp"></jsp:include>
        <body>
        <% if ((int) request.getSession().getAttribute("tipo") == 1) {%>
        <jsp:include page="navegacionFabrica.jsp"></jsp:include>
            <div class="container">
                <center>            
                    <h1>Editar Pieza</h1>
                </center>    
            </div>
        <%Pieza pieza = (Pieza) request.getSession().getAttribute("pieza");%>
        <%if (pieza == null) {
                response.sendRedirect(request.getContextPath() + "/JSP/Fabrica/inicioFabrica.jsp");
            } else {%>
        <div class="container"> 
            <form classs="form-control mr-auto" action="${pageContext.request.contextPath}/ModificarPieza" method="post">
                <label>Id: ${pieza.id}</label>
                <br>
                <label>Pieza: ${pieza.tipoPieza}</label>
                <br>
                <label>Costo:</label>
                <input type="number" name="costo" class="form-control" step=0.1>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Editar</button>
            </form>
        </div>
        <%}%>
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
