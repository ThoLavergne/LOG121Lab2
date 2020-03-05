package framework;

public class Player implements Comparable<Player>{

    private int score;


    public int getScore(){
        return this.score;
    }

    public void setScore(int score){
        this.score = score;
    }

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
}
