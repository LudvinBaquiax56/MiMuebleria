/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

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
@WebServlet(name = "InicioSesion", urlPatterns = {"/InicioSesion"})
public class InicioSesion extends HttpServlet {

    UsuarioBD usuarioBD;

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
        usuarioBD = new UsuarioBD();
        String nombre = request.getParameter("usuario");
        String password = request.getParameter("password");
        Usuario usuario = usuarioBD.getUsuario(nombre);
        if (usuario != null) {
            if (usuario.isEstado()) {
                if (usuario.getPassword().equals(password)) {
                    request.getSession().setAttribute("usuario", usuario.getNombre());
                    request.getSession().setAttribute("password", usuario.getPassword());
                    request.getSession().setAttribute("tipo", usuario.getTipo());
                    switch (usuario.getTipo()) {
                        case 1:
                            response.sendRedirect("JSP/Fabrica/inicioFabrica.jsp");
                            break;
                        case 2:
                            response.sendRedirect("JSP/Ventas/inicioVentas.jsp");
                            break;
                        case 3:
                            response.sendRedirect("JSP/Administracion/inicioAdministracion.jsp");
                            break;
                        default:
                            throw new AssertionError();
                    }
                } else {
                    request.setAttribute("Error", true);
                    request.setAttribute("mensaje", "Error contraseña incorrecto");

                    RequestDispatcher despachar = request.getRequestDispatcher("JSP/inicioSesion.jsp");
                    despachar.forward(request, response);
                }
            } else {
                request.setAttribute("Error", true);
                request.setAttribute("mensaje", "No puedes acceder al sistema incorrecto");

                RequestDispatcher despachar = request.getRequestDispatcher("JSP/inicioSesion.jsp");
                despachar.forward(request, response);
            }

        } else {
            request.setAttribute("Error", true);
            request.setAttribute("mensaje", "Error usuario incorrecto");

            RequestDispatcher despachar = request.getRequestDispatcher("JSP/inicioSesion.jsp");
            despachar.forward(request, response);
        }
    }

}
