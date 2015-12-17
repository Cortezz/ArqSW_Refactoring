
import Controller.BetESSAPI;
import Model.Apostador;
import Model.Evento;
import Model.Aposta;
import Model.Odd;
import View.*;

public class ServiceBetAPITest {

    public static void main(String[] args) {

        
        
        /*
        // criar casa de apostas
        BetESSAPI casaApostas = new BetESSAPI();

        // Criar dois eventos na casa de apostas
        Evento evento1 = casaApostas.registaEvento();
        casaApostas.actualizaOdd(evento1, 1, 2, 3);
        Evento evento2 = casaApostas.registaEvento();
        casaApostas.actualizaOdd(evento2,1, 5, 3);


        Evento evento3 = casaApostas.registaEvento();
        evento3.actualizaOdd(1, 5, 3);

        // Registar dois apostadores
        Apostador apostador1 = casaApostas.registaApostador();
        casaApostas.actualizaApostador(apostador1);
        casaApostas.viewApostadores();
        casaApostas.deleteApostador(apostador1);
        casaApostas.viewApostadores();

        casaApostas.viewEventos();
        casaApostas.viewApostadores();

        /*
        // Registar apostas
        casaApostas.registaAposta(apostador1, evento1);
        casaApostas.registaAposta(apostador1, evento2);*/
        /*
        // fechar eventos 
        casaApostas.fechaEvento(evento1, 'x');
        casaApostas.fechaEvento(evento2, 'x');*/

        // regsitar bookies
        // TODO - implementar funcionalidades de bookie
        // Bokkie bookie1 = casaApostas.registaBookie();
        // Evento evento1 = casaApostas.registaEvento(bookie1);
        // casaApostas.fechaEvento(bookie, evento1);*/
        
        
        //////
        // Novos testes
        /////
        
        BetESSAPI betESS = new BetESSAPI();/*
        Evento e = betESS.registaEvento();
        betESS.viewEventos();*/
        
        
        /** Teste VIEW EVENTO**//*
        EventoView ev = new EventoView(betESS);
        //Create
        Evento e1 = ev.viewCreateEvento();
        //Read
        System.out.println(ev.viewEvento(e1));
        //Update
        ev.viewUpdateEvento(e1);
        //Delete
        ev.viewDeleteEvento(e1);*/


        
        /** Teste Apostador View **/
        ApostadorView av = new ApostadorView(betESS);/*
        // Create
        Apostador a1 = av.viewCreateApostador();
        // Read
        System.out.println(av.viewApostador(a1));
        //Update
        av.viewUpdateApostador(a1);
        //Delete
        av.viewDeleteApostador(a1);*/
        
        /** Teste Aposta View **/
        ApostaView apv = new ApostaView(betESS);
        //Create
        Apostador a2 = av.viewCreateApostador();
        Aposta ap1 = apv.viewCreateAposta();
        ap1.setApostador(a2);
        ap1.setOdd_fixada(new Odd());
        //Read
        System.out.println(apv.viewAposta(ap1));
        //Update
        apv.viewUpdateAposta(ap1);
        //Delete
        apv.viewDeleteAposta(ap1);
        
        


    }

}
