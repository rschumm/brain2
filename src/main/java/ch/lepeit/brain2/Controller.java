package ch.lepeit.brain2;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;


import ch.lepeit.brain2.model.DeployArtefakt;
import ch.lepeit.brain2.model.Server;
import ch.lepeit.brain2.model.Stage;
import ch.lepeit.brain2.model.Version;

@Named
@ConversationScoped
public class Controller implements Serializable {

    Version version;

    @Inject
    private Logger log;

    private Stage selectedStage;

    @Inject
    private BrainService brainService;

    public void machNeueVersion() {

        Version version = null;

        brainService.addVersion(version);

    }

    public List<Stage> getAllStages() {
        return brainService.getAllStages();
    }

    public List<DeployArtefakt> getAllDepArts() {
        return brainService.getAllDepArts();
    }

    public List<Server> getAllServers() {
        return brainService.getAllServers();
    }

    public Stage getSelectedStage() {
        return selectedStage;
    }

    public void setSelectedStage(Stage selectedStage) {
        log.info(selectedStage.getName());
        this.selectedStage = selectedStage;

    }
}
