package stack;

public class StackTester {
    public static void main (String args[]){
        Stack<Integer> s = new Stack<Integer>(); 
        s.push (2); 
        s.push (1); 
        s.dumpstack(); 
        s.push (3); 
        s.push (10); 
        s.pop(); 
        s.push (15); 
        s.dumpstack(); 
        s.pop(); 
        s.pop(); 
        s.dumpstack(); 
        s.pop(); 
        s.pop();
        s.pop(); 
        s.dumpstack(); 
    }
}