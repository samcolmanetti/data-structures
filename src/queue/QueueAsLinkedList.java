package queue;

public class QueueAsLinkedList<E> implements Queue<E> {
    private Node<E> head;
    private Node<E> tail;
    public int size; 

    public QueueAsLinkedList (){
        this.size = 0; 
        this.head = null;
        this.tail = null;
    }
    
    public void enqueue (E val){
        if (size == 0){
            this.tail = new Node<E> (val);
            this.head = this.tail;
        } else {
            Node<E> temp = new Node<E> (val); 
            temp.next = this.tail;
            temp.prev = null; 
            this.tail.prev = temp; 
            this.tail = temp; 
        }
        size++; 
    }
    
    public E dequeue (){
        if (size == 0){
            System.out.println ("The queue is empty."); 
            return null; 
        } else if (size == 1){
            Node<E> temp = this.head; 
            head = null; 
            tail = null; 
            size--;
            return temp.value; 
        } else {
            Node<E> temp = head; 
            head = head.prev; 
            head.next = null; 
            size--; 
            return temp.value; 
        }
    }
    
    public void dumpqueue (){
        System.out.println ("Dump queue:");
        Node<E> current = this.tail; 
        while (current != null){
            System.out.println ("\t" + current.value);
            current = current.next; 
        }
    }
    public boolean hasNext (){
        return (size > 0);
    }
}