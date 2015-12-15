/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Vector;

/**
 *
 * @author Cortez
 */
public class ListaEventos {
    
    private Vector<Evento> listaEventos;
    
    public ListaEventos ()  {
        this.listaEventos = new Vector<Evento>();
    }
    
    public void addEvento (Evento e) {
        listaEventos.add(e);
    }
    
}
