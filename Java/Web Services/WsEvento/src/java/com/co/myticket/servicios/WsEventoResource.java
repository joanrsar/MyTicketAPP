/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.co.myticket.servicios;

import com.co.myticket.conexion.Consultas;
import com.co.myticket.objetos.Evento;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author joanrincon
 */
public class WsEventoResource {

    private String id;

    /**
     * Creates a new instance of WsEventoResource
     */
    private WsEventoResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the WsEventoResource
     */
    public static WsEventoResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of WsEventoResource class.
        return new WsEventoResource(id);
    }

    /**
     * Retrieves representation of an instance of com.co.myticket.servicios.WsEventoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of WsEventoResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    /**
     * DELETE method for resource WsEventoResource
     */
    @DELETE
    public void delete() {
    }
    
        /**
     * PUT method for updating or creating an instance of WsEventoResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */

    

}
