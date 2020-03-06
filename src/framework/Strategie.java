package framework;

import java.util.Collection;

public abstract class Strategie {

    public abstract int calculerScoreTour(Jeu jeu);
    public abstract PlayerCollection calculerLeVainqueur(Jeu jeu);

}
