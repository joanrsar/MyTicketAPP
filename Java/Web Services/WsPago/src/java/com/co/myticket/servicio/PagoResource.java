/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.myticket.servicio;

import com.co.myticket.objetos.Pago;
import com.co.myticket.objetos.PagoResponse;
import com.co.myticket.pago.Transaccion;
import com.co.myticket.utilidades.MD5;
import com.co.myticket.utilidades.Utilidades;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author joanrincon
 */
@Path("/wsPago")
public class PagoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WsPagoesResource
     */
    public PagoResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.co.myticket.servicio.WsPagoesResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * POST method for creating an instance of WsPagoResource
     *
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postJson(String content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public WsPagoResource getWsPagoResource(@PathParam("id") String id) {
        return WsPagoResource.getInstance(id);
    }

    /**
     * Realizado por : Joan Rincon Fecha : 07/04/2016 Proposito : Realizar un
     * pago con tarjeta credito
     *
     * @param valor
     * @param referencia
     * @param idComprador
     * @param nombreComprador
     * @param correoComprador
     * @param telefonoContactoComprador
     * @param dniComprador
     * @param direccionComprador
     * @param direccion2Comprador
     * @param ciudadComprador
     * @param departamentoComprador
     * @param paisComprador
     * @param codigoPostalComprador
     * @param telefonoComprador
     * @param idPagador
     * @param nombrePagador
     * @param correoPagador
     * @param telefonoContactoPagador
     * @param dniPagador
     * @param direccionPagador
     * @param direccion2Pagador
     * @param ciudadPagador
     * @param departamentoPagador
     * @param paisPagador
     * @param codigoPostalPagador
     * @param telefonoPagador
     * @param numeroTarjetaCredito
     * @param fechaExpiracionTarjeta
     * @param codigoSeguridadTarjeta
     * @param metodoPago
     * @param numeroCuotas
     * @param idDispositivo
     * @param ip
     * @param cookies
     * @param agente
     * @return
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/realizarPago")
    public Pago realizarPago(@QueryParam("valor") double valor,
            @QueryParam("referencia") int referencia,
            @QueryParam("usuario") int idComprador,
            @QueryParam("nombreComprador") String nombreComprador,
            @QueryParam("correoComprador") String correoComprador,
            @QueryParam("telefonoContactoComprador") int telefonoContactoComprador,
            @QueryParam("dniComprador") int dniComprador,
            @QueryParam("direccionComprador") String direccionComprador,
            @QueryParam("direccion2Comprador") String direccion2Comprador,
            @QueryParam("ciudadComprador") String ciudadComprador,
            @QueryParam("departamentoComprador") String departamentoComprador,
            @QueryParam("paisComprador") String paisComprador,
            @QueryParam("codigoPostalComprador") int codigoPostalComprador,
            @QueryParam("telefonoComprador") int telefonoComprador,
            @QueryParam("idPagador") int idPagador,
            @QueryParam("nombrePagador") String nombrePagador,
            @QueryParam("correoPagador") String correoPagador,
            @QueryParam("telefonoContactoPagador") int telefonoContactoPagador,
            @QueryParam("dniPagador") int dniPagador,
            @QueryParam("direccionPagador") String direccionPagador,
            @QueryParam("direccion2Pagador") String direccion2Pagador,
            @QueryParam("ciudadPagador") String ciudadPagador,
            @QueryParam("departamentoPagador") String departamentoPagador,
            @QueryParam("paisPagador") String paisPagador,
            @QueryParam("codigoPostalPagador") int codigoPostalPagador,
            @QueryParam("telefonoPagador") int telefonoPagador,
            @QueryParam("numeroTarjetaCredito") int numeroTarjetaCredito,
            @QueryParam("fechaExpiracionTarjeta") String fechaExpiracionTarjeta,
            @QueryParam("codigoSeguridadTarjeta") int codigoSeguridadTarjeta,
            @QueryParam("metodoPago") String metodoPago,
            @QueryParam("numeroCuotas") int numeroCuotas,
            @QueryParam("idDispositivo") int idDispositivo,
            @QueryParam("ip") String ip,
            @QueryParam("cookies") String cookies,
            @QueryParam("agente") String agente
    ) {
        Pago pago = new Pago();
        Transaccion transaccion = new Transaccion();
        try {
            pago.setAgente(agente);
            pago.setCiudadComprador(ciudadComprador);
            pago.setCiudadPagador(ciudadPagador);
            pago.setCodigoPostalComprador(codigoPostalComprador);
            pago.setCodigoPostalPagador(codigoPostalPagador);
            pago.setCodigoSeguridadTarjeta(codigoSeguridadTarjeta);
            pago.setCookies(cookies);
            pago.setCorreoComprador(correoComprador);
            pago.setCorreoPagador(correoPagador);
            pago.setDepartamentoComprador(departamentoComprador);
            pago.setDepartamentoPagador(departamentoPagador);
            pago.setDireccion2Comprador(direccion2Comprador);
            pago.setDireccion2Pagador(direccion2Pagador);
            pago.setDireccionComprador(direccionComprador);
            pago.setDireccionPagador(direccionPagador);
            pago.setDniComprador(dniComprador);
            pago.setFechaExpiracionTarjeta(fechaExpiracionTarjeta);
            pago.setIdComprador(idComprador);
            pago.setIdDispositivo(idDispositivo);
            pago.setIdPagador(idPagador);
            pago.setIp(ip);
            pago.setMetodoPago(metodoPago);
            pago.setNombreComprador(nombreComprador);
            pago.setNombrePagador(nombrePagador);
            pago.setNumeroCuotas(numeroCuotas);
            pago.setNumeroTarjetaCredito(numeroTarjetaCredito);
            pago.setPaisComprador(paisComprador);
            pago.setPaisPagador(paisPagador);
            pago.setReferencia(referencia);
            pago.setTelefonoComprador(telefonoComprador);
            pago.setTelefonoContactoComprador(telefonoContactoComprador);
            pago.setTelefonoContactoPagador(telefonoContactoPagador);
            pago.setTelefonoPagador(telefonoPagador);
            pago.setValor(valor);

            transaccion.realizarPago();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pago;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/simularPago")
    public PagoResponse simularPago(@QueryParam("pIdEvento") int pIdEvento,
            @QueryParam("pIdLocalidad") int pIdLocalidad,
            @QueryParam("pNombreEvento") String pNombreEvento,
            @QueryParam("pTarjeta") String pTarjeta,
            @QueryParam("pEmpresa") String pEmpresa,
            @QueryParam("pCodigo") String pCodigo) {
        PagoResponse response = new PagoResponse();
        try {
            response.setCodigoRespuesta(0);
            response.setPagoId(Utilidades.generarRamdon());
            String cadena = pIdLocalidad + pIdEvento + pNombreEvento + String.valueOf(response.getPagoId());
            response.setCodigo(MD5.encriptaEnMD5(cadena));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
        
    }
}
