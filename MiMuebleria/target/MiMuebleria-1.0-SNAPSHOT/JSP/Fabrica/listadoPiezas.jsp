<%-- 
    Document   : listadoPiezas
    Created on : 29/08/2021, 00:34:50
    Author     : baquiax
--%>

<%@page import="Modelos.Objetos.Pieza"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- para dar formato el texto-->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- SELECCIONAMOS LA LOCALIDAD -->
<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <jsp:include page="../HeadesrAndFooters/headerGeneral.jsp"></jsp:include>
        <body>
        <% if ((int) request.getSession().getAttribute("tipo") == 1) {%>
        <jsp:include page="navegacionFabrica.jsp"></jsp:include>
            <div class="container">
                <h1>Piezas</h1>
            <%List<Pieza> piezas = (List<Pieza>) request.getSession().getAttribute("piezas");%>
            <c:if test="${hayPiezas != null && hayPiezas == true}">
                <div class="row">
                    <div class="col-md-8">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Pieza</th>
                                    <th scope="col">Costo</th>
                                    <th scope="col">Editar</th>
                                    <th scope="col">Eliminar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${piezas}" var="pieza">
                                    <tr>
                                        <td scope="row">${pieza.id}</td>
                                        <td>${pieza.tipoPieza}</td>
                                        <td><fmt:formatNumber value="${pieza.costo}" type="currency"/></td>

                                        <td><a href="${pageContext.request.contextPath}/ModificarPieza?accion=modificar&id=${pieza.id}" 
                                               class="btn btn-lg btn-block btn-outline-info">
                                                Editar
                                            </a>
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/ModificarPieza?accion=eliminar&id=${pieza.id}" 
                                               class="btn btn-lg btn-block btn-outline-warning">
                                                Eliminar
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-4">
                        <h1>Piezas por Agotarse</h1>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Cantidad</th>
                                    <th scope="col">Pieza</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${piezasAgotadas}" var="pieza">
                                    ${pieza}
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
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