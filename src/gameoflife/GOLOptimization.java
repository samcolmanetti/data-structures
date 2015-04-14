package gameoflife;

import java.util.Random;

public class GOLOptimization{

    private GameOfLife[] gol;
    private int fitnessIterations;
    private Random rand = new Random();

    public GOLOptimization (int trials, int size, int fitnessIterations) {
        this.fitnessIterations = fitnessIterations;
        gol = new GameOfLife[trials];
        for (int i = 0; i < trials; i++){
            gol[i] = new GameOfLife(getRandomBoard(size));
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
        GameOfLife maxGame = gol[0];
        for (int i = 0; i < gol.length; i++){
            int currentFitness = gol[i].fitness(fitnessIterations);
            if (currentFitness > maxFitness) {
                maxFitness = currentFitness;
                maxGame = gol[i];
            }
        }

        System.out.println ("Fitness: " + maxFitness + "\n" + maxGame.toString());
    }
}
