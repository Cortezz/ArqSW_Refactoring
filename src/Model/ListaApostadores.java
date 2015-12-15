package Model;

import java.util.HashMap;

/**
 *  Class whose purpose is to store betters.
 * @author José Cortez
 */
public class ListaApostadores {
    
    private HashMap<String,Apostador> listaApostadores;
    
    
    /**
     * Empty constructor.
     */
    public ListaApostadores () {
        this.listaApostadores = new HashMap<String,Apostador>();
    }
    
    
    /**
     * Adds a punter to its punter list.
     * @param email E-mail of the punter.
     * @param a Instance of the punter (Apostador) object to be added.
     */
    public void addApostador (String email, Apostador a){
        this.listaApostadores.put(email,a);
    }
}
