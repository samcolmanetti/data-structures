package gameoflife;

import java.util.ArrayList;
import java.util.Random;

public class GOLBoard implements Comparable{
    public ArrayList<GOLObject> objs;
    private boolean[][] board;
    private boolean[][] initBoard;
    public int fitness;
    public int diversity;
    private int SIZE = 20;


    public GOLBoard (){
        board = new boolean[SIZE][SIZE];
        initBoard = new boolean[SIZE][SIZE];
        objs = new ArrayList<GOLObject>();
        fitness = 0;
        this.insertRandomObjects();
        calcDiversity();
        fitness();
    }
    public GOLBoard (ArrayList<GOLObject> objects){
        board = new boolean[SIZE][SIZE];
        initBoard = new boolean[SIZE][SIZE];
        insertObjects(objects);
        fitness = 0;
        calcDiversity();
        fitness();
    }
    public void setToCrossBetween (GOLBoard b1, GOLBoard b2 ){
        GOLBoard temp = new GOLBoard(clone(b1.objs));
        GOLBoard temp2 = new GOLBoard(clone(b2.objs));
        if (Math.abs(b1.diversity - b2.diversity) > 10)   // If not the same design
            for (int i = 0; i < b2.objs.size(); i++){
                    temp.objs.add(temp2.objs.get(i));
            }

        board = new boolean[SIZE][SIZE];
        initBoard = new boolean[SIZE][SIZE];
        fitness = 0;
        insertObjects(temp.objs);
        calcDiversity();
        fitness();
    }
    private GOLBoard cloneBoard (GOLBoard ob){
        GOLBoard temp = new GOLBoard(clone(ob.objs));
        return temp;
    }
    private ArrayList<GOLObject> clone (ArrayList<GOLObject> ob){
        ArrayList<GOLObject> temp = new ArrayList<GOLObject>();
        for (int i = 0; i < ob.size(); i++)
            temp.add(new GOLObject(ob.get(i).x1 ,ob.get(i).y1,ob.get(i).x2,ob.get(i).y2));
        return temp;
    }
    public void mutationOf (GOLBoard ob){
        Random rand = new Random();
        ArrayList<GOLObject> temp = clone (ob.objs);
        int index = rand.nextInt(20);
        int dx, dy;
        do {
            dx = -5 + rand.nextInt(10);
            temp.get(index).x1 = temp.get(index).x1 + dx;
            temp.get(index).x2 = temp.get(index).x2 + dx;
        } while (temp.get(index).x1 < 1 || temp.get(index).x1 > SIZE-1 || temp.get(index).x2 < 1 || temp.get(index).x2 > SIZE-1);
        do {
            dy = -5 + rand.nextInt(10);
            temp.get(index).y1  = temp.get(index).y1 + dy;
            temp.get(index).y2  = temp.get(index).y2  + dy;
        } while (temp.get(index).y1 < 1 || temp.get(index).y1 > SIZE-1 || temp.get(index).y2 < 1 || temp.get(index).y2 > SIZE-1);

        board = new boolean[SIZE][SIZE];
        initBoard = new boolean[SIZE][SIZE];
        fitness = 0;
        insertObjects(temp);
        calcDiversity();
        fitness();
    }

    public int fitness (){
        initBoard = board.clone();
        for (int i = 0; i < 1000; i++)
            nextStep();
        this.fitness = 0;
        for (int row = 1; row < SIZE-1; row++)
            for (int col = 1; col < SIZE - 1; col++)
                if (board[row][col])
                    fitness++;
        return fitness;
    }
    private void insertRandomObjects (){
        Random rand = new Random();
        for (int i = 0; i < 20; i++){ // 20 objects per board
            int x1 = 1 + rand.nextInt(15);
            int y1 = 1 + rand.nextInt(15);
            int width, length;

            do {
                length = 1 + rand.nextInt(5);
                width = 1 + rand.nextInt(5);
            } while (x1 + width > SIZE - 1 || y1 + length > SIZE-1);  // while object is out of bounds
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
                if (board[y][x])
                    board[y][x] = false;
                else
                    board[y][x] = true;
            }
        }
    }
    private void insertObjects (ArrayList<GOLObject> ob){
        this.objs = clone(ob);
        for (int i = 0; i < ob.size(); i++) {
            for (int x = ob.get(i).x1; x < ob.get(i).x2; x++) {
                for (int y = ob.get(i).y1; y < ob.get(i).y2; y++) {
                    if (board[y][x])
                        board[y][x] = false;
                    else
                        board[y][x] = true;
                }
            }
        }
    }
    public int calcDiversity () {
        this.diversity = 0;
        for (int i = 1; i < SIZE - 1; i++){
            for (int j = 1; j < SIZE - 1; j++) {
                if (board[j][i])
                    diversity += i + j;
            }
        }
        return diversity;
    }
    public boolean pointAt (int x, int y){
        return board[y][x];
    }
    public String getInitBoard (){
        String result = "";
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (initBoard[i][j])
                    result += "X";
                else
                    result += "-";
            }
            result += "\n";
        }

        return result;
    }

    @Override
    public int compareTo(Object o) {
        return this.fitness - ((GOLBoard)o).fitness;
    }
}
