package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *  Class whose purpose is to store punters.
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
    
    /**Getters*/
    public HashMap getListaApostadores () { return listaApostadores;}
     
    
    /**
     * Adds a punter to its punter list.
     * @param email E-mail of the punter.
     * @param a Instance of the punter object to be added.
     */
    public void addApostador (String email, Apostador a){
        this.listaApostadores.put(email,a);
    }
    
    /**
     * Removes a punter.
     * @param email E-mail of the punter.
     */
    public void removeApostador (String email){
        listaApostadores.remove(email);
    }
    
    
    /**Equals**/
    @Override
    public boolean equals (Object o){
        if (this==o) return true;
        if (o==null || o.getClass()!=this.getClass()) return false;
        ListaApostadores la = (ListaApostadores)o;
        return (listaApostadoresEquals(la.getListaApostadores()));
    }
    
    public boolean listaApostadoresEquals (HashMap<String,Apostador> la) {
        if (listaApostadores.size()!=la.size()) return false;
        for (Map.Entry<String,Apostador> entry : listaApostadores.entrySet())
            if (la.containsKey(entry.getKey())) 
            {
                if (!la.get(entry.getKey()).equals(entry.getValue()))
                    return false;
            }
            else return false;
        return true;
               
    }
}
