/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica;

import Modelos.BaseDeDatos.PiezaBD;
import Modelos.BaseDeDatos.TipoPiezaBD;
import Modelos.Objetos.Pieza;
import Modelos.Objetos.TipoPieza;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author baquiax
 */
@WebServlet(name = "CrearPieza", urlPatterns = {"/CrearPieza"})
public class CrearPieza extends HttpServlet {

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
        PiezaBD piezaBD = new PiezaBD();
        TipoPiezaBD tipoPiezaBD = new TipoPiezaBD();
        List<TipoPieza> tipoPiezas = tipoPiezaBD.getTipoPiezas();
        try {
            String nombre = request.getParameter("tipoPieza");
            double costo = Double.parseDouble(request.getParameter("costo"));
            Pieza pieza = new Pieza(nombre, costo);
            if (validarTipoPieza(tipoPiezas, nombre)) {
                piezaBD.crearPieza(pieza);
            } else {
                TipoPieza tipoPieza = new TipoPieza(nombre);
                tipoPiezaBD.crearTipoPieza(tipoPieza);
                piezaBD.crearPieza(pieza);
            }
            request.setAttribute("Error", false);
            request.setAttribute("mensaje", "Pieza creada correctamente");
            RequestDispatcher despachar = request.getRequestDispatcher("JSP/Fabrica/crearPieza.jsp");
            despachar.forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("Error", true);
            request.setAttribute("mensaje", "Error datos incorrectos");
            RequestDispatcher despachar = request.getRequestDispatcher("JSP/Fabrica/crearPieza.jsp");
            despachar.forward(request, response);
        }
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

    private boolean validarTipoPieza(List<TipoPieza> tipoPiezas, String nombre) {
        for (int i = 0; i < tipoPiezas.size(); i++) {
            if (tipoPiezas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

}
