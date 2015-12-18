package Controller;


import Model.*;
import View.*;
import java.util.*;

public class BetESSAPI {

	private ListaEventos listaEventos;
	private ListaApostadores listaApostadores;
        private ListaBookies listaBookies;
        
	private double betESStotal;
	private String name;
        
        private ApostaView apostaView;
        private EventoView eventoView;
        private ApostadorView apostadorView;
        private BookieView bookieView;
        private OddView oddView;

	public BetESSAPI() {
            
		this.betESStotal = 0;
		this.listaEventos = new ListaEventos();
		this.listaApostadores = new ListaApostadores();
                this.listaBookies = new ListaBookies();
		this.name = "BetESSAPI";
                this.apostadorView = new ApostadorView(this);
                this.eventoView = new EventoView(this);
                this.apostaView = new ApostaView(this);
                this.bookieView = new BookieView(this);
                this.oddView = new OddView(this);
	}
        
                                /******* APOSTAS ***********/
        /**
         * CRUD - Create method.
         * @param evento Event which the bet belongs to.
         */
	public Aposta registaAposta(Evento evento, Apostador apostador) {
            Aposta a = apostaView.viewCreateAposta();
            a.setApostador(apostador);
            a.setOdd_fixada(evento.getOdds());
            evento.registaAposta(a);
            return a;
	}
        
        /**
         * CRUD - Read method.
         * @param a Bet to be read.
         * @return String which represents the bet.
         */
        public String detalhesAposta (Aposta a){
            return apostaView.viewAposta(a);
        }
        
        /**
         * CRUD - Update method.
         * @param a Bet to be updated.
         */
        public void updateAposta (Aposta a){
            apostaView.viewUpdateAposta(a);
        }
        
        public void setResultadoDaAposta (Aposta a, Evento.Resultado r){
            a.setResultado(r);
        }

                                /******* EVENTOS ***********/

        /**
         * Updates the odds of an event.
         * @param evento Event whose odds are to be updated.
         * @param odd_1 Odds for a home win.
         * @param odd_x Odds for a draw.
         * @param odd_2 Odds for an away win.
         * @return 
         */
	public boolean actualizaOdd(Evento evento, float odd_1, float odd_x, float odd_2){
             evento.updateOdds(odd_1,odd_x,odd_2);
             return true;
	}

        /**
         * Closes an event, given an outcome.
         * @param evento Event to be closed.
         * @param resultado Outcome of the event.
         * @param b Instance of the bookie who closed the event.
         */
	public void  fechaEvento(Evento evento, char resultado, Bookie b){
            evento.fechaEvento(resultado);
            evento.setBookieFechouEvento(b);
	}

        /**
         * Method which prints information about all the events.
         */
	public void viewEventos(){
            HashMap<Integer, Evento> eventos = (HashMap)listaEventos.getListaEventos();
            for (Evento e : eventos.values())
                System.out.println(eventoView.viewEvento(e));
		
	}


        
        /**
         * CRUD - Create Method.
         * @param b Instance of the bookie who created the event.
         * @return Created event.
         */
        public Evento registaEvento (Bookie b){
            Evento newevento = eventoView.viewCreateEvento();
            newevento.setBookieCriouEvento(b);
            Odd o = oddView.viewCreateOdd();
            newevento.setOdds(o);
            this.listaEventos.addEvento(newevento.getID(),newevento);
            return newevento;
        }
        
        /**
         * CRUD - Update method.
         * @param e Event to be updated.
         */
        public void updateEvento (Evento e){
            listaEventos.removeEvento(e.getID());
            eventoView.viewUpdateEvento(e);
            Odd o = oddView.viewUpdateOdd(e.getOdds());
            e.setOdds(o);
            listaEventos.addEvento(e.getID(), e);
        }
        
        /**
         * CRUD - Delete method.
         * @param e Event to be removed.
         */
        public void deleteEvento (Evento e){
            eventoView.viewDeleteEvento(e);
            listaEventos.removeEvento(e.getID());
        }
        
        /**
         * CRUD - Read Method.
         * @param e Event to be read.
         */
        public void detalhesEvento (Evento e){
            System.out.println(eventoView.viewEvento(e));
        }

        
                                    /** Apostadores **/

        /**
         * Prints information about all the punters.
         */
	public void viewApostadores(){
            HashMap<String, Apostador> apostadores = (HashMap)listaApostadores.getListaApostadores();
            for (Apostador a : apostadores.values())
                System.out.println(apostadorView.viewApostador(a));
	}


        /**
         * CRUD - Read Method.
         * @return Punter that's going to be created.
         */
	public Apostador registaApostador() {
            Apostador newuser = apostadorView.viewCreateApostador();
            this.listaApostadores.addApostador(newuser.getEmail(),newuser);
            return newuser;
	}

        /**
         * CRUD - Update method.
         * @param apostador Punter to be updated.
         * @return 
         */
            public void actualizaApostador(Apostador apostador) {
            listaApostadores.removeApostador(apostador.getEmail());
            apostadorView.viewUpdateApostador(apostador);
            listaApostadores.addApostador(apostador.getEmail(), apostador);
	}

	public void deleteApostador(Apostador apostador){
            apostadorView.viewDeleteApostador(apostador);
            listaApostadores.removeApostador(apostador.getEmail());
	}

                    /*** Bookies ***/
        
        /**
         * CRUD - Create method.
         * @return Instance of a bookie.
         */
        public Bookie registaBookie (){
            Bookie b = bookieView.viewCreateBookie();
            listaBookies.addBookie(b.getNome(), b);
            return b;
        }
        
        /**
         * CRUD - Update method.
         * @param b Instance of the bookie to be updated.
         */
        public void actualizaBookie (Bookie b){
            listaBookies.removeBookie(b.getNome());
            bookieView.viewUpdateBookie(b);
            listaBookies.addBookie(b.getNome(), b);
        }
        
        /**
         * CRUD - Read method.
         * @param b Instance of the bookie to be read.
         */
        public void detalhesBookie (Bookie b){
            System.out.println(bookieView.viewBookie(b));
        }
        
        /**
         * CRUD - Delete method.
         * @param b 
         */
        public void deleteBookie (Bookie b){
            listaBookies.removeBookie(b.getNome());
            bookieView.viewDeleteAposta(b);
        }
        
        


        
}