/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.co.myticket.servicios;

import com.co.myticket.conexion.Consultas;
import com.co.myticket.objetos.Tiquete;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("/wsTiquete")
public class TiqueteResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WsTiquetesResource
     */
    public TiqueteResource() {
    }

    /**
     * Realizado por :Joan Rincón
     * Fecha : 10/04/2016
     * Proposito : Crear un tiquete
     * @param pUsuario
     * @param pCodigo
     * @param pLocalidadEvento
     * @param pIdPago
     * @param pCantidad
     * @return 
     */
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/registrarTiquete")
    public String  registrarTiquete(@QueryParam("pUsuario") String pUsuario,
                                 @QueryParam("pCodigo")    String pCodigo,
                                 @QueryParam("pLocalidadEvento")    int    pLocalidadEvento,
                                 @QueryParam("pIdPago")    int    pIdPago,
                                 @QueryParam("pCantidad")    int    pCantidad){
        int codigoError = 0;
        Consultas consulta = new Consultas();
        try{
            codigoError = consulta.registrarTiquete(pUsuario, pCodigo, pLocalidadEvento, pIdPago, pCantidad);
        }
        catch(Exception e){
            e.printStackTrace();
            codigoError = 300;
        }
        return String.valueOf(codigoError);
        
    }
    
    /**
     * Realizado por : Joan Rincón
     * Fecha : 10/04/2016
     * Proposito : Listar los tiquetes adquiridos por un 
     * usuario
     * @param pUsuario
     * @return 
     */
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/obtenerTiquetes")
    public ArrayList<Tiquete> obtenerTiquetes( @QueryParam("pUsuario") String pUsuario  ){
        ArrayList<Tiquete> tiquete = new ArrayList<Tiquete>();
        Consultas consultas = new Consultas();
        try{
            tiquete = consultas.obtenerTiquetes(pUsuario);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return tiquete;
    }
}
