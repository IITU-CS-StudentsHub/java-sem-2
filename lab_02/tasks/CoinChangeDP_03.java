package lab_02.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinChangeDP_03 {

	public static List<Integer> coinChangeDP(int[] coins, int target) {
		int max = target + 1;
		int[] dp = new int[target + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;

		// Массив для восстановления решения:
		int[] lastCoin = new int[target + 1];
		Arrays.fill(lastCoin, -1);

		// Заполнение таблицы dp
		for (int i = 1; i <= target; i++) {
			for (int coin : coins) {
				if (i - coin >= 0 && dp[i - coin] + 1 < dp[i]) {
					dp[i] = dp[i - coin] + 1;
					lastCoin[i] = coin;
				}
			}
		}

		if (dp[target] == max) {
			System.out.println("Решение не найдено.");
			return Collections.emptyList();
		}

		// Восстановление решения
		List<Integer> result = new ArrayList<>();
		int t = target;
		while (t > 0) {
			result.add(lastCoin[t]);
			t -= lastCoin[t];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] coins = { 1, 5, 10, 20, 25, 50 };
		int target = 40;
		List<Integer> change = coinChangeDP(coins, target);
		System.out.println("Монеты, использованные для размена (DP): " + change);
	}
}
