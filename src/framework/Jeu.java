package framework;

import java.util.Collection;
import java.util.Iterator;

public class Jeu {

    private Strategie strategie;
    private int nbTours;
    private int tourActuel;
    private PlayerCollection players;
    private Player playerActif;
    //private int[] resultatActif;
    private DeCollection des;

    public Jeu(PlayerCollection players, DeCollection des, int nbrTours, Strategie strategie){
        this.strategie = strategie;
        this.nbTours = nbrTours;
        this.players = players;
        this.des = des;
        this.tourActuel=1;
        this.playerActif = (Player) players.first();
    }

    //Accesseurs et mutateurs de la classe Jeu
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

    public Player getPlayerActif(){ return  this.playerActif; }

    public void setPlayerActif(Player playerActif) { this.playerActif = playerActif; }

    public PlayerCollection getPlayers() {
        return players;
    }

    public void setPlayers(PlayerCollection players) { this.players = players; }

    public DeCollection getDes() {
        return des;
    }

    public void setDes(DeCollection des) {
        this.des = des;
    }

   /* public int[] getResultatActif(){ return this.resultatActif; }

    public void setResultatActif(int[] resultatActif){ this.resultatActif = resultatActif; }
*/
    public int getTourActuel() {
        return tourActuel;
    }

    public void setTourActuel(int tourActuel) {
        this.tourActuel = tourActuel;
    }

    ////////////////////////////////////

    /**
     * Méthode qui appelle la strategie pour calculer le score, qui va etre attribué au joueur actif
     * @return le score calculé
     */
    public int calculerScoreTour() {
        return this.strategie.calculerScoreTour(this);
    }

    /**
     * Méthode qui appelle la strategie et qui retourne une nouvelle PlayerCollection avec les memes joueurs que ceux
     * du jeu, mais triée en ordre decroissant de score
     * @return la PlayerCollection triée en ordre decroissant de score
     */
    public PlayerCollection calculerLeVainqueur() {
        return this.strategie.calculerLeVainqueur(this);
    }



    /**
     * Méthode qui lance la partie et gère le tour des joueurs jusqu'à la fin de la partie
     */
    public void jouerPartie(){

        //On specifie qu'on est au premier tour
        this.tourActuel = 1;

        //tant que les jours de jeu ne sont pas tous joués
        while(this.tourActuel <= nbTours){

            System.out.println("\nTOUR DE JEU #" + this.tourActuel);

            //On recupere l'iterateur
            Iterator playerIterator = players.iterator();

            //tant que tous les joueurs n'ont pas joué
            while(playerIterator.hasNext()){

                //Le joueur actif obtient le score correspondant au brassage de dé
                this.playerActif = (Player) playerIterator.next();
                System.out.println("Tour de jeu du "+ this.playerActif.getName());
                this.playerActif.setScore(calculerScoreTour());
            }

            //On recoit la PLayerCollection, triés selon leur score
            PlayerCollection rankings = calculerLeVainqueur();
            //Afficher le classement
            rankings.afficherComparables();
            //On incrémente le tourActuel
            tourActuel++;
        }
    }
}
