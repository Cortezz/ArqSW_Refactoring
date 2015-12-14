/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
    
    public ApostaView (BetESSAPI betESS) {
        this.in = new BufferedReader(new InputStreamReader(System.in));
	this.out = System.out;
        this.controller = betESS;
    }
    
    public void viewCreateAposta(){
		String readinput;
		this.out.println("Introduza o resultado e o montante a apostar: montante, resultado\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");


			switch (tokens[1]) {
				case "1":
					this.setResultado(Evento.Resultado.VITORIA);
					break;
				case "x":
					this.setResultado(Evento.Resultado.EMPATE);
					break;
				case "2":
					this.setResultado(Evento.Resultado.DERROTA);
					break;
			}

			this.setM_aposta(Float.parseFloat(tokens[0]));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
}
