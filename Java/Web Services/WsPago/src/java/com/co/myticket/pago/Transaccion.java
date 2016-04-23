/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.myticket.pago;

import com.co.myticket.objetos.Cuenta;
import com.co.myticket.objetos.Pago;
import com.payu.sdk.PayU;
import com.payu.sdk.PayUPayments;
import com.payu.sdk.model.Currency;
import com.payu.sdk.model.Language;
import com.payu.sdk.model.PaymentCountry;
import com.payu.sdk.model.TransactionResponse;
import com.payu.sdk.utils.LoggerUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 *
 * @author joanrincon
 */
public class Transaccion {

    public Transaccion realizarPago() throws Exception {
        PayU.isTest = true;

        String reference = "payment_test_00000001";
        String value = "1000";
        Map<String, String> parametros = new HashMap<String, String>();
        try {
            PayU.paymentsUrl = "https://stg.api.payulatam.com/payments-api/";
            PayU.reportsUrl = "https://stg.api.payulatam.com/reports-api/";
            // String reference = "payment_test_00000001";
            //String value = "100";

            Map<String, String> parameters = new HashMap<String, String>();

//Ingrese aquí el identificador de la cuenta.
            parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "509171");
//Ingrese aquí el código de referencia.
            parameters.put(PayU.PARAMETERS.REFERENCE_CODE, "" + reference);
//Ingrese aquí la descripción.
            parameters.put(PayU.PARAMETERS.DESCRIPTION, "payment test");
//Ingrese aquí el idima de la orden.
            parameters.put(PayU.PARAMETERS.LANGUAGE, "Language.es");

// -- Valores --
//Ingrese aquí el valor.
            parameters.put(PayU.PARAMETERS.VALUE, "" + value);
//Ingrese aquí la moneda.
            parameters.put(PayU.PARAMETERS.CURRENCY, "" + Currency.ARS.name());

// -- Comprador --
//Ingrese aquí el id del comprador.
            parameters.put(PayU.PARAMETERS.BUYER_ID, "1");
//Ingrese aquí el nombre del comprador.
            parameters.put(PayU.PARAMETERS.BUYER_NAME, "First name and second buyer  name");
//Ingrese aquí el email del comprador.
            parameters.put(PayU.PARAMETERS.BUYER_EMAIL, "buyer_test@test.com");
//Ingrese aquí el teléfono de contacto del comprador.
            parameters.put(PayU.PARAMETERS.BUYER_CONTACT_PHONE, "7563126");
//Ingrese aquí el documento de contacto del comprador.
            parameters.put(PayU.PARAMETERS.BUYER_DNI, "5415668464654");
//Ingrese aquí la dirección del comprador.
            parameters.put(PayU.PARAMETERS.BUYER_STREET, "Viamonte");
            parameters.put(PayU.PARAMETERS.BUYER_STREET_2, "1366");
            parameters.put(PayU.PARAMETERS.BUYER_CITY, "Buenos Aires");
            parameters.put(PayU.PARAMETERS.BUYER_STATE, "Buenos Aires");
            parameters.put(PayU.PARAMETERS.BUYER_COUNTRY, "AR");
            parameters.put(PayU.PARAMETERS.BUYER_POSTAL_CODE, "000000");
            parameters.put(PayU.PARAMETERS.BUYER_PHONE, "7563126");

// -- pagador --
//Ingrese aquí el id del pagador.
            parameters.put(PayU.PARAMETERS.PAYER_ID, "1");
//Ingrese aquí el nombre del pagador.
            parameters.put(PayU.PARAMETERS.PAYER_NAME, "First name and second payer name");
//Ingrese aquí el email del pagador.
            parameters.put(PayU.PARAMETERS.PAYER_EMAIL, "payer_test@test.com");
//Ingrese aquí el teléfono de contacto del pagador.
            parameters.put(PayU.PARAMETERS.PAYER_CONTACT_PHONE, "7563126");
//Ingrese aquí el documento de contacto del pagador.
            parameters.put(PayU.PARAMETERS.PAYER_DNI, "5415668464654");
//Ingrese aquí la dirección del pagador.
            parameters.put(PayU.PARAMETERS.PAYER_STREET, "Avenida entre rios");
            parameters.put(PayU.PARAMETERS.PAYER_STREET_2, "452");
            parameters.put(PayU.PARAMETERS.PAYER_CITY, "La Plata");
            parameters.put(PayU.PARAMETERS.PAYER_STATE, "Buenos Aires");
            parameters.put(PayU.PARAMETERS.PAYER_COUNTRY, "AR");
            parameters.put(PayU.PARAMETERS.PAYER_POSTAL_CODE, "000000");
            parameters.put(PayU.PARAMETERS.PAYER_PHONE, "7563126");

// -- Datos de la tarjeta de crédito -- 
//Ingrese aquí el número de la tarjeta de crédito
            parameters.put(PayU.PARAMETERS.CREDIT_CARD_NUMBER, "4850110000000000");
//Ingrese aquí la fecha de vencimiento de la tarjeta de crédito
            parameters.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, "2014/12");
//Ingrese aquí el código de seguridad de la tarjeta de crédito
            parameters.put(PayU.PARAMETERS.CREDIT_CARD_SECURITY_CODE, "321");
//Ingrese aquí el nombre de la tarjeta de crédito
            parameters.put(PayU.PARAMETERS.PAYMENT_METHOD, "VISA");

//Ingrese aquí el número de cuotas.
            parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "1");
