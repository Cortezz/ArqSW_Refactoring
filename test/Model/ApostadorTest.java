/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cortez
 */
public class ApostadorTest {
    
    public ApostadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of equals method, of class Apostador.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Apostador a1 = new Apostador("José Filipe", "jfilipe@gmail.com", 1000);
        Apostador a2 = new Apostador("José Filipe", "jfilipe@gmail.com", 1000);
        
        assertTrue("This should be true", a1.equals(a2));
    }
    
    
    /**
     * 2nd test of equals method, of class Apostador.
     */
    @Test
    public void testeEquals2(){
        System.out.println("equals");
        
        Apostador a1 = new Apostador("Filipe", "jfilipe@gmail.com", 1000);
        Apostador a2 = new Apostador("José Filipe", "jfilipe@gmail.com", 1000);
        
        assertFalse("This should be false", a1.equals(a2));
        
    }
    
}
