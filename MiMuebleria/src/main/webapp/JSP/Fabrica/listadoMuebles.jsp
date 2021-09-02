<%-- 
    Document   : listadoMuebles
    Created on : 31/08/2021, 22:44:12
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
        <% if ((int) request.getSession().getAttribute("tipo") == 1) {%>
        <jsp:include page="navegacionFabrica.jsp"></jsp:include>
            <div class="container">
                <center>            
                    <h1>Muebles</h1>
                <%List<Mueble> piezas = (List<Mueble>) request.getAttribute("muebles");%>
                <c:if test="${hayMuebles != null && hayMuebles == true}">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Mueble</th>
                                <th scope="col">Costo</th>
                                <th scope="col">Fecha Ensamble</th>
                                <th scope="col">Ensamblador</th>
                                <th scope="col">Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${muebles}" var="mueble">
                                <tr>
                                    <td scope="row">${mueble.id}</td>
                                    <td>${mueble.modeloMueble}</td>
                                    <td>${mueble.costo}</td>
                                    <td>${mueble.fecha}</td>
                                    <td>${mueble.ensamblador}</td>
                                    <c:if test="${mueble.devolucion == false}">
                                        <td>En venta</td>
                                    </c:if>
                                    <c:if test="${mueble.devolucion == true}">
                                        <td>Devuelto</td>
                                    </c:if>
                                </tr>
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