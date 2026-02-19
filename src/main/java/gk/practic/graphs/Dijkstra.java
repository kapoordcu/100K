package gk.practic.graphs;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    void dijkstra(List<List<Pair>> adjList, int src) {

    }

    // Driver method
    public static void main(String[] args)
    {
        /* Let us create the example graph discussed above */
        int V=5;
        Dijkstra t = new Dijkstra();
        List<List<Pair>> adjList = new ArrayList();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(new Pair(1,2));
        adjList.get(1).add(new Pair(0,2));

        t.dijkstra(adjList, 0);
    }
}

class Pair {
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}