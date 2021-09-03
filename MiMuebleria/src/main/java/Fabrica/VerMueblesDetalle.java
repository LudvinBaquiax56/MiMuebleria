/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica;

import Modelos.BaseDeDatos.MuebleBD;
import Modelos.Objetos.Mueble;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "VerMueblesDetalle", urlPatterns = {"/VerMueblesDetalle"})
public class VerMueblesDetalle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VerMueblesDetalle</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VerMueblesDetalle at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        MuebleBD muebleBD = new MuebleBD();
        List<String> muebles = null;
        String accion = request.getParameter("accion");
        if (accion.equals("detalle")) {
            muebles = muebleBD.getMueblesDetalle();
        } else if (accion.equals("nombreAscendente")) {
            muebles = muebleBD.getMueblesDetalleAscendente();
        } else if (accion.equals("nombreDescendente")) {
            muebles = muebleBD.getMueblesDetalleDescendente();
        } else if (accion.equals("cantidadAscendente")) {
            muebles = muebleBD.getMueblesDetalleCantidadAscendente();
        } else if (accion.equals("cantidadDescendente")) {
            muebles = muebleBD.getMueblesDetalleCantidadDescendente();
        } else {
            muebles = muebleBD.getMueblesDetalle();
        }
        if (muebles == null) {
            request.getSession().setAttribute("hayMuebles", false);
        } else {
            request.getSession().setAttribute("hayMuebles", true);
        }
        request.setAttribute("muebles", muebles);
        request.getRequestDispatcher("JSP/Fabrica/detalleMuebles.jsp").forward(request, response);
        processRequest(request, response);
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
        processRequest(request, response);
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
