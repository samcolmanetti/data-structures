package queue;

public interface Queue<E> {
    public void enqueue (E val); 
    public E dequeue (); 
    public void dumpqueue (); 
}