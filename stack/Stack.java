public class Stack <E>{
    
    private Node<E> current; 
    private Node<E> below; 
    public int size; 
    
    public Stack (){
        current = null; 
        below = null;
        size = 0; 
    }
    
    public void push (E val){
        if (size == 0){
            current = new Node<E> (val);
        } else {
            below = current; 
            current = new Node<E> (val); 
            current.prev = below; 
        }
        size++; 
    }
    public E pop (){
        if (current != null && below != null){
            Node<E> temp = current; 
            current = temp.prev;
            below = current.prev;
            size--; 
            return temp.value; 
        } else if (current != null && below == null){
            Node<E> temp = current;
            current = null; 
            below = null; 
            size--; 
            return temp.value; 
        }
        else {
            System.out.println ("You cannot pop from an empty stack"); 
            return null;
        }
    }
    
    public E peak () {
        return current.value; 
    }
    
    public boolean hasNext () {
        return current != null;  
    }
    
    public void dumpstack (){
        System.out.println ("Elements in Stack: "); 
        Node<E> indexNode = current; 
        while (indexNode != null){
            System.out.println ("\t" + indexNode.value); 
            indexNode = indexNode.prev; 
        }
    }
}