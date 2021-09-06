<%-- 
    Document   : realizarVenta
    Created on : 3/09/2021, 23:37:56
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
                <h1>Realizar Venta</h1>  
            </div>                
        <%List<Mueble> muebles = (List<Mueble>) request.getSession().getAttribute("muebles");%>
        <c:if test="${hayMuebles != null && hayMuebles == true}">
            <div class="container">
                <h1>Muebles En Carrito</h1>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Mueble</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Quitar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${muebles}" var="mueble">
                            <c:if test="${mueble.vendido}">
                                <tr>
                                    <td scope="row">${mueble.id}</td>
                                    <td>${mueble.modeloMueble}</td>
                                    <td>${mueble.precio}</td> 
                                    <td><a href="${pageContext.request.contextPath}/AgregarMueble?accion=quitar&id=${mueble.id}" 
                                           class="btn btn-lg btn-block btn-outline-warning">
                                            Quitar
                                        </a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="container">
                <center>                   
                    <a href="${pageContext.request.contextPath}/JSP/Ventas/solicitarCompra.jsp" 
                       class="btn btn-lg btn-block btn btn-success">
                        Comprar
                    </a>
                </center>
            </div>
            <div class="container">
                <h1>Muebles En Venta</h1>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Mueble</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Agregar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${muebles}" var="mueble">
                            <c:if test="${!mueble.vendido}">
                                <tr>
                                    <td scope="row">${mueble.id}</td>
                                    <td>${mueble.modeloMueble}</td>
                                    <td>${mueble.precio}</td> 
                                    <td><a href="${pageContext.request.contextPath}/AgregarMueble?accion=agregar&id=${mueble.id}" 
                                           class="btn btn-lg btn-block btn-outline-info">
                                            Agregar
                                        </a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
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
