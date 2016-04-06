/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.co.myticket.servicios;

import com.co.myticket.conexion.Consultas;
import com.co.myticket.objetos.Login;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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
@Path("/wslogin")
public class LoginResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }



    /**
     * POST method for creating an instance of WsLoginResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/consultarLogin")
    public Login postJson(@QueryParam("usuario") String pUsuario,
                          @QueryParam("clave") String pClave ) {
       
        int codigoRespuesta = 200;
        Login login = new Login();
        boolean bandera  = false;
        Consultas consulta = new Consultas();
        try
        {
          login.setUsuario(pUsuario);
          login.setClave(pClave);
          
          login = consulta.consultarUsuario(login);
          if ( !login.isLogeado() ) codigoRespuesta = 300;
          
  
        }
        catch(Exception e){
            e.printStackTrace();
            codigoRespuesta = 300;
        }
        return login;
        //return Response.status(codigoRespuesta).build();
    }
    /**
     * 
     * @param pUsuario
     * @param pClave
     * @return 
     */
    public int crearUsuario(@QueryParam("usuario") String pUsuario,
                          @QueryParam("clave") String pClave ){
       
        int codigoRespuesta = 0;
        Login login = new Login();
        boolean bandera  = false;
        Consultas consulta = new Consultas();
        try{
            consulta.crearUsuario(pUsuario, pClave);
        }
        catch(Exception e){
            e.printStackTrace();
            codigoRespuesta = 300;
        }
        return codigoRespuesta;
        
    }


    
}
