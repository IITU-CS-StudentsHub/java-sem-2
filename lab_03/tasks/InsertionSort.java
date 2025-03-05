package lab_03.tasks;

public class InsertionSort {
	public static void insertionSort(int[] arr, int left, int right) {

		for (int i = left + 1; i <= right; i++) {
			int temp = arr[i];
			int j = i - 1;

			while (j >= left && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}
}
