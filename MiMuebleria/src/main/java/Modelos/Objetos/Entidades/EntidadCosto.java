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

public class EntidadCosto extends Entidad {

    private double costo;

    /**
     * Constructor por defecto
     */
    public EntidadCosto() {
    }

    /**
     *
     * 
     * @param nombre
     * @param costo
     */
    public EntidadCosto(String nombre, double costo) {
        super(nombre);
        //this.costo  = Double.parseDouble(costo);
        
        this.costo = costo;
       
    }

    /**
     * @return the costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo)  {
        this.costo = costo;
    }

}
