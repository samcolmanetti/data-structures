package gameoflife;

import queue.QueueAsLinkedList;

import java.util.Random;

public class BruteForceOptimization {

    private GOLUsing2DArray[] gol;
    private int fitnessIterations;
    private Random rand = new Random();

    public BruteForceOptimization(int trials, int size, int fitnessIterations) {
        this.fitnessIterations = fitnessIterations;
        gol = new GOLUsing2DArray[trials];
        for (int i = 0; i < trials; i++){
            gol[i] = new GOLUsing2DArray(getRandomBoard(size));
        }
    }

    private boolean[][] getRandomBoard (int size){
        boolean[][] temp = new boolean[size][size];

        for (int row = 1; row < size-1; row++) {
            for (int col = 1; col < size-1; col++) {
                temp[row][col] = rand.nextBoolean();
            }
        }
        return temp;
    }
    public void evalTrials (){
        int maxFitness = 0;
        QueueAsLinkedList<GOLUsing2DArray> maxGames = new QueueAsLinkedList<GOLUsing2DArray>();   // queue from a previous assignment
        int count = 0;
        for (int i = 0; i < gol.length; i++){
            int currentFitness = gol[i].fitness(fitnessIterations);
            if (currentFitness > maxFitness) {
                maxGames.enqueue(gol[i]);
                maxFitness = currentFitness;
                if (maxGames.size > 10)
                    maxGames.dequeue();
            }
        }
        while (!maxGames.empty()) {
            GOLUsing2DArray temp = maxGames.dequeue();
            System.out.println("Fitness: " + temp.fitness +"\n" + temp.getInitBoardAsString());
        }
    }
}