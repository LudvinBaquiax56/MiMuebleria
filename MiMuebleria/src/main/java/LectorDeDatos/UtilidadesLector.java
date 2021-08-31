/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LectorDeDatos;

/**
 *
 * @author baquiax
 */
public class UtilidadesLector {

    /**
     * Valida si en una linea viene una instruccion valida al inicio
     *
     * @param linea
     * @return retorna la instruccion que viene al inicio de una linea
     */
    public static Instruccion seleccionaraAccion(String linea) {
        if (linea.indexOf(Instruccion.USUARIO.toString()) == 0) {
            return Instruccion.USUARIO;
        } else if (linea.indexOf(Instruccion.PIEZA.toString()) == 0) {
            return Instruccion.PIEZA;
        } else if (linea.indexOf(Instruccion.MUEBLE.toString()) == 0) {
            return Instruccion.MUEBLE;
        } else if (linea.indexOf(Instruccion.ENSAMBLE_PIEZAS.toString()) == 0) {
            return Instruccion.ENSAMBLE_PIEZAS;
        } else if (linea.indexOf(Instruccion.ENSAMBLAR_MUEBLE.toString()) == 0) {
            return Instruccion.ENSAMBLAR_MUEBLE;
        } else if (linea.indexOf(Instruccion.CLIENTE.toString()) == 0) {
            return Instruccion.CLIENTE;
        } else {
            return Instruccion.ERROR;
        }
    }

    /**
     *
     * @param linea
     * @param indicacion
     * @return
     */
    public static String quitarIndicacion(String linea, String indicacion) {
        String aux = "";
        for (int i = indicacion.length(); i < linea.length(); i++) {
            aux = aux + linea.charAt(i);
        }
        return aux;
    }

    public static boolean validarTamanio(String[] arreglo, int tamanio) {
        return arreglo.length == tamanio;
    }

    /**
     * Quita el primer y el ultimo caracter de una cadena
     *
     * @param cadena
     * @return retorna la cadena sin el caracter inicial y final
     */
    public static String quitarSignos(String cadena) {
        String aux = "";
        for (int i = 1; i < cadena.length() - 1; i++) {
            aux = aux + cadena.charAt(i);
        }
        return aux;
    }

    /**
     * Valida si la instruccion inicia con parentesis
     *
     * @param linea
     * @return
     */
    public static boolean validarParentesis(String linea) {
        return linea.startsWith("(") && linea.endsWith(")");
    }

    /**
     * Validar el tipo de usuario correcto
     *
     * @param tipo
     * @return
     */
    public static boolean validarTipoUsuario(int tipo) {
        return tipo >= 1 && tipo <= 3;
    }

    /**
     * Quita los espacios extras en un arreglo de Strings
     *
     * @param datos
     * @return
     */
    public static String[] quitarEspacios(String[] datos) {
        String[] datosLimpios = new String[datos.length];
        for (int i = 0; i < datos.length; i++) {
            datosLimpios[i] = datos[i].trim();
        }
        return datosLimpios;
    }

    /**
     * Quita los espacios extras en solo String
     *
     * @param dato
     * @return
     */
    public static String quitarEspacios(String dato) {
        return dato.trim();
    }

}
