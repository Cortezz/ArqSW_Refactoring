package View;

import Controller.BetESSAPI;
import Model.Evento;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.Instant;
import java.util.Date;

/**
 * Class which gives the CRUD methods for Evento's View.
 * @author José Cortez
 */
public class EventoView {
    
    private final BufferedReader in;
    private final PrintStream out;
    private BetESSAPI controller;
    
    /**
     * Implicit stdin and stdout initialization.
     * @param betESS Controller to be added as a reference.
     */
    public EventoView (BetESSAPI betESS) {
        this.in = new BufferedReader(new InputStreamReader(System.in));
	this.out = System.out;
        this.controller = betESS; 
    }
    
    /**
     * Empty Constructor.
     */
    public EventoView(){
        this.in = new BufferedReader(new InputStreamReader(System.in));
	this.out = System.out;
    }
    
    
    /** CRUD Methods **/
    
    
    /**
     * View - Read Method.
     * @param e Event to be read.
     * @return ToString-esque appearance.
     */
    public String viewEvento(Evento e) {
        return "Evento{" +
            "equipa1='" + e.getEquipa1() + '\'' +
            ", equipa2='" + e.getEquipa2() + '\'' +
            ", resultado_final=" + e.getResultadoFinal() +
            ", estado=" + e.getStatus() +
            ", data da aposta" + e.getDataEvento().toString() +
            ", ultima odd" + e.getOdds().toString()+
            '}';
}

    
    
    /**
     * View - Create Method.
     * @return Returns the created Event.
     */
    public Evento viewCreateEvento(){

        Evento ev = new Evento();
        String readinput;
        this.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");
            ev.setEquipa2(tokens[1]);
            ev.setEquipa1(tokens[0]);
            ev.setDataEvento(Date.from(Instant.now()));
            return ev;
        } catch (IOException e) {e.printStackTrace();}
        return null;
        
    }

    /**
     * View - Update Method.
     * @param ev Event to be updated.
     */
    public void viewUpdateEvento(Evento ev){
        String readinput;
        this.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");
            ev.setEquipa2(tokens[1]);
            ev.setEquipa1(tokens[0]);
            ev.setDataEvento(Date.from(Instant.now()));
        } catch (IOException e) {e.printStackTrace();}
    }

    /** 
     * View - Delete Method.
     * @param e Event to be deleted.
     */
    public void viewDeleteEvento(Evento e){
        this.out.println("Remover Evento" + this.viewEvento(e));
    }
    
}
