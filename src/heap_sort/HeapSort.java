package heap_sort;

public class HeapSort extends HeapTree{

    public HeapSort (){
        super();
    }
    public HeapSort (int numberOfEntries){
        super (numberOfEntries);
    }

    public void add (int value){
        super.insert(value);
    }

    public int[] getSortedList (){
        int temp[] = new int[super.size];
        for (int i = 0; i < temp.length; i++){
            temp[i] = super.extract_max();
        }
        return temp;
    }
    public void printSorted (){
        super.dumpheap();
       System.out.println ("Sorted list: ");
        if (!super.hasNext())   System.out.println ("List is empty.");
        while (super.hasNext())
            System.out.println (super.extract_max());
    }
}
