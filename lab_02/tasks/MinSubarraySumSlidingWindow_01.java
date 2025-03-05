package lab_02.tasks;

public class MinSubarraySumSlidingWindow_01 {

	public static int findMinSubarraySum(int[] arr, int k) {
		if (k > arr.length) {
			throw new IllegalArgumentException();
		}

		int currentSum = 0;

		for (int i = 0; i < k; i++) {
			currentSum += arr[i];
		}

		int minSum = currentSum;

		for (int i = k; i < arr.length; i++) {
			currentSum += arr[i] - arr[i - k];
			Math.min(minSum, currentSum);
		}

		return minSum;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 4, 2 };
		int k = 4;
		int result = findMinSubarraySum(arr, k);
		System.out.println(result);
	}
}
