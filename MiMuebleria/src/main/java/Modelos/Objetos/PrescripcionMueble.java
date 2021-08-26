/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Objetos;

/**
 *
 * @author baquiax
 */
public class PrescripcionMueble {

    private int id;
    private String tipoPieza;
    private String modeloMueble;
    private int cantidad;

    /**
     * Constructor por defecto del objeto Prescripcion Mueble (receta Mueble)
     */
    public PrescripcionMueble() {
    }

    /**
     * Constructor con los atributos necesarios del objeto Prescripcion Mueble
     * (receta Mueble)
     *
     * @param tipoPieza
     * @param modeloMueble
     * @param cantidad
     */
    public PrescripcionMueble(String tipoPieza, String modeloMueble, int cantidad) {
        this.tipoPieza = tipoPieza;
        this.modeloMueble = modeloMueble;
        this.cantidad = cantidad;
    }

    /**
     * Constructor con todos los atributos del objeto Prescripcion Mueble
     * (receta Mueble)
     *
     * @param id
     * @param tipoPieza
     * @param modeloMueble
     * @param cantidad
     */
    public PrescripcionMueble(int id, String tipoPieza, String modeloMueble, int cantidad) {
        this.id = id;
        this.tipoPieza = tipoPieza;
        this.modeloMueble = modeloMueble;
        this.cantidad = cantidad;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tipoPieza
     */
    public String getTipoPieza() {
        return tipoPieza;
    }

    /**
     * @param tipoPieza the tipoPieza to set
     */
    public void setTipoPieza(String tipoPieza) {
        this.tipoPieza = tipoPieza;
    }

    /**
     * @return the modeloMueble
     */
    public String getModeloMueble() {
        return modeloMueble;
    }

    /**
     * @param modeloMueble the modeloMueble to set
     */
    public void setModeloMueble(String modeloMueble) {
        this.modeloMueble = modeloMueble;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
