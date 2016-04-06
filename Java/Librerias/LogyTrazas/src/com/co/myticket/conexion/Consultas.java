/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.co.myticket.conexion;

import com.co.general.dao.GeneralDao;
import java.sql.CallableStatement;
import java.sql.Connection;

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
            //con = conexion.obtenerConexion();
            sentencia = con.prepareCall("{ call MTICKET.GENERAL_PCK.INSERTAR_LOG( ? ) }");
            sentencia.setString(1, capa);
            /*sentencia.setString(2, "USUARIO");    
            sentencia.setInt(3, 0);
            sentencia.setString(4, "OK");
            sentencia.setString(5, "MICLASE");*/
            
            sentencia.execute();
            
         }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if (sentencia != null) sentencia.close();
            conexion.cerrarConexion(con);
        }
        }
        
}
