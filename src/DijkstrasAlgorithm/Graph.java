package DijkstrasAlgorithm;

import queue.QueueAsLinkedList;

import java.io.IOException;
import java.util.ArrayList;

public class Graph extends GraphHelper{
    protected ArrayList<Node> nodes;

    public Graph (String filePath) throws IOException {
        super.initialize(filePath);
        nodes = super.nodes;
    }

    public void execute (){
        if (nodes.size() > 0) {
            nodes.get(0).setValue(0);
            QueueAsLinkedList<Node> q = new QueueAsLinkedList<Node>();
            for (int i = 0; i < nodes.size(); i++)
                q.enqueue(nodes.get(i));
            // starting point is first element
            while (!q.empty()) {
                Node current = q.dequeue();
                ArrayList<Neighbor> cNeighbors = current.getNeighbors();
                for (int i = 0; i < cNeighbors.size(); i++)
                    if (cNeighbors.get(i).weight + current.getValue() < cNeighbors.get(i).node.getValue())
                        cNeighbors.get(i).node.setValue(cNeighbors.get(i).weight + current.getValue());
            }
        }
    }
    public void printShortestPaths (){
        for (int i = 0; i < nodes.size(); i++){
            System.out.printf("%s:%d\n", nodes.get(i).name, nodes.get(i).getValue());
        }
    }
}