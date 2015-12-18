/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManualTests;

import Controller.BetESSAPI;
import Model.Odd;
import View.OddView;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Class used to manually test oddView.
 * @author José Cortez
 */
public class OddViewMTest {
    
    public static void main (String[] args){
        
        // criar casa de apostas
        BetESSAPI casaApostas = new BetESSAPI();
        
        
        
        OddView ov = new OddView();
        Odd o = ov.viewCreateOdd();
        System.out.println(ov.viewOdd(o));
        ov.viewUpdateOdd(o);
        System.out.println(ov.viewOdd(o));
        ov.viewDeleteOdd(o);
        
    }
    
    @Test
    public void test (){
        assertTrue(true);
    }
    
}
