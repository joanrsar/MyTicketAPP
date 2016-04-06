/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.co.myticket.log;

import com.co.myticket.conexion.Consultas;

/**
 *
 * @author joanrincon
 */
public class HiloLog extends Thread {
    
    private String usuario;
    private String capa;
    private int codigoError;
    private String mensajeError;
    private String servicio;

    public HiloLog(String usuario, String capa, int codigoError, String mensajeError, String servicio) {
        this.usuario = usuario;
        this.capa = capa;
        this.codigoError = codigoError;
        this.mensajeError = mensajeError;
        this.servicio = servicio;
    }
    
      public void run(){
        Consultas consulta = new Consultas();
        try{
            consulta.registrarLogBD(this.usuario, this.capa, this.codigoError, this.mensajeError, this.servicio);
        }
        catch(Exception e){
            
        }
    }
    
}
