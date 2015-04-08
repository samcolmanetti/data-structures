package gameoflife;

/**
 * Created by Samuel on 4/7/2015.
 */
public class GameOfLife {
    private boolean board[][];
    private final int SIZE = 20;

    public GameOfLife (){
        this.board = new boolean[SIZE][SIZE];
    }

    public void placeGlider (){

    }

    public void nextStep (){

    }

    public String toString (){
        String result = "";
        for (int i = 1; i < SIZE-1; i++){
            for (int j = 1; j < SIZE - 1; j++){
                if (board[i][j])
                    result += "\t*\t";
                else
                    result += "\tX\t";
            }
            result += "\n";
        }

        return result;
    }
}
