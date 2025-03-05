package lecture_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void bucketsort(int[] arr) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] buckets = new ArrayList[6];

		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<>();
		}

		// Distribute the elements into buckets based on their value
		for (int x : arr) {
			buckets[x / 10].add(x);
		}

		// Sort each bucket (using a simple sort like Arrays.sort for simplicity)
		for (var bucket : buckets) {
			bucket.sort(null); // Sort each bucket using natural ordering
		}

		int k = 0;
		// Reassemble the array by concatenating the sorted buckets
		for (var bucket : buckets) {
			for (int x : bucket) {
				arr[k++] = x;
			}
		}
	}

	public static void countingsort(int[] arr, int exp) {
		int n = arr.length;
		int[] output = new int[n];
		int[] count = new int[10]; // Цифры от 0 до 9

		// Подсчет количества вхождений цифр в текущем разряде
		for (int i = 0; i < n; i++) {
			int digit = (arr[i] / exp) % 10;
			count[digit]++;
		}

		// Преобразуем count в массив префиксных сумм (накопленных индексов)
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		// Заполняем выходной массив, идя с конца (стабильность сортировки)
		for (int i = n - 1; i >= 0; i--) {
			int digit = (arr[i] / exp) % 10;
			output[count[digit] - 1] = arr[i];
			count[digit]--;
		}

		// Копируем отсортированный массив обратно
		System.arraycopy(output, 0, arr, 0, n);
	}

	public static void radixsort(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();

		// Сортируем числа по разрядам (единицы, десятки, сотни и т. д.)
		for (int exp = 1; max / exp > 0; exp *= 10) {
			countingsort(arr, exp);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[50];
		Random random = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(999) + 1;
		}

		System.out.println("Initiall array: ");
		System.out.println(Arrays.toString(arr));

		radixsort(arr);

		System.out.println("After sorting: ");
		System.out.println(Arrays.toString(arr));

	}
}
