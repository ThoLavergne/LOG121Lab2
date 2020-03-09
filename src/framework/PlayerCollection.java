package framework;

public class PlayerCollection extends ComparableCollection{

    /**
     * Méthode qui affiche l'info de tous les Players de la collection, dans l'ordre dans lequel ils sont dans la
     * PlayerCollection
     */
    @Override
   public void afficherComparables(){

        System.out.println("\nCLASSEMENT DES JOUEURS");
        System.out.print("\nVainqueur:");
        super.afficherComparables();
    }

    /**
     * Méthode qui classe les joueurs selon leur score, du plus haut au plus bas, et retourne une copie
     * de la Collection, triée
     * Utilisation du triSelection
     * @return rankedComparables : PlayerCollection en ordre décroisssant de score
     */
    public PlayerCollection triDecroissant(){

        PlayerCollection rankedComparables = new PlayerCollection();

        //On clone le tableau de Comparables dans une nouvelle Collection de joueurs
        rankedComparables.setTabComparables(this.getTabComparable().clone());


        //On fait un tri sélection en ordre décroissant
        int pos_max = 0;

        for (int indice_passe = 0; indice_passe < rankedComparables.size() -1 ; indice_passe++) {

            pos_max = indice_passe;

            for (int indice_recherche = (indice_passe+1); indice_recherche < rankedComparables.size(); indice_recherche ++ ) {

                if(rankedComparables.getComparable(indice_recherche).compareTo(rankedComparables.getComparable(pos_max)) == -1) {
                    pos_max = indice_recherche;
                }
            }

            Comparable temp = rankedComparables.getComparable(indice_passe);
            Comparable max = rankedComparables.getComparable(pos_max);
            rankedComparables.setComparable(max, indice_passe);
            rankedComparables.setComparable(temp, pos_max);

        }

        //On retourne la nouvelle collection de Joueurs
        return rankedComparables;
    }



}
