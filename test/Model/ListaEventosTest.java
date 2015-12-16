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
        instance.addEvento(e1.getID(),e1);
        HashMap<Integer,Evento> test= new HashMap<>();
        test.put(e1.getID(),e1);
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
        instance.addEvento(e.getID(),e);
        
        assertEquals(instance.getListaEventos().size(),1);
    }
    
}
