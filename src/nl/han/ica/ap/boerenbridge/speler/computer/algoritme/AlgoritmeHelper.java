package nl.han.ica.ap.boerenbridge.speler.computer.algoritme;

import nl.han.ica.ap.boerenbridge.kaart.Kaart;

import java.util.ArrayList;
import java.util.List;

import static nl.han.ica.ap.boerenbridge.kaart.KaartType.SCHOPPEN;

public class AlgoritmeHelper {

    /**
     * Bepaald welke speler de slag gewonnen heeft.
     * @param bord Het bord met de gespeelde kaarten.
     * @return Of de speler wint.
     */
    static public boolean bepaalWinnaar(List<Kaart> bord, Kaart kaart) {
        Kaart besteKaart = bord.get(0);

        for (Kaart bordKaart : bord)
            besteKaart = bepaalBesteKaart(bordKaart, besteKaart);

        return besteKaart == kaart;
    }

    /**
     * Creeer een lijst met kaarten die toegestaan zijn om te spelen.
     * @param hand De huidige hand.
     * @param bord Het huidige bord.
     * @return Een lijst met kaarten die opgegooit mogen worden.
     */
    static public List<Kaart> toegestaneKaarten(List<Kaart> hand,
                                                List<Kaart> bord) {
        List<Kaart> toegestaneKaarten = new ArrayList<>(hand);
        if (bord.size() == 0) return toegestaneKaarten;

        Kaart teBedienenKaart = bord.get(0);
        for (Kaart kaart : hand)
            if (!kaart.compareType(teBedienenKaart))
                toegestaneKaarten.remove(kaart);

        if (toegestaneKaarten.size() == 0)
            return new ArrayList<>(hand);
        return toegestaneKaarten;
    }

    /**
     * Vergelijk twee kaarten.
     * @param nieuweKaart De kaart die je wilt vergelijken met huidige beste
     *                    kaart.
     * @param besteKaart De huidige beste kaart (kaart die kaarttype bepaald).
     * @return De de beste kaart, of de nieuwe kaart indien hoger dan de beste
     *         kaart.
     */
    static private Kaart bepaalBesteKaart(Kaart nieuweKaart, Kaart besteKaart) {
        if (nieuweKaart.getKaartType() == SCHOPPEN) {
            if (besteKaart.getKaartType() == SCHOPPEN) {
                if (nieuweKaart.getKaartWaarde().ordinal()
                        > besteKaart.getKaartWaarde().ordinal())
                    return nieuweKaart;
            }
            else
                return nieuweKaart;
        } else if (nieuweKaart.getKaartType() == besteKaart.getKaartType()) {
            if (nieuweKaart.getKaartWaarde().ordinal()
                    > besteKaart.getKaartWaarde().ordinal())
                return nieuweKaart;
        }
        return besteKaart;
    }

    /**
     * Vult een incompleet bord met de gegeven kaart en vult hierbij
     * willekeurige kaarten voor de overige tegenstander is.
     * @param teSpelenKaart De kaart die gespeeld dient te worden.
     * @param huidigBord Het huidige bord.
     * @param ongespeeldeKaarten De kaarten die nog niet uit het spel zijn.
     * @return Een mogelijk eindsituatie van een slag.
     */
    static public List<Kaart> genereerBord(Kaart teSpelenKaart,
                                     List<Kaart> huidigBord,
                                     List<Kaart> ongespeeldeKaarten) {
        ongespeeldeKaarten = new ArrayList<>(ongespeeldeKaarten);
        List<Kaart> mogelijkBord = new ArrayList<>(huidigBord);
        mogelijkBord.add(teSpelenKaart);

        int nRandomKaarten = 4 - huidigBord.size();

        for (int i = 0; i < nRandomKaarten; i++) {
            int rIndex = (int) (Math.random() * ongespeeldeKaarten.size());
            mogelijkBord.add(ongespeeldeKaarten.remove(rIndex));
            // Dikke error ongespeelde kaarten < 4
        }

        return mogelijkBord;
    }
}
