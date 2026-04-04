package gk.practic.djikstra;

import gk.practic.models.Pair;

import java.util.*;

public class DjikstraApp {
    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        adjacencyList.get(1).add(new Pair(5, 2));
        adjacencyList.get(1).add(new Pair(2, 4));

        adjacencyList.get(2).add(new Pair(5, 1));
        adjacencyList.get(2).add(new Pair(1, 3));
        adjacencyList.get(2).add(new Pair(2, 4));


        adjacencyList.get(3).add(new Pair(1, 2));
        adjacencyList.get(3).add(new Pair(2, 4));

        adjacencyList.get(4).add(new Pair(2, 1));
        adjacencyList.get(4).add(new Pair(2, 2));
        adjacencyList.get(4).add(new Pair(2, 3));
        DjikstraApp djikstraApp = new DjikstraApp();

        int[] dist = djikstraApp.djkstraAlgo(V, adjacencyList, 1);
        System.out.println(Arrays.toString(dist));
    }

    private int[] djkstraAlgo(int nodes, List<List<Pair>> adjacencyList, int nodeFrom) {
        int[] dist = new int[nodes];
        boolean[] visited = new boolean[nodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[nodeFrom] = 0;
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparing(pair -> pair.distance));
        queue.add(new Pair(0, nodeFrom));

        while (!queue.isEmpty()) {
            Pair peek = queue.poll();
            int node = peek.node;
            if(visited[node]) continue;
            visited[node] = true;
            List<Pair> neighbours = adjacencyList.get(node);
            for (int i = 0; i < neighbours.size(); i++) {
                Pair neighbour = neighbours.get(i);
                if(dist[node] + neighbour.distance < dist[neighbour.node]) {
                    dist[neighbour.node] = dist[node] + neighbour.distance;
                    queue.add(new Pair(dist[neighbour.node], neighbour.node));
                }

            }
        }
        return dist;
    }
}
