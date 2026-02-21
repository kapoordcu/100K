package gk.practic.kahn;

import java.util.*;

public class TopoSort {
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(0);
        adj.get(5).add(2);

        adj.get(2).add(3);

        adj.get(3).add(1);

        adj.get(4).add(1);
        adj.get(4).add(0);
        TopoSort sort = new TopoSort();
        List<Integer> result = sort.topologicalUsingKAHN_BFS(V, adj);
        for (int i: result) {
            System.out.println(i + " ");
        }
    }

    List<Integer> topologicalUsingKAHN_BFS(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for(int neighbour: adj.get(i)) {
                inDegree[neighbour]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(inDegree[i]==0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int pop = queue.poll();
            result.add(pop);
            for (int neighbour: adj.get(pop)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0) {
                    queue.add(neighbour);
                }
            }
        }
        return result;
    }
    void topologicalUsingDFS(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfsApproach(adj, i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private void dfsApproach(List<List<Integer>> adj, int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for(int neighbour : adj.get(node)) {
            if(!visited[neighbour]) {
                dfsApproach(adj, neighbour, visited, stack);
            }
        }
        stack.push(node);
    }
}
