package stack;

public class Node<E> {
    public E value; 
    public Node<E> prev;
    
    public Node (){
        value = null; 
        prev = null; 
    }
    public Node (E val){
        value = val;  
        prev = null; 
    }
}