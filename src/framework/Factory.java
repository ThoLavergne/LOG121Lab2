package framework;

public abstract class Factory {

    //Méthode Template de la création d'une partie
    public final void creerPartie() {
        DeCollection des = creerDes();
        PlayerCollection players = creerPlayers();
        creerJeu(des, players, );
    }

    public abstract DeCollection creerDes();

    public abstract PlayerCollection creerPlayers();

    public void creerJeu(DeCollection des, PlayerCollection players, int nbTours, Strategie strategie) {
    }

    //Méthode Fabrique
    public abstract Strategie strategie();

}
