package framework;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class DeCollection implements Collection<De> {

    private De[] tabDe;
    private int capacite;

    public DeCollection(){
        tabDe = new De[0];
    }

    public DeCollection(int capacite){
        tabDe = new De[capacite];
        this.capacite = capacite;
    }

    @Override
    public int size() {
        return tabDe.length;
    }

    @Override
    public boolean isEmpty() {
        return this.tabDe.length == 0;
    }

    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < tabDe.length; i++){
            if (tabDe[i].equals(o)){
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<De> iterator() {
        return new TabIterator(tabDe);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.tabDe, tabDe.length);
    }

    public boolean add(De de) {
        this.add(de, this.tabDe, this.tabDe.length);
        return true;
    }

    private void add(De de, De[] tabDe, int position) {

        if (position == tabDe.length) {
            tabDe = this.etendre();
        }

        tabDe[position] = de;
        this.capacite = position + 1;
    }

    @Override
    public boolean remove(Object o) {

        De[] newTab;
        boolean deTrouve = false;
        int posAEnlever = 0;

        for (int i = 0; i < this.capacite; i++){
            if (tabDe[i].equals(o)){
                deTrouve = true;
                posAEnlever = i;
            }
        }

        if(!deTrouve){
            return false;
        }

        else{
            this.capacite = this.capacite - 1;
            newTab = new De[this.capacite];
            boolean trouPasse = false;

            for (int j = 0; j < tabDe.length; j++){

                if(!trouPasse){

                    if(j == posAEnlever){
                        trouPasse = true;
                    }

                    else{
                        newTab[j] = tabDe[j];
                    }
                }

                else{
                    newTab[j-1] = tabDe[j];
                }
            }

            tabDe = newTab;
            return true;
        }
    }



    private De[] etendre(int newCapacite) {
        return this.tabDe = Arrays.copyOf(this.tabDe, newCapacite);
    }

    private De[] etendre() {
        return this.etendre(this.capacite + 1);
    }


    /*
    Les méthodes suivantes ne sont pas utilisées dans notre cas
    Nous les avons mises incscrites pour que la classe puisse compiler,
    Mais nous n'allons pas les implémenter
    */
    @Override
    public boolean containsAll(Collection<?> collection) {
        System.out.println("Implémentation omise pour ce type de Collection");
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends De> collection) {
        System.out.println("Implémentation omise pour ce type de Collection");
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        System.out.println("Implémentation omise pour ce type de Collection");
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        System.out.println("Implémentation omise pour ce type de Collection");
        return false;
    }

    @Override
    public void clear() {
        System.out.println("Implémentation omise pour ce type de Collection");
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        System.out.println("Implémentation omise pour ce type de Collection");
        return null;
    }
}
