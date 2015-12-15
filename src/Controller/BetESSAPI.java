package Controller;


import Model.*;
import View.*;
import java.time.Instant;
import java.util.*;

public class BetESSAPI {

	private ListaEventos listaEventos;
	private ListaApostadores listaApostadores;
        
	private double betESStotal;
	private String name;
        private ApostaView apostaView;
        private EventoView eventoView;
        private ApostadorView apostadorView;

	public BetESSAPI() {
            
		this.betESStotal = 0;
		this.listaEventos = new ListaEventos();
		this.listaApostadores = new ListaApostadores();
		this.name = "BetESSAPI";
                this.apostadorView = new ApostadorView(this);
                this.eventoView = new EventoView(this);
                this.apostaView = new ApostaView(this);
	}
        
        //interface sobre Apostas

	public void registaAposta(Apostador apostador, Evento evento) {
		evento.registaAposta(apostador);
	}
        
        public void setResultadoDaAposta (Aposta a, Evento.Resultado r){
            a.setResultado(r);
        }

	// Interface sobre Eventos

	public boolean actualizaOdd(Evento evento, int odd_1, int odd_x, int odd_2){
		return evento.actualizaOdd(odd_1,odd_x,odd_2);
	}

	public boolean  fechaEvento(Evento evento, char resultado){
		return evento.fechaEvento(resultado);
	}

	public void viewEventos(){

		ListIterator<Evento> listIterator = this.listaEventos.listIterator();
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next().viewEvento());
		}
	}

	public Evento registaEvento(String equipa1, String equipa2) {

		Evento aposta = new Evento(equipa1,equipa2, Date.from(Instant.now()));
		this.listaEventos.add(aposta);
		return aposta;
	}

	public Evento registaEvento() {


		Evento newevento = new Evento();

		newevento.viewCreateEvento();
		this.listaEventos.addEvento(newevento);
		return newevento;
	}

	// Interface sobre Apostadores

	public void viewApostadores(){

		ListIterator<Apostador> lista = this.listaApostadores.listIterator();
		while(lista.hasNext()){
			System.out.println(lista.next());
		}
	}

	public Apostador registaApostador(String nome, String  email, double coins){

		Apostador newuser = new Apostador(nome, email, coins);
		listaApostadores.addApostador(email, newuser);
		return newuser;
	}

	public Apostador registaApostador() {


		Apostador newuser = new Apostador();
		newuser.viewCreateApostador();
		this.listaApostadores.add(newuser);


		return newuser;
	}

	public Apostador actualizaApostador(Apostador apostador) {


		apostador.viewUpdateApostador(apostador);


		return apostador;
	}

	public boolean deleteApostador(Apostador apostador){
		apostador.viewDeleteApostador();
		return this.listaApostadores.remove(apostador);

	}

	// Interface sobre Bookies

	// TO-DO

	// Objects view
	@Override
	public String toString() {
		return "BetESSAPI{" +
				"name=" + name +
				", betESStotal=" + betESStotal +
				'}';
	}


}