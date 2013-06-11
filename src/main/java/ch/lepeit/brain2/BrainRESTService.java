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

import ch.lepeit.brain2.model.DeployArtefakt;

import ch.lepeit.brain2.model.Server;

import ch.lepeit.brain2.model.Version;

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
    @Path("/stages")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Stage> listAllStages() {
        log.info("liste stages");
        return brainService.getAllStages();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Stage getStageForName(@PathParam("name")
    String name) {
        log.info("forName");
        return brainService.getStageForName(name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addInstallation(Installation installation) {
        log.info("add");
        brainService.addInstallation(installation);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addVersion(Version version) {
        log.info("add");
        brainService.addVersion(version);
    }

    @POST
    @Path("/addStages")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStage(List<Stage> stages) {
        log.info(stages.get(0).toString());
        // brainService.addVersion(version);
    }

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public int count() {
        log.info("count");
        return brainService.count();
    }
    
    @GET
    @Path("/servers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Server> listAllServers() {
        log.info("liste servers");
        return brainService.getAllServers();
    }
    
    @GET
    @Path("/artefakte")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DeployArtefakt> listAllArtefakte() {
        log.info("liste Artefakte");
        return brainService.getAllDepArts();
    }

}
