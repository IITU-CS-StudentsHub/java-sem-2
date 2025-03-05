package lab_02.tasks;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumRecursive_04 {
	private static Map<Integer, Boolean> memo = new HashMap<>();

	public static boolean canReachZero(int n) {
		if (n < 0)
			return false;
		if (n == 0)
			return true;

		if (memo.containsKey(n))
			return memo.get(n);

		boolean res = canReachZero(n - 3) || canReachZero(n - 5);

		memo.put(n, res);

		return res;
	}

	public static void main(String[] args) {
		int number = 7;
		System.out.println("Можно ли получить 0 из " + number + ": " + canReachZero(number));
	}
}
