package ManualTests;

import Controller.BetESSAPI;
import Model.Bookie;
import Model.Evento;
import View.EventoView;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author José Cortez
 */
public class EventoViewMTest {
    
    public static void main (String[] args){
        
        BetESSAPI casa = new BetESSAPI();
        EventoView eventoView = new EventoView();
        Bookie b = new Bookie("João");
        
        
        Evento e = casa.registaEvento(b);
        System.out.println(eventoView.viewEvento(e));
        eventoView.viewUpdateEvento(e);
        eventoView.viewDeleteEvento(e);
        
        
    }
    
    @Test
    public void test (){
        assertTrue(true);
    }
    
}
