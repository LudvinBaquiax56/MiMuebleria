/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LectorDeDatos.Controladores;

import LectorDeDatos.Instruccion;
import LectorDeDatos.UtilidadesLector;
import Modelos.BaseDeDatos.ClienteBD;
import Modelos.Objetos.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author baquiax
 */
public class ControladorClientes {

    private List<Cliente> clientes;
    private ClienteBD clienteBD;

    /**
     * Constructor por defecto, crea un arreglo de clientes vacio
     */
    public ControladorClientes() {
        this.clientes = new ArrayList<>();
        clienteBD = new ClienteBD();
    }

    /**
     * Constructor que recibe como parametro una lista de clientes
     *
     * @param clientes
     */
    public ControladorClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Agrega un cliente a la vase de datos
     *
     * @param linea
     * @return
     */
    public boolean agregarCliente(String linea) {
        try {
            String datos = UtilidadesLector.quitarIndicacion(linea, Instruccion.CLIENTE.toString());
            if (UtilidadesLector.validarParentesis(datos)) {
                datos = UtilidadesLector.quitarSignos(datos);

                String[] datosSeparados = datos.split(",");
                datosSeparados = UtilidadesLector.quitarEspacios(datosSeparados);
                if (UtilidadesLector.validarTamanio(datosSeparados, 3)) {
                    String nombre = UtilidadesLector.quitarSignos(datosSeparados[0]);
                    String NIT = UtilidadesLector.quitarSignos(datosSeparados[1]);
                    String direccion = UtilidadesLector.quitarSignos(datosSeparados[2]);
                    this.clientes.add(new Cliente(nombre, NIT, direccion));
                    return true;
                } else if (UtilidadesLector.validarTamanio(datosSeparados, 5)) {
                    String nombre = UtilidadesLector.quitarSignos(datosSeparados[0]);
                    String NIT = UtilidadesLector.quitarSignos(datosSeparados[1]);
                    String direccion = UtilidadesLector.quitarSignos(datosSeparados[2]);
                    String municipio = UtilidadesLector.quitarSignos(datosSeparados[3]);
                    String departamento = UtilidadesLector.quitarSignos(datosSeparados[3]);
                    this.clientes.add(new Cliente(NIT, nombre, direccion,
                            municipio, departamento));
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Inserta un Cliente a la base de datos
     */
    public void insertarClientes() {
        for (Cliente cliente : clientes) {
            clienteBD.crearCliente(cliente);
        }
    }

    /**
     * @return the clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}
