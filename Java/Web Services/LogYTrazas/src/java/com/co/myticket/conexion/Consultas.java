/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.co.myticket.conexion;

import com.co.general.dao.GeneralDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author joanrincon
 */
public class Consultas {
    
        GeneralDao conexion  = new GeneralDao();
    
        /**
         * Realizado por : Joan Rincón
         * Fecha         : 26/03/2016
         * Proposito     : Registar el log en base de datos
         * @param usuario
         * @param capa
         * @param codigoError
         * @param mensajeError
         * @param servicio
         * @throws Exception 
         */
        public void registrarLogBD(String usuario,String capa,
                            int codigoError,String mensajeError,
                            String servicio) throws Exception{
        Connection con = null;
        CallableStatement sentencia = null;
        try{
            con = conexion.realizarConexion();
            sentencia = con.prepareCall("{ call MTICKET.GENERAL_PCK.INSERTAR_LOG( ? , ? , ? ,?,?) }");
            sentencia.setString(1, usuario);
            sentencia.setString(2, capa);
            sentencia.setInt(3, codigoError);
            sentencia.setString(4, mensajeError);
            sentencia.setString(5, servicio);
            
            sentencia.execute();
            
         }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        
}
