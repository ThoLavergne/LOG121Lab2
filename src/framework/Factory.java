package framework;

public abstract class Factory {

    //Méthode Template de la création d'une partie
    public final Jeu creerPartie(int nbPlayers, int nbDes, int nbTours) {

        DeCollection des = creerDes(nbDes);
        PlayerCollection players = creerPlayers(nbPlayers);

        return creerJeu(players, des, nbTours, this.strategie());
    }

    /**
     * Méthode finale qui retourne la nouvelle collection de joueurs
     * @param nbPlayers
     * @return players : PlayerCollection
     */
    private final PlayerCollection creerPlayers(int nbPlayers){

        PlayerCollection players = new PlayerCollection();

        for (int i = 0; i < nbPlayers; i++){
            players.add(new Player(i));
        }

        return players;
    };

    /**
     * Méthode qui retourne la nouvelle collection de Des
     * Elle doit être redefinie dans une sous-classe si on veut utiliser des dés qui n'ont pas 6 faces
     * @param ndDes
     * @return des : DeCollection
     */
    protected DeCollection creerDes(int ndDes){

        int nbFaces = 6;

        DeCollection des = new DeCollection();

        for (int i = 0; i < ndDes; i++){
            des.add(new De(nbFaces));
        }

        return des;
    };

    /**
     * Méthode qui crée le jeu à partir des paramètre données à créerPartie()
     * @param players
     * @param des
     * @param nbTours
     * @param strategie
     * @return monJeu : Jeu
     */
    protected Jeu creerJeu(PlayerCollection players, DeCollection des, int nbTours, Strategie strategie) {

        Jeu monJeu = new Jeu(players, des, nbTours, strategie);

        return monJeu;
    }

    //Méthode Fabrique abstraite qui retourne la Strategie que connait la Factory en question
    protected abstract Strategie strategie();

}
