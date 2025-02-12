package tasks;

public class ZeroSumRecursive_04 {

	public static boolean hasZeroSumSubset(int[] arr) {
		return hasZeroSumSubset(arr, 0, 0, false);
	}

	private static boolean hasZeroSumSubset(int[] arr, int index, int currentSum, boolean used) {
		if (index == arr.length) {
			return used && currentSum == 0;
		}
		// включить arr[index]
		if (hasZeroSumSubset(arr, index + 1, currentSum + arr[index], true)) {
			return true;
		}
		// пропустить arr[index]
		if (hasZeroSumSubset(arr, index + 1, currentSum, used)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, -3, 4 };
		if (hasZeroSumSubset(arr)) {
			System.out.println("Существует непустое подмножество с суммой 0.");
		} else {
			System.out.println("Ни одного непустого подмножества с суммой 0 не найдено.");
		}
	}
}
