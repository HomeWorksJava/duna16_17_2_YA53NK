/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.uniduna.gepjarmu.starter;

import genericdaoservice.GenericDaoService;
import jarmuvek.Ar;
import jarmuvek.Busz;
import jarmuvek.Evjarat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Administrator
 */
@Path("ar")
@RequestScoped
public class ArResource 
{
    @Inject
            GenericDaoService gds;
    
    
    @POST
    @Path("hozzaad")
    @Produces(MediaType.TEXT_PLAIN)
    public String addPrice(@FormParam("buszId")Long buszId,
                           @FormParam("evjaratId")Long evjaratId,
                           @FormParam("ar")Integer ar)
    {
         Ar arObj = new Ar();        
            Map<String,Object> params = new HashMap<>();
               params.put("id", buszId);  

           Busz busz;
           busz = (Busz) gds.getEntity("Busz.getBuszById", params);
           
        arObj.setAr(ar);
        arObj.setJarmu(busz);
        
           Evjarat me;
            params.put("id", evjaratId);
           
            me = (Evjarat) gds.getEntity("Evjarat.getEvjaratById", params);
        
        arObj.setMe(me);
        
        gds.save(arObj);
        
        return "ok";
    }
    
    @GET
    @Path("osszes")
    @Produces(MediaType.APPLICATION_JSON)
            public List<Ar> getOsszesAr()
            {
                return gds.getEntities("Ar.getOsszesAr", new HashMap());
            }
    
}
