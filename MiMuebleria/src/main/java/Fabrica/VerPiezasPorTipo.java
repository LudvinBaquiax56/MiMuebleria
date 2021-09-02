/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica;

import Modelos.BaseDeDatos.PiezaBD;
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
@WebServlet(name = "VerPiezasPorTipo", urlPatterns = {"/VerPiezasPorTipo"})
public class VerPiezasPorTipo extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        PiezaBD piezaBD = new PiezaBD();
        List<String> piezas = null;
        String accion = request.getParameter("accion");
        if (accion.equals("mostrar")) {
            piezas = piezaBD.getPiezasPorTipo();
        } else if (accion.equals("descendente")) {
            piezas = piezaBD.getPiezasPorTipoDesendente();
        } else if (accion.equals("ascendente")) {
            piezas = piezaBD.getPiezasPorTipoAsendente();
        } else if (accion.equals("cantidadDescendente")) {
            piezas = piezaBD.getPiezasPorTipoCantidadDesendente();
        } else if (accion.equals("cantidadAscendente")) {
            piezas = piezaBD.getPiezasPorTipoCantidadAsendente();
        } else {
            piezas = piezaBD.getPiezasPorTipo();
        }
        if (piezas == null) {
            request.getSession().setAttribute("hayPiezas", false);
        } else {
            request.getSession().setAttribute("hayPiezas", true);
        }
        request.setAttribute("piezas", piezas);
        request.getRequestDispatcher("JSP/Fabrica/listadoPiezasPorTipo.jsp").forward(request, response);
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
