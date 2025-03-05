package lab_04;

import java.util.Arrays;

public class Main {

	// TC => O(n) + O(nlogn) = O(nlogn)
	// SC => (logn)
	// SC => (logn)

	public static void heapsort(int[] arr) {

		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, i, n);
		}

		for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, 0, i);
		}

	}

	private static void heapify(int[] arr, int i, int n) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;

		if (l < n && arr[l] > arr[largest])
			largest = l;

		if (r < n && arr[r] > arr[largest])
			largest = r;

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heapify(arr, largest, n);
		}

	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 3, 2, 1 };

		System.out.println(Arrays.toString(arr));

		heapsort(arr);

		System.out.println(Arrays.toString(arr));
	}
}
