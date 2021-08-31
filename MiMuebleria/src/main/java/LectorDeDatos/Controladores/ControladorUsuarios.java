/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LectorDeDatos.Controladores;

import LectorDeDatos.Instruccion;
import LectorDeDatos.UtilidadesLector;
import Modelos.BaseDeDatos.UsuarioBD;
import Modelos.Objetos.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author baquiax
 */
public class ControladorUsuarios {

    private List<Usuario> usuarios;
    private UsuarioBD usuarioBD;

    /**
     * Constructor por defecto, crea una lista vacia de usuarios
     */
    public ControladorUsuarios() {
        this.usuarios = new ArrayList<>();
        this.usuarioBD = new UsuarioBD();
    }

    /**
     * Constructor que recibe un lista de Usuarios
     *
     * @param usaurios
     */
    public ControladorUsuarios(List<Usuario> usaurios) {
        this.usuarios = usaurios;
    }

    /**
     * @return the usaurios
     */
    public List<Usuario> getUsaurios() {
        return usuarios;
    }

    /**
     * @param usaurios the usaurios to set
     */
    public void setUsaurios(List<Usuario> usaurios) {
        this.usuarios = usaurios;
    }

    /**
     * Agrega un usuario
     *
     * @param linea
     * @return
     */
    public boolean agregarUsuario(String linea) {
        try {
            String datos = UtilidadesLector.quitarIndicacion(linea, Instruccion.USUARIO.toString());
            if (UtilidadesLector.validarParentesis(datos)) {
                datos = UtilidadesLector.quitarSignos(datos);
                String[] datosSeparados = datos.split(",");
                if (UtilidadesLector.validarTamanio(datosSeparados, 3)) {
                    datosSeparados = UtilidadesLector.quitarEspacios(datosSeparados);
                    String nombre = UtilidadesLector.quitarSignos(datosSeparados[0]);
                    String password = UtilidadesLector.quitarSignos(datosSeparados[1]);
                    int tipo = Integer.valueOf(datosSeparados[2]);
                    if (UtilidadesLector.validarTipoUsuario(tipo)) {
                        usuarios.add(new Usuario(nombre, password, tipo));
                        return true;
                    } else {
                        return false;
                    }
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
     * Inserta los usuarios en la base de datos
     */
    public void insertarUsuarios() {
        for (Usuario usuario : usuarios) {
            usuarioBD.crearUsuario(usuario);
        }
    }

    /**
     * Verifica si un usario existe
     *
     * @param nombre
     * @return
     */
    public boolean existeUsuario(String nombre) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna el tipo de Usuario, 0 si el usuario no existe
     *
     * @param nombre
     * @return
     */
    public int tipoUsuario(String nombre) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return usuarios.get(i).getTipo();
            }
        }
        return 0;
    }
}
