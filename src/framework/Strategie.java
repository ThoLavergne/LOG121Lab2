package framework;

public abstract class Strategie {
    private int nbTour;


    public Strategie(int nbTour){
        this.nbTour= nbTour;
    }
    public int getNbTour() {
        return nbTour;
    }


    public abstract void calculerScoreTour(Jeu jeu);
    public abstract void calculerLeVainqueur(Jeu jeu);
}
