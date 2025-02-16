package tasks;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 5, 4, 3, 2, 1 };

		long startTime = System.nanoTime();
		insertionSort(arr);
		long endTime = System.nanoTime();

		System.out.println(Arrays.toString(arr));
		System.out.println("Execution time: " + (endTime - startTime) + " ns");
	}

	private static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			int temp = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;

		}

	}

}
