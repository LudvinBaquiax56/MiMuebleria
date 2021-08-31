/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LectorDeDatos;

import LectorDeDatos.Controladores.*;
import Modelos.BaseDeDatos.Utilidades;
import Modelos.Objetos.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author baquiax
 */
public class LectorDeDatos {

    private ControladorUsuarios controladorUsuarios;
    private ControladorClientes controladorClietes;
    private ControladorModeloMuebles controladorModelosMuebles;
    private ControladorPiezas controladorPiezas;
    private ControladorEnsamblePieza controladorRecetas;
    private ControladorEnsamblarMueble controladorMuebles;
    private List<String> erroresFormato;
    private List<String> erroresLogicosRecetas;
    private List<String> erroresLogicosEnsamebles;
    private int contador;

    public LectorDeDatos() {
        this.erroresFormato = new ArrayList<>();
        this.erroresLogicosRecetas = new ArrayList<>();
        this.erroresLogicosEnsamebles = new ArrayList<>();

        this.controladorUsuarios = new ControladorUsuarios();
        this.controladorClietes = new ControladorClientes();
        this.controladorPiezas = new ControladorPiezas();
        this.controladorModelosMuebles = new ControladorModeloMuebles();
        this.controladorRecetas = new ControladorEnsamblePieza();
        this.controladorMuebles = new ControladorEnsamblarMueble();
    }

    public void insertarDatos() {
        controladorUsuarios.insertarUsuarios();
        controladorClietes.insertarClientes();

        controladorPiezas.insertarTipoPiezas();

        controladorModelosMuebles.insertarModelosMuebles();

        this.erroresLogicosRecetas = controladorRecetas.validarEnsambles(
                controladorPiezas, controladorModelosMuebles);
        
        this.erroresLogicosEnsamebles = controladorMuebles.ensambraMuebles(
                controladorRecetas,controladorModelosMuebles, controladorUsuarios, controladorPiezas);
        
        controladorPiezas.insertarPiezas();

    }

    public void leerArchivo(BufferedReader miBuffer) {
        contador = 1;
        try {
            String linea = "";
            String datos = "";
            while (linea != null) {
                linea = miBuffer.readLine();
                if (linea != null) {
                    datos = datos + linea + "\n";
                }
            }
            String[] aux = datos.split("\n");
            for (int i = 0; i < aux.length; i++) {
                ejecutarLinea(aux[i]);
            }
        } catch (IOException e) {

        }
    }

    /**
     * Ejecuta la una linea de instrucion
     *
     * @param linea
     */
    private void ejecutarLinea(String linea) {
        Instruccion accion = UtilidadesLector.seleccionaraAccion(linea);
        boolean error = true;
        switch (accion) {
            case USUARIO:
                error = controladorUsuarios.agregarUsuario(linea);
                break;
            case PIEZA:
                error = controladorPiezas.agregarPieza(linea);
                break;
            case MUEBLE:
                error = controladorModelosMuebles.agregarMueble(linea);
                break;
            case ENSAMBLE_PIEZAS:
                error = agregarEnsamblePiezas(linea);
                break;
            case ENSAMBLAR_MUEBLE:
                error = agregarEnsamblarMueble(linea);
                break;
            case CLIENTE:
                error = controladorClietes.agregarCliente(linea);
                break;
            case ERROR:
                linea = contador + ". " + linea;
                this.erroresFormato.add(linea);
                break;
            default:
                throw new AssertionError();
        }
        if (error == false) {
            linea = contador + ". " + linea;
            this.erroresFormato.add(linea);
        }
        contador++;
    }

    /**
     * Agrema una instruccion para enzamblar un mueble
     *
     * @param linea
     * @return
     */
    private boolean agregarEnsamblePiezas(String linea) {
        try {
            String datos = UtilidadesLector.quitarIndicacion(linea, Instruccion.ENSAMBLE_PIEZAS.toString());
            datos = UtilidadesLector.quitarSignos(datos);

            String[] datosSeparados = datos.split(",");
            if (UtilidadesLector.validarTamanio(datosSeparados, 3)) {
                String modeloMueble = UtilidadesLector.quitarSignos(datosSeparados[0]);
                String modeloPieza = UtilidadesLector.quitarSignos(datosSeparados[1]);
                int cantidad = Integer.valueOf(datosSeparados[2]);
                controladorRecetas.getRecetas().add(new PrescripcionMueble(modeloPieza,
                        modeloMueble, cantidad));
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Ensambla un mueble
     *
     * @param linea
     * @return
     */
    private boolean agregarEnsamblarMueble(String linea) {
        try {
            String datos = UtilidadesLector.quitarIndicacion(linea, Instruccion.ENSAMBLAR_MUEBLE.toString());

            if (UtilidadesLector.validarParentesis(datos)) {
                datos = UtilidadesLector.quitarSignos(datos);
                String[] datosSeparados = datos.split(",");
                if (UtilidadesLector.validarTamanio(datosSeparados, 3)) {
                    String modeloMueble = UtilidadesLector.quitarSignos(datosSeparados[0]);
                    String usuario = datosSeparados[1];
                    String fecha = UtilidadesLector.quitarSignos(datosSeparados[2]);

                    controladorMuebles.getMuebles().add(new Mueble(modeloMueble,
                            usuario, Utilidades.convertirFecha(fecha)));
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

}
