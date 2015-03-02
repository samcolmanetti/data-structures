package hashtable;

/**
 * Created by Samuel on 3/1/2015.
 */

public class Node<E>{
    public Node<E> next;
    public E value;

    public Node (){
        this.next = null;
        this.value = null;
    }
    public Node (E val){
        this.value = val;
    }
}
