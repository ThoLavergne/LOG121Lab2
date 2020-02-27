package framework;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class PlayerCollection implements Collection<Player> {

    private Player[] tabPlayer;
    private int capacite;

    public PlayerCollection(){
        tabPlayer = new Player[0];
    }

    public PlayerCollection(int capacite){
        tabPlayer = new Player[capacite];
        this.capacite = capacite;
    }

    @Override
    public int size() {
        return tabPlayer.length;
    }

    @Override
    public boolean isEmpty() {
        return this.tabPlayer.length == 0;
    }

    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < tabPlayer.length; i++){
            if (tabPlayer[i].equals(o)){
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<Player> iterator() {
        return new TabIterator(tabPlayer);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.tabPlayer, tabPlayer.length);
    }

    public boolean add(Player player) {
        this.add(player, this.tabPlayer, this.tabPlayer.length);
        return true;
    }

    @Override
    public boolean remove(Object o) {

        Player[] newTab;
        boolean deTrouve = false;
        int posAEnlever = 0;

        for (int i = 0; i < this.capacite; i++){
            if (tabPlayer[i].equals(o)){
                deTrouve = true;
                posAEnlever = i;
            }
        }

        if(!deTrouve){
            return false;
        }

        else{
            this.capacite = this.capacite - 1;
            newTab = new Player[this.capacite];
            boolean trouPasse = false;

            for (int j = 0; j < tabPlayer.length; j++){

                if(!trouPasse){

                    if(j == posAEnlever){
                        trouPasse = true;
                    }

                    else{
                        newTab[j] = tabPlayer[j];
                    }
                }

                else{
                    newTab[j-1] = tabPlayer[j];
                }
            }

            tabPlayer = newTab;
            return true;
        }
    }

    private void add(Player player, Player[] tabPlayer, int position) {

        if (position == tabPlayer.length) {
            tabPlayer = this.etendre();
        }

        tabPlayer[position] = player;
        this.capacite = position + 1;
    }

    private Player[] etendre(int newCapacite) {
        return this.tabPlayer = Arrays.copyOf(this.tabPlayer, newCapacite);
    }

    private Player[] etendre() {
        return this.etendre(this.capacite + 1);
    }


    /*
    Les méthoPlayers suivantes ne sont pas utilisées dans notre cas
    Nous les avons mises incscrites pour que la classe puisse compiler,
    Mais nous n'allons pas les implémenter
    */
    @Override
    public boolean containsAll(Collection<?> collection) {
        System.out.println("Implémentation omise pour ce type de Collection");
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Player> collection) {
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
