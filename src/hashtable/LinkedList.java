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
        size = 0;
    }

    public void addToFront(E node) {
        if (size == 0){
            this.current = new Node(node);
            this.current.next = null;
            this.current.prev = null; 
        } else{
            Node temp = new Node(node); 
            temp.next = this.current; 
            temp.prev = null; 
            this.current.prev = temp; 
            this.current = temp;
        }
    }

    public void remove(E node) {
        Node curr = this.current; 
        while (curr != null){
            if (curr.value.equals(node)){
                if (curr.prev == null && curr.next == null){
                    curr = null; 
                } else if (curr.prev == null && curr.next != null){
                    this.current = curr.next; 
                    this.current.prev = null;
                } else if (curr.next == null && curr.prev != null) {
                    curr.prev.next = null; 
                    curr = null; 
                } else {
                    curr.prev.next = curr.next; 
                    curr.next.prev = curr.prev; 
                    curr = null;
                }
                size--; 
            }
            curr = curr.next;
        }
    }

    public void dumpList() {
        Node curr = this.current;
        while (curr != null){
            System.out.println (curr.value.toString());
            curr = curr.next;
        }
    }
}