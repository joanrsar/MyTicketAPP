/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.co.myticket.servicios;

import com.co.myticket.conexion.Consultas;
import com.co.myticket.objetos.Evento;
import com.co.myticket.objetos.LocalidadEvento;
import java.util.ArrayList;
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
@Path("/wsEvento")
public class EventoResource {

    @Context
    private UriInfo context;
    private String CAPA = "JAVA";
    /**
     * Creates a new instance of WsEventoesResource
     */
    public EventoResource() {
    }

    
     /**
     * Realizado por : Joan Rincón
     * Fecha : 21/03/2016
     * Propostio : Obtener todos los eventos disponibles en una ciudad
     * @return 
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/consultarEvento")
    public ArrayList<Evento> consultarEvento(@QueryParam("usuario") String pUsuario,
                                             @QueryParam("ciudad") String pCiudad   ){
     ArrayList<Evento> lListaEvento = new ArrayList<Evento>();
     Evento lEventoParametros = new Evento();
     Consultas consulta = new Consultas();
     int codigoError    = 0;
     String MensajeError   = "OK";
      try
      {
          lEventoParametros.setCiudadEvento(pCiudad);
          lListaEvento = consulta.consultaEvento(lEventoParametros);
          
      }
      catch(Exception e){
          MensajeError = e.getMessage();
          codigoError  = 300;
      }
   /*  finally{
          log.registarLog(pUsuario, CAPA, codigoError, MensajeError, getClass().getName());
      }*/
      return lListaEvento;
    }
    
     /**
     * Realizado por : Joan Rincón
     * Fecha : 25/03/2016
     * Propostio : Obtener todos los eventos disponibles en una ciudad
     * @return 
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/consultarLocalidadEvento")
    public ArrayList<LocalidadEvento> consultarLocalidadEvento(@QueryParam("usuario") String pUsuario,
                                                               @QueryParam("idevento") int pIdEvento)
    {
        ArrayList<LocalidadEvento> lLocalidadEvento = new ArrayList<LocalidadEvento> ();
        Consultas consulta = new Consultas();
        int codigoError    = 0;
        String MensajeError   = "OK";
        try{
            lLocalidadEvento = consulta.consultarLocalidadEvento(pIdEvento);
        }
        catch(Exception e){
          MensajeError = e.getMessage();
          codigoError  = 300;
        }
       /* finally{
          log.registarLog(pUsuario, CAPA, codigoError, MensajeError, getClass().getName());
         }*/
        return lLocalidadEvento;
    }
}
