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

            PreparedStatement statement = Conexion.conexion.prepareStatement("INSERT INTO usuario "
                    + "(nombre, password, tipo) VALUES(?,?,?);");
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getPassword());
            statement.setInt(3, usuario.getTipo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga un Usuario con el nombre especificado
     *
     * @param nombre
     * @return Cargador hallado
     */
    public Usuario getCliente(String nombre) {
        try {
            PreparedStatement statement = Conexion.conexion.prepareStatement("SELECT * FROM usuario WHERE nombre=?;");
            statement.setString(1, nombre);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                return instanciarDeResultSet(resultado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Lista todos los usuarios existentes
     *
     * @return Cargadores
     */
    public List<Usuario> getClientes() {
        List<Usuario> usuarios = new ArrayList();
        try {
            PreparedStatement statement = Conexion.conexion.prepareStatement("SELECT * FROM usuario;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                usuarios.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }

    private Usuario instanciarDeResultSet(ResultSet resultado) throws SQLException {
        return new Usuario(
                resultado.getString("nombre"),
                resultado.getString("password"),
                Integer.parseInt(resultado.getString("tipo"))
        );
    }
}