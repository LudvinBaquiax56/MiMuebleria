/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.BaseDeDatos;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author baquiax
 */
public class Utilidades {

    /**
     * Convertie una fecha a un LocalDate
     *
     * @param fecha
     * @return
     */
    public static LocalDate convertirFecha(String fecha) {
        LocalDate fechaDate = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return fechaDate;
    }

    /**
     * Conversión de una cadena con formato 'aaaa-MM-dd' a SqlDate
     *
     * @param fecha String que se desea convertir
     * @return fecha como una instancia de SqlDate
     */
    public static Date StringToDate(String fecha) throws java.text.ParseException {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        //String strFecha = “2007-12-25”;
        return (Date) formatoDelTexto.parse(fecha);
    }

    /**
     * Conversion de un local Date a Date sql
     *
     * @param fecha
     * @return
     */
    public static Date LocalDateToDate(LocalDate fecha) {
        return Date.valueOf(fecha);
    }

    /**
     * Conversion de un Date a LocalDate
     *
     * @param fecha
     * @return
     */
    public static LocalDate DateToLocalDate(Date fecha) {
        return LocalDate.parse(fecha.toString());
    }
}
