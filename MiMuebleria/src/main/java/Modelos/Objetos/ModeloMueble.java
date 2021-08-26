/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Objetos;

import Modelos.Objetos.Entidades.EntidadPrecio;

/**
 *
 * @author baquiax
 */
public class ModeloMueble extends EntidadPrecio {

    /**
     * Constructor por defecto del Modelo Mueble
     */
    public ModeloMueble() {
    }

    /**
     * Constructor con todos los atributos del Modelo Mueble
     *
     * @param nombre
     * @param precio
     */
    public ModeloMueble(String nombre, double precio) {
        super(nombre, precio);
    }

}
