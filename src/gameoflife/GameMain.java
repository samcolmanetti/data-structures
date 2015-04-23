package gameoflife;

public class GameMain {
    public static void main (String args[]){
        GAOptimization op = new GAOptimization(15);
        op.eval(50);
        op.printTop(); // prints the top 10
    }
}