<%-- 
    Document   : InicioSecion
    Created on : 28/08/2021, 23:17:40
    Author     : baquiax
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../JSP/HeadesrAndFooters/headerGeneral.jsp"></jsp:include>
        <body>
            <div class="container">
                <center>
                    <h1><i class="fab fa-medium-m" style="color: brown;"></i> Mi Muebleria</h1>
                    <h2>Inicio Sesion!</h2>
                </center>
            </div>
            <div class="container">
                <form classs="form-control mr-auto">
                    <h1 class="h3 mb-3 fw-normal">Ingrese su Usuario y Contrasenia</h1>
                    <div class="form-floating">
                        <input type="text" class="form-control" id="floatingInput" placeholder="usaurio">
                        <label for="floatingInput">Usuario</label>
                    </div>
                    <div class="form-floating">
                        <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                        <label for="floatingPassword">Password</label>
                    </div>
                    <button class="w-100 btn btn-lg btn-primary" type="submit">Ingresar</button>
                </form>
            </div>

        </center>

    <jsp:include page="HeadesrAndFooters/footerGeneral.jsp"></jsp:include>
</body>
</html>
