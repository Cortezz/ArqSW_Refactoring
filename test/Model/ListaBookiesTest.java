/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.HashMap;
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
public class ListaBookiesTest {
    
    public ListaBookiesTest() {
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
     * Test of getListaBookies method, of class ListaBookies.
     */
    @Test
    public void testGetListaBookies() {
        System.out.println("getListaBookies");
        ListaBookies instance = new ListaBookies();
        Bookie b1 = new Bookie("José");
        instance.addBookie(b1.getNome(),b1);
        //Another hashmap is created and the same bookie is added.
        HashMap<String,Bookie> test= new HashMap<>();
        test.put(b1.getNome(),b1);
        
        //Maps must be the same.
        assertTrue("This should be true", instance.listaBookiesEquals(test));
    }

    /**
     * Test of addBookie method, of class ListaBookies.
     */
    @Test
    public void testAddBookie() {
        System.out.println("addBookie");
        Bookie b = new Bookie("José");
        ListaBookies instance = new ListaBookies();
        //adds a bookie
        instance.addBookie(b.getNome(),b);
        //List size must be 1
        assertEquals(instance.getListaBookies().size(),1);
    }
    
    
    /**
     * Test of removeBookie method, of class ListaBookies.
     */
    @Test
    public void testRemoveBookie (){
        System.out.println("RemoveBookie");
        Bookie b1 = new Bookie("José");
        Bookie b2 = new Bookie("António");
        Evento e = new Evento ("FC Porto", "SC Braga", new Date());
        Evento e2 = new Evento ("FC Porto", "SC Braga", new Date());
        ListaBookies instance = new ListaBookies();
        //adds two bookies
        instance.addBookie(b1.getNome(),b1);
        instance.addBookie(b2.getNome(),b2);
        //Removes one
        instance.removeBookie(b2.getNome());
        //There must be one element remaining.
        assertEquals(instance.getListaBookies().size(),1);
        
        
    }
}
