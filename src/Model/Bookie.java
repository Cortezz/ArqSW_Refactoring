package Model;

import java.util.HashMap;

/**
 * Class which represents the Bookie.
 * @author José Cortez
 */
public class Bookie {
    
    private String nome;
    
    /**
     * Empty constructor.
     */
    public Bookie (){
        nome = "";
    }
    
    public Bookie (String nome){
        this.nome =nome;
    }
    
    
    
    /*Getters*/
    public String getNome () {return this.nome;}
    /*Setters*/
    public void setNome (String nome) {this.nome = nome;}
    
    
    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if (o==null || o.getClass()!=this.getClass()) return false;
        Bookie b = (Bookie)o;
        return (this.nome.equals(b.getNome()));
    }
    
}
