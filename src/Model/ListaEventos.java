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
    public Map getListaEventos(){return listaEventos;  }
    
    /**
     * Adds an event.
     * @param id Unique identifier of the event.
     * @param e Instance of the event object to be added.
     */
    public void addEvento (int id, Evento e) {
        listaEventos.put(id,e);
    }
    
}
