package gameoflife;

public class GameMain {
    public static void main (String args[]){
        BruteForceOptimization op = new BruteForceOptimization(500000,20,1000);
        op.evalTrials();
    }
}