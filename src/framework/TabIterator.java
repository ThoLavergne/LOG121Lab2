package framework;

import java.util.Iterator;

public class TabIterator implements Iterator {

    private Object[] tab;

    public TabIterator(Object[] tab){
        this.tab = tab;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
