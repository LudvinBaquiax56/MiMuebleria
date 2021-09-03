<%-- 
    Document   : ensambleMueble
    Created on : 3/09/2021, 04:38:56
    Author     : baquiax
--%>

<%@page import="Modelos.Objetos.ModeloMueble"%>
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
                <h1>Ensamble Mueble</h1>
            <%List<ModeloMueble> modelosMueble = (List<ModeloMueble>) request.getSession().getAttribute("modelosMueble");%>
            <c:if test="${hayModelos != null && hayModelos == true}">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Mueble</th>
                            <th scope="col">Ensamblar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${modelosMueble}" var="modelo">
                            <tr>
                                <td scope="row">${modelo.nombre}</td>
                                <td><a href="${pageContext.request.contextPath}/EnsamblarMueble?mueble=${modelo.nombre}" 
                                       class="btn btn-lg btn-block btn-outline-info">
                                        Ensamblar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
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
