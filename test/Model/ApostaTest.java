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
public class ApostaTest {
    
    public ApostaTest() {
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
     * Test of getApostador method, of class Aposta.
     */
    @Test
    public void GetAndSettestApostador() {
        System.out.println("GetAndSetApostador");
        Aposta a = new Aposta();
        Apostador ap = new Apostador();
        a.setApostador(ap);
        assertTrue("This should be true", ap.equals(a.getApostador()));
        
    }

    /**
     * Test of getResultado method, of class Aposta.
     */
    @Test
    public void testGetResultado() {
        System.out.println("getResultado");
        Aposta instance = new Aposta();
        instance.setResultado(Evento.Resultado.DERROTA);
        assertEquals(Evento.Resultado.DERROTA, instance.getResultado());
    }
    
    /**
     * Test of setOdd_fixada method, of class Aposta.
     */
    @Test
    public void testSetOdd_fixada() {
        System.out.println("setOdd_fixada");
        Odd odd_fixada = new Odd(3,2,1);
        Aposta instance = new Aposta();
        instance.setOdd_fixada(odd_fixada);
        assertEquals(new Odd(3,2,1), instance.getOdd_fixada());
    }
    /**
     * Test of equals method, of class Aposta.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Apostador jose = new Apostador ("jose", "jose@gmail.com", 1000f);
        Odd odd = new Odd(3,2,1);
        Aposta a1 = new Aposta(jose, 5f, '2', odd);
        Aposta a2 = new Aposta();
        a2.setApostador(jose);
        a2.setValor(5f);
        a2.setOdd_fixada(new Odd(3,2,1));
        a2.setResultado(Evento.Resultado.DERROTA);
        assertEquals(a1,a2);
    }
    
}
