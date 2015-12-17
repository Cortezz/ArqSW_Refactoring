/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BetESSAPI;
import Model.Aposta;
import Model.Apostador;
import Model.Evento;
import Model.Odd;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class ApostaViewTest {
    
    public ApostaViewTest() {
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
     * Test of viewAposta method, of class ApostaView.
     */
    @Test
    public void testViewAposta() {
        System.out.println("viewAposta");
        BetESSAPI controller = new BetESSAPI();
        ApostaView av = new ApostaView(controller);
        Aposta a = new Aposta();
        Apostador a1 = new Apostador("José","j@gmail.com",1000);
        a.setApostador(a1);
        a.setM_aposta(0.5f);
        a.setOdd_fixada(new Odd(3,2,1));
        String result = av.viewAposta(a);
        String result2 = av.viewAposta(a);
        
        assertEquals(result, result2);
    }
    
    /**
     * Test of viewAposta method, of class ApostaView
     */
    @Test
    public void testViewAposta2(){
        System.out.println("viewAposta2");
         BetESSAPI controller = new BetESSAPI();
        ApostaView av = new ApostaView(controller);
        Aposta a = new Aposta();
        Apostador a1 = new Apostador("José","j@gmail.com",1000);
        a.setApostador(a1);
        a.setM_aposta(0.5f);
        a.setOdd_fixada(new Odd(3,2,1));
        String result = av.viewAposta(a);
        a.setM_aposta(1f);
        String result2 = av.viewAposta(a);
        
        assertFalse("This should be false", result.equals(result2));
    }

    /**
     * Test of viewCreateAposta method, of class ApostaView.
     */
    @Test
    public void testViewCreateAposta() {
        System.out.println("viewCreateAposta");
        Aposta a1 = viewCreateApostaFakeInput("5000","x");
        Aposta a2 = viewCreateApostaFakeInput("5000","x");
        Apostador a = new Apostador("José","j@gmail.com",1000);
        a1.setApostador(a);
        a2.setApostador(a);
        Odd o = new Odd(1,2,3);
        a1.setOdd_fixada(o);
        a2.setOdd_fixada(o);
        assertEquals(a1,a2);
    }
    
    /**
     * Second test of viewCreateAposta method, of Class ApostaView.
     */
    @Test
    public void testeViewCreateAposta2(){
        System.out.println("viewCreateAposta");
        Aposta a1 = viewCreateApostaFakeInput("5000","x");
        Aposta a2 = viewCreateApostaFakeInput("5000","x");
        Apostador ap1 = new Apostador("José","j@gmail.com",1000);
        Apostador ap2 = new Apostador("Fernando","j@gmail.com",1000);
        a1.setApostador(ap1);
        a2.setApostador(ap2);
        Odd o = new Odd(1,2,3);
        a1.setOdd_fixada(o);
        a2.setOdd_fixada(o);
        assertFalse("This should be false", a1.equals(a2));
        
    }

    /**
     * Test of viewUpdateAposta method, of class ApostaView.
     */
    @Test
    public void testViewUpdateAposta() {
        Aposta a1 = viewCreateApostaFakeInput("5000","x");
        Apostador ap1 = new Apostador("José","j@gmail.com",1000);
        Odd o = new Odd(1,2,3);
        a1.setApostador(ap1);
        a1.setOdd_fixada(o);
        
        Aposta a2 = viewCreateApostaFakeInput("5000","x");
        a2.setApostador(ap1);
        a2.setOdd_fixada(o);
        a2.setM_aposta(1000f);
        a2.setResultado(Evento.Resultado.DERROTA);
        
        viewUpdateApostaFakeInput(a1,"1000","2");
        assertEquals(a1,a2);
    }
    
       
    /**
     * Method similar to the viewCreateAposta method, but it takes fake input instead of input from the stdin.
     * @param montante Value of the bet.
     * @param resultado Outcome of the bet.
     * @return The bet created.
     */
     public Aposta viewCreateApostaFakeInput(String montante, String resultado){
        String readinput;
        Aposta a = new Aposta();
        System.out.println("Introduza o resultado e o montante a apostar: montante, resultado\n");
        String data = montante +","+resultado;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            readinput = in.readLine();
            String[] tokens = readinput.split(",");
            switch (tokens[1]) {
                    case "1":
                            a.setResultado(Evento.Resultado.VITORIA);
                            break;
                    case "x":
                            a.setResultado(Evento.Resultado.EMPATE);
                            break;
                    case "2":
                            a.setResultado(Evento.Resultado.DERROTA);
                            break;
            }
            a.setM_aposta(Float.parseFloat(tokens[0]));
            return a;
        } catch (IOException e) {e.printStackTrace();}
        return null;
    }
     
     
     /**
      * Similar method to the viewUpdateAposta method, but takes fake input instead.
      * @param a Instance of the bet to be updated.
      * @param montante Value of the bet.
      * @param resultado Outcome chosen by the punter for the bet.
      */
     public void viewUpdateApostaFakeInput(Aposta a, String montante, String resultado){
        String readinput;
        System.out.println("Introduza o resultado e o montante a apostar: montante, resultado\n");
        String data = montante +","+resultado;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            readinput = in.readLine();
            String[] tokens = readinput.split(",");
            System.out.println(tokens.length);
            switch (tokens[1]) {
                    case "1":
                            a.setResultado(Evento.Resultado.VITORIA);
                            break;
                    case "x":
                            a.setResultado(Evento.Resultado.EMPATE);
                            break;
                    case "2":
                            a.setResultado(Evento.Resultado.DERROTA);
                            break;
            }
            a.setM_aposta(Float.parseFloat(tokens[0]));
        } catch (IOException e) {e.printStackTrace();}
    }
    
}
