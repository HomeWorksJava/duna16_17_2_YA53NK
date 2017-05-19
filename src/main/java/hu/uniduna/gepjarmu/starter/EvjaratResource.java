/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.uniduna.gepjarmu.starter;

import genericdaoservice.GenericDaoService;
import jarmuvek.Evjarat;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
@Path("evjarat")
@RequestScoped
public class EvjaratResource 
{
    @Inject
            GenericDaoService gds;
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    
    
    @GET
    @Path("osszes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Evjarat> getOsszesEvjarat()
    {        
        return gds.getEntities("Evjarat.getOsszesEvjarat", new HashMap());
    }
    
    @POST
    @Path("hozzaad")
    @Produces(MediaType.TEXT_PLAIN)
        public String addMennyiseg(
        @FormParam("szarmazas")String szarmazas,
        @FormParam("idoszak")String idoszak,
        @FormParam("evjarat")Integer evjarat
        )
        {
            Evjarat me = new Evjarat();
            
            me.setSzarmazas(idoszak);
            try
            {                
                me.setEvjarat(evjarat);
            }
            catch(NumberFormatException ex)
            {
                log.error("Nem szam",ex);
            }
            
            me.setIdoszak(szarmazas);
         
            gds.save(me);
            
            return "ok";
        }
        
}
