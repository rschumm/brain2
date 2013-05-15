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
    private int ID;
    
    private String Name;

    public int getStage_ID() {
        return ID;
    }

    public void setStage_ID(int stage_ID) {
        ID = stage_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    
}
