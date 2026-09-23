import java.util.Arrays;

public class MergeArraysSolution {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for result array

        // Compare elements and copy the smaller one into the result array
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from arr1 if any
        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        // Copy remaining elements from arr2 if any
        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2))); // Output: [1, 2, 3, 4, 5, 6]

        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        System.out.println(Arrays.toString(mergeSortedArrays(arr3, arr4))); // Output: [1, 2, 3]
    }
}