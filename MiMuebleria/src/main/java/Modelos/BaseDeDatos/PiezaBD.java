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

            PreparedStatement statement = Conexion.conexion.prepareStatement("INSERT INTO pieza (tipo_pieza, costo, disponible) VALUES (?,?,?);");
            statement.setString(1, pieza.getTipoPieza());
            statement.setDouble(2, pieza.getCosto());
            statement.setBoolean(3, pieza.isDisponible());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
            PreparedStatement statement = Conexion.conexion.prepareStatement("SELECT * FROM pieza;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                piezas.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return piezas;
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
                Double.parseDouble(resultado.getString("costo")),
                Boolean.parseBoolean(resultado.getString("disponible")),
                Integer.parseInt(resultado.getString("id"))
        );
    }
}
