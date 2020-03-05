import framework.De;
import framework.DeCollection;
import framework.PlayerCollection;

public class TestMain {

    public static void main(String[] args){

        DeCollection des = new DeCollection();
        PlayerCollection players = new PlayerCollection();

        De de1 = new De(1);
        De de2 = new De(6);
        De de3 = new De(6);

        des.add(de1);
        des.add(de2);
        des.add(de3);

        System.out.println(des.size());


        des.remove(de1);

        System.out.println(des.size());


    }
}
