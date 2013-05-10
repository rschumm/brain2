package ch.lepeit.brain2;

import java.util.Arrays;
import java.util.List;

public class BrainService {

    public List<Stage> getAllStages() {
        return Arrays.asList(Stage.values()); 
    }

}
