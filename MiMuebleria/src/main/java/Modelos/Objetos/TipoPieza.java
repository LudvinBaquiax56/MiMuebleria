/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Objetos;

import Modelos.Objetos.Entidades.Entidad;

/**
 *
 * @author baquiax
 */
public class TipoPieza extends Entidad {

    private String descripcion;

    /**
     *
     */
    public TipoPieza() {
    }

    /**
     *
     * @param nombre
     * @param descripcion
     */
    public TipoPieza(String nombre, String descripcion) {
        super(nombre);
        this.descripcion = descripcion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
