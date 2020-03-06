package framework;

import java.util.Iterator;

public class TabIterator implements Iterator {

    private Object[] tab;
    int position = 0;

    public TabIterator(Object[] tab){
        this.tab = tab;
    }

    /**
     * Méthode qui vérifie s'il y a un prochain élément dans le tableau
     * @return true s'il y a un prochain élément dans le tableau
     */
    @Override
    public boolean hasNext() {

        return position < tab.length && tab[position] != null;
    }

    /**
     * Méthode qui retourne le prochain élément du tableau
     * @return item: Object
     */
    @Override
    public Object next() {
        Object item = tab[position];
        this.position ++;
        return item;
    }

    /**
     * Méthode qui recule l'iterateur d'une case du tableau
     */
    public void stepBack() {
        this.position --;
    }

    /**
     * méthode qui remet la position de l'itérateur à 0
     */
    public void goToHead(){
        this.position = 0;
    }
}
