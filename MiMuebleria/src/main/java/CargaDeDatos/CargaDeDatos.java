/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CargaDeDatos;

import LectorDeDatos.LectorDeDatos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author baquiax
 */
@WebServlet(name = "CargaDeDatos", urlPatterns = {"/JSP/CargaDeDatos"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 100 // 100MB
)
public class CargaDeDatos extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InputStream archivo = request.getPart("archivoDB").getInputStream();
        BufferedReader miBuffer = new BufferedReader(new InputStreamReader(archivo));
        LectorDeDatos lector = new LectorDeDatos();
        lector.leerArchivo(miBuffer);
        lector.insertarDatos();
        HttpSession sesion = request.getSession();
        
        sesion.setAttribute("Informe", lector.informe());
        sesion.setAttribute("erroresFormato", lector.getErroresFormato());
        sesion.setAttribute("erroresRecetas", lector.getErroresLogicosRecetas());
        sesion.setAttribute("erroresEnsambles", lector.getErroresLogicosEnsamebles());
        response.sendRedirect(request.getContextPath() + "/JSP/InformeCargaDeDatos.jsp");
    }

}
