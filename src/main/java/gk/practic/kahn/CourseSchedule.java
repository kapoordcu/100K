package gk.practic.kahn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        CourseSchedule schedule = new CourseSchedule();
        int[] result = schedule.findOrder(numCourses, prerequisites);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer> topo = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] pair = prerequisites[i];
            indegree[pair[0]]++;
            adj.get(pair[1]).add(pair[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i]==0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int popped = queue.poll();
            topo.add(popped);
            for (int neighbour : adj.get(popped)) {
                indegree[neighbour]--;
                if(indegree[neighbour]==0) {
                    queue.add(neighbour);
                }
            }
        }
        if(topo.size() != numCourses) {
            return new int[0];
        }
        return topo.stream().mapToInt(Integer::intValue).toArray();
    }
}
