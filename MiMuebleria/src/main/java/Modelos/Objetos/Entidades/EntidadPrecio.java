/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Objetos.Entidades;

/**
 *
 * @author baquiax
 */
public class EntidadPrecio extends Entidad {

    private double precio;

    public EntidadPrecio() {

    }

    public EntidadPrecio(String nombre, double precio) {
        super(nombre);
        this.precio = precio;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
