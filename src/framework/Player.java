package framework;

public class Player implements Comparable<Player>{

    private int score;
    private String name;

    //Constructeur qui initialise le nom du joueur selon son numero
    public Player (int numero){
        this.name = "Player #" + numero;
    }

    public String getName(){
        return  this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getScore(){
        return this.score;
    }

    public void setScore(int score){
        this.score = score;
    }

    /**
     * Méthode qui compare les joueurs selon leur score
     * @param player
     * @return 1 si score inferieur a celui du Player en param, -1 si superieur, 0 si egal
     */
    @Override
    public int compareTo(Player player) {

        if(this.score < player.getScore()){
            return 1;
        }

        else if(this.score > player.getScore()){
            return -1;
        }

        else{
            return 0;
        }

    }

    /**
     * Méthode qui affiche l'info d'un joueur
     */
    public String toString(){
        return this.name + ": " + this.score + " points";
    }
}
