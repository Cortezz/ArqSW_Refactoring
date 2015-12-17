package Model;

import java.util.HashMap;

/**
 * Class which represents the Bookie.
 * @author José Cortez
 */
public class Bookie {
    
    private String nome;
    private ListaEventos eventosSubscritos;
    
    /**
     * Empty constructor.
     */
    public Bookie (){
        nome = "";
        eventosSubscritos = new ListaEventos();
    }
    
    public Bookie (String nome){
        this.nome =nome;
        eventosSubscritos = new ListaEventos();
    }
    
    
    
    /*Getters*/
    public HashMap<Integer,Evento> getEventosSubscritos(){ return eventosSubscritos.getListaEventos();}
    public String getNome () {return this.nome;}
    /*Setters*/
    public void setNome (String nome) {this.nome = nome;}
    
    /***
     * The bookie subscribes to an event.
     * @param e 
     */
    public void subscreveEvento (Evento e){
        eventosSubscritos.addEvento(e.getID(), e);
    }
    
    /**
     * Removes the subscription from a certain event, given its ID.
     * @param evID ID of the event.
     */
    public void removeSubscricao (int evID){
        eventosSubscritos.removeEvento(evID);
    }
    
    
    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if (o==null || o.getClass()!=this.getClass()) return false;
        Bookie b = (Bookie)o;
        return (this.nome.equals(b.getNome()) && eventosSubscritos.listaEventosEquals(b.getEventosSubscritos()));
    }
    
}
