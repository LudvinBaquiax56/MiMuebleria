<%-- 
    Document   : solicitarCompra
    Created on : 4/09/2021, 04:49:53
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
                    <h1>Realizar Compra</h1>
                </center>    
            </div>
            <div class="container">
                <h1 class="h3 mb-3 fw-normal">Ingrese el NIT del cliente</h1>
                <form classs="form-control mr-auto" action="${pageContext.request.contextPath}/BuscarClienteCompra" method="post">
                    <div class="form-floating">
                        <input type="text" name="NIT" class="form-control">
                        <label for="floatingPassword">NIT</label>
                    </div>
                    <button class="w-100 btn btn-lg btn-primary" type="submit">Confirmar Compra</button>
                </form>
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
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${muebles}" var="mueble">
                            <c:if test="${mueble.vendido}">
                                <tr>
                                    <td scope="row">${mueble.id}</td>
                                    <td>${mueble.modeloMueble}</td>
                                    <td>${mueble.precio}</td> 
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
