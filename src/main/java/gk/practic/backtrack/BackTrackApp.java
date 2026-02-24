package gk.practic.backtrack;

import java.util.ArrayList;
import java.util.List;

public class BackTrackApp {
    public static void main(String[] args) {
//        int[] numbers = {1, 2, 3};
//        List<Integer> curr = new ArrayList<>();
//        List<List<Integer>> resilt = new ArrayList<>();
        BackTrackApp app = new BackTrackApp();
//        app.backtrackGeneric(0, numbers, curr, resilt);
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

    private List<String> mazeRun(int[][] maze) {
        int n =  maze.length;
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {
                {1, 0, 'D'},
                {-1, 0, 'U'},
                {0, 1, 'R'},
                {0, -1, 'L'}
        };
        List<String> result = new ArrayList<>();
        backTrackMaze(0, 0, n, maze, visited, directions, "", result);
        return result;
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
}
