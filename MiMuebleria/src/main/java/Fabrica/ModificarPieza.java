/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica;

import Modelos.BaseDeDatos.PiezaBD;
import Modelos.Objetos.Pieza;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author baquiax
 */
@WebServlet(name = "ModificarPieza", urlPatterns = {"/ModificarPieza"})
public class ModificarPieza extends HttpServlet {

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
        String accion = request.getParameter("accion");
        int id = Integer.parseInt(request.getParameter("id"));
        if (accion.equals("modificar")) {
            Pieza pieza = piezaBD.getPieza(id);
            if (pieza == null) {
                request.setAttribute("hayPieza", false);
            } else {
                request.setAttribute("hayPieza", true);
            }
            request.getSession().setAttribute("pieza", pieza);
            response.sendRedirect("JSP/Fabrica/editarPieza.jsp");
        } else if (accion.equals("eliminar")) {
            piezaBD.eliminarPieza(id);
            response.sendRedirect(request.getContextPath() + "/VerPiezas");
        } else {
            response.sendRedirect("JSP/Fabrica/inicioFabrica.jsp");
        }
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
        try {
            PiezaBD piezaBD = new PiezaBD();
            Pieza pieza = (Pieza) request.getSession().getAttribute("pieza");
            String costo = request.getParameter("costo");
            pieza.setCosto(Double.parseDouble(costo));
            piezaBD.modificarPieza(pieza);
            response.sendRedirect(request.getContextPath() + "/VerPiezas");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
