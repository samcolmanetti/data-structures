package gameoflife;

/**
 * Created by Samuel on 4/7/2015.
 */
public class GameMain {
    public static void main (String args[]){
        GameOfLife g = new GameOfLife();
        //g.placeBlock(10,10);
        //g.placeVerticalBlinker(5,5);
        g.placeGlider(12,12);

        for (int i = 0; i < 3; i++){
            System.out.println (g + "\n");
            g.nextStep();
        }
    }
}
