package lab_05;

import lab_03.tasks.InsertionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void basketSort(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		int n = arr.length;
		@SuppressWarnings("unchecked")
		List<Integer>[] baskets = new ArrayList[n];

		for (int i = 0; i < n; i++)
			baskets[i] = new ArrayList<>(); // Инициализируем корзины

		for (int num : arr) {
			int index = (num * n) / (max + 1); // Определяем индекс корзины
			baskets[index].add(num); // Добавляем число в соответствующую корзину
		}

		int index = 0;
		for (List<Integer> basket : baskets) {
			int[] array = basket.stream().mapToInt(Integer::intValue).toArray();
			InsertionSort.insertionSort(array, 0, array.length - 1);

			for (int num : basket)
				arr[index++] = num; // Объединяем все корзины в отсортированный массив
		}
	}

	public static void countingSort(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int[] count = new int[max - min + 1]; // Создаём массив частот (размер = диапазону чисел)

		for (int num : arr)
			count[num - min]++; // Заполняем массив частот

		int index = 0;
		for (int i = 0; i < count.length; i++) {
			while (count[i]-- > 0)
				arr[index++] = i + min; // Заполняем исходный массив отсортированными значениями
		}
	}

	public static void radixSort(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();

		for (int exp = 1; max / exp > 0; exp *= 10)
			countingsortbydigit(arr, exp);
	}

	private static void countingsortbydigit(int[] arr, int exp) {
		int[] output = new int[arr.length];
		int[] count = new int[10];

		for (int num : arr)
			count[(num / exp) % 10]++; // Подсчитываем частоту цифр в текущем разряде

		for (int i = 1; i < 10; i++)
			count[i] += count[i - 1]; // Преобразуем в массив префиксных сумм

		for (int i = arr.length - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		System.arraycopy(output, 0, arr, 0, arr.length);
	}

	public static void main(String[] args) {
		int[] arr1 = { 42, 32, 33, 52, 7, 62, 32, 32 };
		int[] arr2 = { 4, 2, 2, 8, 3, 3, 1 };
		int[] arr3 = { 170, 45, 75, 90, 802, 24, 2, 66 };

		basketSort(arr1);
		System.out.println("Basket Sort: " + Arrays.toString(arr1));

		countingSort(arr2);
		System.out.println("Counting Sort: " + Arrays.toString(arr2));

		radixSort(arr3);
		System.out.println("Radix Sort: " + Arrays.toString(arr3));
	}
}
