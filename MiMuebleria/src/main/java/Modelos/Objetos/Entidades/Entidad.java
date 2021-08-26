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
public class Entidad {

    private String nombre;

    /**
     * Constructor pro defecto de la clase entidad
     */
    public Entidad() {
    }

    /**
     * Crea un objeto entidad
     *
     * @param nombre nombre de la entidad
     */
    public Entidad(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
