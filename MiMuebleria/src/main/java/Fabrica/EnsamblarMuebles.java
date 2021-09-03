/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica;

import Modelos.BaseDeDatos.ModeloMuebleBD;
import Modelos.Objetos.ModeloMueble;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author baquiax
 */
@WebServlet(name = "EnsamblarMuebles", urlPatterns = {"/EnsamblarMuebles"})
public class EnsamblarMuebles extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModeloMuebleBD modeloMuebleBD = new ModeloMuebleBD();
        List<ModeloMueble> modelosMueble = modeloMuebleBD.getModelosMuebles();
         if (modelosMueble.isEmpty()) {
            request.getSession().setAttribute("hayModelos", false);
        } else {
            request.getSession().setAttribute("hayModelos", true);
        }
        request.getSession().setAttribute("modelosMueble", modelosMueble);
        response.sendRedirect("JSP/Fabrica/ensambleMueble.jsp");
    }

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

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
