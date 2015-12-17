/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Evento;
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
public class EventoViewTest {
    
    public EventoViewTest() {
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
     * Test of viewEvento method, of class EventoView.
     */
    @Test
    public void testViewEvento() {
        System.out.println("viewEvento");
        Evento e = null;
        EventoView instance = null;
        String expResult = "";
        String result = instance.viewEvento(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewCreateEvento method, of class EventoView.
     */
    @Test
    public void testViewCreateEvento() {
        System.out.println("viewCreateEvento");
        EventoView instance = null;
        Evento expResult = null;
        Evento result = instance.viewCreateEvento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewUpdateEvento method, of class EventoView.
     */
    @Test
    public void testViewUpdateEvento() {
        System.out.println("viewUpdateEvento");
        Evento ev = null;
        EventoView instance = null;
        instance.viewUpdateEvento(ev);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewDeleteEvento method, of class EventoView.
     */
    @Test
    public void testViewDeleteEvento() {
        System.out.println("viewDeleteEvento");
        Evento e = null;
        EventoView instance = null;
        instance.viewDeleteEvento(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
