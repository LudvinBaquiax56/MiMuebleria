/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.BaseDeDatos;

import Modelos.Objetos.Factura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baquiax
 */
public class FacturaBD {

    /**
     * Crea una factura en la base de datos
     *
     * @param factura
     */
    public void crearFactura(Factura factura) {
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement("INSERT INTO factura "
                    + "(NIT, nombre_vendedor,fecha,total) VALUES(?,?,?,?);");
            statement.setString(1, factura.getNIT());
            statement.setString(2, factura.getVendedor());
            statement.setDate(3, Utilidades.LocalDateToDate(factura.getFecha()));
            statement.setDouble(4, factura.getTotal());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FacturaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retorna una Factura mediante un ResultSet
     *
     * @param resultado
     * @return
     * @throws SQLException
     */
    private Factura instanciarDeResultSet(ResultSet resultado) throws SQLException {
        return new Factura(
                Integer.parseInt(resultado.getString("no_factura")),
                resultado.getString("NIT"),
                resultado.getString("nombre_vendedor"),
                Utilidades.convertirFecha(resultado.getString("fecha")),
                Double.parseDouble(resultado.getString("total"))
        );
    }

    
}
