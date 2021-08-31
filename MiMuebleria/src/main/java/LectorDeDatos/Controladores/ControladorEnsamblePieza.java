/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LectorDeDatos.Controladores;

import Modelos.BaseDeDatos.PrescripcionMuebleBD;
import Modelos.Objetos.PrescripcionMueble;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author baquiax
 */
public class ControladorEnsamblePieza {

    private List<PrescripcionMueble> recetas;
    PrescripcionMuebleBD prescipcionMuebleBD;

    /**
     * Constructor por defecto, crea una lista de prescripciones
     */
    public ControladorEnsamblePieza() {
        this.recetas = new ArrayList<>();
        this.prescipcionMuebleBD = new PrescripcionMuebleBD();

    }

    /**
     * Constructor que recibe un listado de recetas
     *
     * @param recetas
     */
    public ControladorEnsamblePieza(List<PrescripcionMueble> recetas) {
        this.recetas = recetas;
    }

    /**
     * @return the recetas
     */
    public List<PrescripcionMueble> getRecetas() {
        return recetas;
    }

    /**
     * @param recetas the recetas to set
     */
    public void setRecetas(List<PrescripcionMueble> recetas) {
        this.recetas = recetas;
    }

    /**
     *
     * @param controladorPiezas
     * @param controladorMuebles
     * @return
     */
    public List<String> validarEnsambles(ControladorPiezas controladorPiezas,
            ControladorModeloMuebles controladorMuebles) {
        List<String> errores = new ArrayList<>();
        for (int i = 0; i < recetas.size(); i++) {
            if (controladorPiezas.validarExistenciaTipo(recetas.get(i).getTipoPieza())
                    && controladorMuebles.validarMueble(recetas.get(i).getModeloMueble())) {
                prescipcionMuebleBD.crearPrescripcionMueble(recetas.get(i));
            } else {
                recetas.remove(i);
                String error = recetas.get(i).getModeloMueble() + ", "
                        + recetas.get(i).getTipoPieza() + ", " + recetas.get(i).getCantidad();
                errores.add(error);
            }
        }

        return errores;
    }

    /**
     * Retorna todos los elementos necesarios para un ensamblaje
     *
     * @param Modelomueble
     * @return the recetas de un mueble
     */
    public List<PrescripcionMueble> recetaMueble(String Modelomueble) {
        List<PrescripcionMueble> recetaMueble = new ArrayList<>();
        for (int i = 0; i < recetas.size(); i++) {
            if (recetas.get(i).getModeloMueble().equalsIgnoreCase(Modelomueble)) {
                recetaMueble.add(recetas.get(i));
            }
        }
        return recetaMueble;
    }
}
