/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.*;
import Model.Evento.Resultado;
import java.util.Date;
import java.util.Vector;
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
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    /**
     * Test of registaAposta method, of class Evento.
     */
    @Test
    public void testRegistaAposta() {
      System.out.println("registaAposta");
      //Creates a punter and a bet
      Apostador a = new Apostador ("José Felisberto", "Felisberto@gmail.com", 5);
      Aposta ap = new Aposta();
      //Associates bet with punter.
      ap.setApostador(a);
      ap.setResultado(Resultado.VITORIA);
      ap.setM_aposta(0.5f);
      ap.setOdd_fixada(new Odd());
      //Creates an event
      Evento e = new Evento ("FC Porto", "SC Braga", new Date());
      e.setOdds(1.2f, 4.4f, 6f);
      //Adds the bet
      e.registaAposta(ap);
      Vector<Aposta> apostas = e.getListaApostas();
      //List size must be 1
      assertEquals(apostas.size(),1);
    }

    /**
     * Test of actualizaOdd method, of class Evento.
     */
    @Test
    public void testUpdateOdds() {
        System.out.println("updateOdds");
        
        Evento e = new Evento ("FC Porto", "SC Braga", new Date());
        Evento e2 = new Evento ("Real Madrid", "FC Barcelona", new Date());
        
        e.updateOdds(4, 2, 3);
        //Odds from both events should be different
        assertFalse("This should fail.",e.getOdds().equals(e2.getOdds()));
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
     * Test of getEquipa1 method, of class Evento.
     */
    @Test
    public void testGetEquipa1() {
        System.out.println("getEquipa1");
        Evento e1 = new Evento ("FC Porto", "SC Braga", new Date());
        assertEquals (e1.getEquipa1(),"FC Porto");
    }

    /**
     * Test of getEquipa2 method, of class Evento.
     */
    @Test
    public void testGetEquipa2() {
       System.out.println("getEquipa2");
        Evento e1 = new Evento ("FC Porto", "SC Braga", new Date());
        assertEquals (e1.getEquipa2(),"SC Braga");
    }


    /**
     * Test of getResultadoFinal method, of class Evento.
     */
    @Test
    public void testGetResultadoFinal() {
        System.out.println("getResultadoFinal");
        Evento e1 = new Evento ("FC Porto", "SC Braga", new Date());
        e1.fechaEvento('x');
        assertEquals(e1.getResultadoFinal(),Resultado.EMPATE);
    }

    /**
     * Test of getID method, of class Evento.
     */
    @Test
    public void testIDAssingment() {
        System.out.println("ID Assignment");
        Evento e = new Evento ("FC Porto", "SC Braga", new Date());
        Evento e2 = new Evento ("Real Madrid", "FC Barcelona", new Date());
        
        assertTrue("This should be true.", e.getID()==e2.getID()-1);
    }



    /**
     * Test of setEquipa1 method, of class Evento.
     */
    @Test
    public void testSetEquipa1() {
        System.out.println("setEquipa1");
        Evento e = new Evento ("FC Porto", "SC Braga", new Date());
        e.setEquipa1("FC Barcelona");
        assertEquals("FC Barcelona", e.getEquipa1());
    }

    /**
     * Test of setEquipa2 method, of class Evento.
     */
    @Test
    public void testSetEquipa2() {
        System.out.println("setEquipa2");
        Evento e = new Evento ("FC Porto", "SC Braga", new Date());
        e.setEquipa2("FC Barcelona");
        assertEquals("FC Barcelona", e.getEquipa2());
    }


    /**
     * Test of fechaEvento method, of class Evento.
     */
    @Test
    public void testFechaEvento() {
        System.out.println("fechaEvento");
        Evento e1 = new Evento ("FC Porto", "SC Braga", new Date());
        e1.fechaEvento('x');
        assertEquals(e1.getStatus(),false);
    
    }
    
    @Test
    public void testEquals(){
        System.out.println("equals");
        Date date = new Date(12341234);
        Evento e1 = new Evento("FC Porto", "SC Braga",date);
        Evento e2 = new Evento("FC Porto", "SC Braga",date);
        
        e1.setResultadoFinal(Resultado.VITORIA);
        e2.setResultadoFinal(Resultado.VITORIA);
        e2.setID(e1.getID());
        
        assertTrue("This should be true.", e1.equals(e2));
    }

}
