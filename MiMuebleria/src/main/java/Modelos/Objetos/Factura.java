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
public class Factura {

    private int noFactura;
    private String NIT;
    private String vendedor;
    private LocalDate fecha;
    private double total;

    /**
     * Constructor por defecto de una Factura
     */
    public Factura() {
    }

    /**
     * Constructor con los elementos basicos de una Factura
     *
     * @param NIT
     * @param vendedor
     * @param fecha
     * @param total
     */
    public Factura(String NIT, String vendedor, LocalDate fecha, double total) {
        this.NIT = NIT;
        this.vendedor = vendedor;
        this.fecha = fecha;
        this.total = total;
    }

    /**
     * Constructor de una factura con todos los elementos
     *
     * @param noFactura
     * @param NIT
     * @param vendedor
     * @param fecha
     * @param total
     */
    public Factura(int noFactura, String NIT, String vendedor, LocalDate fecha, double total) {
        this.noFactura = noFactura;
        this.NIT = NIT;
        this.vendedor = vendedor;
        this.fecha = fecha;
        this.total = total;
    }

    /**
     * @return the noFactura
     */
    public int getNoFactura() {
        return noFactura;
    }

    /**
     * @param noFactura the noFactura to set
     */
    public void setNoFactura(int noFactura) {
        this.noFactura = noFactura;
    }

    /**
     * @return the NIT
     */
    public String getNIT() {
        return NIT;
    }

    /**
     * @param NIT the NIT to set
     */
    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    /**
     * @return the vendedor
     */
    public String getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
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
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

}