//Ingrese aquí el nombre del pais.
            parameters.put(PayU.PARAMETERS.COUNTRY, PaymentCountry.AR.name());

//Session id del device.
            parameters.put(PayU.PARAMETERS.DEVICE_SESSION_ID, "vghs6tvkcle931686k1900o6e1");
//IP del pagadador
            parameters.put(PayU.PARAMETERS.IP_ADDRESS, "127.0.0.1");
//Cookie de la sesión actual.
            parameters.put(PayU.PARAMETERS.COOKIE, "pt1t38347bs6jc9ruv2ecpv7o2");
//Cookie de la sesión actual.
            parameters.put(PayU.PARAMETERS.USER_AGENT, "Mozilla/5.0 (Windows NT 5.1; rv:18.0) Gecko/20100101 Firefox/18.0");

            PayU.apiKey = "6u39nqhq8ftd0hlvnjfs66eh8c";//"6u39nqhq8ftd0hlvnjfs66eh8c";
            PayU.apiLogin = "11959c415b33d0c";//"11959c415b33d0c";
            PayU.merchantId = "561096";//"500238";
            PayU.language = Language.es;

            LoggerUtil.setLogLevel(Level.ALL);

            System.out.println(
                    "Api Key " + PayU.apiKey);
            System.out.println(
                    "Api login " + PayU.apiLogin);
            System.out.println(
                    "Api merchan " + PayU.merchantId);
//solicitud de autorización y captura
            TransactionResponse response = PayUPayments.doAuthorizationAndCapture(parameters);

