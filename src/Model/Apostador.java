package Model;


/**
 * Class which represents the punter.
 * @author José Cortez
 */
public class Apostador implements Observer{

	private String email;
	private float betESScoins;
	private String name;

        /**
         * Param constructor.
         * @param name Name of the punter.
         * @param email E-mail of the punter.
         * @param betESScoins Amount of BetESSCoins the punter has.
         */
	public Apostador(String name, String email, float betESScoins) {
		this.email = email;
		this.name = name;
                this.betESScoins = betESScoins;
	}

        /**
         * Empty Constructor.
         */
	public Apostador() {
            this.email="";
            this.betESScoins = 0;
            this.name = "";
	}

        
        /**Getters*/
	public String getEmail() {return email;}
        public float getBetESScoins() {return betESScoins;}
        public String getName() { return name;}
        /**Setters**/
        public void setEmail(String email) { this.email = email;}
        public void setBetESScoins(float betESScoins) { this.betESScoins = betESScoins;}
        public void setName(String name) { this.name = name;}

	@Override
	public String toString() {
		return "Apostador{" +
				"email='" + email + '\'' +
				", betESScoins=" + betESScoins +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public void update(String notificacao) {
            System.out.println("\nApostador(" + this.name + "):" + notificacao + "\n");
	}
        
        
        /** Equals**/
        @Override
        public boolean equals (Object o){
            if (this==o) return true;
            if (o==null || this.getClass()!=o.getClass()) return false;
            Apostador a = (Apostador)o;
            return (this.betESScoins==a.getBetESScoins() && this.email.equals(a.getEmail()) && this.name.equals(a.getName()));
        }


}