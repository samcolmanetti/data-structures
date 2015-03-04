package hashtable;

public class LinkedList<E> implements List<E>{
    private Node<E> head;
    public int size;

    public LinkedList () {
        head = null;
        size = 0;
    }

    public void addToFront(E node) {
        Node<E> temp = new Node<E> (node);
        temp.next = this.head;
        this.head = temp;
    }

    public void remove(E node) {
        Node curr = this.head;
        if (curr != null)
            if(curr.value.equals (node))
                this.head = null;
            else {
                while (curr.next != null) {
                    if (curr.next.value.equals(node)) {
                        curr.next = curr.next.next;
                        size--;
                    }
                    curr = curr.next;
                }
            }

    }

    public void dumpList() {
        Node curr = this.head;
        while (curr != null){
            System.out.println (curr.value.toString());
            curr = curr.next;
        }
    }
}