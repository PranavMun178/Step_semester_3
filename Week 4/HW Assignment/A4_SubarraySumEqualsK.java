import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A4_SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        // Base case: prefix sum of 0 has occurred once (empty prefix)
        prefixSumMap.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) exists in map, a subarray summing to k exists
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }

            // Store/update frequency of current prefix sum
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Input:  nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + subarraySum(nums1, k1));

        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println("\nInput:  nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + subarraySum(nums2, k2));
    }
}