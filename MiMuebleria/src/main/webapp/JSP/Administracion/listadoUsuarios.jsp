<%-- 
    Document   : listadoUsuarios
    Created on : 2/09/2021, 02:45:27
    Author     : baquiax
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Modelos.Objetos.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../HeadesrAndFooters/headerGeneral.jsp"></jsp:include>
        <body>
        <% if ((int) request.getSession().getAttribute("tipo") == 3) {%>
        <jsp:include page="navegacionAdministracion.jsp"></jsp:include>
            <div class="container">
                <center>            
                    <h1>Usuarios</h1>
                </center>    
            </div>
        <%List<Usuario> piezas = (List<Usuario>) request.getSession().getAttribute("usuarios");%>
        <c:if test="${hayUsuarios != null && hayUsuarios == true}">
            <div class="container">                    
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Nombre</th>
                            <th scope="col">Tipo</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Suspender</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${usuarios}" var="usuario">
                            <tr>
                                <td scope="row">${usuario.nombre}</td>
                                <c:if test="${usuario.tipo == 1}">
                                    <td>Fabrica</td>
                                </c:if>
                                <c:if test="${usuario.tipo == 2}">
                                    <td>Ventas</td>
                                </c:if>
                                <c:if test="${usuario.tipo == 3}">
                                    <td>Administracion</td>
                                </c:if>
                                <c:if test="${usuario.estado == true}">
                                    <td>Activo</td>
                                    <td><a href="${pageContext.request.contextPath}/SuspenderUsuario?id=${usuario.nombre}" 
                                           class="btn btn-lg btn-block btn-outline-warning">
                                            Suspender
                                        </a>
                                    </td>
                                </c:if>
                                <c:if test="${usuario.estado == false}">
                                    <td>Suspendido</td>
                                </c:if>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
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

