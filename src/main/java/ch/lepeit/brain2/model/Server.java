package ch.lepeit.brain2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Server {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    
    private String url;
    private int number;
    
    @OneToMany(mappedBy="server")
    private List<Installation> installation;

    public Server() {
        this(null,0);
    }

    public Server(String url, int number) {
        this.id = id;
        this.number = number;
        this.url = url;
        installation = new ArrayList<Installation>();
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
        return installation;
    }

    public void setInstallation(List<Installation> installation) {
        this.installation = installation;
    }
    
}
