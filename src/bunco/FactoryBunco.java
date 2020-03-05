package bunco;

import framework.DeCollection;
import framework.Factory;
import framework.PlayerCollection;
import framework.Strategie;

public class FactoryBunco extends Factory {

    @Override
    public PlayerCollection creerPlayers(){
        //todo
        return null;
    }

    @Override
    public DeCollection creerDes(){
        //TODO
        return null;
    }

    @Override
    public void creerJeu(DeCollection des, PlayerCollection players, int nbTours, Strategie strategie) {
        //TODO
    }

    @Override
    public Strategie strategie() {
        return new StartegieBunco();
    }
}
