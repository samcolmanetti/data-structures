public class HashTableTester {
    public static void main (String[] args){
        HashTableUsingArrays h = new HashTableUsingArrays(); 
        h.insert(1); 
        h.insert(5); 
        h.insert(28); 
        h.delete(5); 
        h.insert(15); 
        h.insert(8); 
        h.dumphash(); 
        h.delete(1); 
        h.insert(18); 
        h.insert (25);
        h.delete(33); 
        h.dumphash(); 
    }
}