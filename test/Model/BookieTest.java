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
     * Test of getEventosSubscritos method, of class Bookie.
     */
    @Test
    public void testGetEventosSubscritos() {
        System.out.println("getEventosSubscritos");
        Evento e1 = new Evento("FC Porto","SC Braga", new Date(1241));
        //New HashMap with an event in it
        ListaEventos eventos1 = new ListaEventos();
        eventos1.addEvento(e1.getID(), e1);
        //Create b and subscrite to an event.
        Bookie b = new Bookie("Rodrigo");
        b.subscreveEvento(e1);
        assertEquals(eventos1.getListaEventos(), b.getEventosSubscritos());
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
     * Test of subscreveEvento method, of class Bookie.
     */
    @Test
    public void testSubscreveEvento() {
        System.out.println("subscreveEvento");
        Bookie instance = new Bookie("Leão");
        
        Evento e1 = new Evento("FC Porto","SC Braga", new Date(1241));
        e1.setBookieCriouEvento(instance);
        instance.subscreveEvento(e1);
        Evento e2 = new Evento("FC Porto","SC Braga", new Date(1241));
        e2.setBookieCriouEvento(instance);
        Evento e3 = instance.getEventosSubscritos().get(e1.getID());
        e3.setID(e2.getID());
        //Minor details
        e2.setResultadoFinal(Evento.Resultado.VITORIA);
        e3.setResultadoFinal(Evento.Resultado.VITORIA);
        e2.setOdds(1, 2, 3);
        e3.setOdds(1, 2, 3);
        
        
        
        assertEquals(e2,e3);
    }
    
    /**
     * 2nd Test of subscreveEvento method, of class Bookie.
     */
    @Test
    public void testSuscreveEvento2(){
        System.out.println("subscreveEvento");
        Evento e1 = new Evento("FC Porto","SC Braga", new Date(1241));
        Bookie instance = new Bookie("Leão");
        instance.subscreveEvento(e1);
        assertEquals(instance.getEventosSubscritos().size(),1);
        
    }

    /**
     * Test of removeSubscricao method, of class Bookie.
     */
    @Test
    public void testRemoveSubscricao() {
        System.out.println("removeSubscricao");
        Evento e1 = new Evento("FC Porto","SC Braga", new Date(1241));
        Evento e2 = new Evento("FC Porto","SC Braga", new Date(1241));
        Bookie instance = new Bookie("Leão");
        instance.subscreveEvento(e2);
        instance.subscreveEvento(e1);
        instance.removeSubscricao(e1.getID());
        Evento e3 = instance.getEventosSubscritos().get(e2.getID());
        assertEquals(e3,e2);
    }
    
    /**
     * Test of removeSubscricao method, of class Bookie.
     */
    @Test
    public void testRemoveSubscricao2 (){
        System.out.println("removeSubscricao");
        Evento e1 = new Evento("FC Porto","SC Braga", new Date(1241));
        Evento e2 = new Evento("FC Porto","SC Braga", new Date(1241));
        Bookie instance = new Bookie("Leão");
        instance.subscreveEvento(e2);
        instance.subscreveEvento(e1);
        instance.removeSubscricao(e1.getID());
        assertEquals(instance.getEventosSubscritos().size(),1);
        
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
        b1.subscreveEvento(e1);
        b2.subscreveEvento(e1);
        assertEquals(b1,b2);
    }
    
    /**
     * 2nd Test of equals method, of class Bookie.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Evento e1 = new Evento("FC Porto","SC Braga", new Date(1241));
        Bookie b1 = new Bookie("João");
        Bookie b2 = new Bookie();
        b2.setNome("João");
        b1.subscreveEvento(e1);
        b2.subscreveEvento(e1);
        b2.removeSubscricao(e1.getID());
        b2.subscreveEvento(e1);
        assertEquals(b1,b2);
    }
    
    /**
     * 3rd Test of equals method, of class Bookie.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Evento e1 = new Evento("FC Porto","SC Braga", new Date(1241));
        Bookie b1 = new Bookie("João");
        Bookie b2 = new Bookie();
        b2.setNome("João");
        b1.subscreveEvento(e1);
        b2.subscreveEvento(e1);
        b1.removeSubscricao(e1.getID());
        assertFalse("This should be false.", b1.equals(b2));
    }
    
    /**
     * 4th Test of equals method, of class Bookie.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals");
        Evento e1 = new Evento("FC Porto","SC Braga", new Date(1241));
        Bookie b1 = new Bookie("João");
        Bookie b2 = new Bookie();
        b2.setNome("João");
        b1.subscreveEvento(e1);
        b2.subscreveEvento(e1);
        b1.removeSubscricao(e1.getID());
        Evento e3 = new Evento("FC Porto","SC Braga", new Date());
        b1.subscreveEvento(e3);
        assertFalse("This should be false.", b1.equals(b2));
    }
    
}
