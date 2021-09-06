<%-- 
    Document   : Reporte1
    Created on : 6/09/2021, 01:15:04
    Author     : baquiax
--%>

<%@page import="java.util.List"%>
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
                    <h1>Reporte de Ventas</h1>
                </center>    
            </div>
        <%List<String> reporte = (List<String>) request.getAttribute("reporte");%>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">No Factura</th>
                    <th scope="col">Mueble</th>
                    <th scope="col">Precio</th>
                </tr>
            </thead>
            <tbody>                        
                <c:forEach items="${reporte}" var="report">
                    ${report}
                </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/DescargarReporte1">Descargar Reporte</a>
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