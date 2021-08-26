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
public class Usuario extends Entidad {

    private String password;
    private int tipo;

    /**
     * Constructor por defecto de un Usuario
     */
    public Usuario() {
    }

    /**
     * Constructor para un usaurio
     *
     * @param nombre
     * @param password
     * @param tipo
     */
    public Usuario(String nombre, String password, int tipo) {
        super(nombre);
        this.password = password;
        this.tipo = tipo;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

}
