package heap_sort;


public class HeapTree implements Heap{
    private int[] heap;
    private int MAX_SIZE;
    public int size;

    public HeapTree (){
        MAX_SIZE = 10;
        heap = new int[MAX_SIZE];
        size = 0;
    }
    public HeapTree (int numberOfEntries){
        MAX_SIZE = numberOfEntries + 1; // heap[0] is not being used
        heap = new int[MAX_SIZE];
        size = 0;
    }

    public void insert(int v) {
        size++;
        heap[size] = v;
        if (size > 1)
            insert (size, parentOf(size));
    }

    private void insert (int curr, int parent){

        if ((curr != -1 && parent != -1 )&& heap[curr] > heap[parent]){
            swap (curr, parent);
            if (parent > 1)
                insert (parent, parentOf(parent));
        }
    }

    public int extract_max() {
        if (size > 0) {
            int temp = heap[1];
            heap[1] = heap[size];
            heap[size] = 0;
            size--;
            extract_max(1);
            return temp;
        } else {
            System.out.println ("Extracting when empty");
            return -1;
        }
    }
    private void extract_max (int curr){
        if (heap[rightOf(curr)] > heap[leftOf(curr)]){
            if (heap[curr] < heap[rightOf(curr)]) {
                swap(curr, rightOf(curr));
                extract_max(rightOf(curr));
            }
        } else if (heap[leftOf(curr)] > heap[rightOf(curr)]) {
            if (heap[curr] < heap[leftOf(curr)]) {
                swap(curr, leftOf(curr));
                extract_max(leftOf(curr));
            }
        }

    }

    public void dumpheap() {
        System.out.println ("Dump heap");
        for (int i = 1; i <= size; i++)
            System.out.println (heap[i]);
    }

    public boolean hasNext (){
        return size > 0;
    }

    private int parentOf (int index) {
        if (index == 1)
            return -1;
        else if (index % 2 == 0)
            return index/2;
        else {
            return (index - 1)/ 2;
        }
    }

    private int max (int v1, int v2){
        if (v1 > v2)
            return v1;
        else
            return v2;
    }
    private int leftOf (int index){
        if (2 * index <= size )
            return 2 * index;
        else
            return 0;
    }
    private int rightOf (int index){
        if (2 * index + 1 <= size )
            return 2 * index + 1;
        else
            return 0;
    }
    private void swap (int i1, int i2){
        int temp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = temp;
    }
}