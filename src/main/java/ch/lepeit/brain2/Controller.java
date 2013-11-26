package ch.lepeit.brain2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omg.CORBA.OMGVMCID;

import ch.lepeit.brain2.model.Installation;

import ch.lepeit.brain2.model.DeployArtefakt;
import ch.lepeit.brain2.model.Server;
import ch.lepeit.brain2.model.Stage;
import ch.lepeit.brain2.model.Version;

@Named
@SessionScoped
public class Controller implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Logger log;

    @Inject
    private BrainService brainService;

    private String generatedString;

    private String currentVersion;

    private String newVersion;

    private String selectedDepArts;

    private String selectedServer;

    private String selectedStage;

    @PostConstruct
    private void init() {
        selectedDepArts = String.valueOf(brainService.getAllDepArts().get(0).getId());
        selectedServer = String.valueOf(brainService.getAllServers().get(0).getId());
        selectedStage = String.valueOf(brainService.getAllStages().get(0).getStage_ID());
        generateCurrentVersion();
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

    public String getSelectedStage() {
        return selectedStage;
    }

    public void setSelectedStage(String selectedStage) {
        this.selectedStage = selectedStage;

    }

    public void save() {
        log.info("save");

        Installiere installiere = new Installiere();
        installiere.setArtefaktBundleId(getDeployArtefakt(selectedDepArts).getArtefaktId());
        installiere.setNeueVersion(getNewVersion());
        installiere.setServerUrl(getServer(selectedServer).getUrl());
        installiere.setStageKurzName(getStage(selectedStage).getKurzName());

        brainService.addInstallation(installiere);
        generateCurrentVersion();

    }

    public void generateCurrentVersion() {

        DeployArtefakt artefakt = getDeployArtefakt(selectedDepArts);
        Server server = getServer(selectedServer);
        Stage stage = getStage(selectedStage);

        VersionInfo versionInfo = new VersionInfo();
        versionInfo.setArtefaktBudleId(artefakt.getBundleId());
        versionInfo.setServerUrl(server.getUrl());
        versionInfo.setStageKurzName(stage.getKurzName());

        setCurrentVersion(brainService.versionFuerInstallation(versionInfo) != null ? brainService
                .versionFuerInstallation(versionInfo) : "nichts");
    }

    public void generate() {
        System.out.println("generate");

        DeployArtefakt artefakt = getDeployArtefakt(selectedDepArts);
        Server server = getServer(selectedServer);
        Stage stage = getStage(selectedStage);

        log.info("selectedDepArts " + selectedDepArts);
        log.info("selectedServer " + selectedServer);
        log.info("selectedStage " + selectedStage);
        log.info("version " + getCurrentVersion());

        generateCurrentVersion();
        
        setGeneratedString("Deployment deploy {\"tenantDefinedBundleId\":\""
                + artefakt.getBundleId()
                + "\",\"groupId\":\""
                + artefakt.getGroupId()
                + "\",\"artifactId\":\""
                + artefakt.getArtefaktId()
                + "\",\"extension\":\""
                + artefakt.getExtension()
                + (getCurrentVersion() != "" ? "\",\"currentVersion\":\"" + getCurrentVersion() : "")
                + "\",\"newVersion\":\""
                + getNewVersion()
                + "\",\"primary\":\"true\",\"restartRequired\":\"true\",\"repoId\":\"ch-public\"} {\"platformRepoId\":\"ch-public\",\"runtimeName\":\""
                + artefakt.getBundleId()
                + "-runtime\",\"asVersion\":\"jboss-eap-6.0.0\",\"sharedContainer\":\"false\",\"asHome\":\"/opt/jet/jboss-platform-0/jboss/"
                + "TODO-instance"
                + "\",\"platformStage\":\""
                + stage.getKurzName()
                + "\",\"operationMode\":\"DOMAIN\",\"tenant\":\"axa-ch\",\"stage\":\""
                + stage.getKurzName()
                + "\"} {\"server-group-1\":{\""
                + server.getUrl()
                + "."
                + stage.getKurzName()
                + ".firma.intranet"
                + "."
                + "jb000"
                + server.getNumber()
                + ".master\":[\"server-1\"]}} {\"ch-public\":{\"repoUrl\":\"http://mvnrepo.paas.intraxa/nexus/ch-public\"}}");


    }

    private DeployArtefakt getDeployArtefakt(String id) {
        for (DeployArtefakt d : getAllDepArts()) {
            if (String.valueOf(d.getId()).equals(id)) {
                return d;
            }
        }
        return new DeployArtefakt();
    }

    private Server getServer(String id) {
        for (Server s : getAllServers()) {
            if (String.valueOf(s.getId()).equals(id)) {
                return s;
            }
        }
        return new Server();
    }

    private Stage getStage(String id) {
        for (Stage s : getAllStages()) {
            if (String.valueOf(s.getStage_ID()).equals(id)) {
                return s;
            }
        }
        return new Stage();
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    public String getGeneratedString() {
        return generatedString;
    }

    public void setGeneratedString(String generatedString) {
        this.generatedString = generatedString;
    }

    public String getSelectedDepArts() {
        return selectedDepArts;
    }

    public void setSelectedDepArts(String selectedDepArts) {
        this.selectedDepArts = selectedDepArts;
    }

    public String getSelectedServer() {
        return selectedServer;
    }

    public void setSelectedServer(String selectedServer) {
        this.selectedServer = selectedServer;
    }
}
