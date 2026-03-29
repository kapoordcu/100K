package gk.practic.merge;

import gk.practic.models.KMergeNode;
import gk.practic.models.ListNode;

import java.util.*;

public class KWayMerge {
    public ListNode mergeKLists(ListNode[] lists) {
        /*
        Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
         */
        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node: lists) {
            queue.offer(node);
        }
        ListNode head = new ListNode(0); // 0 -> 1 -> 1 ->
        ListNode current = head;
        while (!queue.isEmpty()) {
            ListNode remove = queue.remove();
            current.next = remove;
            current = current.next;
            if(remove.next != null) {
                queue.offer(remove.next);
            }
        }
        return head.next;
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        int[] nums1 = {1,7,11};
//        int[] nums2 = {2,4,6};
        List<List<Integer>> result = new ArrayList<>();
        Queue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[0].compareTo(b[0]));
        for (int i = 0; i < nums1.length; i++) {
            Integer[] pair = new Integer[] {nums1[i]+nums2[0], i, 0};
            queue.offer(pair);
        }
        while (k>0 && !queue.isEmpty()) {
            Integer[] poll = queue.poll();
            int i = poll[1];
            int j = poll[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;
            if(j+1<nums2.length) {
                Integer[] pair = new Integer[] {nums1[i]+nums2[j+1], i, j+1};
                queue.offer(pair);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        ListNode node00 = new ListNode(1);
//        ListNode node01 = new ListNode(4);
//        ListNode node02 = new ListNode(5);
//        ListNode node10 = new ListNode(1);
//        ListNode node11 = new ListNode(3);
//        ListNode node12 = new ListNode(4);
//        ListNode node20 = new ListNode(2);
//        ListNode node21 = new ListNode(6);
//        node00.next = node01;
//        node01.next = node02;
//
//        node10.next = node11;
//        node11.next = node12;
//
//        node20.next = node21;
//
//        ListNode[] lists = { node00, node10, node20};

        KWayMerge merge = new KWayMerge();
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
//[[1,2],[1,4],[1,6]]
        List<List<Integer>> listsPairs = merge.kSmallestPairs(nums2, nums1, k);
    }
}

/*

int[] nums1 = {1,7,11};
int[] nums2 = {2,4,6};
int k = 3;
//[[1,2],[1,4],[1,6]]
KWayMerge merge = new KWayMerge();
List<List<Integer>> lists = merge.kSmallestPairs(nums1, nums2, k);
 */