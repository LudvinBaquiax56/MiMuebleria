/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import Modelos.BaseDeDatos.UsuarioBD;
import Modelos.Objetos.Usuario;
import java.io.IOException;
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
@WebServlet(name = "CrearUsuario", urlPatterns = {"/CrearUsuario"})
public class CrearUsuario extends HttpServlet {

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
        UsuarioBD usuarioBD = new UsuarioBD();
        try {
            String nombre = request.getParameter("usuario");
            String password = request.getParameter("password");
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            if (tipo >= 1 && tipo <= 3) {
                Usuario usuario = new Usuario(nombre, password, tipo);
                usuarioBD.crearUsuario(usuario);
                request.setAttribute("Error", false);
                request.setAttribute("mensaje", "Usuario creado correctamente");
                RequestDispatcher despachar = request.getRequestDispatcher("JSP/Administracion/crearUsuario.jsp");
                despachar.forward(request, response);
            } else {
                request.setAttribute("Error", true);
                request.setAttribute("mensaje", "Error datos incorrectos");
                RequestDispatcher despachar = request.getRequestDispatcher("JSP/Administracion/crearUsuario.jsp");
                despachar.forward(request, response);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("Error", true);
            request.setAttribute("mensaje", "Error datos incorrectos");
            RequestDispatcher despachar = request.getRequestDispatcher("JSP/Administracion/crearUsuario.jsp");
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

}
