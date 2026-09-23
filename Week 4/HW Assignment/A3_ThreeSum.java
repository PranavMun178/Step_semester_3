import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A3_ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort array first

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate outer elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input:  " + Arrays.toString(nums1));
        System.out.println("Output: " + threeSum(nums1));

        int[] nums2 = {0, 0, 0};
        System.out.println("\nInput:  " + Arrays.toString(nums2));
        System.out.println("Output: " + threeSum(nums2));
    }
}