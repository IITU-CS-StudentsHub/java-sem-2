package lecture_4;

public class Main {

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, n, largest);
		}
	}

	private static void heapsort(int[] arr) {
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			swap(arr, 0, i);

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	public static void main(String[] args) {

		int[] arr = { 10, 7, 8, 9, 1, 5 };
		heapsort(arr);

		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

}