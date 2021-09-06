/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.BaseDeDatos;

import Modelos.Objetos.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author baquiax
 */
public class ClienteBD {

    /**
     * Crea un cliente en la base de datos
     *
     * @param cliente
     */
    public void crearCliente(Cliente cliente) {
        try {
            if (cliente.isCompleto()) {
                PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("INSERT INTO "
                        + "cliente (NIT, nombre, direccion,municipio,departamento) VALUES(?,?,?,?,?);");
                statement.setString(1, cliente.getNIT());
                statement.setString(2, cliente.getNombre());
                statement.setString(3, cliente.getDireccion());
                statement.setString(4, cliente.getMunicipio());
                statement.setString(5, cliente.getDepartamento());
                statement.executeUpdate();
            } else {
                PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("INSERT INTO "
                        + "cliente (NIT, nombre, direccion) VALUES(?,?,?);");
                statement.setString(1, cliente.getNIT());
                statement.setString(2, cliente.getNombre());
                statement.setString(3, cliente.getDireccion());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Carga un cliente con el NIT especificado
     *
     * @param NIT
     * @return Cargador hallado
     */
    public Cliente getCliente(String NIT) {
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("SELECT * FROM cliente WHERE NIT=?;");
            statement.setString(1, NIT);
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
     * Lista todos los clientes existentes
     *
     * @return Cargadores
     */
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("SELECT * FROM cliente;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                clientes.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return clientes;
    }

    /**
     * Carga un cliente mediante un resultSet
     *
     * @param resultado
     * @return
     * @throws SQLException
     */
    private Cliente instanciarDeResultSet(ResultSet resultado) throws SQLException {
        return new Cliente(
                resultado.getString("NIT"),
                resultado.getString("nombre"),
                resultado.getString("direccion"),
                resultado.getString("municipio"),
                resultado.getString("departamento")
        );
    }

}
