package framework;

public class De implements Comparable<De>{

    private int nbFaces;
    private int faceObtenue;

    public De (int nbFaces){
        this.nbFaces = nbFaces;
    }


    public int getNbFaces(){
        return this.nbFaces;
    }

    public int getFaceObtenue(){
        return this.faceObtenue;
    }

    public void setFaceObtenue(int faceObtenue){
        this.faceObtenue = faceObtenue;
    }

    @Override
    public int compareTo(De de) {

        if(this.faceObtenue < de.getFaceObtenue()){
            return 1;
        }

        else if(this.faceObtenue > de.getFaceObtenue()){
            return -1;
        }

        else{
            return 0;
        }
    }
}
