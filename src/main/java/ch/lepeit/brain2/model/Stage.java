package ch.lepeit.brain2.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * @author C925845
 * Wir später ersetzt. 
 */

@Entity
public class Stage implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private int Stage_ID;
    
    @Lob()
    private String Name;

    public int getStage_ID() {
        return Stage_ID;
    }

    public void setStage_ID(int stage_ID) {
        Stage_ID = stage_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static Stage values() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
