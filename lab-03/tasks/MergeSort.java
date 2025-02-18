package tasks;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] arr, int left, int right) {
		if (left >= right)
			return;

		int mid = left + (right - left) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
		int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

		int i = 0, j = 0, k = left;

		while (i < leftArr.length && j < rightArr.length) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k++] = leftArr[i++];
			} else {
				arr[k++] = rightArr[j++];
			}
		}

		while (i < leftArr.length)
			arr[k++] = leftArr[i++];
		while (j < rightArr.length)
			arr[k++] = rightArr[j++];
	}
}
