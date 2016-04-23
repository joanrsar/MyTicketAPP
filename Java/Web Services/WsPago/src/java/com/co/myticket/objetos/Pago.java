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
public class Pago {
    
    
    private double  valor;
    private int     referencia;
    private int     idComprador;
    private String  nombreComprador;
    private String  correoComprador;
    private int     telefonoContactoComprador;
    private int     dniComprador;
    private String  direccionComprador;
    private String  direccion2Comprador;
    private String  ciudadComprador;
    private String  departamentoComprador;
    private String  paisComprador = "CO";
    private int     codigoPostalComprador;
    private int     telefonoComprador;
    
    private int     idPagador;
    private String  nombrePagador;
    private String  correoPagador;
    private int     telefonoContactoPagador;
    private int     dniPagador;
    private String  direccionPagador;
    private String  direccion2Pagador;
    private String  ciudadPagador;
    private String  departamentoPagador;
    private String  paisPagador = "CO";
    private int     codigoPostalPagador;
    private int     telefonoPagador; 
    
    private int     numeroTarjetaCredito;
    private String  fechaExpiracionTarjeta;
    private int     codigoSeguridadTarjeta;
    private String  metodoPago;
    private int     numeroCuotas;
    
    private int     idDispositivo;
    private String  ip;
    private String  cookies;
    private String  agente;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getCorreoComprador() {
        return correoComprador;
    }

    public void setCorreoComprador(String correoComprador) {
        this.correoComprador = correoComprador;
    }

    public int getTelefonoContactoComprador() {
        return telefonoContactoComprador;
    }

    public void setTelefonoContactoComprador(int telefonoContactoComprador) {
        this.telefonoContactoComprador = telefonoContactoComprador;
    }

    public int getDniComprador() {
        return dniComprador;
    }

    public void setDniComprador(int dniComprador) {
        this.dniComprador = dniComprador;
    }

    public String getDireccionComprador() {
        return direccionComprador;
    }

    public void setDireccionComprador(String direccionComprador) {
        this.direccionComprador = direccionComprador;
    }

    public String getDireccion2Comprador() {
        return direccion2Comprador;
    }

    public void setDireccion2Comprador(String direccion2Comprador) {
        this.direccion2Comprador = direccion2Comprador;
    }

    public String getCiudadComprador() {
        return ciudadComprador;
    }

    public void setCiudadComprador(String ciudadComprador) {
        this.ciudadComprador = ciudadComprador;
    }

    public String getDepartamentoComprador() {
        return departamentoComprador;
    }

    public void setDepartamentoComprador(String departamentoComprador) {
        this.departamentoComprador = departamentoComprador;
    }

    public String getPaisComprador() {
        return paisComprador;
    }

    public void setPaisComprador(String paisComprador) {
        this.paisComprador = paisComprador;
    }

    public int getCodigoPostalComprador() {
        return codigoPostalComprador;
    }

    public void setCodigoPostalComprador(int codigoPostalComprador) {
        this.codigoPostalComprador = codigoPostalComprador;
    }

    public int getTelefonoComprador() {
        return telefonoComprador;
    }

    public void setTelefonoComprador(int telefonoComprador) {
        this.telefonoComprador = telefonoComprador;
    }

    public int getIdPagador() {
        return idPagador;
    }

    public void setIdPagador(int idPagador) {
        this.idPagador = idPagador;
    }

    public String getNombrePagador() {
        return nombrePagador;
    }

    public void setNombrePagador(String nombrePagador) {
        this.nombrePagador = nombrePagador;
    }

    public String getCorreoPagador() {
        return correoPagador;
    }

    public void setCorreoPagador(String correoPagador) {
        this.correoPagador = correoPagador;
    }

    public int getTelefonoContactoPagador() {
        return telefonoContactoPagador;
    }

    public void setTelefonoContactoPagador(int telefonoContactoPagador) {
        this.telefonoContactoPagador = telefonoContactoPagador;
    }

    public int getDniPagador() {
        return dniPagador;
    }

    public void setDniPagador(int dniPagador) {
        this.dniPagador = dniPagador;
    }

    public String getDireccionPagador() {
        return direccionPagador;
    }

    public void setDireccionPagador(String direccionPagador) {
        this.direccionPagador = direccionPagador;
    }

    public String getDireccion2Pagador() {
        return direccion2Pagador;
    }

    public void setDireccion2Pagador(String direccion2Pagador) {
        this.direccion2Pagador = direccion2Pagador;
    }

    public String getCiudadPagador() {
        return ciudadPagador;
    }

    public void setCiudadPagador(String ciudadPagador) {
        this.ciudadPagador = ciudadPagador;
    }

    public String getDepartamentoPagador() {
        return departamentoPagador;
    }

    public void setDepartamentoPagador(String departamentoPagador) {
        this.departamentoPagador = departamentoPagador;
    }

    public String getPaisPagador() {
        return paisPagador;
    }

    public void setPaisPagador(String paisPagador) {
        this.paisPagador = paisPagador;
    }

    public int getCodigoPostalPagador() {
        return codigoPostalPagador;
    }

    public void setCodigoPostalPagador(int codigoPostalPagador) {
        this.codigoPostalPagador = codigoPostalPagador;
    }

    public int getTelefonoPagador() {
        return telefonoPagador;
    }

    public void setTelefonoPagador(int telefonoPagador) {
        this.telefonoPagador = telefonoPagador;
    }

    public int getNumeroTarjetaCredito() {
        return numeroTarjetaCredito;
    }

    public void setNumeroTarjetaCredito(int numeroTarjetaCredito) {
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    public String getFechaExpiracionTarjeta() {
        return fechaExpiracionTarjeta;
    }

    public void setFechaExpiracionTarjeta(String fechaExpiracionTarjeta) {
        this.fechaExpiracionTarjeta = fechaExpiracionTarjeta;
    }

    public int getCodigoSeguridadTarjeta() {
        return codigoSeguridadTarjeta;
    }

    public void setCodigoSeguridadTarjeta(int codigoSeguridadTarjeta) {
        this.codigoSeguridadTarjeta = codigoSeguridadTarjeta;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }
    
    
    
    
    
}
