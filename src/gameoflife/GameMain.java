package gameoflife;

public class GameMain {
    public static void main (String args[]){
        GAOptimization op = new GAOptimization(100);
        op.eval(1000);
        op.printTop(); // prints the top 10
    }
}