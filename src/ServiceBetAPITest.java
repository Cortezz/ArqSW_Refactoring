
import Controller.BetESSAPI;
import Model.*;
import View.*;

public class ServiceBetAPITest {

    public static void main(String[] args) {

        
        
       
        
        
        // criar casa de apostas
        BetESSAPI casaApostas = new BetESSAPI();
        
        
        /*
        OddView ov = new OddView();
        Odd o = ov.viewCreateOdd();
        System.out.println(ov.viewOdd(o));
        ov.viewUpdateOdd(o);
        System.out.println(ov.viewOdd(o));
        ov.viewDeleteOdd(o);*/

        /*
        // Criar dois eventos na casa de apostas
        Evento evento1 = casaApostas.registaEvento();
        casaApostas.actualizaOdd(evento1, 1, 2, 3);
        Evento evento2 = casaApostas.registaEvento();
        casaApostas.actualizaOdd(evento2,1, 5, 3);*/

        // Registar dois apostadores
        /*Apostador apostador1 = casaApostas.registaApostador();
        casaApostas.actualizaApostador(apostador1);
        casaApostas.viewApostadores();
        casaApostas.deleteApostador(apostador1);
        casaApostas.viewApostadores();*/

        Bookie bookie1 = casaApostas.registaBookie();
        Evento evento1 = casaApostas.registaEvento(bookie1);
        Evento evento2 = casaApostas.registaEvento(bookie1);
        
        casaApostas.viewEventos();
        casaApostas.viewApostadores();

        
        // Registar apostas
        Apostador apostador2 = casaApostas.registaApostador();
        Aposta aposta1 = casaApostas.registaAposta(evento1, apostador2);
        Aposta aposta2 = casaApostas.registaAposta(evento2, apostador2);
        
        
        casaApostas.fechaEvento(evento1, 'x',bookie1);
        casaApostas.fechaEvento(evento2, 'x',bookie1);

        
        
        
        
        


    }

}
