/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.BaseDeDatos;

import Modelos.Objetos.PrescripcionMueble;
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
public class PrescripcionMuebleBD {

    /**
     * Crea una PrescripcionMueble en la base de datos
     *
     * @param receta
     */
    public void crearPrescripcionMueble(PrescripcionMueble receta) {
        try {

            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("INSERT INTO prescripcion_mueble "
                    + "(tipo_pieza, modelo_mueble, cantidad_pieza) VALUES (?,?,?);");
            statement.setString(1, receta.getTipoPieza());
            statement.setString(2, receta.getModeloMueble());
            statement.setString(3, String.valueOf(receta.getCantidad()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrescripcionMuebleBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Carga un todos los elementos de un mueble con el modelo especificado
     *
     * @param modeloMueble
     * @return Cargador hallado
     */
    public List<PrescripcionMueble> getPrescripcionMueble(String modeloMueble) {
        List<PrescripcionMueble> receta = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("SELECT * FROM "
                    + "prescripcion_mueble WHERE modelo_mueble=?;");
            statement.setString(1, modeloMueble);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                receta.add(instanciarDeResultSet(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrescripcionMuebleBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Instancia una Prescripcion Mueble desde un ResulSet
     *
     * @param resultado
     * @return
     * @throws SQLException
     */
    private PrescripcionMueble instanciarDeResultSet(ResultSet resultado) throws SQLException {
        return new PrescripcionMueble(Integer.parseInt(resultado.getString("id")),
                resultado.getString("tipo_pieza"),
                resultado.getString("modelo_mueble"),
                Integer.parseInt(resultado.getString("cantidad_pieza"))
        );
    }

}
