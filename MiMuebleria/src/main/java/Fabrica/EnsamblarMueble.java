/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica;

import Modelos.BaseDeDatos.MuebleBD;
import Modelos.BaseDeDatos.PiezaBD;
import Modelos.BaseDeDatos.PrescripcionMuebleBD;
import Modelos.Objetos.Mueble;
import Modelos.Objetos.Pieza;
import Modelos.Objetos.PrescripcionMueble;
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
@WebServlet(name = "EnsamblarMueble", urlPatterns = {"/EnsamblarMueble"})
public class EnsamblarMueble extends HttpServlet {

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
        String mueble = request.getParameter("mueble");
        PrescripcionMuebleBD prescripcionMuebleBD = new PrescripcionMuebleBD();
        List<PrescripcionMueble> receta = prescripcionMuebleBD.getPrescripcionMueble(mueble);
        if (receta.isEmpty()) {
            request.setAttribute("Error", true);
            request.setAttribute("mensaje", "No se pudo realizar el ensamble de " + mueble);
            RequestDispatcher despachar = request.getRequestDispatcher("JSP/Fabrica/confirmacionEnsamble.jsp");
            despachar.forward(request, response);
        } else {
            PiezaBD piezaBD = new PiezaBD();
            List<Pieza> piezasMueble = new ArrayList<>();
            boolean posible = true;
            int contador = 0;
            while (contador < receta.size() && posible) {
                List<Pieza> piezas = piezaBD.getPiezas(receta.get(contador).getTipoPieza(),
                        receta.get(contador).getCantidad());
                if (piezas.isEmpty() || piezas.size() < receta.get(contador).getCantidad()) {
                    posible = false;
                } else {
                    agregarPiezas(piezasMueble, piezas);
                }
                contador++;
            }
            if (posible == true) {
                double costo = calcularCostoMueble(piezasMueble);
                piezasUtilizadas(piezaBD, piezasMueble);

                LocalDate hoy = LocalDate.now();
                String usuario = (String) request.getSession().getAttribute("usuario");
                Mueble muebleC = new Mueble(mueble, costo, hoy, usuario);
                MuebleBD muebleBD = new MuebleBD();
                muebleBD.crearMueble(muebleC);
                request.setAttribute("Error", false);
                request.setAttribute("mensaje", "Ensamblaje realizado con exito");
                RequestDispatcher despachar = request.getRequestDispatcher("JSP/Fabrica/confirmacionEnsamble.jsp");
                despachar.forward(request, response);
            } else {
                request.setAttribute("Error", true);
                request.setAttribute("mensaje", "No se pudo realizar el ensamble de " + mueble + ", no existen piezas suficienetes");
                RequestDispatcher despachar = request.getRequestDispatcher("JSP/Fabrica/confirmacionEnsamble.jsp");
                despachar.forward(request, response);
            }
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
     * Agrega piezas
     *
     * @param piezasTotal
     * @param piezasAgregar
     */
    private void agregarPiezas(List<Pieza> piezasTotal, List<Pieza> piezasAgregar) {
        for (int i = 0; i < piezasAgregar.size(); i++) {
            piezasTotal.add(piezasAgregar.get(i));
        }
    }

    /**
     * Calcula el costo de un mueble
     *
     * @param piezasMueble
     * @return
     */
    private double calcularCostoMueble(List<Pieza> piezasMueble) {
        double costo = 0;
        for (int i = 0; i < piezasMueble.size(); i++) {
            costo = costo + piezasMueble.get(i).getCosto();
        }
        return costo;
    }

    /**
     * Cambia de estado las piezas disponibles a utilizadas
     *
     * @param piezasMueble
     */
    private void piezasUtilizadas(PiezaBD piezaBD, List<Pieza> piezasMueble) {
        for (Pieza pieza : piezasMueble) {
            pieza.setDisponible(false);
            piezaBD.modificarPieza(pieza);
        }
    }
}
