package tasks;

import java.util.Arrays;

public class SortManager {
	public static void main(String[] args) {
		int[] arr = ArrayProvider.getArray();

		int[] arrForMergeSort = Arrays.copyOf(arr, arr.length);
		int[] arrForEnhancedMergeSort = Arrays.copyOf(arr, arr.length);
		int[] arrForDualPivotQuickSort = Arrays.copyOf(arr, arr.length);

		// Merge + Insertion
		long startTime = System.nanoTime();
		EnhancedMergeSort.mergeSort(arrForEnhancedMergeSort, 0, arrForEnhancedMergeSort.length - 1);
		long endTime = System.nanoTime();
		long mergeSortWithInsertionTime = endTime - startTime;

		// Merge
		startTime = System.nanoTime();
		MergeSort.mergeSort(arrForMergeSort, 0, arrForMergeSort.length - 1);
		endTime = System.nanoTime();
		long mergeSortTime = endTime - startTime;

		// Dual pivot quick sort
		DualPivotQuickSort sorter = new DualPivotQuickSort(arrForDualPivotQuickSort);
		startTime = System.nanoTime();
		sorter.sort();
		endTime = System.nanoTime();
		long dualPivotQuickSortTime = endTime - startTime;

		// System.out.println("Initial array: " + Arrays.toString(arr));
		// Merge + Insertion
		// System.out.println("Sorted array (Merge Sort + Insertion): " +
		// Arrays.toString(arrForEnhancedMergeSort));
		System.out.println("Time taken by Merge Sort + Insertion: " + mergeSortWithInsertionTime / 1000 + " ns");
		// Merge
		// System.out.println("Sorted array (Merge Sort): " +
		// Arrays.toString(arrForMergeSort));
		System.out.println("Time taken by Merge Sort: " + mergeSortTime / 1000 + " ns");
		// Dual pivot quick sort
		// System.out.println("Sorted array (Dual pivot quick sort): " +
		// sorter.getArray());
		System.out.println("Time taken by Deal pivot quick Sort: " + dualPivotQuickSortTime / 1000 + " ns");
	}
}
