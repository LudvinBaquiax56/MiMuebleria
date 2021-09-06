/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Modelos.BaseDeDatos.ClienteBD;
import Modelos.BaseDeDatos.FacturaBD;
import Modelos.BaseDeDatos.MuebleBD;
import Modelos.BaseDeDatos.MueblesFacturaBD;
import Modelos.Objetos.Cliente;
import Modelos.Objetos.Factura;
import Modelos.Objetos.Mueble;
import Modelos.Objetos.MueblesFactura;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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
@WebServlet(name = "CrearClienteVenta", urlPatterns = {"/CrearClienteVenta"})
public class CrearClienteVenta extends HttpServlet {

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
        FacturaBD facturaBD = new FacturaBD();
        MuebleBD mubleBD = new MuebleBD();
        String NIT = (String) request.getSession().getAttribute("NIT");
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String municipio = request.getParameter("municipio");
        String departamento = request.getParameter("departamento");
        String usuario = (String) request.getSession().getAttribute("usuario");
        Cliente cliente = new Cliente(NIT, nombre, direccion, municipio, departamento);
        List<Mueble> muebles = (List<Mueble>) request.getSession().getAttribute("muebles");
        List<Mueble> mueblesComprados = obtenerMueblescomprados(muebles);
        if (mueblesComprados.isEmpty()) {
            request.setAttribute("Error", true);
            request.setAttribute("mensaje", "Compra incorrecta no hay mubles para comprar");
            RequestDispatcher despachar = request.getRequestDispatcher("JSP/Ventas/confirmacionVenta.jsp");
            despachar.forward(request, response);
        } else {
            double total = calcularTotal(mueblesComprados);
            LocalDate hoy = LocalDate.now();
            Factura factura = new Factura(NIT, usuario, hoy, total);
            facturaBD.crearFactura(factura);
            int id = facturaBD.idUltimaFactura();
            factura.setNoFactura(id);
            List<MueblesFactura> mublesFactura = new ArrayList<>();
            for (int i = 0; i < mueblesComprados.size(); i++) {
                mublesFactura.add(new MueblesFactura(id, mueblesComprados.get(i).getId()));
            }
            MueblesFacturaBD mublesFacturaBD = new MueblesFacturaBD();
            for (int i = 0; i < mublesFactura.size(); i++) {
                mublesFacturaBD.crearMueblesFactura(mublesFactura.get(i));
            }
            for (int i = 0; i < mueblesComprados.size(); i++) {
                mubleBD.modificarMueble(mueblesComprados.get(i));
            }
            request.setAttribute("Error", false);
            request.setAttribute("Cliente", cliente);
            request.setAttribute("MublesComprados", mueblesComprados);
            request.setAttribute("Factura", factura);
            request.setAttribute("mensaje", "Compra realizada correctamente");
            RequestDispatcher despachar = request.getRequestDispatcher("JSP/Ventas/confirmacionVenta.jsp");
            despachar.forward(request, response);
        }
    }

    /**
     * Retorna los muebles comprados por el usuario
     *
     * @param muebles
     * @return
     */
    private List<Mueble> obtenerMueblescomprados(List<Mueble> muebles) {
        List<Mueble> mueblesComprados = new ArrayList<>();
        for (Mueble mueble : muebles) {
            if (mueble.isVendido() == true) {
                mueblesComprados.add(mueble);
            }
        }
        return mueblesComprados;
    }

    /**
     * Calcula el total de los muebles comprados
     *
     * @param mueblesComprados
     * @return
     */
    private double calcularTotal(List<Mueble> mueblesComprados) {
        double total = 0;
        for (Mueble mueblesComprado : mueblesComprados) {
            total = total + mueblesComprado.getCosto();
        }
        return total;
    }
}
