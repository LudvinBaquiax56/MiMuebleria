/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author baquiax
 */
public class Conexion {

    public static Connection conexion;

    private static final String NOMBRE_BASE_DE_DATOS = "mi_muebleria";
    private static final String USER = "root2";
    private static final String PASSWORD = "root1234";

    /**
     * Procedimiento estatico para cargar la conexion con la base de datos
     *
     * @return
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        if (conexion == null) {
            try {
                //Buscamos nuestra db por medio de su ubicacion <entorno  local>, mandando el nombre y nuestra password
                Class.forName("com.mysql.cj.jdbc.Driver");
                String stringConnection = "jdbc:mysql://localhost:3306/" + NOMBRE_BASE_DE_DATOS + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                conexion = DriverManager.getConnection(stringConnection, USER, PASSWORD);

            }//en caso de que no se encuentre la base de datos 
            catch (SQLException ex) {
                ex.printStackTrace();
            }//en caso de que no encuentre la libreria 
            catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return conexion;
    }

    /**
     * Procedimiento para cerrar el flujo de informacion con la base de datos
     *
     * @throws java.sql.SQLException
     */
    public static void cerrar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
