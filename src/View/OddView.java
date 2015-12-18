/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BetESSAPI;
import Model.Odd;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *
 * @author José Cortez
 */
public class OddView {
    
    private  BufferedReader in;
    private PrintStream out;
    private BetESSAPI controller;
    
    /**
     * Implicit stdin and stdout initialization.
     * @param betESS Controller to be added as a reference.
     */
    public OddView (BetESSAPI betESS) {
        this.in = new BufferedReader(new InputStreamReader(System.in));
	this.out = System.out;
        this.controller = betESS;
    }
    
    /** 
     * Empty Constructor.
     */
    public OddView (){
        this.in = new BufferedReader(new InputStreamReader(System.in));
	this.out = System.out;
    }
    
    
    /** CRUD Methods **/
    
    /**
     * View - Read Method.
     * @param a Odds to be read.
     * @return ToString-esque string.
     */
    public String viewOdd(Odd o) {
        return "Odd{" +
            "1=" + o.getOdd1() +
            ",X=" + o.getOddx() +
            ",2=" + o.getOdd2() +
            '}';
    }
    
    
    /**
     * View - Create Method.
     * @return Newly created odds.
     */
    public Odd viewCreateOdd(){
        String readinput;
        Odd o = new Odd();
        this.out.println("Introduza as odds para vitória em casa, empate e vitória fora: (odd1,oddx,odd2)\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");
            o.setOdd1(Float.parseFloat(tokens[0]));
            o.setOddx(Float.parseFloat(tokens[1]));
            o.setOdd2(Float.parseFloat(tokens[2]));
            return o;
        } catch (IOException e) {e.printStackTrace();}
        return null;
    }
    
    
    /**
     * View - Update Method.
     * @param o Odds to be updated.
     */
    public Odd viewUpdateOdd(Odd o){
        String readinput;
        this.out.println("Introduza as odds para vitória em casa, empate e vitória fora: odd1,oddx,odd2\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");
            o.setOdd1(Float.parseFloat(tokens[0]));
            o.setOddx(Float.parseFloat(tokens[1]));
            o.setOdd2(Float.parseFloat(tokens[2]));
        } catch (IOException e) {e.printStackTrace();}
        return null;
    }
    
    /**
     * View - Delete Method.
     * @param o Odds to be deleted.
     */
    public void viewDeleteOdd (Odd o){
        this.out.println("Remover Odd"+this.viewOdd(o));
        
    }
    
}
