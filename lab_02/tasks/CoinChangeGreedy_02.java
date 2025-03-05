package lab_02.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChangeGreedy_02 {
	public static List<Integer> coinChangeGreedy(int[] coins, int target) {
		int[] sortedCoins = Arrays.copyOf(coins, coins.length);
		Arrays.sort(sortedCoins);

		for (int i = 0; i < sortedCoins.length / 2; i++) {
			int temp = sortedCoins[i];
			sortedCoins[i] = sortedCoins[sortedCoins.length - 1 - i];
			sortedCoins[sortedCoins.length - 1 - i] = temp;
		}

		List<Integer> result = new ArrayList<>();
		for (int coin : sortedCoins) {
			while (target >= coin) {
				target -= coin;
				result.add(coin);
			}
		}

		if (target != 0) {
			System.out.println("Невозможно разменять заданную сумму точно с данными монетами.");
		}
		return result;
	}

	public static void main(String[] args) {
		int[] coins = { 1, 5, 10, 20, 25, 50 };
		int target = 40;
		List<Integer> change = coinChangeGreedy(coins, target);
		System.out.println("Монеты, использованные для размена: " + change);
	}
}
