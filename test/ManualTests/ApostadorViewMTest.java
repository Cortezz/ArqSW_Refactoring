package ManualTests;

import Controller.BetESSAPI;
import Model.Apostador;
import View.ApostadorView;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Class used to manually test ApostadorView.
 * @author José Cortez
 */
public class ApostadorViewMTest {
    
    public static void main (String[] args){
        
        BetESSAPI casa = new BetESSAPI();
        ApostadorView av = new ApostadorView();
        Apostador a = casa.registaApostador();
        
        System.out.println(av.viewApostador(a));
        av.viewUpdateApostador(a);
        av.viewDeleteApostador(a);
        
    }
    
    @Test
    public void test (){
        assertTrue(true);
    }
    
}
