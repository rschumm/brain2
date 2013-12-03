package ch.lepeit.brain2;

import org.junit.Before;
import ch.lepeit.brain2.model.Stage;

public class BrainServiceTest {
    
    
    BrainService brainService = new BrainService(); 
    

    @Before
    public void setUp() throws Exception {
    }

//    @Test
    public void testGetAllStages() {
        Stage stage = brainService.getAllStages().get(1);
        
//        assertEquals(Stage.ACC, stage); 
        
    }

}
