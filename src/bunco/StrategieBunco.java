package bunco;

import framework.Jeu;
import framework.Strategie;

public class StrategieBunco extends Strategie {

    /**
     * Ce constructeur permet de créer une nouvelle de partie de Bunco classique jouable en 6 tours avec 3 dés.
     */
    public StrategieBunco() {
        super(6);
    }

    /**
     * Ce constructeur permet de créer une nouvelle partie de Bungo avec un nombre de dés et de tours différent du jeu original
     *
     * @param nbTour nombre de tours de jeu
     */
    public StrategieBunco(int nbTour) {
        super(nbTour);
    }

    /**
     * Méthode permettant de faire passer un tour de jeu
     * @param jeu Partie de jeu actuelle
     */
    public void calculerScoreTour(Jeu jeu) {
        // for ONE player (écrit dans les consignes qu'il faut faire pour un joueur seulement)
        // utiliser les dès et attribuer les points selon le résultat

    }

    public void calculerLeVainqueur(Jeu jeu) {

    }
}
