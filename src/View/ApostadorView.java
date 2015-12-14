/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BetESSAPI;
import Model.Apostador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *
 * @author José Cortez
 */
public class ApostadorView {
    
    private BufferedReader in;
    private PrintStream out = null;
    private BetESSAPI controller;
    
        public ApostadorView (BetESSAPI betESS){
            this.in = new BufferedReader(new InputStreamReader(System.in));
            this.out = System.out;
            this.controller = betESS;
        }

	public void viewCreateApostador(){

		String readinput;
		this.out.print("Introduza os seguintes dados de Apostador: (Nome, email, montante betESScoins\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			this.setName(tokens[0]);
			this.setEmail(tokens[1]);
			this.setBetESScoins(Double.parseDouble(tokens[2]));
			this.viewApostador();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void viewUpdateApostador(Apostador apostador){

		String readinput;
		this.out.print("Introduza novos dados de Apostador: (Nome("+ this.name +"), email("+this.email+"), montante betESScoins("+ this.betESScoins+")\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			apostador.setName(tokens[0]);
			apostador.setEmail(tokens[1]);
			apostador.setBetESScoins(Double.parseDouble(tokens[2]));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void viewDeleteApostador(){
		this.out.println("Remover Apostador"+this.viewApostador());

	}

	public String viewApostador(){

		String view;
		view = new String ("Apostador{" + "email='" + email +  ", betESScoins=" + betESScoins + ", name='" + name + '\'' + '}');
		this.out.println(view);
		return view;

	}
    
}
