/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.uniduna.gepjarmu.starter;

import jarmuvek.Busz;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import genericdaoservice.*;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;


@Path("busz")
@RequestScoped
public class BuszResource 
{
    @Inject
            GenericDaoService gds;
    
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    
       
    public BuszResource()
    {
        log.info("buszresource peldany letrejott");
    }
    
    @GET
    @Path("osszes")
    @Produces(MediaType.APPLICATION_JSON)
      public List<Busz> getBusz()
      {
         return gds.getEntities("Busz.OsszesBusz", new HashMap());
      }
      
    @GET
    @Path("busz/{id}")
    @Produces(MediaType.APPLICATION_JSON)
        public Busz getBuszById(@PathParam("id")Long id)
        {
            Map<String,Object> params = new HashMap<>();
            params.put("id", id);
            
            return (Busz) gds.getEntity("Busz.getBuszById", params);
        }
    
    @POST
    @Path("hozzaad")
    @Produces(MediaType.TEXT_PLAIN)
      public String insertBusz(
                              @FormParam("gyarto")String gyarto,
                              @FormParam("hengerurtartalom")String hengerurtartalom,
                              @FormParam("tipus")String tipus,
                              @FormParam("szemelyek")String szemelyek)
      {
         Busz busz = new Busz();
         
         try
         {
             busz.setHengerurtartalom(Double.parseDouble(hengerurtartalom));
         }
         catch(NumberFormatException ex)
         {
             log.error("Nem szam",ex);
         }        
            busz.setGyarto(gyarto);
            busz.setTipus(tipus);
            busz.setSzemelyek(szemelyek);
            
//            em.getTransaction().begin();
            gds.save(busz);
//            em.getTransaction().commit();
          
          return " ok ";
      }
}