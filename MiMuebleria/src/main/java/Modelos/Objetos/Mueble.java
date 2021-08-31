/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Objetos;

import java.time.LocalDate;

/**
 *
 * @author baquiax
 */
public class Mueble {

    private String modeloMueble;
    private double costo;
    private LocalDate fecha;
    private String ensamblador;
    private boolean devolucion;
    private int id;

    /**
     * Constructor por defecto
     */
    public Mueble() {
    }

    /**
     * Constructor basico, este constructor funciona para luego ser validado si
     * el mueble es posible de ensamblar
     *
     * @param modeloMueble
     * @param ensamblador
     * @param fecha
     */
    public Mueble(String modeloMueble, String ensamblador, LocalDate fecha) {
        this.modeloMueble = modeloMueble;
        this.ensamblador = ensamblador;
        this.fecha = fecha;
    }

    /**
     * Constructor con atributo devolucion falso
     *
     * @param modeloMueble
     * @param costo
     * @param fecha
     * @param ensamblador
     */
    public Mueble(String modeloMueble, double costo, LocalDate fecha, String ensamblador) {
        this.modeloMueble = modeloMueble;
        this.costo = costo;
        this.fecha = fecha;
        this.ensamblador = ensamblador;
        this.devolucion = false;
    }

    /**
     * Constructor con todos los parametros de un mueble
     *
     * @param id
     * @param modeloMueble
     * @param costo
     * @param fecha
     * @param ensamblador
     * @param devolucion
     */
    public Mueble(int id, String modeloMueble, double costo, LocalDate fecha,
            String ensamblador, boolean devolucion) {
        this.id = id;
        this.modeloMueble = modeloMueble;
        this.costo = costo;
        this.fecha = fecha;
        this.ensamblador = ensamblador;
        this.devolucion = devolucion;
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
     * @return the fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the ensamblador
     */
    public String getEnsamblador() {
        return ensamblador;
    }

    /**
     * @param ensamblador the ensamblador to set
     */
    public void setEnsamblador(String ensamblador) {
        this.ensamblador = ensamblador;
    }

    /**
     * @return the devolucion
     */
    public boolean isDevolucion() {
        return devolucion;
    }

    /**
     * @param devolucion the devolucion to set
     */
    public void setDevolucion(boolean devolucion) {
        this.devolucion = devolucion;
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
