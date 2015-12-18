/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Class responsible for storing bookies.
 * @author José Cortez
 */
public class ListaBookies {
    
    private HashMap<String,Bookie> bookies;
    
    /**
     * Empty constructor.
     */
    public ListaBookies () {
        bookies = new HashMap<String,Bookie>();
    }
    
    /**Getters*/
    public HashMap<String,Bookie> getListaBookies () { return bookies;}
     
    
    /**
     * Adds a bookie to the list.
     * @param nome Name of the bookie.
     * @param b Instance of the bookie to be added.
     */
    public void addBookie (String nome, Bookie b){
        this.bookies.put(nome,b);
    }
    
    /**
     * Removes a bookie.
     * @param nome Name of the bookie..
     */
    public void removeBookie (String nome){
        bookies.remove(nome);
    }
    
    
    /**Equals**/
    @Override
    public boolean equals (Object o){
        if (this==o) return true;
        if (o==null || o.getClass()!=this.getClass()) return false;
        ListaBookies lb = (ListaBookies)o;
        return (listaBookiesEquals(lb.getListaBookies()));
    }
    
    public boolean listaBookiesEquals (HashMap<String,Bookie> lb) {
        if (bookies.size()!=lb.size()) return false;
        for (Map.Entry<String,Bookie> entry : bookies.entrySet())
            if (lb.containsKey(entry.getKey())) 
            {
                if (!lb.get(entry.getKey()).equals(entry.getValue()))
                    return false;
            }
            else return false;
        return true;
               
    }
    
}
