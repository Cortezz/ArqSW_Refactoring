/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
import java.util.Map;
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
public class ListaApostadoresTest {
    
    public ListaApostadoresTest() {
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
     * Test of getListaApostadores method, of class ListaApostadores.
     */
    @Test
    public void testGetListaApostadores() {
        System.out.println("getListaApostadores");
        //adds a punter into a hashmap
        ListaApostadores instance = new ListaApostadores();
        Apostador a = new Apostador("Jose","f@gmail.com",1000);
        instance.addApostador(a.getEmail(), a);
        //Same punter into another hashmap
        HashMap<String,Apostador> test= new HashMap<>();
        test.put(a.getEmail(),a);
        //Both structures must be the same
        assertTrue("This should be true", instance.listaApostadoresEquals(test));
    }

    /**
     * Test of addApostador method, of class ListaApostadores.
     */
    @Test
    public void testAddApostador() {
        System.out.println("addApostador");
        
        //adds a punter
        Apostador a = new Apostador("Jose","f@gmail.com",1000);
        ListaApostadores instance = new ListaApostadores();
        instance.addApostador(a.getEmail(),a);
        //list size must be 1
        assertEquals(instance.getListaApostadores().size(),1);
    }

    /**
     * Test of removeApostador method, of class ListaApostadores.
     */
    @Test
    public void testRemoveApostador() {
        System.out.println("removeApostador");
        
        Apostador a = new Apostador("Jose","f@gmail.com",1000);
        ListaApostadores instance = new ListaApostadores();
        
        //Adds and removes the same punter
        instance.addApostador(a.getEmail(),a);
        instance.removeApostador(a.getEmail());
        //List size must be 0
        assertEquals(instance.getListaApostadores().size(),0);
    }
    
}
