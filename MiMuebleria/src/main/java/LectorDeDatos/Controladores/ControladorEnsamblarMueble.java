/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LectorDeDatos.Controladores;

import Modelos.BaseDeDatos.MuebleBD;
import Modelos.Objetos.*;
import java.util.*;

/**
 *
 * @author baquiax
 */
public class ControladorEnsamblarMueble {

    private List<Mueble> muebles;
    private MuebleBD muebleBD;

    /**
     * Constructor por defecto, crea una lista de muebles
     */
    public ControladorEnsamblarMueble() {
        this.muebles = new ArrayList<>();
        this.muebleBD = new MuebleBD();
    }

    /**
     * Constructor que recibe una lista de muebles
     *
     * @param muebles
     */
    public ControladorEnsamblarMueble(List<Mueble> muebles) {
        this.muebles = muebles;
    }

    /**
     * @return the muebles
     */
    public List<Mueble> getMuebles() {
        return muebles;
    }

    /**
     * @param muebles the muebles to set
     */
    public void setMuebles(List<Mueble> muebles) {
        this.muebles = muebles;
    }

    /**
     * Ensamble los muebles y envia los errores de ensambles
     *
     * @param controladorRecetas
     * @param controladorModelosMuebles
     * @param controladorUsuarios
     * @param controladorPiezas
     * @return
     */
    public List<String> ensambraMuebles(ControladorEnsamblePieza controladorRecetas,
            ControladorModeloMuebles controladorModelosMuebles,
            ControladorUsuarios controladorUsuarios, ControladorPiezas controladorPiezas) {
        List<String> errores = new ArrayList<>();
        for (int i = 0; i < this.muebles.size(); i++) {
            if (validarMuebleYUsuario(muebles.get(i), controladorModelosMuebles, controladorUsuarios)) {
                List<PrescripcionMueble> recetaMueble = new ArrayList<>();
                recetaMueble = controladorRecetas.recetaMueble(muebles.get(i).getModeloMueble());
                if (recetaMueble.isEmpty()) {
                    String error = muebles.get(i).getModeloMueble() + ", "
                            + muebles.get(i).getEnsamblador() + ", " + muebles.get(i).getFecha();
                    errores.add(error);
                } else {
                    List<Pieza> piezasMueble = new ArrayList<>();
                    boolean posible = true;
                    for (int j = 0; j < recetaMueble.size() && posible == true; j++) {
                        recetaMueble.get(i).getTipoPieza();
                        recetaMueble.get(i).getCantidad();
                        List<Pieza> piezas = controladorPiezas.piezasMueble(recetaMueble.get(i).getTipoPieza(),
                                recetaMueble.get(i).getCantidad());
                        if (piezas.isEmpty()) {
                            String error = muebles.get(i).getModeloMueble() + ", "
                                    + muebles.get(i).getEnsamblador() + ", " + muebles.get(i).getFecha();
                            errores.add(error);
                            System.out.println("no hay piezas");
                            posible = false;
                        } else {
                            agregarPiezas(piezasMueble, piezas);
                        }
                    }
                    if (posible == true) {
                        double costo = calcularCostoMueble(piezasMueble);
                        controladorPiezas.piezasUtilizadas(piezasMueble);
                        System.out.println("costo");
                        muebles.get(i).setCosto(costo);
                        muebleBD.crearMueble(muebles.get(i));
                    }
                }
            } else {
                String error = muebles.get(i).getModeloMueble() + ", "
                        + muebles.get(i).getEnsamblador() + ", " + muebles.get(i).getFecha();
                errores.add(error);
            }
        }
        return errores;
    }

    /**
     *
     * @param mueble
     * @param controladorModelosMuebles
     * @param controladorUsuarios
     * @return
     */
    private boolean validarMuebleYUsuario(Mueble mueble, ControladorModeloMuebles controladorModelosMuebles,
            ControladorUsuarios controladorUsuarios) {
        return (controladorUsuarios.existeUsuario(mueble.getEnsamblador())
                && controladorUsuarios.tipoUsuario(mueble.getEnsamblador()) == 2
                && controladorModelosMuebles.existeMueble(mueble.getModeloMueble()));
    }

    /**
     * Agrega piezas para un ensamblaje
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
            costo = piezasMueble.get(i).getCosto();
        }
        return costo;
    }

}
