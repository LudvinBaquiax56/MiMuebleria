/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.BaseDeDatos;

import Modelos.Objetos.Mueble;
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
public class MuebleBD {

    /**
     * Crea un Mueble en la base de datos
     *
     * @param mueble
     */
    public void crearMueble(Mueble mueble) {
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("INSERT INTO mueble "
                    + "(modelo_mueble, costo, fecha, ensamblador, precio_venta, vendido, devolucion, fecha_devolucion) VALUES (?,?,?,?,?,?,?,?);");
            statement.setString(1, mueble.getModeloMueble());
            statement.setDouble(2, mueble.getCosto());
            statement.setDate(3, Utilidades.LocalDateToDate(mueble.getFecha()));
            statement.setString(4, mueble.getEnsamblador());
            statement.setDouble(5, mueble.getPrecio());
            statement.setBoolean(6, mueble.isVendido());
            statement.setBoolean(7, mueble.isDevolucion());
            statement.setDate(8, Utilidades.LocalDateToDate(mueble.getFechaDevolucion()));
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MuebleBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Modifica los mubles
     *
     * @param mueble
     */
    public void modificarMueble(Mueble mueble) {
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "UPDATE mueble SET modelo_mueble=?, costo=?, fecha=?, ensamblador=?, precio_venta=?, vendido=?, devolucion=?, fecha_devolucion=? WHERE id=?;");
            statement.setString(1, mueble.getModeloMueble());
            statement.setDouble(2, mueble.getCosto());
            statement.setDate(3, Utilidades.LocalDateToDate(mueble.getFecha()));
            statement.setString(4, mueble.getEnsamblador());
            statement.setDouble(5, mueble.getPrecio());
            statement.setBoolean(6, mueble.isVendido());
            statement.setBoolean(7, mueble.isDevolucion());
            statement.setDate(8, Utilidades.LocalDateToDate(mueble.getFechaDevolucion()));
            statement.setInt(9, mueble.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lista todos los muebles existentes
     *
     * @return Cargadores
     */
    public List<Mueble> getMuebles() {
        List<Mueble> muebles = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("SELECT * FROM mueble;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                muebles.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MuebleBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return muebles;
    }

    /**
     * Obtiene los muebles en venta
     *
     * @return
     */
    public List<Mueble> getMueblesVenta() {
        List<Mueble> muebles = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("SELECT n.id, m.nombre, n.costo, n.fecha, n.ensamblador, m.precio, n.vendido, n.devolucion, n.fecha_devolucion FROM modelo_mueble m JOIN mueble n ON m.nombre=n.modelo_mueble WHERE n.vendido = false;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                muebles.add(instanciarDeResultSetVenta(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MuebleBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return muebles;
    }

    /**
     * Total de muebles creados
     *
     * @return
     */
    public List<String> getMueblesDetalle() {
        List<String> muebles = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT count(n.id) AS cantidad, m.nombre FROM modelo_mueble m JOIN "
                    + "mueble n ON m.nombre=n.modelo_mueble GROUP BY m.nombre;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                muebles.add(resultadoConsultaDetalle(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return muebles;
    }

    /**
     * Muebles detalle Ascendente
     *
     * @return
     */
    public List<String> getMueblesDetalleAscendente() {
        List<String> muebles = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT count(n.id) AS cantidad, m.nombre FROM modelo_mueble m JOIN "
                    + "mueble n ON m.nombre=n.modelo_mueble GROUP BY m.nombre ORDER BY m.nombre ASC;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                muebles.add(resultadoConsultaDetalle(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return muebles;
    }

    /**
     * Muebles detalle Descendente
     *
     * @return
     */
    public List<String> getMueblesDetalleDescendente() {
        List<String> muebles = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT count(n.id) AS cantidad, m.nombre FROM modelo_mueble m JOIN "
                    + "mueble n ON m.nombre=n.modelo_mueble GROUP BY m.nombre ORDER BY m.nombre DESC;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                muebles.add(resultadoConsultaDetalle(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return muebles;
    }

    /**
     * Muebles detalle por cantidad Ascendente
     *
     * @return
     */
    public List<String> getMueblesDetalleCantidadAscendente() {
        List<String> muebles = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT count(n.id) AS cantidad, m.nombre FROM modelo_mueble m JOIN "
                    + "mueble n ON m.nombre=n.modelo_mueble GROUP BY m.nombre ORDER BY cantidad ASC;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                muebles.add(resultadoConsultaDetalle(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return muebles;
    }

    /**
     * Muebles detalle por cantidad Descendente
     *
     * @return
     */
    public List<String> getMueblesDetalleCantidadDescendente() {
        List<String> muebles = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT count(n.id) AS cantidad, m.nombre FROM modelo_mueble m JOIN"
                    + " mueble n ON m.nombre=n.modelo_mueble GROUP BY m.nombre ORDER BY cantidad DESC;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                muebles.add(resultadoConsultaDetalle(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return muebles;
    }

    /**
     * Retorna una Mueble mediante un ResultSet
     *
     * @param resultado
     * @return
     * @throws SQLException
     */
    private Mueble instanciarDeResultSet(ResultSet resultado) throws SQLException {
        return new Mueble(
                resultado.getInt("id"),
                resultado.getString("modelo_mueble"),
                resultado.getDouble("costo"),
                Utilidades.DateToLocalDate(resultado.getDate("fecha")),
                resultado.getString("ensamblador"),
                resultado.getDouble("precio_venta"),
                resultado.getBoolean("vendido"),
                resultado.getBoolean("devolucion")
        );
    }

    /**
     * Retorna un mueble para la exposicion en ventas
     *
     * @param resultado
     * @return
     * @throws SQLException
     */
    private Mueble instanciarDeResultSetVenta(ResultSet resultado) throws SQLException {
        return new Mueble(resultado.getInt("id"),
                resultado.getString("nombre"),
                resultado.getDouble("costo"),
                Utilidades.DateToLocalDate(resultado.getDate("fecha")),
                resultado.getString("ensamblador"),
                resultado.getDouble("precio"),
                resultado.getBoolean("vendido"),
                resultado.getBoolean("devolucion"),
                Utilidades.DateToLocalDate(resultado.getDate("fecha_devolucion")));
    }

    private String resultadoConsultaDetalle(ResultSet resultado) throws SQLException {
        String result = "<tr> <td>";
        result = result + resultado.getString(1) + "</td><td>";
        result = result + resultado.getString(2) + "</td>";
        result = result + "</tr>";
        return result;
    }

}
