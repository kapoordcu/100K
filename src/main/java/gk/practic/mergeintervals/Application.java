package gk.practic.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int len = intervals.length; // 3
        int[][] results = new int[len][2];
        results[0] = intervals[0]; // { 1, 4 }
        int e = 0;

        for (int i = 1; i < len; i++) {
            int[] currentInterval = intervals[i]; // {3, 6 }
            if(currentInterval[0] <= results[e][1]) { // merge
               results[e][1] = Math.max(results[e][1], currentInterval[1]);
            } else {
                e++;
                results[e] = intervals[i];
            }
        }
        return Arrays.copyOfRange(results, 0, e + 1);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> results = new ArrayList<>();
        int i=0;
        while (i< len && newInterval[0] > intervals[i][1]) {
            results.add(intervals[i]);
            i++;
        }
        while (i< len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        results.add(newInterval);
        while (i<len){
            results.add(intervals[i]);
            i++;
        }
        return results.toArray(new int[results.size()][2]);
    }

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }


    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s = 0;
        int e = 0;
        int count = 0;
        int min = 0;
        while (s < intervals.length) {
            if(start[s] < end[e]) {
                count++;
                s++;
            } else {
                count--;
                e++;
            }
            min = Math.max(min, count);
        }
        return min;
    }

    public static void main(String[] args) {
        Application app = new Application();
//        int[][] intervals = {{1,4},{7, 8},{3,6}};
//        int[][] merge = app.merge(intervals);
//        System.out.println(merge.length);
//
//
//        int[][] intervals2 = {{2,4},{6, 9}};
//        int[] newInterval = {0,1};
//        int[][] newRange = app.insert(intervals2, newInterval);
//
//        //Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//        //Output: [[1,5],[6,9]]
//
//        int[][] intervals = {{0,30},{60,240},{90,120}};
//        //{{7,10},{2,4}};
//        //
//        System.out.println(app.canAttendMeetings(intervals));

       int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(app.minMeetingRooms(intervals));
    }
}
