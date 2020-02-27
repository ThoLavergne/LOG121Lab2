package framework;

import java.util.Iterator;

public class TabIterator implements Iterator {

    private Object[] tab;
    int position = 0;

    public TabIterator(Object[] tab){
        this.tab = tab;
    }

    @Override
    public boolean hasNext() {

        if(position >= tab.length || tab[position] == null){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public Object next() {
        Object item = tab[position];
        position ++;
        return item;
    }
}
