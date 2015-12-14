/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BetESSAPI;
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
    
    public String viewEvento() {
		return "Evento{" +
				"equipa1='" + equipa1 + '\'' +
				", equipa2='" + equipa2 + '\'' +
				", resultado_final=" + resultado_final +
				", estado=" + isOpen +
				", data da aposta" + dataEvento.toString() +
				", ultima odd" + this.odds.toString() +
				'}';
	}

	public void viewCreateEvento(){

		String readinput;
		this.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			this.setEquipa2(tokens[1]);
			this.setEquipa1(tokens[0]);
			this.setDataEvento(Date.from(Instant.now()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void viewUpdateEvento(){
		String readinput;
		this.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			this.setEquipa2(tokens[1]);
			this.setEquipa1(tokens[0]);
			this.setDataEvento(Date.from(Instant.now()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void viewDeleteApostador(){
		this.out.println("Remover Apostador" + this.viewEvento());

	}
    
}
