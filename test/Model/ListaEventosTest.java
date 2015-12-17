/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
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
public class ListaEventosTest {
    
    public ListaEventosTest() {
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
     * Test of getListaEventos method, of class ListaEventos.
     */
    @Test
    public void testGetListaEventos() {
        System.out.println("getListaEventos");
        ListaEventos instance = new ListaEventos();
        Evento e1 = new Evento ("FC Porto", "SC Braga", new Date());
        //Adds an event
        instance.addEvento(e1.getID(),e1);
        //Another hashmap is created and the same event is added.
        HashMap<Integer,Evento> test= new HashMap<>();
        test.put(e1.getID(),e1);
        
        //Maps must be the same.
        assertTrue("This should be true", instance.listaEventosEquals(test));
    }

    /**
     * Test of addEvento method, of class ListaEventos.
     */
    @Test
    public void testAddEvento() {
        System.out.println("addEvento");
        Evento e = new Evento ("FC Porto", "SC Braga", new Date());
        ListaEventos instance = new ListaEventos();
        //adds an event
        instance.addEvento(e.getID(),e);
        //List size must be 1
        assertEquals(instance.getListaEventos().size(),1);
    }
    
    
    /**
     * Test of removeEvento method, of class ListaEventos.
     */
    @Test
    public void testRemoveEvento (){
        System.out.println("RemoveEvento");
        Evento e = new Evento ("FC Porto", "SC Braga", new Date());
        Evento e2 = new Evento ("FC Porto", "SC Braga", new Date());
        ListaEventos instance = new ListaEventos();
        //adds two events
        instance.addEvento(e.getID(),e);
        instance.addEvento(e2.getID(),e2);
        //Removes one
        instance.removeEvento(e.getID());
        //There must be one element remaining.
        assertEquals(instance.getListaEventos().size(),1);
        
        
    }
    
}
