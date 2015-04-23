package gameoflife;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class GAOptimization {
    private ArrayList<GOLBoard> boards;
    private int size;
    private Random rand = new Random();

    public GAOptimization (){
        boards = new ArrayList<GOLBoard>();
        size = 0;
    }
    public GAOptimization (int numBoards){
        boards = new ArrayList<GOLBoard>();
        size = 0;
        genBoards(numBoards);
    }
    public void newBoard (){
        boards.add (new GOLBoard());
        size++;
    }
    public void genBoards (int amount){
        for (int i = 0; i < amount; i++)
            newBoard();
    }
    public void nextGeneration (){
        sort();
        for (int i = boards.size()/ 2; i <= boards.size(); i++){
            if (i < boards.size() - boards.size()/4){ // second worse fitness
                boards.get(i).mutationOf(boards.get(rand.nextInt(boards.size()/10)));
            } else { // worst fitness
                int i1, i2;
                do {
                    i1 = rand.nextInt(boards.size()/10);
                    i2 = rand.nextInt(boards.size()/10);
                } while (i1 == i2);
                boards.get(i).setToCrossBetween(boards.get(i1), boards.get(i2));
            }
        }
    }
    private void sort (){
        GOLComparator c = new GOLComparator();
        boards.sort(c);
    }
    public void eval (int numOfIterations){
        for (int i = 0; i < numOfIterations; i++){
            nextGeneration();
        }
    }
    public void printTop (){
        for (int i = 0; i < 10; i++){
            System.out.println ("Fitness: "+ boards.get(i).fitness);
            System.out.println (boards.get(i).getInitBoard());
        }
    }
}