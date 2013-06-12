package ch.lepeit.brain2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Server {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    
    private String url;
    private int number;
    private String description;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="server")
    private List<Installation> installationen;

    public Server() {
        this(null,0);
    }

    public Server(String url, int number) {
        this.id = id;
        this.number = number;
        this.url = url;
        installationen = new ArrayList<Installation>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Installation> getInstallation() {
        return installationen;
    }

    public void setInstallation(List<Installation> installationen) {
        this.installationen = installationen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Installation> getInstallationen() {
        return installationen;
    }

    public void setInstallationen(List<Installation> installationen) {
        this.installationen = installationen;
    }
    
    
}
