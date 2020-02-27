package bungo;

import framework.Jeu;
import framework.Strategie;

public class StrategieBungo extends Strategie {
    /**
     * Ce constructeur permet de créer une nouvelle de partie de Bunco classique jouable en 6 tours avec 3 dés.
     */
    public StrategieBungo() {
        super(6, 3);
    }

    /**
     * Ce constructeur permet de créer une nouvelle partie de Bungo avec un nombre de dés et de tours différent du jeu original
     *
     * @param nbTour nombre de tours de jeu
     * @param nbDes nombre de dés utilisé pour le jeu
     */
    public StrategieBungo(int nbTour, int nbDes) {
        super(nbTour, nbDes);
    }

    /**
     * Méthode permettant de faire passer un tour de jeu
     * @param jeu
     */
    public void calculerScoreTour(Jeu jeu) {
        // for all player
        // utiliser les dès et attribuer les points selon le résultat
    }

    public void calculerLeVainqueur(Jeu jeu) {

    }
}
