package gk.practic.prefixsum;

public class FindTargetSum {

    public static void main(String[] args) {
//        int arr[] = {1,2,3,7,5};
//        int[] indices = FindTargetSum.calculateTargetSumIndices(arr, 12);
//        assert indices.length == 2;
//        assert indices[0] == 1;
//        assert indices[1] == 3;

        int[] arrNeg = {3, 2,-1,7,-5};
        int[] indicesNeg = FindTargetSum.calculateTargetSumIndices(arrNeg, 1);
        assert indicesNeg.length == 2;
        assert indicesNeg[0] == 1;
        assert indicesNeg[1] == 2;
    }

    private static int[] calculateTargetSumIndices(int[] arr, int target) {
        //{1,2,3,7,5};
        int[] indices = {-1, -1};
        int sum = 0;
        int left = 0;
        for (int right = left; right < arr.length;) {
            if(sum == target) {
                indices[0] = left;
                indices[1] = right;
                return indices;
            }
            sum += arr[right];
            if(sum < target) {
                right++;
            } else {
                sum -= arr[left];
                left++;
            }

        }

        return indices;
    }
}
