/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.BaseDeDatos;

import Modelos.Objetos.MueblesFactura;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author baquiax
 */
public class MueblesFacturaBD {

    /**
     * Crea un muble Factura en la base de datos
     *
     * @param mubleFactura
     */
    public void crearMueblesFactura(MueblesFactura mubleFactura) {
        try {

            PreparedStatement statement = Conexion.conexion.prepareStatement("INSERT INTO"
                    + " muebles_factura (id_factura, id_mueble) VALUES (?,?);");
            statement.setInt(1, mubleFactura.getFactura());
            statement.setInt(2, mubleFactura.getMueble());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
