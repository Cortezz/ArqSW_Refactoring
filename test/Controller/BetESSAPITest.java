/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aposta;
import Model.Apostador;
import Model.Evento;
import Controller.BetESSAPI;
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
public class BetESSAPITest {
    
    public BetESSAPITest() {
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
     * Test of setResultadoDaAposta method, of class BetESSAPI.
     */
    @Test
    public void testSetResultadoDaAposta() {
        System.out.println("setResultadoDaAposta");
        BetESSAPI controller = new BetESSAPI();
        Aposta instance = new Aposta();
        controller.setResultadoDaAposta(instance, Evento.Resultado.VITORIA);
        
        assertEquals(Evento.Resultado.VITORIA, instance.getResultado());
        
    }
    
    /**
     * Test of fechaEvento method, of class BetESSAPI.
     */
    @Test
    public void testFechaEvento() {
        System.out.println("fechaEvento");
        Evento evento = new Evento();
        BetESSAPI controller = new BetESSAPI();
        controller.fechaEvento(evento, '1');
        
        assertEquals(Evento.Resultado.VITORIA, evento.getResultadoFinal());
    }
    

    /**
     * Test of registaEvento method, of class BetESSAPI.
     */
    @Test
    public void testRegistaEvento_0args() {
        System.out.println("registaEvento");
        BetESSAPI instance = new BetESSAPI();
        Evento expResult = null;
        Evento result = instance.registaEvento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    

    /**
     * Test of registaApostador method, of class BetESSAPI.
     */
    @Test
    public void testRegistaApostador_3args() {
        System.out.println("registaApostador");
        String nome = "";
        String email = "";
        double coins = 0.0;
        BetESSAPI instance = new BetESSAPI();
        Apostador expResult = null;
        Apostador result = instance.registaApostador(nome, email, coins);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registaApostador method, of class BetESSAPI.
     */
    @Test
    public void testRegistaApostador_0args() {
        System.out.println("registaApostador");
        BetESSAPI instance = new BetESSAPI();
        Apostador expResult = null;
        Apostador result = instance.registaApostador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizaApostador method, of class BetESSAPI.
     */
    @Test
    public void testActualizaApostador() {
        System.out.println("actualizaApostador");
        Apostador apostador = null;
        BetESSAPI instance = new BetESSAPI();
        Apostador expResult = null;
        Apostador result = instance.actualizaApostador(apostador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteApostador method, of class BetESSAPI.
     */
    @Test
    public void testDeleteApostador() {
        System.out.println("deleteApostador");
        Apostador apostador = null;
        BetESSAPI instance = new BetESSAPI();
        boolean expResult = false;
        boolean result = instance.deleteApostador(apostador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
