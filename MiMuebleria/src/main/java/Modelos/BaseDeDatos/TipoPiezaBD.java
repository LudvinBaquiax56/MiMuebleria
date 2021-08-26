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

            PreparedStatement statement = Conexion.conexion.prepareStatement("INSERT INTO tipo_pieza"
                    + " (nombre, descripcion) VALUES (?,?);");
            statement.setString(1, tipoPieza.getNombre());
            statement.setString(2, tipoPieza.getDescripcion());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga un Tipo de pieza con su nombre especificado
     *
     * @return Cargador hallado
     */
    public TipoPieza getTipoPieza(String nombre) {
        try {
            PreparedStatement statement = Conexion.conexion.prepareStatement("SELECT * FROM tipo_pieza WHERE nombre=?;");
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
     * Lista todos los tipos de piezas existentes
     *
     * @return Cargadores
     */
    public List<TipoPieza> getTipoPiezas() {
        List<TipoPieza> piezas = new ArrayList();
        try {
            PreparedStatement statement = Conexion.conexion.prepareStatement("SELECT * FROM cliente;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                piezas.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return piezas;
    }

    private TipoPieza instanciarDeResultSet(ResultSet resultado) throws SQLException {
        return new TipoPieza(
                resultado.getString("nombre"),
                resultado.getString("descripcion")
        );
    }

}
