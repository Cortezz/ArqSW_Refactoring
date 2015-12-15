/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author José Cortez
 */
public class EventoView {
    
    private final BufferedReader in;
    private final PrintStream out;
    private BetESSAPI controller;
    
    public EventoView (BetESSAPI betESS) {
        this.in = new BufferedReader(new InputStreamReader(System.in));
	this.out = System.out;
        this.controller = betESS; 
    }
    
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

	public Evento viewCreateEvento(){

                Evento ev = null;
		String readinput;
		this.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			ev.setEquipa2(tokens[1]);
			ev.setEquipa1(tokens[0]);
			ev.setDataEvento(Date.from(Instant.now()));

		} catch (IOException e) {
			e.printStackTrace();
		}
                return ev;
	}

	public void viewUpdateEvento(Evento ev){
		String readinput;
		this.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			ev.setEquipa2(tokens[1]);
			ev.setEquipa1(tokens[0]);
			ev.setDataEvento(Date.from(Instant.now()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void viewDeleteEvento(Evento e){
		this.out.println("Remover Evento" + this.viewEvento(e));

	}
    
}
