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
public class Pieza {

    private String tipoPieza;
    private double costo;
    private boolean disponible;
    private int id;

    /**
     * Constructor por defecto del objeto Pieza
     */
    public Pieza() {
    }

    /**
     * Constructor con los atributos basicos de una pieza
     *
     * @param tipoPieza
     * @param costo
     */
    public Pieza(String tipoPieza, double costo) {
        this.tipoPieza = tipoPieza;
        this.costo = costo;
        this.disponible = true;
    }

    /**
     * Constructor con todos los atributos de una pieza
     *
     * @param tipoPieza
     * @param costo
     * @param disponible
     * @param id
     */
    public Pieza(String tipoPieza, double costo, boolean disponible, int id) {
        this.tipoPieza = tipoPieza;
        this.costo = costo;
        this.disponible = disponible;
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
     * @return the costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * @return the disponible
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
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

}
