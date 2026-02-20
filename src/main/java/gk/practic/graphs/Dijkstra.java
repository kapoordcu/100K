package gk.practic.graphs;

import java.util.*;

public class Dijkstra {

    public int[] findDistanceByDijkstra(List<List<Pair>> adj, int source) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparing(a -> a.weight));
        Set<Integer> nodesVisited = new HashSet<>();
        int[] distances = new int[adj.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        queue.offer(new Pair(source, 0));

        while (!queue.isEmpty()) {
            Pair pop = queue.poll();
            if (nodesVisited.contains(pop.node))
                continue;
            nodesVisited.add(pop.node);
            List<Pair> neighbours = adj.get(pop.node);
            for (Pair pair: neighbours) {
                int neighbour = pair.node; //1
                if(!nodesVisited.contains(neighbour)) {
                    int neighbourDist = pair.weight; //3
                    if(distances[neighbour] > distances[pop.node] + neighbourDist) {
                        distances[neighbour] = distances[pop.node] + neighbourDist;
                        queue.offer(new Pair(neighbour, distances[neighbour]));
                    }
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new Pair(1, 3));
        adj.get(1).add(new Pair(0, 3));

        adj.get(0).add(new Pair(2, 1));
        adj.get(2).add(new Pair(0, 1));

        adj.get(1).add(new Pair(2, 1));
        adj.get(2).add(new Pair(1, 1));

        adj.get(1).add(new Pair(3, 2));
        adj.get(3).add(new Pair(1, 2));

        adj.get(2).add(new Pair(4, 4));
        adj.get(4).add(new Pair(2, 4));

        adj.get(3).add(new Pair(4, 2));
        adj.get(4).add(new Pair(3, 2));

        Dijkstra findD = new Dijkstra();
        int[] dists = findD.findDistanceByDijkstra(adj, 0);
        System.out.println(Arrays.stream(dists).boxed().distinct());
    }
}
