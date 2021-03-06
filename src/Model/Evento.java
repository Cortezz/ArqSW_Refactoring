package Model;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/** 
 * Class which represents an event.
 * @author José Cortez
 */
public class Evento implements Subject {

	public enum Resultado {
		VITORIA,
		DERROTA,
		EMPATE
	}

	private static AtomicInteger uniqueId=new AtomicInteger();

	private String equipa1;
	private String equipa2;
	private Resultado resultado_final;
	private Date dataEvento;
	private int id;
	private Vector<Aposta> listaApostas;
	private boolean isOpen;
	private Odd odds;
        private Bookie bookieCriouEvento;
        private Bookie bookieFechouEvento;

        /**
         * Param constructor.
         * @param equipa1 Name of the home team.
         * @param equipa2 Name of the away team.
         * @param data Date on which the event is going to take place.
         */
	public Evento(String equipa1, String equipa2, Date data) {
		this.equipa1 = equipa1;
		this.equipa2 = equipa2;
		this.isOpen = false;
		this.resultado_final = null;
		this.dataEvento = data;
		this.id=uniqueId.getAndIncrement();
		this.odds = new Odd();
		this.listaApostas = new Vector<Aposta>();
                bookieCriouEvento = new Bookie();
                bookieFechouEvento = new Bookie();
	}

        /**
         * Empty Constructor.
         */
	public Evento() {
		this.equipa1 = null;
		this.equipa2 = null;
		this.isOpen = false;
		this.dataEvento = null;
		this.id=uniqueId.getAndIncrement();
		this.odds = new Odd();
		this.listaApostas = new Vector<Aposta>();
                bookieCriouEvento = new Bookie();
                bookieFechouEvento = new Bookie();
	}

        /** Getters **/
        public String getEquipa1() { return this.equipa1;}
        public String getEquipa2() { return this.equipa2;}
        public boolean getStatus () {return this.isOpen;}
        public Evento.Resultado getResultadoFinal () {return this.resultado_final;}
        public int getID() {return this.id;}
        public Odd getOdds () {return this.odds;}
        public Date getDataEvento () {return this.dataEvento;}
        public Vector<Aposta> getListaApostas () { return this.listaApostas; }
        public Bookie getBookieCriouEvento () {return this.bookieCriouEvento;}
        public Bookie getBookieFechouEvento () {return this.bookieFechouEvento;}
        
        /** Setters **/ 
        public void setEquipa1(String equipa1) {this.equipa1 = equipa1;}
        public void setEquipa2(String equipa2) {this.equipa2 = equipa2;}
        public void setDataEvento(Date dataEvento) {this.dataEvento = dataEvento;}
        public void setEstado(boolean estado) {this.isOpen = estado;}
        public void setResultadoFinal (Evento.Resultado res) {this.resultado_final = res;}
        public void setID (int id ) {this.id = id;}
        public void setOdds(float odd_1, float odd_x, float odd_2) { this.odds = new Odd(odd_1,odd_x,odd_2);}
        public void setOdds (Odd o) {this.odds = o;}
        public void setBookieCriouEvento (Bookie b) {this.bookieCriouEvento = b;}
        public void setBookieFechouEvento (Bookie b) {this.bookieFechouEvento = b;}

        
        /**
         * Closes an event. After this stage no bets will be able to take place.
         * @param res Final result of the event.
         * @return Boolean condition which expresses the method's success.
         */
	public boolean fechaEvento(Resultado res){
                this.resultado_final = res;
		this.isOpen = false;
		this.notifyApostadores();
		return true;
	}
        
        
        /**
         * Adds a bet to its bet list.
         * @param a Instance of the bet to be added.
         */
        public void registaAposta (Aposta a){
            this.listaApostas.add(a);
        }

        @Override
	public void notifyApostadores() {
            float premio = 0;
            if (!this.isOpen){
                Enumeration<Aposta> lista_apostas = this.listaApostas.elements();
                while (lista_apostas.hasMoreElements()) {
                    Aposta aposta = lista_apostas.nextElement();
                    if (this.resultado_final == aposta.getResultado()) 
                        premio = calculaPremioConsoanteResultado(aposta,aposta.getResultado());
                    else premio = 0;
                    aposta.notificaApostador(premio);
                }
            }
	}
        
        
        
        /**
         * Calculates the gains of a bet, given the event's result.
         * @param aposta A bet.
         * @param res Outcome of the event.
         * @return Gains of the bet.
         */
        public float calculaPremioConsoanteResultado (Aposta aposta, Evento.Resultado res){
            switch (res) {
                case VITORIA:
                        return aposta.calculaPremio("1");
                case EMPATE:
                        return aposta.calculaPremio("x");
                case DERROTA:
                        return aposta.calculaPremio("2");
            }
            return 0;
            
        }

        
	
        /**
         * Updates the odds of the event.
         * @param odd_1 Odd for the home win.
         * @param odd_x Odd for the draw.
         * @param odd_2 Odd for the away win.
         */
	public void updateOdds(float odd_1, float odd_x, float odd_2){
	    this.odds.setOdd1(odd_1);
            this.odds.setOdd2(odd_2);
            this.odds.setOddx(odd_x);
	}
        
       
        
        
        
        /**Equals**/
        @Override
        public boolean equals (Object o){
            if (this==o) return true;
            if (o==null || this.getClass()!=o.getClass()) return false;
            Evento e = (Evento)o;
            return (this.dataEvento.equals(e.getDataEvento()) && this.equipa1.equals(e.getEquipa1()) 
                    && this.bookieCriouEvento.equals(e.getBookieCriouEvento()) && this.bookieFechouEvento.equals((e.getBookieFechouEvento()))
                    && this.equipa2.equals(e.getEquipa2()) && this.id == e.getID() && this.odds.equals(e.getOdds()) 
                    && this.resultado_final.equals(e.getResultadoFinal()) && ListaApostasEquals(e.getListaApostas()));
        }
        
        private boolean ListaApostasEquals (Vector<Aposta> a){
            if (this.listaApostas.size()!=a.size()) return false;
            for (int i = 0; i<a.size(); i++)
                if (!listaApostas.get(i).equals(a.get(i)))return false;
            return true;
        }

}