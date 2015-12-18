package ManualTests;

import Controller.BetESSAPI;
import Model.Bookie;
import View.BookieView;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Class used to manually test BookieView.
 * @author José Cortez
 */
public class BookieViewMTest {
    
    public static void main (String[] args){
        
        BetESSAPI casa = new BetESSAPI();
        BookieView bookieView = new BookieView();
        
        
        Bookie b = casa.registaBookie();
        System.out.println(bookieView.viewBookie(b));
        bookieView.viewUpdateBookie(b);
        bookieView.viewDeleteAposta(b);
        
    }
    
    @Test
    public void test (){
        assertTrue(true);
    }
    
}
