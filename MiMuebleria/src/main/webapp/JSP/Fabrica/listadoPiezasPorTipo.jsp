<%-- 
    Document   : listadoPiezasPorTipo
    Created on : 1/09/2021, 01:23:07
    Author     : baquiax
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
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
                    <h1>Piezas</h1>
                <%List<String> piezas = (List<String>) request.getAttribute("piezas");%>
                <c:if test="${hayPiezas != null && hayPiezas == true}">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Cantidad</th>
                                <th scope="col">Pieza</th>
                            </tr>
                        </thead>
                        <tbody>                        
                            <c:forEach items="${piezas}" var="pieza">
                                ${pieza}
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </center>    
        </div>
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