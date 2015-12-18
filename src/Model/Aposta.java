package Model;

import java.util.HashMap;

/**
 * Class which represents a bet.
 * @author José Cortez
 */
public class Aposta {

	private Apostador apostador;
	private float valor;
	private Evento.Resultado resultado;
	private Odd odd_fixada;


        /**
         * Empty constructor.
         */
	public Aposta(){
		this.apostador = null;
		this.valor = 0;
		this.resultado = null;
		this.odd_fixada = null;
	}

        /**
         * Param constructor.
         * @param apostador Punter who made the bet.
         * @param valor Value of the bet.
         * @param resultado The option chosen by the punter.
         * @param odd_actual The fixed odds of the bet.
         */
	public Aposta(Apostador apostador, float valor, Evento.Resultado resultado, Odd odd_actual) {
		this.apostador = apostador;
		this.valor = valor;
                this.resultado = resultado;
		this.odd_fixada = odd_actual.clone();
	}

	// getter and setters
        /** Getters**/
	public Apostador getApostador() {return apostador;}
        public Evento.Resultado getResultado() {return resultado;}
        public float getValor() {return valor;}
        public Odd getOdd_fixada() {return odd_fixada;}
        /**Setters*/
	public void setOdd_fixada(Odd odd_fixada) { this.odd_fixada = odd_fixada.clone();}
        public void setValor(float valor) { this.valor = valor;}
        public void setApostador(Apostador apostador) { this.apostador = apostador; }
        public void setResultado(Evento.Resultado resultado) { this.resultado = resultado;}

        
        /**
         * Calculates the gains a punter associated with an odd;
         * @return Gains of the bet.
         */
        public float calculaPremio (String odd){
            HashMap<String,Float> odds = new HashMap<>();
            odds.put("1",odd_fixada.getOdd1());
            odds.put("x",odd_fixada.getOddx());
            odds.put("2",odd_fixada.getOdd2());
            return (this.getValor() * odds.get(odd));
        }
        
        /**
         * Notifies the punter about the prize he's received from a bet.
         * @param notificacao Value of the prize.
         */
        public void notificaApostador (float notificacao){
            this.apostador.update(Float.toString(notificacao));
        }
        
        
        /**Equals**/
        @Override
        public boolean equals (Object o) {
            if (this==o) return true;
            if (o==null || o.getClass()!=this.getClass()) return false;
            Aposta a = (Aposta)o;
            return (this.apostador.equals(a.getApostador()) && this.valor==a.getValor() && this.odd_fixada.equals(a.getOdd_fixada())
                    && this.resultado.equals(a.getResultado()));
        }

}