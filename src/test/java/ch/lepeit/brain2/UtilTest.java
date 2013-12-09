package ch.lepeit.brain2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ch.lepeit.brain2.util.Util;

public class UtilTest {
    
    


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testUtil() {
        int add = Util.add(1, 1);
        assertEquals(2, add);        
    }

}