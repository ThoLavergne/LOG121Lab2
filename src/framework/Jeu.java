package framework;

public abstract class Jeu {

    private Strategie strategie;
    private int nbTours;
    private PlayerCollection joueurs;
    private DeCollection des;


    public void calculerScoreTour() {

        while (nbTours < this.strategie.getNbTour()) {
            this.strategie.calculerScoreTour(this);
        }
    }
    public void calculerLeVainqueur(){
        this.strategie.calculerLeVainqueur(this);
    }
}
