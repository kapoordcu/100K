package gk.practic.graphs;

import java.util.*;

public class GraphsApp {
    public static void main(String[] args) {
        GraphsApp app = new GraphsApp();
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
//        int result = initOrangeRotting(app);
//        System.out.println(result);

         initCourseSchedule(app);
//        int[][] image = {{0, 1,0,1}, {1,1,0, 0}, {0,0,1, 1}, {0,0,0,0}};
//        int sr = 1;
//        int sc = 1;
//        int color = 2;
//        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
//        GraphsApp app = new GraphsApp();
//        int time = app.orangesRotting(grid);
//        System.out.println(time);
//        app.floodFill(image, sr, sc, color);
//        System.out.println(image);
    }

    private static void initCourseSchedule(GraphsApp app) {
        int[][] preq = new int[4][];
        // [1,0], [2,0], [3,1], [3,2]
        preq[0] = new int[]{1,0};
        preq[1] = new int[]{2,0};
        preq[2] = new int[]{3,1};
        preq[3] = new int[]{3,2};
        app.canFinish(4, preq);
    }

    private static void initTopoSort(GraphsApp app) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(2).add(3);
        adjList.get(3).add(1);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(5).add(0);
        adjList.get(5).add(2);

        app.toposortInDegree(6, adjList);
    }

    private List<Integer> toposortInDegree(int V, List<List<Integer>> adjList) {
        List<Integer> result = new ArrayList<>();
        int[] indegree = calculateInDegree(V, adjList);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int pop = queue.poll(); // 5 4
            result.add(pop);
            for(Integer neighbor: adjList.get(pop)) {
                indegree[neighbor]--;
                if(indegree[neighbor]==0) queue.offer(neighbor);
            }
        }
        return result;
    }

    private int[] calculateInDegree(int V, List<List<Integer>> adjList) {
       int[] indegree = new int[V];
        for (int i = 0; i < adjList.size(); i++) {
            for(Integer in: adjList.get(i)) {
                indegree[in]++;
            }
        }
        return indegree;
    }

    private static int initOrangeRotting(GraphsApp app) {
        int[][] image = {{2,1,1}, {1,1,0}, {0,1,1}}; // 4
        int[][] image2 = {{2,1,1}, {0,1,1}, {1,0,1}}; // 0
        return app.orangesRottingBFS(image);
    }

    public int orangesRottingBFS(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int fresh = 0;
        int time = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                } else if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if(fresh == 0) {
            return 0;
        }
        if(queue.isEmpty()) return -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] poll = queue.poll();
                int row = poll[0];
                int col = poll[1];
                for (int[] dir: directions) {
                    int newRow = row + dir[0];
                    int newCol =  col + dir[1];
                    if(newCol >= 0 && newRow >=0 && newCol < grid[0].length && newRow < grid.length
                            && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.add(new int[] {newRow, newCol});
                        fresh--;
                    }
                }
                size--;
            }
            time++;
        }
        return (fresh == 0) ? time: -1;
    }

    public int[][] floodFillRevUsingDFS(int[][] image, int sr, int sc, int color) {
        dfsRev(image, sr, sc, image.length, image[0].length, image[sr][sc], color);
        return image;
    }

    private void dfsRev(int[][] image, int sr, int sc, int rows, int cols, int orginalColor, int newColor) {
        if (sr < 0 || sc < 0 || sr >= rows || sc >= cols) {
            return;
        }
        if(image[sr][sc] == newColor || image[sr][sc] != orginalColor) {
            return;
        }
        if(image[sr][sc] == orginalColor) {
            image[sr][sc] = newColor;
        }
        dfsRev(image, sr+1, sc, rows, cols, orginalColor, newColor);
        dfsRev(image, sr-1, sc, rows, cols, orginalColor, newColor);
        dfsRev(image, sr, sc-1, rows, cols, orginalColor, newColor);
        dfsRev(image, sr, sc+1, rows, cols, orginalColor, newColor);
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = -1;
        int[][] directions4 = new int[][] {
                {0,1}, {0, -1}, {1, 0}, {-1, 0}
        };
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if(fresh == 0) {
            return 0;
        }
        if(queue.isEmpty()) {
            return -1;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                for (int i = 0; i < directions4.length; i++) {
                    int[] direction = directions4[i];
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if(newCol >= 0 && newRow>=0 && newCol < n && newRow < m
                            && grid[newRow][newCol] == 1) {
                        queue.add(new int[] {newRow, newCol});
                        grid[newRow][newCol] = 2;
                        fresh--;
                    }
                }
                size--;
            }
            time++;
        }
        if(fresh == 0) {
            return time;
        }
        return -1;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        int rows = image.length;
        int cols = image[0].length;
        if(originalColor != color) {
            dfsFloodFill(image, rows, cols, sr, sc, color, originalColor);
        }
        return image;
    }

    private void dfsFloodFill(int[][] image, int rows, int cols, int sr, int sc, int color, int originalColor) {
        if(sr < 0 || sc < 0 ||
        sr >= rows || sc >= cols ||
        image[sr][sc] != originalColor) {
            return;
        }
        image[sr][sc] = color;
        dfsFloodFill(image, rows, cols, sr+1, sc, color, originalColor);
        dfsFloodFill(image, rows, cols, sr-1, sc, color, originalColor);
        dfsFloodFill(image, rows, cols, sr, sc+1, color, originalColor);
        dfsFloodFill(image, rows, cols , sr, sc-1, color, originalColor);
    }

    private static void addEdge(List<List<Integer>> adjacencyList, int i, int j) {
        adjacencyList.get(i).add(j);
        adjacencyList.get(j).add(i);
    }

    private static void addEdge(int[][] matrix, int from, int to) {
        matrix[from][to] = 1;
        matrix[to][from] = 1;
    }

    public void toposort(int V, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfs(i, visited, stack, adjList);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private void dfs(int nodeLabel, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adjList) {
        visited[nodeLabel] = true;
        for(Integer neighbour: adjList.get(nodeLabel)) {
            if(!visited[neighbour]) {
                dfs(neighbour, visited, stack, adjList);
            }
        }
        stack.push(nodeLabel);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = calculateAdjList(prerequisites);
        List<Integer> indegree = toposortInDegree(numCourses, adjList);
        return indegree.size() == numCourses;
    }

    private List<List<Integer>> calculateAdjList(int[][] prerequisites) {
        // [1,0], [2,0], [3,1], [3,2]
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] arr: prerequisites) {
            adjList.get(arr[1]).add(arr[0]);
        }
        return adjList;
    }
}
