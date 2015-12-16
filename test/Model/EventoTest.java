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
      Apostador a = new Apostador ("José Felisberto", "Felisberto@gmail.com", 5);
      Aposta ap = new Aposta();
      ap.setApostador(a);
      ap.setResultado(Resultado.VITORIA);
      ap.setM_aposta(0.5f);
      ap.setOdd_fixada(new Odd());
      Evento e = new Evento ("FC Porto", "SC Braga", new Date());
      e.setOdds(1.2f, 4.4f, 6f);
      e.registaAposta(ap);
      
      
      Vector<Aposta> apostas = e.getListaApostas();
      assertEquals(apostas.size(),1);
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
        e.actualizaOdd(4, 2, 3);
        
        
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

    /**
     * Test of getEquipa1 method, of class Evento.
     */
    @Test
    public void testGetEquipa1() {
        System.out.println("getEquipa1");
        Evento instance = new Evento();
        String expResult = "";
        String result = instance.getEquipa1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEquipa2 method, of class Evento.
     */
    @Test
    public void testGetEquipa2() {
        System.out.println("getEquipa2");
        Evento instance = new Evento();
        String expResult = "";
        String result = instance.getEquipa2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Evento.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Evento instance = new Evento();
        boolean expResult = false;
        boolean result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultadoFinal method, of class Evento.
     */
    @Test
    public void testGetResultadoFinal() {
        System.out.println("getResultadoFinal");
        Evento instance = new Evento();
        Resultado expResult = null;
        Resultado result = instance.getResultadoFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Evento.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Evento instance = new Evento();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOdds method, of class Evento.
     */
    @Test
    public void testGetOdds() {
        System.out.println("getOdds");
        Evento instance = new Evento();
        Odd expResult = null;
        Odd result = instance.getOdds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataEvento method, of class Evento.
     */
    @Test
    public void testGetDataEvento() {
        System.out.println("getDataEvento");
        Evento instance = new Evento();
        Date expResult = null;
        Date result = instance.getDataEvento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaApostas method, of class Evento.
     */
    @Test
    public void testGetListaApostas() {
        System.out.println("getListaApostas");
        Evento instance = new Evento();
        Vector<Aposta> expResult = null;
        Vector<Aposta> result = instance.getListaApostas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEquipa1 method, of class Evento.
     */
    @Test
    public void testSetEquipa1() {
        System.out.println("setEquipa1");
        String equipa1 = "";
        Evento instance = new Evento();
        instance.setEquipa1(equipa1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEquipa2 method, of class Evento.
     */
    @Test
    public void testSetEquipa2() {
        System.out.println("setEquipa2");
        String equipa2 = "";
        Evento instance = new Evento();
        instance.setEquipa2(equipa2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataEvento method, of class Evento.
     */
    @Test
    public void testSetDataEvento() {
        System.out.println("setDataEvento");
        Date dataEvento = null;
        Evento instance = new Evento();
        instance.setDataEvento(dataEvento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
     * Test of setEstado method, of class Evento.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        Evento instance = new Evento();
        instance.setEstado();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOdds method, of class Evento.
     */
    @Test
    public void testSetOdds() {
        System.out.println("setOdds");
        float odd_1 = 0.0F;
        float odd_x = 0.0F;
        float odd_2 = 0.0F;
        Evento instance = new Evento();
        instance.setOdds(odd_1, odd_x, odd_2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
