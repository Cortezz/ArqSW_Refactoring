/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManualTests;

import Controller.BetESSAPI;
import Model.Aposta;
import Model.Apostador;
import Model.Evento;
import View.ApostaView;
import java.util.Date;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Cortez
 */
public class ApostaViewMTest {
    
    public static void main (String[] args){
        
        BetESSAPI casa = new BetESSAPI();
        ApostaView apostaView = new ApostaView();
        
        Evento e1 = new Evento("FC Porto", "Real Madrid",new Date());
        e1.setOdds(1,2,3);
        Apostador apostador = new Apostador("José","jose@gmail.com",2000);
        
        Aposta a = casa.registaAposta(e1, apostador);
        System.out.println(apostaView.viewAposta(a));
        apostaView.viewUpdateAposta(a);
        apostaView.viewDeleteAposta(a);
        
        
        
    }
    
    
    
    
    
    @Test
    public void test (){
        assertTrue(true);
    }
    
}
