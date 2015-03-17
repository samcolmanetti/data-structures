package heap_sort;


public class HeapTree implements Heap{
    private int[] heap;
    public int size;

    public HeapTree (){
        heap = new int[2];
        size = 0;
    }

    public void insert(int v) {
        size++;
        if (heap.length > size)    doubleSize();
        heap[size] = v;
        insert (size, parentOf(size));
    }

    private void insert (int curr, int parent){
        if (heap[curr] > heap[parent]){
            swap (curr, parent);
            insert (parent, parentOf(parent));
        }
    }

    public int extract_max() {
        int temp = heap[1];
        heap[1] = heap[size];
        extract_max(1);
        size--;
        return temp;
    }
    private void extract_max (int curr){
        if (heap[rightOf(curr)] > heap[leftOf(curr)]){
            if (heap[curr] < heap[rightOf(curr)])
                swap (curr, rightOf(curr));
        } else {
            if (heap[curr] < heap[leftOf(curr)])
                swap (curr, leftOf(curr));
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

    private void doubleSize (){
        int[] temp = new int[2 * heap.length];

        for (int i = 0; i < heap.length; i++)
            temp[i] = heap[i];

        heap = temp;
    }
    private int parentOf (int index){
        if (index == 1) return 0;
        else return parentOf (index, 1);

    }
    private int parentOf (int index, int prev){
        if (leftOf(prev) == index)
            return prev;
        else if (rightOf(prev) == index)
            return prev;
        else {
            if (heap[prev] < heap[index])
                return 0;
            else{
                 return max (parentOf(index, leftOf(prev)), parentOf(index, rightOf(prev)));
            }
        }
    }
    private int max (int v1, int v2){
        if (v1 > v2)
            return v1;
        else
            return v2;
    }
    private int leftOf (int index){
        return 2 * index;
    }
    private int rightOf (int index){
        return 2 * index + 1;
    }
    private void swap (int i1, int i2){
        int temp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = temp;
    }
}