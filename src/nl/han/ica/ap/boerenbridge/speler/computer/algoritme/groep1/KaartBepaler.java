package nl.han.ica.ap.boerenbridge.speler.computer.algoritme.groep1;

import nl.han.ica.ap.boerenbridge.kaart.Kaart;
import nl.han.ica.ap.boerenbridge.speler.computer.algoritme.AKaart;
import nl.han.ica.ap.boerenbridge.speler.computer.algoritme.AlgoritmeHelper;
import nl.han.ica.ap.boerenbridge.speler.computer.algoritme.Kaartteller;
import nl.han.ica.ap.boerenbridge.speler.computer.algoritme.Typeteller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 07-Jun-16.
 */
public class KaartBepaler extends AKaart {
    public KaartBepaler(Kaartteller kaartteller, Typeteller typeteller)
    {
        super(kaartteller, typeteller);
    }

    @Override
    public Kaart bepaalKaart(ArrayList<Kaart> hand, ArrayList<Kaart> gespeeldeKaarten, int nogTeWinnen)
    {
        List<Kaart> uitslag;
        int n = 10000;
        int winkans = 0;
        Kaart speelkaart = null;
        for(Kaart kaart : AlgoritmeHelper.toegestaneKaarten(hand,gespeeldeKaarten) ){
            int teller = 0;
            for(int i = 0; i<n; i++){
                uitslag = AlgoritmeHelper.genereerBord(kaart, gespeeldeKaarten,kaartteller.getOngespeeldeKaarten(hand));
                if(AlgoritmeHelper.bepaalWinnaar(uitslag, kaart))
                    teller++;
            }
            int tempwinkans  = teller / n * 100;

            if((nogTeWinnen >=1 && tempwinkans >= winkans) || (tempwinkans <= winkans && nogTeWinnen == 0) || winkans == 0) {
                winkans = tempwinkans;
                speelkaart = kaart;
            }
        }
        return speelkaart;
    }
}

