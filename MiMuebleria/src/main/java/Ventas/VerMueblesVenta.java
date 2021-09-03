/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Modelos.BaseDeDatos.MuebleBD;
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
@WebServlet(name = "VerMueblesVenta", urlPatterns = {"/VerMueblesVenta"})
public class VerMueblesVenta extends HttpServlet {

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
        MuebleBD mubleBD = new MuebleBD();
        List<Mueble> muebles = mubleBD.getMueblesVenta();
        if (muebles.isEmpty()) {
            request.getSession().setAttribute("hayMuebles", false);
        } else {
            request.getSession().setAttribute("hayMuebles", true);
        }
        request.getSession().setAttribute("muebles", muebles);
        response.sendRedirect("JSP/Ventas/listadoMueblesVenta.jsp");
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
