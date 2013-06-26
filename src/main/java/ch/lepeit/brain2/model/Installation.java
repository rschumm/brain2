package ch.lepeit.brain2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Installation {
    private static final long serialVersionUID = 1L;
    
    @Id
    private int id;
    
    @ManyToOne
    @JoinColumn(name="server_IDFS", nullable=false)
    private Server server;
    
    @ManyToOne
    @JoinColumn(name="deployArtefakt_IDFS", nullable=false)
    private DeployArtefakt deployArtefakt;
    
    @ManyToOne
    @JoinColumn(name="version_IDFS", nullable=false)
    private Version version;
    
    @ManyToOne
    @JoinColumn(name="Stage_IDFS", nullable=false)
    private Stage stage;
    
    public Installation() {
        //this(null, null, null, null);
    }
    
    public Installation(Server server, DeployArtefakt deployArtefakt, Version version, Stage stage) {
        this.server = server;
        this.deployArtefakt = deployArtefakt;
        this.version = version;
        this.stage = stage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public DeployArtefakt getDeployArtefakt() {
        return deployArtefakt;
    }

    public void setDeployArtefakt(DeployArtefakt deployArtefakt) {
        this.deployArtefakt = deployArtefakt;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    
}
