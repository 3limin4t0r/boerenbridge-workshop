package nl.han.ica.ap.boerenbridge.speler.computer.algoritme.groep1;

import nl.han.ica.ap.boerenbridge.kaart.Kaart;
import nl.han.ica.ap.boerenbridge.speler.computer.algoritme.ABieding;
import nl.han.ica.ap.boerenbridge.speler.computer.algoritme.Kaartteller;
import nl.han.ica.ap.boerenbridge.speler.computer.algoritme.Typeteller;

import java.util.ArrayList;

/**
 * Created by Max on 07-Jun-16.
 */
public class BodBepaler extends ABieding {
    public BodBepaler(Kaartteller kaartteller, Typeteller typeteller) {
        super(kaartteller, typeteller);
    }

    @Override
    public int bepaalBieding(ArrayList<Kaart> hand, ArrayList<Integer> biedingen) {
        return 0;
    }
}
