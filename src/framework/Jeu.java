package framework;

public abstract class Jeu {

    private IStrategie strategie;
    private int nbTours;
    private PlayerCollection joueurs;
    private DeCollection des;


    public void calculerScoreTour(){
        this.strategie.calculerScoreTour(this);
    }

    public void calculerLeVainqueur(){
        this.strategie.calculerLeVainqueur(this);
    }
}
