package gameoflife;

/**
 * Created by Samuel on 4/22/2015.
 */
public class GOLBoard {
    private GOLObject[] objs;
    private boolean[][] board;
    private int SIZE = 20;

    public GOLBoard (){
        objs = new GOLObject[15];
        board = new boolean[20][20];
    }
    public int fitness (){

        return 0;
    }

    private void insert (GOLObject ob) {

    }

}
