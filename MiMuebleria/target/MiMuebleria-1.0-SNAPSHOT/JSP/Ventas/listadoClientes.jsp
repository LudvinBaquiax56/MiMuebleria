<%-- 
    Document   : listadoClientes
    Created on : 3/09/2021, 00:31:42
    Author     : baquiax
--%>

<%@page import="Modelos.Objetos.Cliente"%>
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
                    <h1>Clientes</h1>
                </center>    
            </div>
        <%List<Cliente> clientes = (List<Cliente>) request.getSession().getAttribute("clientes");%>
        <c:if test="${hayClientes != null && hayClientes == true}">
            <div class="container">                    
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Nombre</th>
                            <th scope="col">NIT</th>
                            <th scope="col">Direccion</th>
                            <th scope="col">Municipio</th>
                            <th scope="col">Departamento</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${clientes}" var="cliente">
                            <tr>
                                <td scope="row">${cliente.nombre}</td>
                                <td scope="row">${cliente.NIT}</td>
                                <td scope="row">${cliente.direccion}</td>
                                <td scope="row">${cliente.municipio}</td>
                                <td scope="row">${cliente.departamento}</td>                        
                            </tr>
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
