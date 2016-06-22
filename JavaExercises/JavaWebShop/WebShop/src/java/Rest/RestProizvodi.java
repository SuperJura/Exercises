/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import dataAccessLayer.Repozitorij;
import models.Proizvod;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
/**
 * REST Web Service
 *
 * @author Jurica
 */
@Path("proizvodi")
public class RestProizvodi {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestProizvodi
     */
    public RestProizvodi() {
    }

    /**
     * Retrieves representation of an instance of Rest.RestProizvodi
     * @param id
     * @return an instance of Models.Proizvod
     */
    @GET
    @Produces("application/json")
    @Path("{id}")
    public String getXml(@PathParam("id") int id){
        Gson json = new Gson();
        return json.toJson(Repozitorij.getProizvodiDatabaseInstance().getProizvod(id));
    }
}
