package lab_03.tasks;

import java.util.Random;

public class ArrayProvider {
	public static int[] getArray() {

		int[] arr = new int[1_000_000];

		for (int i = 0; i < 1_000_000; i++) {
			arr[i] = new Random().nextInt(10000);
		}

		return arr;
	}

	public static int[] getSmallArray() {
		return new int[] {
				38, 27, 43, 3, 9, 82, 10
		};
	}
}
