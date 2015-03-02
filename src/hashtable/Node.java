package hashtable;

public class Node<E>{
    public Node<E> next; 
    public Node<E> prev; 
    public E value;

    public Node (){
        this.next = null;
        this.prev = null; 
        this.value = null;
    }
    public Node (E val){
        this.value = val;
    }
}
