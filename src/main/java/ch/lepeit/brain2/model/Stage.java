package ch.lepeit.brain2.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * @author C925845
 */

@Entity
public class Stage implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private int id;
    
    private String name;
    
    private String kurzName;

    public int getId() {
        return id;
    }

    public void setStage_ID(int stage_ID) {
        id = stage_ID;
    }

    public String getKurzName() {
        return kurzName;
    }

    public void setKurzName(String kurzName) {
        this.kurzName = kurzName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }
    
}
