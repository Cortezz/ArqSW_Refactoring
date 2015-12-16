package Model;

import java.util.HashMap;
import java.util.Map;



/**
 * Class whose purpose is to store events.
 * @author José Cortez
 */
public class ListaEventos {
    
    private HashMap<Integer,Evento> listaEventos;
    
    /**
     * Empty constructor.
     */
    public ListaEventos ()  {
        this.listaEventos = new HashMap<Integer,Evento>();
    }
    
    
    /**Getters**/
    public HashMap<Integer,Evento> getListaEventos(){return listaEventos;  }
    
    /**
     * Adds an event.
     * @param id Unique identifier of the event.
     * @param e Instance of the event object to be added.
     */
    public void addEvento (int id, Evento e) {
        listaEventos.put(id,e);
    }
    
    /**Equals**/
    @Override
    public boolean equals (Object o){
        if (this==o) return true;
        if (o==null || o.getClass()!=this.getClass()) return false;
        ListaEventos le = (ListaEventos)o;
        return (listaEventosEquals(le.getListaEventos()));
    }
    
    public boolean listaEventosEquals (HashMap<Integer,Evento> le) {
        if (listaEventos.size()!=le.size()) return false;
        for (Map.Entry<Integer,Evento> entry : listaEventos.entrySet())
            if (le.containsKey(entry.getKey())) 
            {
                if (!le.get(entry.getKey()).equals(entry.getValue()))
                    return false;
            }
            else return false;
        return true;
               
    }
    
}
