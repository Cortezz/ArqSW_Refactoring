/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
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
public class EventoTest {
    
    public EventoTest() {
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
     * Test of fechaEvento method, of class Evento.
     */
    @Test
    public void testFechaEvento() {
        System.out.println("fechaEvento");
        char resultadofinal = ' ';
        Evento instance = new Evento();
        boolean expResult = false;
        boolean result = instance.fechaEvento(resultadofinal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registaAposta method, of class Evento.
     */
    @Test
    public void testRegistaAposta() {
      System.out.println("registaAposta");
      Apostador a = new Apostador ("José Felisberto", "Felisberto@gmail.com", 5);
      Evento e = new Evento ("FC Porto", "SC Braga", new Date());
      e.setOdds(1.2f, 4.4f, 6f);
      e.registaAposta(a);
      //Adicionar getListaApostas()
      //assertEquals(e.getListaApostas().size(),1);
    }

    /**
     * Test of actualizaOdd method, of class Evento.
     */
    @Test
    public void testActualizaOdd() {
        System.out.println("actualizaOdd");
        int odd1 = 0;
        int oddx = 0;
        int odd2 = 0;
        Evento e = new Evento ("FC Porto", "SC Braga", new Date());
        
        Evento instance = new Evento();
        boolean expResult = false;
        boolean result = instance.actualizaOdd(odd1, oddx, odd2);
        assertEquals(expResult, result);
    }

    /**
     * Test of notifyApostadores method, of class Evento.
     */
    @Test
    public void testNotifyApostadores() {
        System.out.println("notifyApostadores");
        Evento instance = new Evento();
        instance.notifyApostadores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /**
     * Test of updateOdds method, of class Evento.
     */
    @Test
    public void testUpdateOdds() {
        System.out.println("updateOdds");
        float odd_1 = 0.0F;
        float odd_x = 0.0F;
        float odd_2 = 0.0F;
        Evento instance = new Evento();
        instance.updateOdds(odd_1, odd_x, odd_2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
