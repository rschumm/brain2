package control;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;

import ch.lepeit.brain2.model.Version;

import ch.lepeit.brain2.BrainService;

@Named
//scope.... 
public class Controller {

    @Inject
    private Logger log;

    @Inject
    private BrainService brainService;
    
    public void machNeueVersion(){
        
        Version version = null;
        //bla bla
        brainService.addVersion(version); 
        
        
    }
    
}
