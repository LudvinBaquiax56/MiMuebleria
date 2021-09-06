/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Modelos.Objetos.Mueble;
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
@WebServlet(name = "AgregarMueble", urlPatterns = {"/AgregarMueble"})
public class AgregarMueble extends HttpServlet {

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
        try {
            String accion = request.getParameter("accion");
            int id = Integer.parseInt(request.getParameter("id"));
            List<Mueble> muebles = (List<Mueble>) request.getSession().getAttribute("muebles");
            if (accion.equals("quitar")) {
                modificarEstadoMueble(muebles, id);
            } else if (accion.equals("agregar")) {
                modificarEstadoMueble(muebles, id);
            }
            request.getSession().setAttribute("muebles", muebles);
            response.sendRedirect("JSP/Ventas/realizarVenta.jsp");
        } catch (NumberFormatException e) {
            e.printStackTrace();
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

    }

    /**
     * Cambia el estado de un mueble
     *
     * @param muebles
     * @param id
     */
    private void modificarEstadoMueble(List<Mueble> muebles, int id) {
        for (Mueble mueble : muebles) {
            if (mueble.getId() == id) {
                mueble.setVendido(!mueble.isVendido());
            }
        }

    }

}
