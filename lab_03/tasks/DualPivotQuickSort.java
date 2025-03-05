package lab_03.tasks;

import java.util.Arrays;

public class DualPivotQuickSort {

	private final int[] arr;

	public DualPivotQuickSort(int[] arr) {
		this.arr = arr;
	}

	public void sort() {
		dualPivotQuicksort(0, arr.length - 1);
	}

	private void dualPivotQuicksort(int low, int high) {
		if (low < high) {
			Pivot pivot = partition(low, high);

			dualPivotQuicksort(low, pivot.left() - 1);
			dualPivotQuicksort(pivot.left() + 1, pivot.right() - 1);
			dualPivotQuicksort(pivot.right() + 1, high);
		}
	}

	private Pivot partition(int low, int high) {
		if (arr[low] > arr[high]) {
			swap(low, high);
		}

		int pivot1 = arr[low];
		int pivot2 = arr[high];

		int left = low + 1;
		int right = high - 1;
		int iterator = low + 1;

		while (iterator <= right) {
			if (arr[iterator] < pivot1) {
				swap(iterator, left);
				left++;
				iterator++;
			} else if (arr[iterator] > pivot2) {
				swap(iterator, right);
				right--;
			} else {
				iterator++;
			}
		}

		swap(low, left - 1);
		swap(high, right + 1);

		return new Pivot(left - 1, right + 1);
	}

	private void swap(int i, int j) {
		if (i != j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	private record Pivot(int left, int right) {
	}

	public String getArray() {
		return Arrays.toString(arr);
	}
}