<%-- 
    Document   : detalleMuebles
    Created on : 3/09/2021, 06:46:47
    Author     : baquiax
--%>

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
                    <h1>Bienvenido</h1>
                    <h2>Area de Fabrica</h2>
                </center>
                <%List<String> muebles = (List<String>) request.getAttribute("muebles");%>
                <c:if test="${hayMuebles != null && hayMuebles == true}">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Cantidad</th>
                                <th scope="col">Mueble</th>
                            </tr>
                        </thead>
                        <tbody>                        
                            <c:forEach items="${muebles}" var="mueble">
                                ${mueble}
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
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
