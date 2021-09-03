<%-- 
    Document   : listadoMueblesVenta
    Created on : 3/09/2021, 03:32:18
    Author     : baquiax
--%>

<%@page import="Modelos.Objetos.Mueble"%>
<%@page import="java.util.List"%>
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
                    <h1>Muebles en Venta</h1>
                <%List<Mueble> piezas = (List<Mueble>) request.getAttribute("muebles");%>
                <c:if test="${hayMuebles != null && hayMuebles == true}">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Mueble</th>
                                <th scope="col">Precio</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${muebles}" var="mueble">
                                <tr>
                                    <td scope="row">${mueble.id}</td>
                                    <td>${mueble.modeloMueble}</td>
                                    <td>${mueble.precio}</td>                                    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </center>    
        </div>
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
