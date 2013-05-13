package ch.lepeit.brain2;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/brain2")
@RequestScoped
public class BrainRESTService {
	
    @Inject
    private Logger log;
    
    @Inject
    private BrainService brainService; 
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Stage> listAllStages() {
    	log.info("liste stages"); 
        return brainService.getAllStages();
    }
    
    @GET
    @Path("/eins")
    @Produces(MediaType.APPLICATION_JSON)
    public Stage firstStage() {
    	log.info("liste stages"); 
        return brainService.getAllStages().get(1);
    }
    
    
}
