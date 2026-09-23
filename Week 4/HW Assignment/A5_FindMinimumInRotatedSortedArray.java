import java.util.Arrays;

public class A5_FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than rightmost element, min lies in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { // Otherwise, min lies in left half (including mid)
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Input:  " + Arrays.toString(nums1));
        System.out.println("Output: " + findMin(nums1));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("\nInput:  " + Arrays.toString(nums2));
        System.out.println("Output: " + findMin(nums2));

        int[] nums3 = {11, 13, 15, 17};
        System.out.println("\nInput:  " + Arrays.toString(nums3));
        System.out.println("Output: " + findMin(nums3));
    }
}