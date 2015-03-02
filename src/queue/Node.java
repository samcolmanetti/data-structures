package queue;

public class Node<E> {
    public E value; 
    public Node<E> prev;
    public Node<E> next;
    
    public Node (){
        value = null; 
        prev  = null; 
        next  = null; 
    }
    public Node (E val){
        value = val;  
        prev  = null; 
        next  = null;
    }
}