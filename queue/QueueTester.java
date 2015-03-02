public class QueueTester {
    
    public static void main (String[] arguements){
        QueueAsLinkedList<Integer> q = new QueueAsLinkedList<Integer>(); 
        q.enqueue (2); 
        q.enqueue (1);
        q.dumpqueue(); 
        q.enqueue (3);
        q.enqueue (10);
        q.dequeue();
        q.enqueue (15);
        q.dumpqueue();
        q.dequeue();
        q.dequeue();
        q.dumpqueue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dumpqueue();
    }
}