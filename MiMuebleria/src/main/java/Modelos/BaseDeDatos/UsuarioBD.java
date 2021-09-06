/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.BaseDeDatos;

import Modelos.Objetos.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author baquiax
 */
public class UsuarioBD {

    /**
     * Crea un usuario en la base de datos
     *
     * @param usuario
     */
    public void crearUsuario(Usuario usuario) {
        try {

            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "INSERT INTO usuario (nombre, password, tipo, estado) VALUES(?,?,?,?);");
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getPassword());
            statement.setInt(3, usuario.getTipo());
            statement.setBoolean(4, usuario.isEstado());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Carga un Usuario con el nombre especificado
     *
     * @param nombre
     * @return Cliente hallado
     */
    public Usuario getUsuario(String nombre) {
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT * FROM usuario WHERE nombre=?;");
            statement.setString(1, nombre);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                return instanciarDeResultSet(resultado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Lista todos los usuarios existentes
     *
     * @return Clientes
     */
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT * FROM usuario;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                usuarios.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }

    /**
     * Modifica un Usuarios
     *
     * @param usuario
     */
    public void modificarUsuario(Usuario usuario) {
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "UPDATE usuario SET password=?, tipo=?, estado=? WHERE nombre=?;");
            statement.setString(1, usuario.getPassword());
            statement.setDouble(2, usuario.getTipo());
            statement.setBoolean(3, usuario.isEstado());
            statement.setString(4, usuario.getNombre());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Retorna un Usuario de un resultSet
     *
     * @param resultado
     * @return
     * @throws SQLException
     */
    private Usuario instanciarDeResultSet(ResultSet resultado) throws SQLException {
        return new Usuario(resultado.getString("nombre"),
                resultado.getString("password"),
                resultado.getInt("tipo"),
                resultado.getBoolean("estado"));
    }
}