//  -- podrás obtener las propiedades de la respuesta --
            if (response != null) {
                response.getOrderId();
                response.getTransactionId();
                response.getState();
                if (response.getState().toString().equalsIgnoreCase("PENDING")) {
                    response.getPendingReason();
                }
                response.getPaymentNetworkResponseCode();
                response.getPaymentNetworkResponseErrorMessage();
                response.getTrazabilityCode();
                response.getResponseCode();
                response.getResponseMessage();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

            throw new Exception(e.getMessage());
        }
        return null;
    }

    /**
     * Realizado por : Joan Rincon Fecha : 07/04/2016 Proposito : Realizar un
     * pago con tarjeta credito
     *
     * @param pago
     * @return
     * @throws Exception
     */
    private Transaccion realizarPago(Pago pago) throws Exception {

        Map<String, String> parametros = new HashMap<String, String>();
        Transaccion pagoRespuesta = new Transaccion();
        try {
            PayU.isTest = Cuenta.esTest;
            String reference = "payment_test_00000001";
            PayU.paymentsUrl = Cuenta.urlPago;
            PayU.reportsUrl = Cuenta.ulrReporte;
            parametros.put(PayU.PARAMETERS.ACCOUNT_ID, String.valueOf(Cuenta.numeroCuenta));
            //Ingrese aquí la descripción.
            parametros.put(PayU.PARAMETERS.DESCRIPTION, Cuenta.descripcion);
//Ingrese aquí el idima de la orden.
            parametros.put(PayU.PARAMETERS.LANGUAGE, Cuenta.lenguaje);

// -- Valores --
//Ingrese aquí el valor.
            parametros.put(PayU.PARAMETERS.VALUE, "" + String.valueOf(pago.getValor()));
//Ingrese aquí la moneda.
            parametros.put(PayU.PARAMETERS.CURRENCY, "" + Currency.COP.name());

// -- Comprador --
//Ingrese aquí el id del comprador.
            parametros.put(PayU.PARAMETERS.BUYER_ID, String.valueOf(pago.getIdComprador()));
//Ingrese aquí el nombre del comprador.
            parametros.put(PayU.PARAMETERS.BUYER_NAME, pago.getNombreComprador());
//Ingrese aquí el email del comprador.
            parametros.put(PayU.PARAMETERS.BUYER_EMAIL, pago.getCorreoComprador());
//Ingrese aquí el teléfono de contacto del comprador.
            parametros.put(PayU.PARAMETERS.BUYER_CONTACT_PHONE, String.valueOf(pago.getTelefonoContactoComprador()));
//Ingrese aquí el documento de contacto del comprador.
            parametros.put(PayU.PARAMETERS.BUYER_DNI, String.valueOf(pago.getDniComprador()));
//Ingrese aquí la dirección del comprador.
            parametros.put(PayU.PARAMETERS.BUYER_STREET, pago.getDireccionComprador());
            parametros.put(PayU.PARAMETERS.BUYER_STREET_2, pago.getDireccion2Comprador());
            parametros.put(PayU.PARAMETERS.BUYER_CITY, pago.getCiudadComprador());
            parametros.put(PayU.PARAMETERS.BUYER_STATE, pago.getDepartamentoComprador());
            parametros.put(PayU.PARAMETERS.BUYER_COUNTRY, pago.getPaisComprador());
            parametros.put(PayU.PARAMETERS.BUYER_POSTAL_CODE, String.valueOf(pago.getCodigoPostalComprador()));
            parametros.put(PayU.PARAMETERS.BUYER_PHONE, String.valueOf(pago.getTelefonoComprador()));

// -- Pagador --
//Ingrese aquí el id del pagador.
            parametros.put(PayU.PARAMETERS.PAYER_ID, "1");
//Ingrese aquí el nombre del pagador.
            parametros.put(PayU.PARAMETERS.PAYER_NAME, "APPROVED");
//Ingrese aquí el email del pagador.
            parametros.put(PayU.PARAMETERS.PAYER_EMAIL, "payer_test@test.com");
//Ingrese aquí el teléfono de contacto del pagador.
            parametros.put(PayU.PARAMETERS.PAYER_CONTACT_PHONE, "7563126");
//Ingrese aquí el documento de contacto del pagador.
            parametros.put(PayU.PARAMETERS.PAYER_DNI, "5415668464654");
//Ingrese aquí la dirección del pagador.
            parametros.put(PayU.PARAMETERS.PAYER_STREET, "calle 93");
            parametros.put(PayU.PARAMETERS.PAYER_STREET_2, "125544");
            parametros.put(PayU.PARAMETERS.PAYER_CITY, "Bogota");
            parametros.put(PayU.PARAMETERS.PAYER_STATE, "Bogota");
            parametros.put(PayU.PARAMETERS.PAYER_COUNTRY, "CO");
            parametros.put(PayU.PARAMETERS.PAYER_POSTAL_CODE, "000000");
            parametros.put(PayU.PARAMETERS.PAYER_PHONE, "7563126");

// -- Datos de la tarjeta de crédito -- 
//Ingrese aquí el número de la tarjeta de crédito
            parametros.put(PayU.PARAMETERS.CREDIT_CARD_NUMBER, "4097440000000004");
//Ingrese aquí la fecha de vencimiento de la tarjeta de crédito
            parametros.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, "2014/12");
//Ingrese aquí el código de seguridad de la tarjeta de crédito
            parametros.put(PayU.PARAMETERS.CREDIT_CARD_SECURITY_CODE, "321");
//Ingrese aquí el nombre de la tarjeta de crédito
            parametros.put(PayU.PARAMETERS.PAYMENT_METHOD, "VISA");

//Ingrese aquí el número de cuotas.
            parametros.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "1");
//Ingrese aquí el nombre del pais.
            parametros.put(PayU.PARAMETERS.COUNTRY, PaymentCountry.CO.name());

//Session id del device.
            parametros.put(PayU.PARAMETERS.DEVICE_SESSION_ID, "vghs6tvkcle931686k1900o6e1");
//IP del pagadador
            parametros.put(PayU.PARAMETERS.IP_ADDRESS, "127.0.0.1");
//Cookie de la sesión actual.
            parametros.put(PayU.PARAMETERS.COOKIE, "pt1t38347bs6jc9ruv2ecpv7o2");
//Cookie de la sesión actual.
            parametros.put(PayU.PARAMETERS.USER_AGENT, "Mozilla/5.0 (Windows NT 5.1; rv:18.0) Gecko/20100101 Firefox/18.0");

//Solicitud de autorización y captura
            PayU.apiKey = "wvyH9SB620ScNAEqWx1yUH0lR2";
            PayU.apiLogin = "C6NvyYSyVgvLGJ4";
            PayU.merchantId = "561096";
            TransactionResponse response = PayUPayments.doAuthorizationAndCapture(parametros);

//Respuesta
            if (response != null) {
                response.getOrderId();
                response.getTransactionId();
                response.getState();
                if (response.getState().toString().equalsIgnoreCase("PENDING")) {
                    response.getPendingReason();
                }
                response.getPaymentNetworkResponseCode();
                response.getPaymentNetworkResponseErrorMessage();
                response.getTrazabilityCode();
                response.getResponseCode();
                response.getResponseMessage();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return pagoRespuesta;
    }

    public static void main(String[] args) throws Exception {
        Transaccion pago = new Transaccion();
        pago.realizarPago();
    }

}
