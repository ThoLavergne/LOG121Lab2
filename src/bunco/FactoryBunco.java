package bunco;

import framework.*;

public class FactoryBunco extends Factory {

    //Le Bunco doit absolutment avoir 6 tours de jeu et 3 dés
    private final int nbToursBunco = 6;
    private final int nbDesBunco = 3;

    /**
     * Méthode qui crée la collection de 3 dés obligatoire au Bunco
     * @param nbDes, **est ignoré
     * @return la DeCollection
     */
    @Override
    protected DeCollection creerDes(int nbDes){

        //On ignore le nombre de dés passé en paramètre lors de la création de la partie et on le fixe obligatoirement
        //à 3, le nombre de dés du bunco
        DeCollection des = super.creerDes(this.nbDesBunco);

        return des;
    };

    /**
     * Méthode qui crée le Jeu selon les players, des, nbTours fixé pour le bunco et la stratégieBunco
     * @param players
     * @param des
     * @param nbTours **ignoré
     * @param strategie
     * @return monJeu: Jeu
     */
    @Override
    protected Jeu creerJeu(PlayerCollection players, DeCollection des, int nbTours, Strategie strategie) {

        //On ignore le nombre de tours passé en paramètres et on le fixe à 6, obligatoire au Bunco

        return new Jeu(players, des, this.nbToursBunco, strategie);
    }

    /**
     * Méthode Fabrique qui retourne la stratégie connue par cette Factory
     * @return
     */
    @Override
    protected Strategie strategie() {
        return new StrategieBunco();
    }
}
