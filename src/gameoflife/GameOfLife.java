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

    public void placeGlider (int x, int y){
        if (x > 0 && x+2 < SIZE-1 && y+2 < SIZE-1 && y > 0) {
            board[y][x] = true;
            board[y][x+1] = true;
            board[y][x+2] = true;
            board[y+1][x] = true;
            board[y + 2][x + 1] = true;
        } else {
            System.out.println ("Error: Glider is out of bounds.");
        }
    }
    public void placeBlock (int x, int y){
        if (x+1 < SIZE-1 && x>0 && y+1 < SIZE-1 && y>0) {
            board[y][x] = true;
            board[y + 1][x] = true;
            board[y + 1][x + 1] = true;
            board[y][x + 1] = true;
        } else {
            System.out.println ("Error: Block is out of bounds.");
        }
    }
    public void placeVerticalBlinker (int x, int y){
        if (y+2 < SIZE-1 && y > 0 && x < SIZE-1 && x>0) {
            board[y][x] = true;
            board[y+1][x] = true;
            board[y+2][x] = true;
        } else {
            System.out.println ("Error: Blinker is out of bounds.");
        }
    }

    public void nextStep (){
        boolean[][] temp = clone(board);

        for (int i = 1; i < SIZE-1; i++){
            for (int j = 1; j < SIZE - 1; j++){
                if (board[i][j]) {    // if alive
                    if (!continueLiving(i,j))
                        temp[i][j] = false;
                } else {              // if dead
                    if (comeBack(i,j))
                        temp[i][j] = true;
                }
            }
        }
        board = temp;
    }

    private boolean continueLiving (int x, int y){
        int count = countLiveNeighbors(x,y);
        if (count == 2 || count == 3)
            return true;
        else
            return false;
    }
    private boolean comeBack (int x, int y){

        if (countLiveNeighbors(x,y) == 3)
            return true;
        else
            return false;
    }

    private int countLiveNeighbors (int x, int y){
        int count = 0;
        if (board[x+1][y])
            count++;
        if (board[x-1][y])
            count++;
        if (board[x][y+1])
            count++;
        if (board[x][y-1])
            count++;
        if (board[x+1][y+1])
            count++;
        if (board[x+1][y-1])
            count++;
        if (board[x-1][y+1])
            count++;
        if (board[x-1][y-1])
            count++;
        return count;
    }

    private boolean[][] clone (boolean[][] b){
        boolean[][] result = new boolean[b.length][b.length];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (board[i][j])
                    result[i][j] = true;
                else
                    result[i][j] = false;
            }
        }
        return result;
    }

    public String toString (){
        String result = "";
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (board[i][j])
                    result += "X";
                else
                    result += "-";
            }
            result += "\n";
        }

        return result;
    }
}