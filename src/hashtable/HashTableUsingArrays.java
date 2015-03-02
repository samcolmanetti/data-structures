package hashtable;

import java.util.*;

public class HashTableUsingArrays implements HashTable {
    private LinkedList[] table;
    private final int SIZE = 10; 
    
    public HashTableUsingArrays (){
        table = new hashtable.LinkedList[SIZE];
    }
    
    
    public void insert (int n){
        int index = this.hash(n);
        if (table[index] == null){
            table[index] = new hashtable.LinkedList<Integer>();
            table[index].add(n); 
        } else {
            table[index].add(n);
        }
    }
    
    public void delete (int n){
        int tbIndex = this.hash(n);
        if (table[tbIndex] != null) {
            int elementIndex = table[tbIndex].indexOf(n);

            if (elementIndex != -1)
                table[tbIndex].remove(elementIndex);
            else
                System.out.println("Element not in list.");
        } else
            System.out.println("Element not in list.");
    }
    
    public void dumphash (){
        System.out.println ("Dump hash: "); 
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                ListIterator iterator = table[i].listIterator(0);
                while (iterator.hasNext())
                    System.out.println("\t" + iterator.next());
            }
        }
        
    }
    public int hash (int n){
        return n % SIZE; 
    }
}