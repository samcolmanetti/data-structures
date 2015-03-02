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
            this.next = this.current;
        } else if (size == 1){
            
        }else {
            this.next = this.current;
            this.current = new Node (node);
            current.next = this.next;
        }
    }

    public void remove(E node) {
        Node curr = this.current;

        while (curr != null){
            if (curr.value.equals(node)){

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