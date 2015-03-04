package hashtable;

public class HashTableUsingArrays implements HashTable {
    private LinkedList[] table;
    private final int SIZE = 10; 
    
    public HashTableUsingArrays (){
        table = new LinkedList[SIZE];
    }

    public void insert (int n){
        int index = this.hash(n);
        if (table[index] == null)
            table[index] = new LinkedList<Integer>();

        table[index].addToFront(n);
    }
    
    public void delete (int n){
        int index = this.hash(n);
        if (table[index] != null)
            table[index].remove(n);
    }
    
    public void dumphash (){
        System.out.println ("Dump hash: "); 
        for (int i = 0; i < table.length; i++)
            if (table[i] != null)
                table[i].dumpList();
        
    }
    public int hash (int n){
        return n % SIZE; 
    }
}