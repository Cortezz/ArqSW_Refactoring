/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Evento;
import Model.ListaEventos;
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
public class BookieTest {
    
    public BookieTest() {
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
     * Test of setNome method, of class Bookie.
     */
    @Test
    public void testSetAndGetNome() {
        System.out.println("setNome");
        Bookie instance = new Bookie("Rodrigo");
        instance.setNome("Filipe");
        assertEquals(instance.getNome(),"Filipe");
    }

    
    

  
    /**
     * Test of equals method, of class Bookie.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Evento e1 = new Evento("FC Porto","SC Braga", new Date(1241));
        Bookie b1 = new Bookie("João");
        Bookie b2 = new Bookie();
        b2.setNome("João");
        assertEquals(b1,b2);
    }
    
}
