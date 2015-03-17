package heap_sort;

/**
 * Created by samso_000 on 3/16/2015.
 */
public class HeapTester {
    public static void main (String arguments[]){
        HeapSort h = new HeapSort();
        h.add(10);
        h.add (2);
        h.add (8);
        h.add (4);
        h.add(18);
        h.add(20);
        h.add (3);
        h.add(16);
        h.add (5);
        h.printSorted();
    }
}
