/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.uniduna.gepjarmu.starter;

import jarmuvek.Auto;
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


@Path("auto")
@RequestScoped
public class AutoResource
{
    @Inject
            GenericDaoService gds;
    
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    
       
    public AutoResource()
    {
        log.info("autoresource peldany letrejott");
    }
    
    @GET
    @Path("osszes")
    @Produces(MediaType.APPLICATION_JSON)
      public List<Auto> getAuto()
      {
         return gds.getEntities("Auto.OsszesAuto", new HashMap());
      }
      
    @GET
    @Path("auto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
        public Auto getAutoById(@PathParam("id")Long id)
        {
            Map<String,Object> params = new HashMap<>();
            params.put("id", id);
            
            return (Auto) gds.getEntity("Auto.getAutoById", params);
        }
    
    @POST
    @Path("hozzaad")
    @Produces(MediaType.TEXT_PLAIN)
      public String insertAuto(@FormParam("gyarto")String gyarto,
                              @FormParam("hengerurtartalom")String hengerurtartalom,
                              @FormParam("tipus")String tipus,
                              @FormParam("uzemanyag")String uzemanyag)
      {
         Auto auto = new Auto();
         
         try
         {
             auto.setHengerurtartalom(Double.parseDouble(hengerurtartalom));
         }
         catch(NumberFormatException ex)
         {
             log.error("Nem szam",ex);
         }        
            auto.setGyarto(gyarto);
            auto.setTipus(tipus);
            auto.setUzemanyag(uzemanyag);
            
//            em.getTransaction().begin();
            gds.save(auto);
//            em.getTransaction().commit();
          
          return " ok ";
      }
}
