/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Evento;
import Model.Odd;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
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
        EventoView ev = new EventoView();
        Evento e1 = new Evento("FC Porto", "SC Braga", new Date());
        Evento e2 = new Evento("FC Porto", "SC Braga", new Date());
        e1.setOdds(1,2,3);
        e2.setOdds(1, 2, 3);
        assertEquals(ev.viewEvento(e1), ev.viewEvento(e2)); 
    }
    
    
    /**
     * 2nd test of method testViewEvento, from class EventoView.
     */
    @Test
    public void testViewEvento2 (){
        System.out.println("viewEvento");
        EventoView ev = new EventoView();
        Evento e1 = new Evento("FC Porto", "SC Braga", new Date());
        Evento e2 = new Evento("FC Porto", "SC Braga", new Date());
        e1.setOdds(1,2,3);
        e2.setOdds(3,2,1);
        assertFalse("This should be false.",ev.viewEvento(e1).equals(ev.viewEvento(e2))); 
    }

    /**
     * Test of viewCreateEvento method, of class EventoView.
     */
    @Test
    public void testViewCreateEvento() {
        System.out.println("viewCreateEvento");
        EventoView ev = new EventoView();
        Evento e1 = viewCreateEventoFakeInput("FC Porto","SC Braga");
        Evento e2 = viewCreateEventoFakeInput("FC Porto","SC Braga");
        e1.setOdds(1,2,3);
        e2.setOdds(1,2,3);
        e1.setResultadoFinal(Evento.Resultado.VITORIA);
        e2.setResultadoFinal(Evento.Resultado.VITORIA);
        Date date = new Date();
        date.setTime(1234213);
        e1.setDataEvento(date);
        e2.setDataEvento(date);
        e2.setID(e1.getID());
        
        assertEquals(e1,e2);
    }
    
    @Test
    public void testViewCreateEvento2() {
        
        System.out.println("viewCreateEvento");
        
        Evento e1 = viewCreateEventoFakeInput("FC Porto","SC Braga");
        Evento e2 = viewCreateEventoFakeInput("SC Braga","FC Porto");
        e1.setOdds(1,2,3);
        e2.setOdds(1,2,3);
        assertFalse("This should be false", e1.equals(e2));
        
    }

    /**
     * Test of viewUpdateEvento method, of class EventoView.
     */
    @Test
    public void testViewUpdateEvento() {
        System.out.println("viewUpdateEvento");
        Date date = new Date(123423);
        Evento e1 = new Evento ("FC Porto", "SC Braga",date);
        Evento e2 = new Evento ("FC Barcelona","Real Madrid",date);
        e1.setResultadoFinal(Evento.Resultado.VITORIA);
        e2.setResultadoFinal(Evento.Resultado.VITORIA);
        e1.setOdds(1,2,3);
        e2.setOdds(1, 2, 3);
        e2.setID(e1.getID());
        viewUpdateEventoFakeInput(e1,"FC Barcelona", "Real Madrid");
        e1.setDataEvento(date);
        assertEquals(e1,e2);
    }
    
    
    /**
     * Similar method to viewCreateEquipa but with fake input instead.
     * @param equipa1 Name of the home team.
     * @param equipa2 Name of the away team.
     * @return The event created.
     */
    public Evento viewCreateEventoFakeInput(String equipa1, String equipa2){

        Evento ev = new Evento();
        String readinput;
        String data = equipa1+","+equipa2;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
        
        try {
            readinput = in.readLine();
            String[] tokens = readinput.split(",");
            ev.setEquipa2(tokens[1]);
            ev.setEquipa1(tokens[0]);
            ev.setDataEvento(Date.from(Instant.now()));
            return ev;
        } catch (IOException e) {e.printStackTrace();}
        return null;
        
    }
    
    /**
     * Similar method to viewUpdateEvento but with fake input instead.
     * @param ev Instance of the event to be updated.
     * @param equipa1 Name of the home team.
     * @param equipa2 Name of the away team.
     */
    public void viewUpdateEventoFakeInput(Evento ev, String equipa1, String equipa2){
        String readinput;
        String data = equipa1+","+equipa2;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
        try {
            readinput = in.readLine();
            String[] tokens = readinput.split(",");
            ev.setEquipa2(tokens[1]);
            ev.setEquipa1(tokens[0]);
            ev.setDataEvento(Date.from(Instant.now()));
        } catch (IOException e) {e.printStackTrace();}
    }

    
    
}
