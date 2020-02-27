package framework;

public class De implements Comparable<De>{

    private int nbFaces;

    public De (int nbFaces){
        this.nbFaces = nbFaces;
    }

    @Override
    public int compareTo(De de) {
        return 0;
    }
}
