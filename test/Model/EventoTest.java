/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.*;
import Model.Evento.Resultado;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
      Apostador a = new Apostador ("José Felisberto", "Felisberto@gmail.com", 5f);
      Aposta ap = new Aposta();
      //Associates bet with punter.
      ap.setApostador(a);
      ap.setResultado(Resultado.VITORIA);
      ap.setValor(0.5f);
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
        Evento e1 = new Evento("FC Porto","SC Braga", new Date());
        e1.setOdds(1, 2, 3);
        Apostador a1 = new Apostador("Josa","j@gmail.com",1000f);
        Apostador a2 = new Apostador("Filipe","f@gmail.com",1000f);
        
        Aposta ap1 = new Aposta(a1, 50, 'x', e1.getOdds());
        Aposta ap2 = new Aposta(a2, 50, '1', e1.getOdds());
        Aposta ap3 = new Aposta(a2, 100,'x', e1.getOdds());
        Aposta ap4 = new Aposta(a1, 150,'2', e1.getOdds());
        Aposta ap5 = new Aposta(a2, 200,'2', e1.getOdds());
        Aposta ap6 = new Aposta(a1,1500,'x',e1.getOdds());
        
        e1.registaAposta(ap1);
        e1.registaAposta(ap2);
        e1.registaAposta(ap3);
        e1.registaAposta(ap4);
        e1.registaAposta(ap5);
        e1.registaAposta(ap6);
        
        
        PrintStream original = new PrintStream(System.out); 
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        e1.fechaEvento('x');
        
        //Array List with the name and prize
        ArrayList<String> tokens = getTokens(outContent.toString(),original);
        //"Artificial array"
        ArrayList<String> tokens2 = new ArrayList<String>();
         //#1
        tokens2.add("Josa");
        tokens2.add("100.0");
        //#2
        tokens2.add("Filipe");
        tokens2.add("0.0");
        //#3
        tokens2.add("Filipe");
        tokens2.add("200.0");
        //#4
        tokens2.add("Josa");
        tokens2.add("0.0");
        //#5
        tokens2.add("Filipe");
        tokens2.add("0.0");
        //#6
        tokens2.add("Josa");
        tokens2.add("3000.0");
        
        original.println(printArray(tokens));
        original.println(printArray(tokens2));
        
        assertTrue("This should be true", arrayListEquals(tokens, tokens2));
    }
    
    
    
    public ArrayList<String> getTokens (String s, PrintStream ps){
        int inicio=0, fim=0,limit;
        
        String nome,f;
        ArrayList<String> res = new ArrayList<>();
        limit = charOccurrences(s,'\n')/3;
        
        s.split("\n\n");
        for (int i=0; i<limit;i++){
            nome = s.substring(s.indexOf("(",inicio) + 1, s.indexOf(")",inicio));
            fim = s.indexOf("\n",s.indexOf(":",inicio));
            f = s.substring(s.indexOf(":",inicio)+1, fim);
            inicio = fim;
            res.add(nome);
            res.add(f);
        }
            
        return res;
    }
    
    public int charOccurrences (String s, char c){
        int count = 0;
        for(int i=0;i<s.length();i++)
            if ((char)(s.charAt(i)) == c)
                    count++;
        
        return count;
        
    }
    
    public boolean arrayListEquals (ArrayList<String> l1, ArrayList<String> l2) {
        if (l1.size()!=l2.size()) return false;
        for (int i=0;i<l1.size();i++)
            if (!l1.get(i).equals(l2.get(i))) return false;
        return true;
     }
    
    public String printArray (ArrayList<String> l){
        int i;
        StringBuilder sb = new StringBuilder();
        for (i=0;i<l.size();i++)
            sb.append(i).append(" - ").append(l.get(i)).append("\n");
        return sb.toString();
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
