/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.BaseDeDatos;

import Modelos.Objetos.TipoPieza;
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
public class TipoPiezaBD {

    /**
     * Crea un elemento Tipo Pieza en la base de datos
     *
     * @param tipoPieza
     */
    public void crearTipoPieza(TipoPieza tipoPieza) {
        try {

            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "INSERT INTO tipo_pieza (nombre) VALUES (?);");
            statement.setString(1, tipoPieza.getNombre());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TipoPiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Carga un Tipo de pieza con su nombre especificado
     *
     * @param nombre
     * @return
     */
    public TipoPieza getTipoPieza(String nombre) {
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT * FROM tipo_pieza WHERE nombre=?;");
            statement.setString(1, nombre);
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                return instanciarDeResultSet(resultado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TipoPiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Lista todos los tipos de piezas existentes
     *
     * @returns
     */
    public List<TipoPieza> getTipoPiezas() {
        List<TipoPieza> piezas = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT * FROM tipo_pieza;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                piezas.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TipoPiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return piezas;
    }

    private TipoPieza instanciarDeResultSet(ResultSet resultado) throws SQLException {
        return new TipoPieza(
                resultado.getString("nombre")
        );
    }

}
