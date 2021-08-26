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
public class MueblesFactura {

    private int id;
    private int factura;
    private int mueble;

    /**
     * Constructor sin el Id para mueblesFactura
     *
     * @param factura
     * @param mueble
     */
    public MueblesFactura(int factura, int mueble) {
        this.factura = factura;
        this.mueble = mueble;
    }

    /**
     * Constructor con todos los elementos de mueblesFactura
     *
     * @param id
     * @param factura
     * @param mueble
     */
    public MueblesFactura(int id, int factura, int mueble) {
        this.id = id;
        this.factura = factura;
        this.mueble = mueble;
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
     * @return the factura
     */
    public int getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(int factura) {
        this.factura = factura;
    }

    /**
     * @return the mueble
     */
    public int getMueble() {
        return mueble;
    }

    /**
     * @param mueble the mueble to set
     */
    public void setMueble(int mueble) {
        this.mueble = mueble;
    } 

}
