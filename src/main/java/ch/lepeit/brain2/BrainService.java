package ch.lepeit.brain2;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ch.lepeit.brain2.model.DeployArtefakt;
import ch.lepeit.brain2.model.Installation;
import ch.lepeit.brain2.model.Server;
import ch.lepeit.brain2.model.Stage;
import ch.lepeit.brain2.model.Version;

@Stateless
public class BrainService {
    
    private String name;

    @PersistenceContext
    private EntityManager em;
    
    public List<Stage> getAllStages() {
        return em.createQuery("SELECT x FROM Stage x", Stage.class).getResultList();
    }
    
    public List<DeployArtefakt> getAllDepArts(){
        return em.createQuery("SELECT x FROM DeployArtefakt x", DeployArtefakt.class).getResultList();
    }
    
    public List<Server> getAllServers(){
        return em.createQuery("SELECT x FROM Server x", Server.class).getResultList();
    }
    
    public List<Version> getAllVersions(){
        return em.createQuery("SELECT x FROM Version x", Version.class).getResultList();
    }
    
    public List<Installation> getAllInstallations(){
        return em.createQuery("SELECT x FROM Installation x").getResultList();
    }
    
    public List<Stage> getStageForName(String name){
        return em.createQuery("SELECT name FROM Stage name").getResultList();
    }
    
    public int count(){
        return (int) em.createQuery("SELECT COUNT x FROM Stage x").getSingleResult();
        
    }
    
    public List<Installation> addInstallation(){
        return em.createQuery("INSERT x FROM Installation x").getResultList();
        
    }

}
