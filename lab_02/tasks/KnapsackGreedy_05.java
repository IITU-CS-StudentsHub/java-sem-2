package lab_02.tasks;

import java.util.Arrays;

public class KnapsackGreedy_05 {
	// Вспомогательный класс для представления предмета
	static class Item {
		int weight;
		int value;

		public Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

		public double getRatio() {
			return (double) value / weight;
		}
	}

	public static double fractionalKnapsack(Item[] items, int capacity) {
		// Сортировка предметов по убыванию отношения стоимости к весу
		Arrays.sort(items, (a, b) -> Double.compare(b.getRatio(), a.getRatio()));

		double totalValue = 0;
		int remainingCapacity = capacity;

		for (Item item : items) {
			if (remainingCapacity == 0)
				break;

			if (item.weight <= remainingCapacity) {
				// Берем весь предмет
				totalValue += item.value;
				remainingCapacity -= item.weight;
			} else {
				// Берем часть предмета
				double fraction = (double) remainingCapacity / item.weight;
				totalValue += item.value * fraction;
				remainingCapacity = 0;
			}
		}
		return totalValue;
	}

	public static void main(String[] args) {
		Item[] items = {
				new Item(100, 1000),
				new Item(20, 400),
				new Item(5, 200)
		};
		int capacity = 50;
		double maxValue = fractionalKnapsack(items, capacity);
		System.out.println("Максимальная стоимость, которую можно получить: " + maxValue);
	}
}
