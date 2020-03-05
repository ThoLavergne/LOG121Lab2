package framework;

public class Jeu {

    private Strategie strategie;
    private int nbTours;
    private int tourActuel;
    private PlayerCollection joueurs;
    private DeCollection des;

    public Jeu(Strategie strategie, int nbrTours, PlayerCollection joueurs, DeCollection des){
        this.strategie = strategie;
        this.nbTours = nbrTours;
        this.joueurs = joueurs;
        this.des = des;
        this.tourActuel=1;
    }

    public Strategie getStrategie() {
        return strategie;
    }

    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }

    public int getNbTours() {
        return nbTours;
    }

    public void setNbTours(int nbTours) {
        this.nbTours = nbTours;
    }

    public PlayerCollection getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(PlayerCollection joueurs) {
        this.joueurs = joueurs;
    }

    public DeCollection getDes() {
        return des;
    }

    public void setDes(DeCollection des) {
        this.des = des;
    }

    public int getTourActuel() {
        return tourActuel;
    }

    public void setTourActuel(int tourActuel) {
        this.tourActuel = tourActuel;
    }

    public void calculerScoreTour() {

        while (tourActuel < nbTours) {
            this.strategie.calculerScoreTour(this);
            this.tourActuel++;
        }
    }

    public void calculerLeVainqueur() {
        this.strategie.calculerLeVainqueur(this);
    }

    /**
     * Méthode qui lance la partie et gère le tour des joueurs jusqu'à la fin de la partie
     */
    public void lancerPartie(){

    }
}
