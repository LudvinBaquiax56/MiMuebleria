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
                    + "(modelo_mueble, costo, fecha, ensamblador, devolucion) VALUES (?,?,?,?,?)");
            statement.setString(1, mueble.getModeloMueble());
            statement.setString(2, String.valueOf(mueble.getCosto()));
            statement.setDate(3, Utilidades.LocalDateToDate(mueble.getFecha()));
            statement.setString(4, mueble.getEnsamblador());
            statement.setBoolean(5, mueble.isDevolucion());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MuebleBD.class.getName()).log(Level.SEVERE, null, ex);
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
     * Retorna una Mueble mediante un ResultSet
     *
     * @param resultado
     * @return
     * @throws SQLException
     */
    private Mueble instanciarDeResultSet(ResultSet resultado) throws SQLException {
        return new Mueble(
                Integer.valueOf(resultado.getString("id")),
                resultado.getString("modelo_mueble"),
                Double.parseDouble(resultado.getString("costo")),
                Utilidades.DateToLocalDate(resultado.getDate("fecha")),
                resultado.getString("ensamblador"),
                Boolean.parseBoolean(resultado.getString("devolucion"))
        );
    }

}
