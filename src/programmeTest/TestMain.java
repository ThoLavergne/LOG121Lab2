package programmeTest;

import bunco.FactoryBunco;
import framework.Jeu;

public class TestMain {

    public static void main(String[] args){

        FactoryBunco fBunco = new FactoryBunco();
        Jeu maPartie = fBunco.creerPartie(5, 4, 8);

        maPartie.jouerPartie();



    }
}
