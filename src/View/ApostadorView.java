package View;

import Controller.BetESSAPI;
import Model.Apostador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Class which gives the CRUD methods for the Apostador (Punter).
 * @author José Cortez
 */
public class ApostadorView {
    
    private BufferedReader in;
    private PrintStream out = null;
    private BetESSAPI controller;
    
        /**
        * Implicit stdin and stdout initialization.
        * @param betESS Controller to be added as a reference.
        */
        public ApostadorView (BetESSAPI betESS){
            this.in = new BufferedReader(new InputStreamReader(System.in));
            this.out = System.out;
            this.controller = betESS;
        }
        
        /**
         * Empty Constructor.
         */
        public ApostadorView (){
            this.in = new BufferedReader(new InputStreamReader(System.in));
            this.out = System.out;
        }

        
        
        /** CRUD Methods **/
        
        /**
         * View - Create Method.
         * @return Newly created punter.
         */
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
            } catch (IOException e) {e.printStackTrace();}
            return null;
	}

        /**
         * View - Update Method.
         * @param a Punter to be updated.
         */
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

            } catch (IOException e) { e.printStackTrace();}
	}

        
        /**
         * View - Delete Method.
         * @param a Punter to be deleted.
         */
	public void viewDeleteApostador(Apostador a){
		this.out.println("Remover Apostador"+this.viewApostador(a));

	}

        /***
         * View - Read Method.
         * @param a Punter to be read.
         * @return ToString-esque string.
         */
	public String viewApostador(Apostador a){

		String view;
		view = new String ("Apostador{" + "email='" + a.getEmail() +  ", betESScoins=" + a.getBetESScoins() + ", name='" + a.getName() + '\'' + '}');
		this.out.println(view);
		return view;

	}
    
}
