package framework;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ComparableCollection implements Collection<Comparable>{

    private Comparable[] tabComparable;
    private int capacite = 0;

    public ComparableCollection(){
        tabComparable = new Comparable[0];
    }

    public ComparableCollection(int capacite){
        tabComparable = new Comparable[capacite];
        this.capacite = capacite;
    }

    //Accesseur de la capacite de la Collection
    public int getCapacite() {
        return this.capacite;
    }

    /**
     * Méthode qui permet de fournir le tableau de Comparable directement à cette collection
     * @param comps
     */
    public void setTabComparables(Comparable [] comps){
        this.tabComparable = comps;
        this.capacite = comps.length;
    }

    /**
     * Méthode qui retourne le tableau de données Comparable
     * @return le tableau de données Comparable
     */
    public Comparable[] getTabComparable() {
        return tabComparable;
    }

    @Override
    public int size() {
        return tabComparable.length;
    }

    @Override
    public boolean isEmpty() {
        return this.tabComparable.length == 0;
    }

    @Override
    public boolean contains(Object o) {

        for (Comparable comparable : tabComparable) {
            if (comparable.equals(o)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Méthode qui retourne l'itérateur compatible avec cette Collection
     * @return le TabIterator
     */
    public TabIterator iterator() {
        return new TabIterator(tabComparable);
    }

    /**
     * Méthode qui affiche l'info de tous les Players de la collection, dans l'ordre dans lequel ils sont dans la
     * PlayerCollection
     */
    public void afficherComparables(){

        for (Comparable aAfficher : this) {
            System.out.println(aAfficher.toString());
        }
    }

    /**
     * Méthode qui retourne une copie du tableau de Comparable de la Collection
     * @return une copie du tableau de Comparable de la Collection
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.tabComparable, tabComparable.length);
    }

    /**
     * Méthode qui ajoute le Comparable à la fin de la Collection
     * @param comp
     * @return true si l'operation a fonctionné
     * inspiré de l'implémentation de ArrayList
     */
    public boolean add(Comparable comp) {
        this.add(comp, this.tabComparable, this.tabComparable.length);
        return true;
    }

    /**
     * Méthode privée qui étend la Collection et ajoute le nouveau Comparable à la position spécifiée
     * @param comp
     * @param tabComparable
     * @param position
     * inspiré de l'implémentation de ArrayList
     */
    private void add(Comparable comp, Comparable[] tabComparable, int position) {

        if (position == tabComparable.length) {
            tabComparable = this.etendre();
        }

        tabComparable[position] = comp;
        this.capacite = position + 1;
    }

    /**
     * Méthode qui étend la Collection avec des cases vides pour avoir une Collection de grandeur fournie en paramètre
     * @param newCapacite
     * @return
     * inspiré de l'implémentation de ArrayList
     */
    private Comparable[] etendre(int newCapacite) {
        return this.tabComparable = Arrays.copyOf(this.tabComparable, newCapacite);
    }

    /**
     * Méthode qui étend la Collection de 1
     * @return le tableau étendu d'une case
     * inspiré de l'implémentation de ArrayList
     */
    private Comparable[] etendre() {
        return this.etendre(this.capacite + 1);
    }

    /**
     * Méthode qui retire de la Collection l'objet passé en paramètre
     * @param o
     * @return true si l'élément a été enlevé, false s'il n'était pas dans la Collection
     */
    @Override
    public boolean remove(Object o) {

        Comparable[] newTab;
        boolean trouve = false;
        int posAEnlever = 0;

        for (int i = 0; i < this.capacite; i++){
            if (tabComparable[i].equals(o)){
                trouve = true;
                posAEnlever = i;
            }
        }

        if(!trouve){
            return false;
        }

        else{
            this.capacite = this.capacite - 1;
            newTab = new Comparable[this.capacite];
            boolean trouPasse = false;

            for (int j = 0; j < tabComparable.length; j++){

                if(!trouPasse){

                    if(j == posAEnlever){
                        trouPasse = true;
                    }

                    else{
                        newTab[j] = tabComparable[j];
                    }
                }

                else{
                    newTab[j-1] = tabComparable[j];
                }
            }

            tabComparable = newTab;
            return true;
        }
    }

    /**
     * Méthode qui retourne le premier comp de la collection
     * @return le premier Comparable de la collection
     */
    public Comparable first(){
        return this.tabComparable[0];
    }

    /**
     * Méthode qui retourne le dernier comp de la collection
     * @return le dernier Comparable de la collection
     */
    public Comparable last(){
        return this.tabComparable[capacite-1];
    }

    /**
     * Méthode qui retourne le Comparable à la position spécifiée
     * @param position
     * @return
     */
    Comparable getComparable(int position){

        if(position >= this.capacite){
            System.out.println("indice trop élevé: dernier élément retourné");
            return this.last();
        }

        else{
            return this.tabComparable[position];
        }
    }

    /**
     * Méthode qui insère un comp à la position passée en param
     * Ce comp efface celui qui était à cette position avant
     * @param comp
     * @param position
     */
    void setComparable(Comparable comp, int position){

        this.tabComparable[position] = comp;

    }

    /**
     * Méthode qui classe les joueurs selon leur score, du plus haut au plus bas, et retourne une copie
     * de la Collection, triée
     * @return rankedComparables : ComparableCollection en ordre décroisssant de score
     */
    public ComparableCollection triDecroissant(){

        ComparableCollection rankedComparables = new ComparableCollection();

        rankedComparables.setTabComparables(this.tabComparable.clone());

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

        return rankedComparables;
    }

    /**
     * Méthode qui verifie si la Collection contient tous les éléments de celle passée en paramètre
     * @param collection
     * @return
     */
    @Override
    public boolean containsAll(Collection<?> collection) {

        Iterator iterator = collection.iterator();

        while(iterator.hasNext()){

            if(!this.contains(iterator.next())){
                return false;
            }
        }

        return true;
    }

    /**
     * Méthode qui ajoute tous les joueurs de la Collection passée en paramètre à cette Collection
     * @param collection
     * @return
     */
    @Override
    public boolean addAll(Collection<? extends Comparable> collection) {

        Iterator iterator = collection.iterator();

        while(iterator.hasNext()){

            this.add((Comparable) iterator.next());
        }
        return true;
    }

    /**
     * Méthode qui retire tous les joueurs de la Collection passée en paramètre à cette Collection
     * @param collection
     * @return
     */
    @Override
    public boolean removeAll(Collection<?> collection) {

        Iterator iterator = collection.iterator();

        while(iterator.hasNext()){

            this.remove(iterator.next());

        }
        return true;
    }

    /**
     * Méthode qui conserve seulement dans cette Collection les éléments de la Collection passée en paramètre
     * @param collection
     * @return
     */
    @Override
    public boolean retainAll(Collection<?> collection) {

        TabIterator iterator = this.iterator();

        while(iterator.hasNext()){

            Object aVerifier = iterator.next();

            if(!collection.contains(aVerifier)){
                this.remove(aVerifier);
                iterator.stepBack();
            }
        }

        return true;
    }

    /**
     * Méthode qui retire tous les éléments de la Collection
     */
    @Override
    public void clear() {

        TabIterator iterator = this.iterator();

        while(iterator.hasNext()){
            this.remove(this.first());
        }
    }

    /**
     * Méthode qui retourne le contenu de la Collection dans le tableau passé en paramètre
     * Si le tableau est plus grand que la Collection, le tableau est rapetissé à la même grandeur que la Collection
     * S'il est plus petit que la Collection, seuls les éléments qui entrent dans le tableau vont être copiés
     * @param ts
     * @param <T>
     * @return
     */
    public <T> T[] toArray(T[] ts) {

        //On reduit la grandeur du tableau si il est plus grand que la Collection
        if(this.capacite > ts.length){
            ts = Arrays.copyOf(ts, this.capacite);
        }

        for(int i = 0; i< ts.length; i++){
            ts[i] = (T) this.getComparable(i);
        }
        return ts;
    }
}
