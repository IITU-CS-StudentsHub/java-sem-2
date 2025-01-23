package tasks;

// Task 2
// Input: [5,0,1,-5,7]
// Output: Target = 
//         SubArrays =
// 			   sum 0 = target
//         [0] [5, -5], [5, 0, -5]
// Note: Bitmask
import java.util.ArrayList;
import java.util.List;

public class SubArraySumBitmask_02 {
    public static void main(String[] args) {
        int[] arr = {5, 0, 1, -5, 7};
        int target = 0;

        List<List<Integer>> subarrays = findTargetSubarrays(arr, target);

        System.out.println("Target = " + target);
        System.out.println("Subarrays:");
        for (List<Integer> subarray : subarrays) {
            System.out.println(subarray);
        }
    }

    public static List<List<Integer>> findTargetSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        // Total number of subsets = 2^n (represented by 1 << n)
        int totalSubsets = 1 << n;

        // Iterate through all possible subsets
        for (int mask = 0; mask < totalSubsets; mask++) {
            List<Integer> subarray = new ArrayList<>();
            int sum = 0;

            // Build the subset based on the current mask
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { // Check if the ith bit is set
                    subarray.add(arr[i]);
                    sum += arr[i];
                }
            }

            // Check if the sum equals the target
            if (sum == target && !subarray.isEmpty()) {
                result.add(subarray);
            }
        }

        return result;
    }
}
