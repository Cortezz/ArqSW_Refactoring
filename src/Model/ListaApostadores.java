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
public class ListaApostadores {
    
    private Vector<Apostador> listaApostadores;
    
    public ListaApostadores () {
        this.listaApostadores = new Vector<Apostador>();
    }
    
    
    public void addApostador (Apostador a){
        this.listaApostadores.add(a);
    }
}
