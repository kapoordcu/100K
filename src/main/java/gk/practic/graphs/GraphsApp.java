package gk.practic.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphsApp {
    public static void main(String[] args) {
        // Adjacency Matrix
//        int V = 3;
//        int[][] matrix = new int[V][V];
//        addEdge(matrix, 0, 1);
//        addEdge(matrix, 0, 2);
//        addEdge(matrix, 1, 2);
//        //printAdjacenyMatrix(matrix);
//        // Adjacency List
//        List<List<Integer>> adjacencyList = new ArrayList<>(V);
//        addEdge(adjacencyList, 0, 1);
        //printAdjancyList(adjacencyList);
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        GraphsApp app = new GraphsApp();
        app.floodFill(image, sr, sc, color);
        System.out.println(image);
    }

    private void floodFill(int[][] image, int sr, int sc, int color) {

    }

    private static void addEdge(List<List<Integer>> adjacencyList, int i, int j) {
        adjacencyList.get(i).add(j);
        adjacencyList.get(j).add(i);
    }

    private static void addEdge(int[][] matrix, int from, int to) {
        matrix[from][to] = 1;
        matrix[to][from] = 1;
    }
}
