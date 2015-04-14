package gameoflife;

public class GameMain {
    public static void main (String args[]){
        GOLOptimization op = new GOLOptimization(100000,20,1000);
        op.evalTrials();
    }
}