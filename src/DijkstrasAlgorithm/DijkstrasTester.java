package DijkstrasAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DijkstrasTester {
    public static void main (String args[]) throws IOException {
        Graph graph = new Graph ("src/DijkstrasAlgorithm/data.txt");
        graph.printNodes();

    }
}