package framework;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class DeCollection extends ComparableCollection {

    private static Random rand = new Random();

    /**
     * Méthode qui brasse tous les dés de la collection et retourne un tableau de resultats qui contient le resultat de
     * chaque dé
     * @return resultats : int[]
     */
    public int[] toutBrasser(){

        int [] resultats = new int[this.getCapacite()];

        TabIterator iterator = this.iterator();
        int position = 0;

        while(iterator.hasNext()){

            De deCourant = (De) iterator.next();
            int nbFaces = deCourant.getNbFaces();
            deCourant.setFaceObtenue(rand.nextInt(nbFaces) + 1);
            resultats[position] = deCourant.getFaceObtenue();
            position ++;

        }

        return resultats;
    }


}
