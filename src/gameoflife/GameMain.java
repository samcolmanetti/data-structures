package gameoflife;

/**
 * Created by Samuel on 4/7/2015.
 */
public class GameMain {
    public static void main (String args[]){
        GOLOptimization op = new GOLOptimization(100000,20,1000);
        op.evalTrials();
    }
}