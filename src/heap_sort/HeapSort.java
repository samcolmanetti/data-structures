package heap_sort;

/**
 * Created by samso_000 on 3/16/2015.
 */
public class HeapSort {
    private HeapTree tree;

    public HeapSort (){
        tree = new HeapTree();
    }

    public void add (int value){
        tree.insert(value);
    }

    public int[] getSortedList (){
        int temp[] = new int[tree.size];
        for (int i = 0; i < temp.length; i++){
            temp[i] = tree.extract_max();
        }
        return temp;
    }
    public void printSorted (){
        System.out.println ("Sorted list: ");
        while (tree.hasNext())
            System.out.println (tree.extract_max());
    }
}
