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
        
        public ApostadorView (){
            this.in = new BufferedReader(new InputStreamReader(System.in));
            this.out = System.out;
        }

	public Apostador viewCreateApostador(){

		String readinput;
                Apostador a = new Apostador();
		this.out.print("Introduza os seguintes dados de Apostador: (Nome, email, montante betESScoins\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			a.setName(tokens[0]);
			a.setEmail(tokens[1]);
			a.setBetESScoins(Double.parseDouble(tokens[2]));
			this.viewApostador(a);
                        return a;
		} catch (IOException e) {
			e.printStackTrace();
		}
                return null;
	}

	public void viewUpdateApostador(Apostador a){

		String readinput;
		this.out.print("Introduza novos dados de Apostador: (Nome("
                        +a.getName()+"), email("+a.getEmail()+"), montante betESScoins("+ a.getBetESScoins()+")\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			a.setName(tokens[0]);
			a.setEmail(tokens[1]);
			a.setBetESScoins(Double.parseDouble(tokens[2]));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void viewDeleteApostador(Apostador a){
		this.out.println("Remover Apostador"+this.viewApostador(a));

	}

	public String viewApostador(Apostador a){

		String view;
		view = new String ("Apostador{" + "email='" + a.getEmail() +  ", betESScoins=" + a.getBetESScoins() + ", name='" + a.getName() + '\'' + '}');
		this.out.println(view);
		return view;

	}
    
}
