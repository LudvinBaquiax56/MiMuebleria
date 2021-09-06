/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Modelos.BaseDeDatos.Conexion;
import Modelos.BaseDeDatos.PiezaBD;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
public class ReporteBD {

    /**
     * Reporte de Ventas
     *
     * @return Cargadores
     */
    public List<String> getReporte1() {
        List<String> piezas = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT mf.id_factura, m.modelo_mueble, m.precio_venta FROM "
                    + "muebles_factura mf INNER JOIN mueble m ON m.id=mf.id_mueble "
                    + "INNER JOIN factura f ON f.no_factura=mf.id_factura;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                piezas.add(resultadoConsulta1(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return piezas;
    }

    /**
     * Reporte de Ganacias
     *
     * @return Cargadores
     */
    public List<String> getReporte2() {
        List<String> piezas = new ArrayList();
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT m.modelo_mueble, (m.precio_venta - m.costo) AS ganacia FROM "
                    + "factura f INNER JOIN muebles_factura mf ON f.no_factura=mf.id_factura "
                    + "INNER JOIN mueble m ON mf.id_mueble=m.id");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                piezas.add(resultadoConsulta2(resultado));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return piezas;
    }

    /**
     * Reporte de Ventas
     *
     * @return Cargadores
     */
    public File getReporte1File() throws SQLException {
        File archivo = new File("Reporte1.csv");
        PrintWriter printWriter = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            printWriter = new PrintWriter(archivo);
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT mf.id_factura, m.modelo_mueble, m.precio_venta FROM "
                    + "muebles_factura mf INNER JOIN mueble m ON m.id=mf.id_mueble "
                    + "INNER JOIN factura f ON f.no_factura=mf.id_factura;");
            ResultSet resultado = statement.executeQuery();
            stringBuilder.append("No Factura");
            stringBuilder.append(",");
            stringBuilder.append("Mueble");
            stringBuilder.append(",");
            stringBuilder.append("Precio Venta");
            stringBuilder.append("\r\n");
            while (resultado.next()) {
                stringBuilder.append(resultado.getString(1));
                stringBuilder.append(",");
                stringBuilder.append(resultado.getString(2));
                stringBuilder.append(",");
                stringBuilder.append(resultado.getString(3));
                stringBuilder.append("\r\n");
            }
            printWriter.write(stringBuilder.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReporteBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReporteBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            printWriter.close();
        }
        return archivo;
    }

    /**
     * Reporte de Ventas
     *
     * @return Cargadores
     */
    public File getReporte2File() throws SQLException {
        File archivo = new File("Reporte1.csv");
        PrintWriter printWriter = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            printWriter = new PrintWriter(archivo);
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT m.modelo_mueble, (m.precio_venta - m.costo) AS ganacia FROM "
                    + "factura f INNER JOIN muebles_factura mf ON f.no_factura=mf.id_factura "
                    + "INNER JOIN mueble m ON mf.id_mueble=m.id");
            ResultSet resultado = statement.executeQuery();
            stringBuilder.append("Mueble");
            stringBuilder.append(",");
            stringBuilder.append("Ganancia");
            stringBuilder.append("\r\n");
            while (resultado.next()) {
                stringBuilder.append(resultado.getString(1));
                stringBuilder.append(",");
                stringBuilder.append(resultado.getString(2));
                stringBuilder.append("\r\n");
            }
            printWriter.write(stringBuilder.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReporteBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReporteBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            printWriter.close();
        }
        return archivo;
    }

    /**
     * Reporte de Ganacias
     *
     * @return Cargadores
     */
    public String getGanacia() {
        String ganancia = "";
        try {
            PreparedStatement statement = Conexion.obtenerConexion().prepareStatement(
                    "SELECT SUM((m.precio_venta - m.costo)) AS ganacia_total FROM"
                    + " factura f INNER JOIN muebles_factura mf ON f.no_factura=mf.id_factura "
                    + "INNER JOIN mueble m ON mf.id_mueble=m.id AND f.fecha");
            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                ganancia = resultado.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PiezaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ganancia;
    }

    /**
     *
     * @param resultado
     * @return
     * @throws SQLException
     */
    private String resultadoConsulta1(ResultSet resultado) throws SQLException {
        String result = "<tr> <td>";
        result = result + resultado.getString(1) + "</td><td>";
        result = result + resultado.getString(2) + "</td><td>";
        result = result + resultado.getString(3) + "</td>";
        result = result + "</tr>";
        return result;
    }

    /**
     *
     * @param resultado
     * @return
     * @throws SQLException
     */
    private String resultadoConsulta2(ResultSet resultado) throws SQLException {
        String result = "<tr> <td>";
        result = result + resultado.getString(1) + "</td><td>";
        result = result + resultado.getString(2) + "</td>";
        result = result + "</tr>";
        return result;
    }

}
