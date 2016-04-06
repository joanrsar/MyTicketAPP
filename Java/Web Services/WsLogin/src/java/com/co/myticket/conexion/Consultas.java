/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.co.myticket.conexion;

import com.co.general.dao.GeneralDao;
import com.co.myticket.objetos.Login;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author joanrincon
 */
public class Consultas 
{
     GeneralDao conexion = new GeneralDao();
    /**
     * Realizado por : Joan Rincón
     * Fecha         : 31/01/2016
     * Proposito     : Verificar si el usuario existe en el sistema
     * @param login
     * @return 
     */
    public Login consultarUsuario( Login login ) throws Exception{
        Connection con = null;
        CallableStatement sentencia = null;
        Login lLogin = new Login();
        boolean respuesta = false;
        try
        {
            lLogin.setUsuario(login.getUsuario());
            lLogin.setClave(login.getClave());
            
            con = conexion.realizarConexion();
            sentencia = con.prepareCall("{ call MTICKET.GENERAL_PCK.CONSULTAR_LOGIN( ? , ? , ? ,?) }");
            sentencia.setString(1, lLogin.getUsuario());
            sentencia.setString(2, lLogin.getClave());
            sentencia.registerOutParameter(3, Types.INTEGER);
            sentencia.registerOutParameter(4, Types.VARCHAR);
            sentencia.execute();
            
            
            if ( sentencia.getInt(3) == 0){
                respuesta = true;
            }
            lLogin.setLogeado(respuesta);
            lLogin.setPerfil(sentencia.getString(4));
            


        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if (sentencia != null) sentencia.close();
            conexion.cerrarConexion(con);
        }
        return lLogin;
        
    }
    
    public int crearUsuario(String pUsuario, String pClave) throws Exception{
        int codigoError; 
        Connection con = null;
        CallableStatement sentencia = null;
        try{
            con = conexion.realizarConexion();
            sentencia = con.prepareCall("{ call MTICKET.GENERAL_PCK.CREAR_USUARIO( ? , ? , ? ,?) }");
            sentencia.setString(1, pUsuario);
            sentencia.setString(2, pClave);
            sentencia.registerOutParameter(3, Types.INTEGER);
            sentencia.registerOutParameter(4, Types.VARCHAR);
            
            sentencia.execute();
            if( sentencia.getInt(3) == 0){
                codigoError = 0;
            }else{
                codigoError = sentencia.getInt(3);
            }
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return codigoError;
    }

}
