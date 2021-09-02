/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CargaDeDatos;

import Modelos.BaseDeDatos.UsuarioBD;
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
@WebServlet(name = "ValidarCargaDeDatos", urlPatterns = {"/ValidarCargaDeDatos"})
public class ValidarCargaDeDatos extends HttpServlet {

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
        UsuarioBD usuarios = new UsuarioBD();
        
        if (usuarios.getUsuarios().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/JSP/cargaDeDatos.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/JSP/inicioSesion.jsp");
        }
    }

}
