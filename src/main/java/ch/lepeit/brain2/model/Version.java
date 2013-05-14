package ch.lepeit.brain2.model;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Version {
    private static final long serialVersionUID = 1L;
    
    @Id
    private int id;
    
    @OneToMany
    private List<Installation> installationen;
    
    private String versionsNr;
    
    public Version(){
        this(null);
    }
    
    public Version(String versionsNr){
        this.id = id;
        this.versionsNr = versionsNr;
        installationen = new ArrayList<Installation>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Installation> getInstallationen() {
        return installationen;
    }

    public void setInstallationen(List<Installation> installationen) {
        this.installationen = installationen;
    }

    public String getVersionsNr() {
        return versionsNr;
    }

    public void setVersionsNr(String versionsNr) {
        this.versionsNr = versionsNr;
    }
    
    
}
