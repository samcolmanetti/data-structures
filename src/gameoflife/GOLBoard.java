package gameoflife;

import java.util.ArrayList;
import java.util.Random;

public class GOLBoard {
    private ArrayList<GOLObject> objs;
    private boolean[][] board;
    public int fitness;
    public int diversity;
    private int SIZE = 20;


    public GOLBoard (){
        board = new boolean[20][20];
        fitness = 0;
        generateRandomObjects();
        fitness();
    }
    public int fitness (){
        for (int i = 0; i < 1000; i++)
            nextStep();
        this.fitness = 0;
        for (int row = 1; row < SIZE-1; row++)
            for (int col = 1; col < SIZE - 1; col++)
                if (board[row][col])
                    fitness++;
        return fitness;
    }
    private void generateRandomObjects (){
        Random rand = new Random();
        for (int i = 0; i < objs.size(); i++){
            int x1 = 1 + rand.nextInt(15);
            int y1 = 1 + rand.nextInt(15);
            int width, length;

            do {
                length = 1 + rand.nextInt(5);
                width = 1 + rand.nextInt(5);
            } while (x1 + width <= SIZE - 1 && y1 + length <= SIZE-1);  // while object is in bounds
            GOLObject temp = new GOLObject(x1, y1, x1 + width, y1 + length);
            objs.add(i,temp);
            this.insert (temp);
        }
    }
    private void nextStep (){
        boolean[][] temp = board.clone();

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
        int count = countLiveNeighbors(x, y);
        return (count == 2 || count == 3);
    }
    private boolean comeBack (int x, int y){
        return (countLiveNeighbors(x,y) == 3);
    }
    private int countLiveNeighbors (int x, int y){
        int count = 0;
        if (board[y+1][x])
            count++;
        if (board[y-1][x])
            count++;
        if (board[y][x+1])
            count++;
        if (board[y][x-1])
            count++;
        if (board[y+1][x+1])
            count++;
        if (board[y+1][x-1])
            count++;
        if (board[y-1][x+1])
            count++;
        if (board[y-1][x-1])
            count++;
        return count;
    }

    private void insert (GOLObject ob) {
        for (int x = ob.x1; x < ob.x2; x++){
            for (int y = ob.y1; y < ob.y2; y++){
                board[y][x] = true;
            }
        }
    }
    public int calcDiversity () {
        diversity = 0;
        for (int i = 0; i < SIZE - 1; i++){
            for (int j = 0; j < SIZE - 1; j++) {
                if (board[j][i])
                    diversity += i + j;
            }
        }
        return diversity;
    }
    public boolean pointAt (int x, int y){
        return board[y][x];
    }
}
