package View;

import Model.Aposta;
import Model.Evento;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import Controller.BetESSAPI;

/**
 *
 * @author José Cortez
 */
public class ApostaView {
    
    private  BufferedReader in;
    private PrintStream out;
    private BetESSAPI controller;
    
    /**
     * Implicit stdin and stdout initialization.
     * @param betESS Controller to be added as a reference.
     */
    public ApostaView (BetESSAPI betESS) {
        this.in = new BufferedReader(new InputStreamReader(System.in));
	this.out = System.out;
        this.controller = betESS;
    }
    
    /** 
     * Empty Constructor.
     */
    public ApostaView (){
        this.in = new BufferedReader(new InputStreamReader(System.in));
	this.out = System.out;
    }
    
    
    /** CRUD Methods **/
    
    
    /**
     * View - Read Method.
     * @param a Bet to be read.
     * @return ToString-esque string.
     */
    public String viewAposta(Aposta a) {
        ApostadorView av = new ApostadorView();
        
        return "Aposta{" +
            "Apostador='" + av.viewApostador(a.getApostador()) +
            ", m_aposta='" + a.getValor() +
            ", Resultado_final='" + a.getResultado() +
            ", Odd_fixada='" +a.getOdd_fixada().toString() +
            '}';
    }
    
    
    /**
     * View - Create Method.
     * @return Newly created bet.
     */
    public Aposta viewCreateAposta(){
        String readinput;
        Aposta a = new Aposta();
        this.out.println("Introduza o resultado e o montante a apostar: montante, resultado\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");
            a.setResultado(stringToResultado(tokens[1]));
            a.setValor(Float.parseFloat(tokens[0]));
            return a;
        } catch (IOException e) {e.printStackTrace();}
        return null;
    }
    
    
    /**
     * View - Update Method.
     * @param a Bet to be updated.
     */
    public void viewUpdateAposta (Aposta a){
        String readinput;
	this.out.println("Introduza o resultado e o montante a apostar: montante, resultado\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");
            a.setResultado(stringToResultado(tokens[1]));
            a.setValor(Float.parseFloat(tokens[0]));
        } catch (IOException e) {e.printStackTrace();}
    }
    
    private Evento.Resultado stringToResultado(String s){
        Evento.Resultado res = null;
        switch (s) {
		case "1":
                    res = Evento.Resultado.VITORIA;
                    break;
                case "x":
                    res = Evento.Resultado.EMPATE;
                    break;
                case "2":
                    res = Evento.Resultado.DERROTA;
                    break;
            }
        return res;
    }
    
    /**
     * View - Delete Method.
     * @param a Bet to be deleted.
     */
    public void viewDeleteAposta (Aposta a){
        this.out.println("Remover Aposta"+this.viewAposta(a));
        
    }
    
}
