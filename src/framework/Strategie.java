package framework;

public abstract class Strategie {
    private int nbTour;
    private int nbDes;

    public Strategie(int nbTour, int nbDes){
        this.nbTour= nbTour;
        this.nbDes = nbDes;
    }
    public int getNbTour() {
        return nbTour;
    }

    public int getNbDes() {
        return nbDes;
    }

    public abstract void calculerScoreTour(Jeu jeu);
    public abstract void calculerLeVainqueur(Jeu jeu);
}
