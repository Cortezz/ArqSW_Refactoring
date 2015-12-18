/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BetESSAPI;
import Model.Apostador;
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
public class ApostadorViewTest {
    
    public ApostadorViewTest() {
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
     * Test of viewCreateApostador method, of class ApostadorView.
     */
    @Test
    public void testViewCreateApostador() {
        System.out.println("viewCreateApostador");
        BetESSAPI controller = new BetESSAPI();
        ApostadorView av = new ApostadorView(controller);
        Apostador a = viewCreateApostadorFakeInput("josé,j@gmail.com,1000");
        Apostador a2 = viewCreateApostadorFakeInput("josé,j@gmail.com,1000");
        
        assertEquals(a,a2);
    }
    
    /**
     * 2nd test of viewCreateApostador method, of class ApostadorView.
     */
    @Test
    public void testViewCreateApostador2 () {
        System.out.println("viewCreateApostador");
        BetESSAPI controller = new BetESSAPI();
        ApostadorView av = new ApostadorView(controller);
        Apostador a = viewCreateApostadorFakeInput("josé,j@gmail.com,1000");
        Apostador a2 = viewCreateApostadorFakeInput("filipe,j@gmail.com,1000");
        
        assertFalse("This should be false",a.equals(a2));
    }

    /**
     * Test of viewUpdateApostador method, of class ApostadorView.
     */
    @Test
    public void testViewUpdateApostador() {
        System.out.println("viewUpdateApostador");
        BetESSAPI controller = new BetESSAPI();
        ApostadorView av = new ApostadorView(controller);
        Apostador a = new Apostador("josé","j@gmail.com",1000.0);
        Apostador a2 = new Apostador("filipe","j@gmail.com",1002);
        viewUpdateApostadorFakeInput(a, "filipe,j@gmail.com,1002.0");
        assertEquals(a,a2);
        
    }

    /**
     * Test of viewApostador method, of class ApostadorView.
     */
    @Test
    public void testViewApostador() {
        System.out.println("viewApostador");
        BetESSAPI controller = new BetESSAPI();
        ApostadorView av = new ApostadorView(controller);
        Apostador a = new Apostador("josé","j@gmail.com",1000);
        Apostador a2 = new Apostador("josé","j@gmail.com",1000);
        assertEquals (av.viewApostador(a), av.viewApostador(a2));
    }
    
    
    
    /**
     * Similar method to viewCreateApostador, but with fake input instead.
     * @param nome Name of the punter.
     * @param email E-mail of the punter.
     * @param coins Amount of coins the punter has.
     * @return The punter created.
     */
    public Apostador viewCreateApostadorFakeInput(String data){

            String readinput;
            Apostador a = new Apostador();
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Introduza os seguintes dados de Apostador: (Nome, email, montante betESScoins\n");
            try {
                    readinput = in.readLine();
                    String[] tokens = readinput.split(",");
                    a.setName(tokens[0]);
                    a.setEmail(tokens[1]);
                    a.setBetESScoins(Double.parseDouble(tokens[2]));
                    return a;
            } catch (IOException e) {e.printStackTrace();}
            return null;
	}
    
    
        /**
         * Similar method to viewUpdateApostador, but takes fake input instead.
         * @param a Punter to be updtated.
         * @param email E-mail of the punter.
         * @param nome Name of the punter. 
         * @param coins Amount of coins the punter has.
         */
	public void viewUpdateApostadorFakeInput(Apostador a, String data){
            
            String readinput;
            System.out.print("Introduza novos dados de Apostador: (Nome("
                    +a.getName()+"), email("+a.getEmail()+"), montante betESScoins("+ a.getBetESScoins()+")\n");
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {
                readinput = in.readLine();
                String[] tokens = readinput.split(",");
                a.setName(tokens[0]);
                a.setEmail(tokens[1]);
                a.setBetESScoins(Double.parseDouble(tokens[2]));

            } catch (IOException e) { e.printStackTrace();}
	}
    
}
