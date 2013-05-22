package ch.lepeit.brain2;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.lepeit.brain2.model.Installation;
import ch.lepeit.brain2.model.Stage;

@Path("/brain2")
@RequestScoped
public class BrainRESTService {

    @Inject
    private Logger log;

    @Inject
    private BrainService brainService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Stage> listAllStages() {
        log.info("liste stages");
        return brainService.getAllStages();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Stage> getStageForName(@PathParam("name")
    String name) {
        log.info("forName");
        return brainService.getStageForName(name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addInstallation(Installation installation){
        log.info("add");
        brainService.addInstallation();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public int count() {
        log.info("count");
        return brainService.count();
    }

}
