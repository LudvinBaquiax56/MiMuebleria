/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Modelos.BaseDeDatos.ClienteBD;
import Modelos.Objetos.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CrearCliente", urlPatterns = {"/CrearCliente"})
public class CrearCliente extends HttpServlet {

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
        ClienteBD clienteBD = new ClienteBD();
        try {
            String nombre = request.getParameter("nombre");
            String NIT = request.getParameter("NIT");
            String direccion = request.getParameter("direccion");
            String municipio = request.getParameter("municipio");
            String departamento = request.getParameter("departamento");
            Cliente cliente = new Cliente(NIT, nombre, direccion, municipio, departamento);
            clienteBD.crearCliente(cliente);
            request.setAttribute("Error", false);
            request.setAttribute("mensaje", "Cliente creado correctamente");
            RequestDispatcher despachar = request.getRequestDispatcher("JSP/Ventas/registrarCliente.jsp");
            despachar.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("Error", true);
            request.setAttribute("mensaje", "Error no se pudo registrar al usuario");
            RequestDispatcher despachar = request.getRequestDispatcher("JSP/Ventas/registrarCliente.jsp");
            despachar.forward(request, response);
        }
    }

}
