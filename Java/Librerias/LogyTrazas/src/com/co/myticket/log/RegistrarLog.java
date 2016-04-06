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
public class RegistrarLog {
    
    /**
     * Realizado por : Joan Rincón
     * Fecha         : 26/03/2016
     * Proposito     : Registar el log en base de datos
     * @param usuario
     * @param capa
     * @param codigo_error
     * @param mensajeError
     * @param servicio 
     */
    
    public void registarLog(String usuario,String capa,
                            int codigo_error,String mensajeError,
                            String servicio){
        
       HiloLog hilo = new HiloLog(usuario,capa,codigo_error,mensajeError,servicio);
       try{
           hilo.start();
        
       }
       catch(Exception e){
           e.printStackTrace();
       }finally{
           
       }
        
    }
    

    
}
