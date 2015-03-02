package hashtable;

/**
 * Created by Samuel on 3/1/2015.
 */
public class LinkedList<E> implements List<E>{
    private Node<E> current;
    private Node<E> next;
    public int size;

    public LinkedList () {
        current = null;
        next = null;
    }

    public void addToFront(E node) {

    }

    public boolean remove(E node) {
        return false;
    }

    public void dumpList() {

    }
}