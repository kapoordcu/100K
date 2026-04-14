package gk.practic.backtrack;

import java.awt.image.VolatileImage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BackTrackApp {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
//        List<Integer> curr = new ArrayList<>();
//        List<List<Integer>> resilt = new ArrayList<>();
        BackTrackApp app = new BackTrackApp();
//        List<List<Integer>> allSubsetUsingBacktrack = app.getAllSubsetUsingBacktrackWithBitmask(numbers);
//        allSubsetUsingBacktrack.forEach(System.out::println);
//        app.backtrackGeneric(0, numbers, curr, resilt);
        //List<List<String>> lists = app.solveNQueens(4);
//        System.out.println(resilt);
        int maze[][] = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        List<String> allPaths = app.mazeRun(maze);
        System.out.println(allPaths);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> queens = new ArrayList<>();
        int[][] directions = {
                {-1, -1 },
                {-1, 0 },
                {-1, 1 },
                {0, -1 },
                {0, 1  },
                {1, -1 },
                {1, 0  },
                {1, 1  }
        };
        backtrackQueen(0, 0, n, directions, queens, new ArrayList<>());
        return queens;
    }

    private void backtrackQueen(int x, int y, int n, int[][] directions, List<List<String>> queens, ArrayList<String> current) {

    }

    private List<String> mazeRun(int[][] maze) {
        int size = maze.length;
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[size][size];
        if(maze[0][0] == 1) {
            backtrackMazeRev(0, 0, size, maze, "", visited, result);
        }
        return result;
    }

    private void backtrackMazeRev(int x, int y, int size, int[][] maze, String path, boolean[][] visited, List<String> result) {
        int[][] directions = {
                {-1, 0, 'L'},     //left
                {1, 0, 'R'},     // right
                {0, -1, 'U'},     // top
                {0, 1, 'D'}      //down
        };
        if(x==size-1 && y==size-1) {
            result.add(path);
            return;
        }
        visited[x][y]= true;
        for (int[] dir: directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            char di = (char)dir[2];
            if(newX>=0 && newX<size && newY>=0 && newY<size &&
                    !visited[newX][newY] && maze[newX][newY]==1) {
                backtrackMazeRev(newX, newY, size, maze, path+di, visited, result);
            }
        }
        visited[x][y]= false;
    }

    private void backTrackMaze(int x, int y, int n, int[][] maze, boolean[][] visited, int[][] directions, String path, List<String> result) {
        if(x==n-1 && y==n-1) {
            result.add(path);
            return;
        }
        visited[x][y]=true;
        for (int[] dir: directions) {
            int nextRow = dir[0] + x;
            int nextCol = dir[1] + y;
            Character ch = (char)dir[2];
            if(nextRow>=0 && nextCol>=0 &&
                nextCol<n && nextRow<n &&
                !visited[nextRow][nextCol] && maze[nextRow][nextCol]==1) {
                backTrackMaze(nextRow, nextCol, n, maze, visited, directions,path+ch, result);
            }
        }
        visited[x][y]=false;
    }

    public void backtrackGeneric(int index, int[] nums, List<Integer> curr, List<List<Integer>> resilt) {
        resilt.add(new ArrayList<>(curr)); //current subset
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrackGeneric(i + 1, nums, curr, resilt);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> getAllSubsetUsingBacktrack(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracksubset(nums, 0, result, new ArrayList<>());
        return result;
    }

    public List<List<Integer>> getAllSubsetUsingBacktrackWithBitmask(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length; //3
        int sets = 1 << n; // 2"3 = 8
        for (int mask = 0; mask < sets; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    private void backtracksubset(int[] nums, int index, List<List<Integer>> result, ArrayList<Integer> current) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtracksubset(nums, i+1, result, current);
            current.remove(current.size()-1);
        }
    }
}
