package framework;

public abstract class Factory {

    //Constructeur de Factory avec la Stratégie et le nombre de joueurs en paramètres ?

    //Méthode de la création d'une partie
    public final void creerPartie(){
        creerDes();
        creerJoueurs();
        creerJeu();
    }
    public void creerDes(){
        //En fonction de la stratégie mise en paramètre
    }
    public void creerJoueurs(){
        //En fonction du nombre de joueurs mis en paramètre
    }
    public void creerJeu(){
        //En fonction de la stratégie mise en paramètre
    }

}
