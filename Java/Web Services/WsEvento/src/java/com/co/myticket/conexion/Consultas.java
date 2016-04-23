/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.co.myticket.conexion;

import com.co.general.dao.GeneralDao;
import com.co.myticket.objetos.Evento;
import com.co.myticket.objetos.LocalidadEvento;
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
    
    /**
     * Realizado por : Joan Rincón
     * Fecha         : 23/03/2016
     * Proposito     : Consultar los eventos activos
     * @param pParametros
     * @return
     * @throws Exception 
     */
    public ArrayList<Evento> consultaEvento(Evento pParametros) throws Exception{
        ArrayList<Evento> lEvento = new ArrayList<Evento> ();
        Connection con = null;
        CallableStatement sentencia = null;
        ResultSet   lResultado = null;
        Evento evento ;
        try{
            
            con = conexion.realizarConexion();
            sentencia = con.prepareCall("{ call MTICKET.EVENTOS_PCK.CONSULTAR_EVENTOS( ? , ? , ? ) }");
            sentencia.registerOutParameter(1, Types.INTEGER);
            sentencia.registerOutParameter(2, Types.VARCHAR);
            sentencia.registerOutParameter(3, OracleTypes.CURSOR);
            sentencia.execute();
            
            if ( sentencia.getInt(1) == 0){
                lResultado = (ResultSet) sentencia.getObject(3);
                while( lResultado.next() )
                {
                    evento = new Evento();
                    evento.setIdEvento(lResultado.getInt("ID_EVENTO"));
                    evento.setNombreEvento(lResultado.getString("NOMBRE_EVENTO"));
                    evento.setDescripcionEvento(lResultado.getString("DESCRIPCION_EVENTO"));
                    evento.setNombreEscenario(lResultado.getString("NOMBRE_ESCENARIO"));
                    evento.setDescripcionEscenario(lResultado.getString("DESCRIPCION_ESCENARIO"));
                    evento.setDireccionEvento(lResultado.getString("DIRECCION_EVENTO"));
                    evento.setCiudadEvento(lResultado.getString("CIUDAD_EVENTO"));
                    evento.setTipoIdOrganizacion(lResultado.getString("TIPO_ID_ORG"));
                    evento.setNumeroIdOrganizacion(lResultado.getString("NUM_ID_ORG"));
                    evento.setRazonSocial(lResultado.getString("RAZON_SOCIAL"));
                    evento.setDireccionOrganizacion(lResultado.getString("DIRECCION_ORG"));
                    evento.setTipoEvento(lResultado.getString("TIPO_EVENTO"));
                    evento.setEstadoEvento(lResultado.getString("ESTADO_EVENTO"));
                    evento.setFechaEvento(lResultado.getString("FECHA_EVENTO"));
                    evento.setHoraInicio(lResultado.getString("HORA_INICIO"));
                    evento.setHoraFin(lResultado.getString("HORA_FIN"));
                    evento.setDisponibilidad(lResultado.getString("DISPONIBILIDAD"));
                    evento.setFechaCreacion(lResultado.getDate("FECHA_CREACION"));
                    evento.setUsuarioCreacion(lResultado.getString("USUARIO_CREACION"));
                    evento.setUsuarioUltimaModificacion(lResultado.getString("USUARIO_ULTIMA_MODIFICACION"));
                    evento.setFechaUltimaModificacion(lResultado.getDate("FECHA_ULTIMA_MODIFICACION"));
                    evento.setUlrIcono(lResultado.getString("URL_ICONO"));
                    evento.setUrlImagen(lResultado.getString("URL_IMAGEN"));
                    evento.setCoordenadaUno(lResultado.getString("COORDENADA_UNO"));
                    evento.setCoordenadaDos(lResultado.getString("COORDENADA_DOS"));
                    
                    lEvento.add(evento);
                    
                }
            }
            

            
        }
        catch(Exception e){
            throw new Exception(e.getCause());
        }
        finally{
            if (sentencia != null) sentencia.close();lResultado.close();
            conexion.cerrarConexion(con);
        }
        return lEvento;
    }
    /**
     * Realizado por : Joan Rincón
     * Fecha : 25/03/2016
     * Propostio : Obtener todos los eventos disponibles en una ciudad
     * @param pIdEvento
     * @return
     * @throws Exception 
     */
    public ArrayList<LocalidadEvento> consultarLocalidadEvento(int pIdEvento) throws Exception{
        ArrayList<LocalidadEvento> lLocalidadEvento = new ArrayList<LocalidadEvento>();
        Connection con = null;
        CallableStatement sentencia = null;
        ResultSet   lResultado = null;
        LocalidadEvento localidadEvento ;
        try{
            con = conexion.realizarConexion();
            sentencia = con.prepareCall("{ call MTICKET.EVENTOS_PCK.CONSULTAR_LOCALIDAD_EVENTO( ? , ? , ? ,?) }");
            sentencia.setInt(1, pIdEvento);
            sentencia.registerOutParameter(2, Types.INTEGER);
            sentencia.registerOutParameter(3, Types.VARCHAR);
            sentencia.registerOutParameter(4, OracleTypes.CURSOR);
            sentencia.execute();
            
            if ( sentencia.getInt(2) == 0){
                lResultado = (ResultSet) sentencia.getObject(4);
                while(lResultado.next()){
                    localidadEvento = new LocalidadEvento();
                    localidadEvento.setIdLocalidadEvento(lResultado.getInt("ID_LOCALIDAD_EVENTO"));
                    localidadEvento.setIdEvento(lResultado.getInt("ID_EVENTO"));
                    localidadEvento.setNombreLocalidad(lResultado.getString("NOMBRE_LOCALIDAD"));
                    localidadEvento.setDescripcion(lResultado.getString("DESCRIPCION"));
                    localidadEvento.setDisponibilidadTotal(lResultado.getInt("DISPONIBILIDAD_TOTAL"));
                    localidadEvento.setTotalDisponible(lResultado.getInt("TOTAL_DISPONIBLE"));
                    localidadEvento.setValor(lResultado.getDouble("VALOR"));
                    localidadEvento.setValorPesos(lResultado.getString("VALOR_PESOS"));
                    localidadEvento.setUsuarioCreacion(lResultado.getString("USUARIO_CREACION"));
                    localidadEvento.setFechaCreacion(lResultado.getDate("FECHA_CREACION"));
                    localidadEvento.setUsuarioUltimaModificacion(lResultado.getString("USUARIO_ULTIMA_MODIFICACION"));
                    localidadEvento.setFechaUltimaModificacion(lResultado.getDate("FECHA_ULTIMA_MODIFICACION"));
                    
                    lLocalidadEvento.add(localidadEvento);
                }
             }   
        }
        catch(Exception e){
            throw new Exception(e.getCause());
        }
        finally{
            if (sentencia != null) sentencia.close();lResultado.close();
            conexion.cerrarConexion(con);
        }
        return lLocalidadEvento;
    }
    
}
