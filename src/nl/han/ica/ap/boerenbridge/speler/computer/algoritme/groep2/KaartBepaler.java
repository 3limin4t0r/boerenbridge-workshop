package nl.han.ica.ap.boerenbridge.speler.computer.algoritme.groep2;

import nl.han.ica.ap.boerenbridge.kaart.Kaart;
import nl.han.ica.ap.boerenbridge.speler.computer.algoritme.AKaart;
import nl.han.ica.ap.boerenbridge.speler.computer.algoritme.Kaartteller;
import nl.han.ica.ap.boerenbridge.speler.computer.algoritme.Typeteller;

import java.util.ArrayList;

/**
 * Created by Max on 07-Jun-16.
 */
public class KaartBepaler extends AKaart {
    public KaartBepaler(Kaartteller kaartteller, Typeteller typeteller) {
        super(kaartteller, typeteller);
    }

    @Override
    public Kaart bepaalKaart(ArrayList<Kaart> hand, ArrayList<Kaart> gespeeldeKaarten, int nogTeWinnen) {
        return null;
    }
}
