package Model;

/**
 * Class which represents the odds of 1/x/2 event.
 * @author Cortez
 */
public class Odd {

	private float odd1;
	private float oddx;
	private float odd2;

        /** 
         * Param constructor.
         * @param odd1 Odds of a home win.
         * @param oddx Odds of an away win.
         * @param odd2 Odds of a draw.
         */
	public Odd(float odd1, float oddx, float odd2) {
		this.odd1 = odd1;
		this.oddx = oddx;
		this.odd2 = odd2;
	}

        /**
         * Empty constructor.
         */
	public Odd() {
		this.odd1 = 0;
		this.oddx = 0;
		this.odd2 = 0;
	}

        /**Getters*/
	public float getOdd1() {return this.odd1;}
        public float getOddx() {return this.oddx;}
        public float getOdd2() {return this.odd2;}
        /*Setters*/
	public void setOdd1(float odd1) {this.odd1 = odd1;}
        public void setOddx(float oddx) {this.oddx = oddx;}
	public void setOdd2(float odd2) {this.odd2 = odd2;}



	public Odd clone(){
		Odd newOdd = new Odd();
		newOdd.setOdd1(this.odd1);
		newOdd.setOdd2(this.odd2);
		newOdd.setOddx(this.oddx);
		return newOdd;
	}
        
        /** Equals**/
        
        @Override
        public boolean equals (Object o){
            if (o==this) return true;
            if (o==null || o.getClass()!=this.getClass()) return false;
            Odd odd = (Odd)o;
            return (this.odd1==odd.getOdd1() && this.odd2==odd.getOdd2() && this.oddx == odd.getOddx());
        }
        
        @Override
        public String toString () {
            StringBuilder sb = new StringBuilder();
            sb.append("Odd 1 - ").append(odd1).append("\n");
            sb.append("Odd x - ").append(oddx).append("\n");
            sb.append("Odd 2 - ").append(odd2).append("\n");
            return sb.toString();
        }
}