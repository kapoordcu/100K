package gk.practic.twopointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoPointerPatternQuestions {

static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
//        val = x;
//        next = null;
    }
}

    public static void main(String[] args) {
        TwoPointerPatternQuestions questions = new TwoPointerPatternQuestions();
        int[] nums = { 2,3,1,2,4,3};
        System.out.println(questions.minSubArrayLen(7, nums));
//        int[] array = { 1, 4, 6, 9, 12};
//        int[] indices = TwoPointerPatternQuestions.findIndicesWithSumIfNotSortedGK(array, 13);
//        int[] indicesSorted = TwoPointerPatternQuestions.findIndicesWithSumIfSortedGK(array, 16);
//        assert indices[0] ==1 && indices[1] ==3;
//        assert indicesSorted[0] ==1 && indicesSorted[1] ==4;
//
//        int[] arrayOfDuplicates = { 1, 1, 3, 3, 3, 5, 6, 6, 6, 7, 8,8,8,8,8};
//        int[] arrayOfDuplicatesRemoved = TwoPointerPatternQuestions.removeDuplicatesSorted(arrayOfDuplicates);
//        assert arrayOfDuplicatesRemoved[0] == 1;
//        assert arrayOfDuplicatesRemoved[1] == 3;
//        assert arrayOfDuplicatesRemoved[2] == 5;
//        assert arrayOfDuplicatesRemoved[3] == 6;
//        assert arrayOfDuplicatesRemoved[4] == 7;
//        assert arrayOfDuplicatesRemoved[5] == 8;
//        int[] array2 = { 1, -4, -6, 9, -5};
//        int[] indices2 = TwoPointerPatternQuestions.findIndicesWithSumIfNotSortedGK(array2, -9);
//        assert indices2[0] ==1;
//        assert indices2[1] ==4;
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        int five = TwoPointerPatternQuestions.removeDuplicates(nums);
//        assert five == 5;
//       String s = "A man, a plan, a canal: Panama";
//       TwoPointerPatternQuestions.isPalindrome(s);
//        int[] height = {1,8,6,2,5,4,8,3,7};
//        int maxArea  = TwoPointerPatternQuestions.maxArea(height);
//        System.out.println(maxArea); // 49
//        int[] height = new int[]{1, 3, 5, 6, 9, 11};
//        int[] heightTrapped = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        //int maxArea  = TwoPointerPatternQuestions.maxArea(height);
//        int maxAreaTrapped  = TwoPointerPatternQuestions.trap(heightTrapped);
//        System.out.println(maxAreaTrapped); // 6
//        System.out.println(maxArea); // 15
//        ListNode head = new ListNode(3);
//        ListNode a = new ListNode(2);
//        ListNode b = new ListNode(0);
//        ListNode c = new ListNode(-4);
//        head.next = a;
//        a.next = b;
//        b.next = c;
//        c.next = a;
//        System.out.println(TwoPointerPatternQuestions.cycleBegins(head).val);
//        System.out.println(TwoPointerPatternQuestions.isHappy(121));
//         System.out.println(TwoPointerPatternQuestions.isHappyUsingSet(45));
//        System.out.println(TwoPointerPatternQuestions.isHappyUsingSet(82));

    }

    public static boolean isHappy(int n) {
        int slow = squareOfDigits(n);
        int fast = squareOfDigits(squareOfDigits(n));
        while (fast != slow) {
            slow = squareOfDigits(slow);
            fast = squareOfDigits(squareOfDigits(fast));
        }
        return slow == 1;
    }

    public int minSubArrayLen(int target, int[] nums) {
    //2,3,1,2,4,3
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int right = left; right < nums.length; right++) {
            sum += nums[right];
            while(sum >= target) {
                min = Math.min(min, right - left +1);
                sum -= nums[left];
                left++;
            }
        }
        return min;
    }

    public static boolean isHappyUsingSet(int n) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (n != 1) {
            if(uniqueNumbers.contains(n)) {
                return false;
            }
            uniqueNumbers.add(n);
            n = squareOfDigits(n);
        }
        return true;
    }

    public static int squareOfDigits(int n) {
        int sum  = 0;
        while (n > 0) {
            int unitDigit = n % 10;
            sum += unitDigit*unitDigit;
            n = n/10;
        }
        return sum;
    }


    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static ListNode cycleBegins(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static ListNode middleLinkedList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            if(fast.next == null) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static  int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length -1;
        while (left < right) {
            //1,8,6,2,5,4,8,3,7
            int minH = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minH*(right-left));
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }

    public static int trap(int[] height) {
        int maxWaterTrap = 0;
        int len = height.length;
        int[] prefixMax = new int[len];
        int[] suffixMax = new int[len];
        prefixMax[0] = height[0];
        suffixMax[len-1] = height[len-1];
        for (int i = 1; i < len - 1; i++) {
            prefixMax[i] = Math.max(height[i], prefixMax[i-1]);
        }
        for (int i = len -2; i >=0 ; i--) {
            suffixMax[i] = Math.max(height[i], suffixMax[i+1]);
        }
        for (int i = 0; i < len - 1; i++) {
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i];
            if(height[i] < leftMax  && height[i] < rightMax) {
                maxWaterTrap += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return maxWaterTrap;
    }

    public int removeDuplicates2(int[] nums) {
        int i=0;
        int j=i+1;
        while(j<nums.length) {
            if(nums[i]==nums[j]) {
                j++;
            } else {
                nums[i+1]=nums[j];
                i = i+1;
            }
        }
        return i+1;
    }

    public static int removeDuplicates(int[] nums) {
        int visited = nums[0];
        int index = 1;
        for(int i=1; i< nums.length; i++) {
            if(nums[i] != visited) {
                visited = nums[i];
                nums[index] = visited;
                index++;
            }
        }
        return index;
    }

    public static boolean isPalindrome(String s) {
    s=s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int i=0, j=s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private static int[] findIndicesWithSumIfSortedGK(int[] array, int target) {
        int[] indices = {-1, -1};
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            if(array[i]+array[j] == target) {
                indices[0] = i;
                indices[1] = j;
                return indices;
            }
            if(array[i]+array[j] < target) {
                i++;
            }
            if(array[i]+array[j] > target) {
                j--;
            }
        }

        return indices;
    }

    private static int[] findIndicesWithSumIfNotSortedGK(int[] array, int target) {
        int[] indices = {-1, -1};
        Map<Integer, Integer> sumSet = new HashMap<>();
            //{ 1, 4, 6, 9, 12};
        /*
        1, 0
        4, 1
        6, 2
        9, 3
        12, 4
         */
        for (int i = 0; i < array.length; i++) {
            if(sumSet.containsKey(target - array[i])) {
                indices[0] = sumSet.get(target - array[i]);
                indices[1] = i;
                return indices;
            }
            else {
                sumSet.put(array[i], i);
            }
        }
        return indices;
    }
}
