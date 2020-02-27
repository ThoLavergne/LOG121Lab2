package framework;

public abstract class Factory {

    //Constructeur de Factory avec la Stratégie et le nombre de joueurs en paramètres ?

    //Méthode de la création d'une partie
    public final void creerPartie() {
        DeCollection des = creerDes();
        PlayerCollection players = creerJoueurs();
        creerJeu(des, players);
    }

    public abstract DeCollection creerDes(); //En fonction de la stratégie mise en paramètre

    private PlayerCollection creerJoueurs() //En fonction du nombre de joueurs mis en paramètre
    {
        //TODO
        return null;
    }

    public abstract void creerJeu(DeCollection des, PlayerCollection players);
    //En fonction de la stratégie mise en paramètre


}
