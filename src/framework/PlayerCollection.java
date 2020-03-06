package framework;

public class PlayerCollection extends ComparableCollection{

    /**
     * Méthode qui affiche l'info de tous les Players de la collection, dans l'ordre dans lequel ils sont dans la
     * PlayerCollection
     */
    @Override
   public void afficherComparables(){

        System.out.println("\nCLASSEMENT DES JOUEURS");
        super.afficherComparables();
    }

    /**
     * Méthode qui classe les joueurs selon leur score, du plus haut au plus bas, et retourne une copie
     * de la Collection, triée
     * @return rankedComparables : ComparableCollection en ordre décroisssant de score
     */
    @Override
    public PlayerCollection triDecroissant(){

        ComparableCollection rankedComparables = new PlayerCollection();

        rankedComparables.setTabComparables(this.getTabComparable().clone());

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

        return (PlayerCollection) rankedComparables;
    }



}
