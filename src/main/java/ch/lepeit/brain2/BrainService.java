package ch.lepeit.brain2;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    public List<DeployArtefakt> getAllDepArts() {
        return em.createQuery("SELECT x FROM DeployArtefakt x", DeployArtefakt.class).getResultList();
    }

    public List<Server> getAllServers() {
        return em.createQuery("SELECT x FROM Server x", Server.class).getResultList();
    }

    public List<Version> getAllVersions() {
        return em.createQuery("SELECT x FROM Version x", Version.class).getResultList();
    }

    public List<Installation> getAllInstallations() {
        return em.createQuery("SELECT x FROM Installation x").getResultList();
    }

    public Stage getStageForName(String name) {
        Query query = em.createQuery("Select x from Stage x where x.name = :name", Stage.class);
        query.setParameter("name", name);
        return (Stage) query.getSingleResult();
    }

    public int count() {
        return (int) em.createQuery("SELECT COUNT x FROM Stage x").getSingleResult();
    }

    public void addInstallation(Installiere installiere) {
        
        Installation installation = new Installation();
        //TODO abfüllen. 
        em.persist(installation );
    }

    public void addVersion(Version version) {
        em.persist(version);
    }

    // public Installation getInsForVers() {
    // return em.createQuery("SELECT x FROM ");
    // }
}
