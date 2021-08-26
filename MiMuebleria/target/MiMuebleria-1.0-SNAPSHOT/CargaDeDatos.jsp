<%-- 
    Document   : Carga De Datos
    Created on : 25/08/2021, 22:39:17
    Author     : baquiax
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file= "HeaderGeneral.html" %>
    <body>

        <div class="container" style="padding-top: 70px">
            <center>
                <h1 class="align-content-lg-center">Carga de Datos</h1>
            </center>
            
            <form class="col-12 caja2" action="CargaDeDatos" method="post" enctype="multipart/form-data">
                <table>
                    <tr>
                        <input class="form-control" type="file"  name="archivoDB" id="archivoDB" placeholder="Elija el Archivo" required>
                    </tr>
                </table>
                
                <br>
                <CENTER>
                    <input class="btn btn-primary" type="submit" value="Cargar">
                    <input class="btn" type="reset" value="Eliminar Datos">
                </CENTER>
            </form>
        </div>
        <%@ include file = "FooterGeneral.html" %>
    </body>
</html>
