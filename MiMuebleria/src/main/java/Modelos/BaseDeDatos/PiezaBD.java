/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.BaseDeDatos;

import Modelos.Objetos.Pieza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baquiax
 */
public class PiezaBD {

    /**
     * Crea una pieza en la base de datos
     *
     * @param pieza
     */
    public void crearPieza(Pieza pieza) {
        try {

            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("INSERT INTO pieza (tipo_pieza, costo, disponible) VALUES (?,?,?);");
            statement.setString(1, pieza.getTipoPieza());
            statement.setDouble(2, pieza.getCosto());
            statement.setBoolean(3, pieza.isDisponible());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lista todas las piezas existentes
     *
     * @return Cargadores
     */
    public List<Pieza> getPiezas() {
        List<Pieza> piezas = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("SELECT * FROM pieza;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                piezas.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return piezas;
    }

    /**
     *
     * @param id
     * @return
     */
    public Pieza getPieza(int id) {
        Pieza pieza = null;
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("SELECT * FROM pieza WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                pieza = instanciarDeResultSet(resultado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pieza;
    }

    /**
     * Lista todas las piezas disponibles
     *
     * @return Cargadores
     */
    public List<Pieza> getPiezasDisponibles() {
        List<Pieza> piezas = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("SELECT * FROM pieza WHERE disponible = true;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                piezas.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return piezas;
    }

    /**
     * Lista todas las piezas disponibles
     *
     * @return Cargadores
     */
    public List<String> getPiezasPorTipo() {
        List<String> piezas = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT count(p.id) AS cantidad, t.nombre FROM pieza p JOIN tipo_pieza t "
                    + "ON p.tipo_pieza=t.nombre WHERE p.disponible = true GROUP BY t.nombre;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                piezas.add(resultadoConsultaTipo(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return piezas;
    }

    /**
     * Lista todas las piezas disponibles ordenas de forma descendente con el
     * nombre
     *
     * @return Cargadores
     */
    public List<String> getPiezasPorTipoDesendente() {
        List<String> piezas = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT count(p.id) AS cantidad, t.nombre FROM pieza p JOIN tipo_pieza t "
                    + "ON p.tipo_pieza=t.nombre WHERE p.disponible = true GROUP BY t.nombre"
                    + " ORDER BY t.nombre DESC;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                piezas.add(resultadoConsultaTipo(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return piezas;
    }

    /**
     * Lista todas las piezas disponibles ascendente al nombre
     *
     * @return Cargadores
     */
    public List<String> getPiezasPorTipoAsendente() {
        List<String> piezas = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT count(p.id) AS cantidad, t.nombre FROM pieza p JOIN tipo_pieza t "
                    + "ON p.tipo_pieza=t.nombre WHERE p.disponible = true GROUP BY t.nombre"
                    + " ORDER BY t.nombre ASC;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                piezas.add(resultadoConsultaTipo(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return piezas;
    }

    /**
     * Lista todas las piezas disponibles ordenados por la cantidad de forma
     * descendente
     *
     * @return Cargadores
     */
    public List<String> getPiezasPorTipoCantidadDesendente() {
        List<String> piezas = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT count(p.id)  AS cantidad, t.nombre FROM pieza p JOIN tipo_pieza t "
                    + "ON p.tipo_pieza=t.nombre WHERE p.disponible = true GROUP BY "
                    + "t.nombre ORDER BY cantidad DESC;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                piezas.add(resultadoConsultaTipo(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return piezas;
    }

    /**
     * Lista todas las piezas disponibles ordenados por la cantidad de forma
     * ascendente
     *
     * @return Cargadores
     */
    public List<String> getPiezasPorTipoCantidadAsendente() {
        List<String> piezas = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT count(p.id)  AS cantidad, t.nombre FROM pieza p JOIN tipo_pieza t "
                    + "ON p.tipo_pieza=t.nombre WHERE p.disponible = true GROUP BY "
                    + "t.nombre ORDER BY cantidad ASC;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                piezas.add(resultadoConsultaTipo(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return piezas;
    }

    /**
     * Modifica una pieza
     *
     * @param pieza
     */
    public void modificarPieza(Pieza pieza) {
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "UPDATE pieza SET tipo_pieza=?, costo=?, disponible=? WHERE id=?;");
            statement.setString(1, pieza.getTipoPieza());
            statement.setDouble(2, pieza.getCosto());
            statement.setBoolean(3, pieza.isDisponible());
            statement.setInt(4, pieza.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Elimina un pieza por su Id
     *
     * @param id
     */
    public void eliminarPieza(int id) {
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("DELETE FROM pieza WHERE id = ?;");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Instancia una pieza desde un ResulSet
     *
     * @param resultado
     * @return
     * @throws SQLException
     */
    private Pieza instanciarDeResultSet(ResultSet resultado) throws SQLException {
        return new Pieza(
                resultado.getString("tipo_pieza"),
                resultado.getDouble("costo"),
                resultado.getBoolean("disponible"),
                resultado.getInt("id")
        );
    }

    private String resultadoConsultaTipo(ResultSet resultado) throws SQLException {
        String result = "<tr> <td>";
        result = result + resultado.getString(1) + "</td><td>";
        result = result + resultado.getString(2) + "</td>";
        result = result + "</tr>";
        return result;
    }
}
