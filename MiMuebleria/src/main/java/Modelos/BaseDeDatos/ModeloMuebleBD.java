/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.BaseDeDatos;

import Modelos.Objetos.ModeloMueble;
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
public class ModeloMuebleBD {

    /**
     * Crea una Modelo Mueble en la base de datos
     *
     * @param modeloMueble
     */
    public void crearModeloMueble(ModeloMueble modeloMueble) {
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "INSERT INTO modelo_mueble (nombre, precio) VALUES (?,?);");
            statement.setString(1, modeloMueble.getNombre());
            statement.setString(2, String.valueOf(modeloMueble.getPrecio()));
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModeloMuebleBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lista todos los Modelos Mubles existentes
     *
     * @return Cargadores
     */
    public List<ModeloMueble> getModelosMuebles() {
        List<ModeloMueble> modelosMuebles = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT * FROM modelo_mueble;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                modelosMuebles.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModeloMuebleBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelosMuebles;
    }

    /**
     * Retorna una ModeloMueble mediante un ResultSet
     *
     * @param resultado
     * @return
     * @throws SQLException
     */
    private ModeloMueble instanciarDeResultSet(ResultSet resultado) throws SQLException {
        return new ModeloMueble(
                resultado.getString("nombre"),
                resultado.getDouble("precio")
        );
    }

}
