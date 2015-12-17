package View;

import Controller.BetESSAPI;
import Model.Bookie;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Class responsible for the output of a bookie's data.
 * @author José Cortez
 */
public class BookieView {
     
    private  BufferedReader in;
    private PrintStream out;
    private BetESSAPI controller;
    
    /**
     * Implicit stdin and stdout initialization.
     * @param betESS Controller to be added as a reference.
     */
    public BookieView (BetESSAPI betESS) {
        this.in = new BufferedReader(new InputStreamReader(System.in));
	this.out = System.out;
        this.controller = betESS;
    }
    
    /** 
     * Empty Constructor.
     */
    public BookieView (){
        this.in = new BufferedReader(new InputStreamReader(System.in));
	this.out = System.out;
    }
    
    
    /** CRUD Methods **/
    
    
    /**
     * View - Read Method.
     * @param b Bookie to be read.
     * @return ToString-esque string.
     */
    public String viewBookie(Bookie b) {
        
        return "Bookie{" +
            "Nome='" + b.getNome() +
            '}';
    }
    
    
    /**
     * View - Create Method.
     * @return Newly created bookie.
     */
    public Bookie viewCreateBookie(){
        String readinput;
        Bookie b = new Bookie();
        this.out.println("Introduza o nome do Bookie: \n");
        try {
            readinput = this.in.readLine();
            b.setNome(readinput);
            return b;
        } catch (IOException e) {e.printStackTrace();}
        return null;
    }
    
    
    /**
     * View - Update Method.
     * @param b Bookie to be updated.
     */
    public void viewUpdateBookie (Bookie b){
        String readinput;
	this.out.println("Introduza o nome do Bookie:\n");
        try {
            readinput = this.in.readLine();
            b.setNome(readinput);
        } catch (IOException e) {e.printStackTrace();}
        
    }
    
    /**
     * View - Delete Method.
     * @param a Bookie to be deleted.
     */
    public void viewDeleteAposta (Bookie b){
        this.out.println("Remover Bookie: "+this.viewBookie(b));
        
    }
    
}
