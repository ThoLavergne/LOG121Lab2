package bunco;

import framework.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class StrategieBunco extends Strategie {

    /**
     * Méthode permettant de faire jouer un tour de jeu et calculer le score du tour de jeu
     * @param jeu Partie de jeu actuelle
     * @return score
     */
    public int calculerScoreTour(Jeu jeu) {

        int scoreTour = 0;
        int tourActuel = jeu.getTourActuel();
        DeCollection des = jeu.getDes();
        boolean passerTour = false;

        //On affiche les

        //Calcul de toutes les options de pointages
        while(!passerTour){

            boolean bunco = false;
            int scoreBrassage = 0;

            //on recoit les faces des des dans un tableau
            int[] resultats = des.toutBrasser();

            //On affiche les dés
            System.out.print("Brassage:\t");
            for (int i = 0; i< resultats.length; i++){
                System.out.print(resultats[i]+ "\t");
            }

            //Si les 3 des sont identiques
            if(resultats[0] == resultats[1] && resultats[1] == resultats[2]){

                //Bunco s'ils correspondent au tour actuel
                if(resultats[0] == tourActuel){
                    bunco = true;
                    scoreBrassage = 21;
                }

                //5 pts s'ils ne correspondent pas au tour actuel
                else{
                    scoreBrassage = 5;
                }
            }

            //Si les 3 dés ne sont pas identiques
            else{

                //On ajoute au score la valeur de chaque dé qui correspond au tour actuel
                for (int i = 0; i< resultats.length; i++){
                    if(resultats[i] == tourActuel){
                        scoreBrassage += 1;
                    }
                }

            }


            System.out.println("= " + scoreBrassage+ "pts");

            //On ajoute le score du brassage au score du tour
            scoreTour += scoreBrassage;

            //On détermine s'il faut passer le tour
            if(bunco || scoreBrassage == 0){
                passerTour = true;
            }
        }

        return scoreTour;
    }

    /**
     * Méthode qui retourne les players du jeu classés dans une nouvelle PlayerCollection
     * Fait appel à la méthode triDecroissant de PlayerCollection
     * @param jeu
     * @return
     */
    public PlayerCollection calculerLeVainqueur(Jeu jeu) {

        PlayerCollection players = jeu.getPlayers();

        return players.triDecroissant();
    }
}
