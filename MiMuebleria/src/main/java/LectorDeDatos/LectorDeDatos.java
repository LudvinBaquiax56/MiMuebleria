/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LectorDeDatos;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author baquiax
 */
public class LectorDeDatos {

    public LectorDeDatos() {

    }

    public void leerArchivo(BufferedReader miBuffer) {
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
        Instruccion accion = seleccionaraAccion(linea);
        boolean error = false;
        switch (accion) {
            case USUARIO:
                System.out.println("user");
                error = agregarUsuario(linea);
                break;
            case PIEZA:
                System.out.println("pieza");
                error = agregarPieza(linea);
                break;
            case MUEBLE:
                System.out.println("mueble");
                error = agregarMueble(linea);
                break;
            case ENSAMBLE_PIEZAS:
                System.out.println("ensamble pieza");
                error = agregarEnsamblePiezas(linea);
                break;
            case ENSAMBLAR_MUEBLE:
                System.out.println("ensamblar mueble");
                error = agregarEnsamblarMueble(linea);
                break;
            case CLIENTE:
                System.out.println("cliente");
                error = agregarCliente(linea);
                break;
            case ERROR:
                System.out.println("error");
                System.out.println(linea);
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Valida si en una linea viene una instruccion valida al inicio
     *
     * @param linea
     * @return retorna la instruccion que viene al inicio de una linea
     */
    public Instruccion seleccionaraAccion(String linea) {
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
    public String quitarIndicacion(String linea, String indicacion) {
        String aux = "";
        for (int i = indicacion.length(); i < linea.length(); i++) {
            aux = aux + linea.charAt(i);
        }
        return aux;
    }

    /**
     * Agrega un usuario
     *
     * @param linea
     * @return
     */
    private boolean agregarUsuario(String linea) {
        String datos = quitarIndicacion(linea, Instruccion.USUARIO.toString());
        datos = quitarSignos(datos);
        String[] datosSeparados = datos.split(",");
        if (datosSeparados.length == 3) {
            try {
                String nombre = quitarSignos(datosSeparados[0]);
                String password = quitarSignos(datosSeparados[1]);
                int tipo = Integer.valueOf(datosSeparados[2]);
                System.out.println(nombre + "-" + password + "-" + tipo);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            return true;
        } else {
            return false;
        }

    }

    /**
     * Agrega una pieza
     *
     * @param linea
     * @return
     */
    private boolean agregarPieza(String linea) {
        String datos = quitarIndicacion(linea, Instruccion.PIEZA.toString());
        datos = quitarSignos(datos);

        String[] datosSeparados = datos.split(",");

        String tipo = quitarSignos(datosSeparados[0]);
        double costo = Double.valueOf(datosSeparados[1]);

        System.out.println(tipo + "-" + costo);
        return true;
    }

    /**
     * Agrega un mueble
     *
     * @param linea
     * @return
     */
    private boolean agregarMueble(String linea) {
        String datos = quitarIndicacion(linea, Instruccion.MUEBLE.toString());
        datos = quitarSignos(datos);

        String[] datosSeparados = datos.split(",");

        String nombre = quitarSignos(datosSeparados[0]);
        double costo = Double.valueOf(datosSeparados[1]);

        System.out.println(nombre + "-" + costo);
        return true;
    }

    /**
     * Agrema una instruccion para enzamblar un mueble
     *
     * @param linea
     * @return
     */
    private boolean agregarEnsamblePiezas(String linea) {
        String datos = quitarIndicacion(linea, Instruccion.ENSAMBLE_PIEZAS.toString());
        datos = quitarSignos(datos);

        String[] datosSeparados = datos.split(",");

        String modeloMueble = quitarSignos(datosSeparados[0]);
        String modeloPieza = quitarSignos(datosSeparados[1]);
        int cantidad = Integer.valueOf(datosSeparados[2]);

        System.out.println(modeloMueble + "-" + modeloPieza + "-" + cantidad);
        return true;
    }

    /**
     * Ensambla un mueble
     *
     * @param linea
     * @return
     */
    private boolean agregarEnsamblarMueble(String linea) {
        String datos = quitarIndicacion(linea, Instruccion.ENSAMBLAR_MUEBLE.toString());
        datos = quitarSignos(datos);

        String[] datosSeparados = datos.split(",");

        String modeloMueble = quitarSignos(datosSeparados[0]);
        //consultar
        String usuario = datosSeparados[1];
        String fecha = quitarSignos(datosSeparados[2]);

        System.out.println(modeloMueble + " " + usuario + " " + fecha);
        return true;
    }

    /**
     * Agrega un cliente a la vase de datos
     *
     * @param linea
     * @return
     */
    private boolean agregarCliente(String linea) {
        String datos = quitarIndicacion(linea, Instruccion.CLIENTE.toString());
        datos = quitarSignos(datos);

        String[] datosSeparados = datos.split(",");
        if (datosSeparados.length == 3) {
            String nombre = quitarSignos(datosSeparados[0]);
            String NIT = quitarSignos(datosSeparados[1]);
            String direccion = quitarSignos(datosSeparados[2]);

            System.out.println(nombre + " " + NIT + " " + direccion);
            return true;
        } else if (datosSeparados.length == 5) {
            String nombre = quitarSignos(datosSeparados[0]);
            String NIT = quitarSignos(datosSeparados[1]);
            String direccion = quitarSignos(datosSeparados[2]);
            String municipio = quitarSignos(datosSeparados[3]);
            String departamento = quitarSignos(datosSeparados[3]);

            System.out.println(nombre + " " + NIT + " " + direccion + " " + municipio + " " + departamento);
            return true;
        }
        return false;
    }

    /**
     * Quita el primer y el ultimo caracter de una cadena
     *
     * @param cadena
     * @return retorna la cadena sin el caracter inicial y final
     */
    public String quitarSignos(String cadena) {
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
    public boolean validarParentesis(String linea) {
        return linea.startsWith("(") && linea.endsWith(")");
    }

}
