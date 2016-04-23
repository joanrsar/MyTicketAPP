/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.myticket.conexion;

import com.co.general.dao.GeneralDao;
import com.co.myticket.objetos.Tiquete;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author joanrincon
 */
public class Consultas {

    GeneralDao conexion = new GeneralDao();

    public int registrarTiquete(String pUsuario,
            String pCodigo,
            int pLocalidadEvento,
            int pIdPago,
            int pCantidad) throws Exception {
        int codigoError = 0;
        String mensajeError = "";
        Connection con = null;
        CallableStatement sentencia = null;
        try {
            con = conexion.realizarConexion();
            sentencia = con.prepareCall("{ call MTICKET.TIQUETE_PCK.CREAR_TIQUETE( ? , ? , ? , ? ,? ,? ,?) }");
            sentencia.setInt(1, pLocalidadEvento);
            sentencia.setString(2, pUsuario);
            sentencia.setInt(3, pIdPago);
            sentencia.setString(4, pCodigo);
            sentencia.setInt(5, pCantidad);
            sentencia.registerOutParameter(6, Types.INTEGER);
            sentencia.registerOutParameter(7, Types.VARCHAR);
            sentencia.execute();

            codigoError = sentencia.getInt(6);
            if (codigoError != 0 ){
                mensajeError = sentencia.getString(7);
                throw new Exception(mensajeError);
            }
          
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return codigoError;
    }

    public ArrayList<Tiquete> obtenerTiquetes(String pUsuario) throws Exception {
        ArrayList<Tiquete> listaTiquetes = new ArrayList<Tiquete>();
        Connection con = null;
        CallableStatement sentencia = null;
        ResultSet lResultado = null;
        Tiquete tiquete;
        try {
            con = conexion.realizarConexion();
            sentencia = con.prepareCall("{ call MTICKET.TIQUETE_PCK.OBTERNER_TIQUETES( ?, ? , ? , ? ) }");
            sentencia.setString(1, pUsuario);
            sentencia.registerOutParameter(2, OracleTypes.CURSOR);
            sentencia.registerOutParameter(3, Types.INTEGER);
            sentencia.registerOutParameter(4, Types.VARCHAR);
            sentencia.execute();

            if (sentencia.getInt(3) == 0) {
                lResultado = (ResultSet) sentencia.getObject(2);
                while (lResultado.next()) {
                    tiquete = new Tiquete();
                    tiquete.setIdTiquete(lResultado.getInt("ID_TIQUETE"));
                    tiquete.setIdLocalidadEvento(lResultado.getInt("ID_LOCALIDAD_EVENTO"));
                    tiquete.setIdUsuario(lResultado.getString("ID_USUARIO"));
                    tiquete.setIdPago(1);
                    tiquete.setCodigo(lResultado.getString("CODIGO"));
                    tiquete.setEstadoEvento(lResultado.getString("ESTADO_EVENTO"));
                    tiquete.setCantidadBoleta(lResultado.getInt("CANTIDAD_BOLETA"));
                    tiquete.setFechaCreacion(lResultado.getDate("FECHA_CREACION"));
                    tiquete.setUsuarioCreacion(lResultado.getString("USUARIO_CREACION"));
                    tiquete.setUsuarioUltimaModificacion(lResultado.getString("USUARIO_ULTIMA_MODIFICACION"));
                    tiquete.setFechaUltimaModificacion(lResultado.getDate("FECHA_ULTIMA_MODIFICACION"));
                    tiquete.setNombreLocalidad(lResultado.getString("NOMBRE_LOCALIDAD"));
                    tiquete.setNombreEvento(lResultado.getString("NOMBRE_EVENTO"));
                    tiquete.setFechaEvento(lResultado.getString("FECHA_EVENTO"));
                    tiquete.setNombreEscenario(lResultado.getString("NOMBRE_ESCENARIO"));
                    tiquete.setDireccion(lResultado.getString("DIRECCION"));

                    listaTiquetes.add(tiquete);
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaTiquetes;
    }
}
