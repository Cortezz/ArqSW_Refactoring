/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Bookie;
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
public class BookieViewTest {
    
    public BookieViewTest() {
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
     * Test of viewBookie method, of class BookieView.
     */
    @Test
    public void testViewBookie() {
        BookieView bv = new BookieView();
        System.out.println("viewBookie");
        Bookie b = new Bookie("José");
        Bookie b2 = new Bookie("Firmino");
        assertFalse("This should be false.", bv.viewBookie(b).equals(bv.viewBookie(b2)));
    }
    
    /**
     * 2nd test of viewBookie method, of class BookieView.
     */
    @Test
    public void testViewBookie2 (){
        BookieView bv = new BookieView();
        System.out.println("viewBookie");
        Bookie b = new Bookie("José");
        Bookie b2 = new Bookie();
        b2.setNome("José");
        assertEquals(bv.viewBookie(b), bv.viewBookie(b2));
        
    }

    /**
     * Test of viewCreateBookie method, of class BookieView.
     */
    @Test
    public void testViewCreateBookie() {
        System.out.println("viewCreateBookie");
        Bookie b = viewCreateBookieFakeInput("Armeno");
        BookieView bv = new BookieView();
        System.out.println(bv.viewBookie(b));
        assertEquals(b.getNome(), "Armeno");
    }

    /**
     * Test of viewUpdateBookie method, of class BookieView.
     */
    @Test
    public void testViewUpdateBookie() {
        System.out.println("viewUpdateBookie");
        Bookie b = viewCreateBookieFakeInput("Armeno");
        viewUpdateBookieFakeInput(b,"Rodrigo");
        assertEquals(b.getNome(),"Rodrigo");
    }

    
    
    /**
     * Similar method to viewCreateBookie but receiving fake input instead.
     * @param nome Name of the bookie.
     * @return Newly created Bookie.
     */
    public Bookie viewCreateBookieFakeInput(String nome){
        String readinput;
        Bookie b = new Bookie();
        System.setIn(new ByteArrayInputStream(nome.getBytes()));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduza o nome do Bookie: \n");
        try {
            readinput = in.readLine();
            b.setNome(readinput);
            return b;
        } catch (IOException e) {e.printStackTrace();}
        return null;
    }
    
    /**
     * Similar method to viewUpdateBookieFakeInput but receiving fake input instead.
     * @param b Instance of the bookie to be updated.
     * @param nome Name of the bookie.
     */
    public void viewUpdateBookieFakeInput (Bookie b, String nome){
        String readinput;
        System.setIn(new ByteArrayInputStream(nome.getBytes()));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Introduza o nome do Bookie:\n");
        try {
            readinput = in.readLine();
            b.setNome(readinput);
        } catch (IOException e) {e.printStackTrace();}
        
    }
    
}
