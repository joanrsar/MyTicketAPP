/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.co.myticket.objetos;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author joanrincon
 */
@XmlRootElement
public class  Cuenta {
    
    public static int numeroCuenta;
    public static boolean esTest = true;
    public static String  urlPago = "https://stg.api.payulatam.com/payments-api/";
    public static String  ulrReporte = "https://stg.api.payulatam.com/reports-api/";
    public static String  lenguaje = "Language.es";
    public static String  descripcion = "payment test";
    
}
