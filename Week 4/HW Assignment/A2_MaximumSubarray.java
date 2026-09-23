import java.util.Arrays;

public class A2_MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the current subarray or start fresh
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Track the overall maximum sum encountered
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input:  " + Arrays.toString(nums1));
        System.out.println("Output: " + maxSubArray(nums1));

        int[] nums2 = {-3, -1, -2};
        System.out.println("\nInput:  " + Arrays.toString(nums2));
        System.out.println("Output: " + maxSubArray(nums2));
    }
}