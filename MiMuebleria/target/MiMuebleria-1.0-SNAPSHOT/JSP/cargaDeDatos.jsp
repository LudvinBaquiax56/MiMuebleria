<%-- 
    Document   : Carga De Datos
    Created on : 25/08/2021, 22:39:17
    Author     : baquiax
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="HeadesrAndFooters/headerGeneral.jsp"></jsp:include>
        <body>
            <div class="container">
                <center>
                    <h1><i class="fab fa-medium-m" style="color: brown;"></i> Mi Muebleria</h1>
                </center>
            </div>
            <div class="container" style="padding-top: 70px">
                <center>
                    <h1 class="align-content-lg-center">Carga de Datos</h1>
                </center>

                <form class="row g-3" action="CargaDeDatos" method="post" enctype="multipart/form-data">

                    <input class="form-control" type="file" name="archivoDB" id="archivoDB" placeholder="Elija el Archivo" required>
                    <br>
                    <center>
                        <input class="btn btn-primary" type="submit" value="Cargar">
                        <input class="btn" type="reset" value="Eliminar Datos">
                    </center>
                </form>
            </div>
        <jsp:include page="HeadesrAndFooters/footerGeneral.jsp"></jsp:include>
    </body>
</html>
