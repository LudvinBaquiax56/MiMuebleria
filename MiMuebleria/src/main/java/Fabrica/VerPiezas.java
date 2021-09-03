/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica;

import Modelos.BaseDeDatos.PiezaBD;
import Modelos.Objetos.Pieza;
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
@WebServlet(name = "VerPiezas", urlPatterns = {"/VerPiezas"})
public class VerPiezas extends HttpServlet {


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
        List<Pieza> piezas = piezaBD.getPiezasDisponibles();
        List<String> piezasAgotadas = piezaBD.getPiezasAgotadas();
        if (piezas.isEmpty()) {
            request.getSession().setAttribute("hayPiezas", false);
        } else {
            request.getSession().setAttribute("hayPiezas", true);
        }
        request.getSession().setAttribute("piezas", piezas);
        request.getSession().setAttribute("piezasAgotadas", piezasAgotadas);
        response.sendRedirect("JSP/Fabrica/listadoPiezas.jsp");
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
}
