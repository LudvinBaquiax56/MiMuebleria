/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LectorDeDatos.Controladores;

import LectorDeDatos.*;
import Modelos.BaseDeDatos.*;
import Modelos.Objetos.*;
import java.util.*;

/**
 *
 * @author baquiax
 */
public class ControladorPiezas {

    private List<Pieza> piezas;
    private PiezaBD piezaBD;
    private List<TipoPieza> tipoPiezas;
    private TipoPiezaBD tipoPiezaBD;

    /**
     * Constructor por defecto, crea una lista de tipo pieza
     */
    public ControladorPiezas() {
        this.piezas = new ArrayList<>();
        piezaBD = new PiezaBD();
        this.tipoPiezas = new ArrayList<>();
        tipoPiezaBD = new TipoPiezaBD();
    }

    /**
     * Constructor del controlador piezas
     *
     * @param piezas
     */
    public ControladorPiezas(List<Pieza> piezas) {
        this.piezas = piezas;
    }

    /**
     * Valida si una pieza ya existe
     *
     * @param pieza
     * @return
     */
    public boolean validarPieza(String pieza) {
        for (int i = 0; i < getPiezas().size(); i++) {
            if (getPiezas().get(i).getTipoPieza().equalsIgnoreCase(pieza)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Valida si un tipo ya existe en la base de datos
     *
     * @param tipo
     * @return
     */
    public boolean validarExistenciaTipo(String tipo) {
        for (int i = 0; i < tipoPiezas.size(); i++) {
            if (tipoPiezas.get(i).getNombre().equalsIgnoreCase(tipo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Agrega una pieza
     *
     * @param linea
     * @return
     */
    public boolean agregarPieza(String linea) {
        try {
            String datos = UtilidadesLector.quitarIndicacion(linea, Instruccion.PIEZA.toString());
            if (UtilidadesLector.validarParentesis(datos)) {
                datos = UtilidadesLector.quitarSignos(datos);
                String[] datosSeparados = datos.split(",");
                datosSeparados = UtilidadesLector.quitarEspacios(datosSeparados);
                if (UtilidadesLector.validarTamanio(datosSeparados, 2)) {
                    String tipo = UtilidadesLector.quitarSignos(datosSeparados[0]);
                    double costo = Double.valueOf(datosSeparados[1]);
                    if (validarExistenciaTipo(tipo) == false) {
                        tipoPiezas.add(new TipoPieza(tipo));
                    }
                    piezas.add(new Pieza(tipo, costo));
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
     * Inserta el tipo de piezas a las piezas
     */
    public void insertarTipoPiezas() {
        for (TipoPieza tipoPieza : getTipoPiezas()) {
            tipoPiezaBD.crearTipoPieza(tipoPieza);
        }
    }

    /**
     * Insertar las piezas a la base de datos
     */
    public void insertarPiezas() {
        for (Pieza pieza : getPiezas()) {
            piezaBD.crearPieza(pieza);
        }
    }

    /**
     * @return the piezas
     */
    public List<Pieza> getPiezas() {
        return piezas;
    }

    /**
     * @param piezas the piezas to set
     */
    public void setPiezas(List<Pieza> piezas) {
        this.piezas = piezas;
    }

    /**
     * @return the tipoPiezas
     */
    public List<TipoPieza> getTipoPiezas() {
        return tipoPiezas;
    }

    /**
     * @param tipoPiezas the tipoPiezas to set
     */
    public void setTipoPiezas(List<TipoPieza> tipoPiezas) {
        this.tipoPiezas = tipoPiezas;
    }

    /**
     * Retorna la piezas necesarias para un mueble
     *
     * @param tipoPieza pieza necesaria
     * @param cantidad numero de piezas necesarias
     * @return
     */
    public List<Pieza> piezasMueble(String tipoPieza, int cantidad) {
        List<Pieza> piezasSolicitadas = new ArrayList<>();
        int contador = 0;
        for (int i = 0; i < this.piezas.size() && contador < cantidad; i++) {
            if (this.piezas.get(i).getTipoPieza().equalsIgnoreCase(tipoPieza)) {
                piezasSolicitadas.add(this.piezas.get(i));
                contador++;
            }
        }
        if (piezasSolicitadas.size() == cantidad) {
            return piezasSolicitadas;
        } else {
            piezasSolicitadas.clear();
            return piezasSolicitadas;
        }
    }

    /**
     * Cambia de estado a un listado de piezas a no disponibles
     *
     * @param piezas
     */
    public void piezasUtilizadas(List<Pieza> piezas) {
        for (Pieza pieza : piezas) {
            pieza.setDisponible(false);
        }
    }

}
