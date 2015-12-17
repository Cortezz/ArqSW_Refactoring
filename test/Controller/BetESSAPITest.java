/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aposta;
import Model.Apostador;
import Model.Evento;
import Model.Bookie;
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
        Bookie b = new Bookie("José");
        controller.fechaEvento(evento, '1',b);
        
        assertEquals(Evento.Resultado.VITORIA, evento.getResultadoFinal());
    }
    

    
    /**
     * Test of actualizaApostador method, of class BetESSAPI.
     */
    @Test
    public void testActualizaApostador() {
        System.out.println("actualizaApostador");
    }
}
