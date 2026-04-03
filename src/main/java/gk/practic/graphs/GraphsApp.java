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
        int[][] image = {{2,1,1}, {1,1,0}, {0,1,1}}; // 4
        int[][] image2 = {{2,1,1}, {0,1,1}, {1,0,1}}; // 0
        int result = app.orangesRottingBFS(image);
        System.out.println(result);
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
}
