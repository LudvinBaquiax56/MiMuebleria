/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LectorDeDatos.Controladores;

import LectorDeDatos.*;
import Modelos.BaseDeDatos.ModeloMuebleBD;
import Modelos.Objetos.ModeloMueble;
import java.util.*;

/**
 *
 * @author baquiax
 */
public class ControladorModeloMuebles {

    private List<ModeloMueble> modelosMuebles;
    private ModeloMuebleBD modeloMuebleBD;

    /**
     * Constructor por defecto crea una lista de modelos muebles
     */
    public ControladorModeloMuebles() {
        this.modelosMuebles = new ArrayList<>();
        modeloMuebleBD = new ModeloMuebleBD();
    }

    /**
     * Constructor que recibe una lista de Modelos Muebles
     *
     * @param modelosMuebles
     * @param modeloMuebleBD
     */
    public ControladorModeloMuebles(List<ModeloMueble> modelosMuebles, ModeloMuebleBD modeloMuebleBD) {
        this.modelosMuebles = modelosMuebles;
        this.modeloMuebleBD = modeloMuebleBD;
    }

    /**
     * valida si un muble ya existe
     *
     * @param mueble
     * @return
     */
    public boolean validarMueble(String mueble) {
        for (int i = 0; i < modelosMuebles.size(); i++) {
            if (modelosMuebles.get(i).getNombre().equalsIgnoreCase(mueble)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the modelosMuebles
     */
    public List<ModeloMueble> getModelosMuebles() {
        return modelosMuebles;
    }

    /**
     * @param modelosMuebles the modelosMuebles to set
     */
    public void setModelosMuebles(List<ModeloMueble> modelosMuebles) {
        this.modelosMuebles = modelosMuebles;
    }

    /**
     * Agrega un mueble
     *
     * @param linea
     * @return
     */
    public boolean agregarMueble(String linea) {
        try {
            String datos = UtilidadesLector.quitarIndicacion(linea, Instruccion.MUEBLE.toString());
            if (UtilidadesLector.validarParentesis(datos)) {
                datos = UtilidadesLector.quitarSignos(datos);
                String[] datosSeparados = datos.split(",");
                if (datosSeparados.length == 2) {
                    datosSeparados = UtilidadesLector.quitarEspacios(datosSeparados);
                    String nombre = UtilidadesLector.quitarSignos(datosSeparados[0]);
                    double costo = Double.valueOf(datosSeparados[1]);

                    modelosMuebles.add(new ModeloMueble(nombre, costo));
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Verifica si un usario existe
     *
     * @param nombre
     * @return
     */
    public boolean existeMueble(String nombre) {
        for (int i = 0; i < modelosMuebles.size(); i++) {
            if (modelosMuebles.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Inserta los muebles a la base de datos
     */
    public void insertarModelosMuebles() {
        for (ModeloMueble modelosMueble : modelosMuebles) {
            modeloMuebleBD.crearModeloMueble(modelosMueble);
        }
    }

}
