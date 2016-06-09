package nl.han.ica.ap.boerenbridge.speler.computer.algoritme.groep2;

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
    public KaartBepaler(Kaartteller kaartteller, Typeteller typeteller) {
        super(kaartteller, typeteller);
    }

    @Override
    public Kaart bepaalKaart(ArrayList<Kaart> hand, ArrayList<Kaart> huidigeBord, int nogTeWinnen) {
        Kaart returnKaart = null;
        List<Kaart> speelbareKaarten = AlgoritmeHelper.toegestaneKaarten(hand, huidigeBord);


        int[] puntenTelling = new int[speelbareKaarten.size()];

        for (Kaart k : speelbareKaarten) {
            for (int i = 0; i < 100000; i++) {
                if (AlgoritmeHelper.bepaalWinnaar(AlgoritmeHelper.genereerBord(k, huidigeBord, kaartteller.getOngespeeldeKaarten(speelbareKaarten)), k)) {
                    puntenTelling[speelbareKaarten.indexOf(k)] ++;
                }
            }
        }

        for (int i = 0; i < puntenTelling.length; i++) {
                if (returnKaart == null)
                    returnKaart = speelbareKaarten.get(i);
                else if (nogTeWinnen > 0) {
                    if(puntenTelling[speelbareKaarten.indexOf(returnKaart)] > puntenTelling[i])
                        returnKaart = speelbareKaarten.get(i);
                } else {
                        if (puntenTelling[speelbareKaarten.indexOf(returnKaart)] < puntenTelling[i])
                            returnKaart = speelbareKaarten.get(i);
                }
        }

        return returnKaart;
    }
}
