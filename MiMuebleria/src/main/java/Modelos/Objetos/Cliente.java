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
public class Cliente extends Entidad {

    private String NIT;
    private String direccion;
    private String municipio;
    private String departamento;

    /**
     * Constructor por defecto del Cliente
     */
    public Cliente() {
    }

    /**
     * Constructor con los parametros indespinsables de un Cliente
     *
     * @param nombre
     * @param NIT
     * @param direccion
     */
    public Cliente(String nombre, String NIT, String direccion) {
        super(nombre);
        this.NIT = NIT;
        this.direccion = direccion;
    }

    /**
     * Constructor con todos los parametros de un cliente
     *
     * @param NIT
     * @param nombre
     * @param direccion
     * @param municipio
     * @param departamento
     */
    public Cliente(String NIT, String nombre, String direccion, String municipio, String departamento) {
        super(nombre);
        this.NIT = NIT;
        this.direccion = direccion;
        this.municipio = municipio;
        this.departamento = departamento;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isCompleto() {
        return municipio != null && departamento != null;
    }
}
