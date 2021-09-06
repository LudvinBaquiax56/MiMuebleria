<%-- 
    Document   : confirmacionVenta
    Created on : 4/09/2021, 07:26:45
    Author     : baquiax
--%>

<%@page import="Modelos.Objetos.Factura"%>
<%@page import="Modelos.Objetos.Mueble"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.Objetos.Cliente"%>
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
                    <h1>Venta</h1>
                </center>    
            </div>
        <c:if test="${Error == false}">
            <%Cliente Cliente = (Cliente) request.getAttribute("Cliente");
                List<Mueble> MublesComprados = (List<Mueble>) request.getAttribute("MublesComprados");
                Factura Factura = (Factura) request.getAttribute("Factura");%>
            <div class="container">
                <h2>No Factura: ${Factura.noFactura}</h2>
                <h4>Nombre: ${Cliente.nombre}</h4>
                <h4>NIT: ${Cliente.NIT}</h4>
                <h4>Direccion: ${Cliente.direccion}</h4>
            </div>
            <div class="container">                
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Mueble</th>
                            <th scope="col">Precio</th>
                        </tr>
                    </thead>
                    <tbody>                        
                        <c:forEach items="${MublesComprados}" var="mueble">
                            <tr>
                                <td>${mueble.modeloMueble}</td>
                                <td>${mueble.precio}</td> 
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="container">
                <h2>Total: </h2>
                <h3>${Factura.total}</h3>
            </div>
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

