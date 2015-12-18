/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
public class OddViewTest {
    
    public OddViewTest() {
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
     * Test of viewOdd method, of class OddView.
     */
    @Test
    public void testViewOdd() {
        System.out.println("viewOdd");
        OddView oddView = new OddView();
        
        Odd o1 = new Odd(1,2,3);
        Odd o2 = new Odd();
        o2.setOdd1(1);
        o2.setOddx(2);
        o2.setOdd2(3);
        
        assertEquals(oddView.viewOdd(o1),oddView.viewOdd(o2));
    }

    /**
     * Test of viewCreateAposta method, of class OddView.
     */
    @Test
    public void testViewCreateAposta() {
        System.out.println("viewCreateAposta");
        Odd o = viewCreateOddFakeInput("1,2,3");
        Odd o2 = new Odd(2,3,4);
        assertFalse("This should be false", o.equals(o2));
    }
    
    /**
     * 2nd Test of viewCreateAposta method, of class OddView.
     */
    @Test
    public void testViewCreateAposta2() {
        System.out.println("viewCreateAposta");
        Odd o = viewCreateOddFakeInput("1,2,3");
        Odd o2 = new Odd(1,2,3);
        assertEquals(o,o2);
    }

    /**
     * Test of viewUpdateOdd method, of class OddView.
     */
    @Test
    public void testViewUpdateOdd() {
        System.out.println("viewUpdateOdd");
        Odd o1 = new Odd(1,2,3);
        Odd o2 = new Odd(2,3,4);
        viewUpdateOddFakeInput(o2,"1,2,3");
        
        assertEquals(o1,o2);
    }
    
    /**
     * 2nd Test of viewUpdateOdd method, of class OddView.
     */
    @Test
    public void testViewUpdateOdd2() {
        System.out.println("viewUpdateOdd");
        Odd o1 = new Odd(1,2,3);
        Odd o2 = new Odd(1,2,3);
        viewUpdateOddFakeInput(o2,"2,3,4");
        
        assertFalse("This should be false",o1.equals(o2));
    }

    
    
    /**
     * Similar method to viewCreateOdd but with fake input instead.
     * @param data Fake Input.
     * @return Newly created Odds.
     */
    public Odd viewCreateOddFakeInput(String data){
        String readinput;
        Odd o = new Odd();
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduza as odds para vitória em casa, empate e vitória fora: odd1,oddx,odd2\n");
        try {
            readinput = in.readLine();
            String[] tokens = readinput.split(",");
            o.setOdd1(Float.parseFloat(tokens[0]));
            o.setOddx(Float.parseFloat(tokens[1]));
            o.setOdd2(Float.parseFloat(tokens[2]));
            return o;
        } catch (IOException e) {e.printStackTrace();}
        return null;
    }
    
    /**
     * Similar method to viewUpdateOdd but with fake input.
     * @param o Odds to be updated.
     * @param data Fake input.
     */
    public void viewUpdateOddFakeInput (Odd o, String data){
        String readinput;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduza as odds para vitória em casa, empate e vitória fora: odd1,oddx,odd2\n");
        try {
            readinput = in.readLine();
            String[] tokens = readinput.split(",");
            o.setOdd1(Float.parseFloat(tokens[0]));
            o.setOddx(Float.parseFloat(tokens[1]));
            o.setOdd2(Float.parseFloat(tokens[2]));
        } catch (IOException e) {e.printStackTrace();}
        
    }
    
}
