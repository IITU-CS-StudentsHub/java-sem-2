package lab_09;

import lab_09.tasks.RedBlackTree;
import lab_09.tasks.TreeMap;
import lab_09.tasks.TreeSet;

public class Main {
	public static void main(String[] args) {
		// Тестирование RedBlackTree
		System.out.println("\n=== TEST RedBlackTree ===");
		RedBlackTree<Integer> rbt = new RedBlackTree<>();
		rbt.add(5);
		rbt.add(3);
		rbt.add(7);
		rbt.add(1);
		rbt.add(4);
		rbt.add(6);
		rbt.add(8);

		System.out.println("RedBlackTree contains: " + rbt); // Содержимое с цветами (R или B)

		System.out.println("Contains 4? " + rbt.contains(4)); // true
		System.out.println("Contains 10? " + rbt.contains(10)); // false

		rbt.delete(3);
		System.out.println("After deleting 3: " + rbt); // 1 4 5 6 7 8

		// Тестирование TreeMap
		System.out.println("\n=== TEST TreeMap ===");
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(5, "Five");
		treeMap.put(3, "Three");
		treeMap.put(7, "Seven");
		treeMap.put(1, "One");
		treeMap.put(4, "Four");
		treeMap.put(6, "Six");
		treeMap.put(8, "Eight");

		System.out.println("TreeMap contains: " + treeMap); // 1=One 3=Three 4=Four 5=Five 6=Six 7=Seven 8=Eight

		System.out.println("Value by key 4: " + treeMap.get(4)); // Four
		System.out.println("Value by key 10: " + treeMap.get(10)); // null

		treeMap.remove(3);
		System.out.println("After deleting 3: " + treeMap); // 1=One 4=Four 5=Five 6=Six 7=Seven 8=Eight

		// Тестирование TreeSet
		System.out.println("\n=== TEST TreeSet ===");
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(5);
		treeSet.add(3);
		treeSet.add(7);
		treeSet.add(1);
		treeSet.add(4);
		treeSet.add(6);
		treeSet.add(8);
		treeSet.add(3); // Повторный элемент, не добавится

		System.out.println("TreeSet contains: " + treeSet); // 1 3 4 5 6 7 8

		System.out.println("Contains 4? " + treeSet.contains(4)); // true
		System.out.println("Contains 10? " + treeSet.contains(10)); // false

		treeSet.remove(3);
		System.out.println("After deleting 3: " + treeSet); // 1 4 5 6 7 8
	}
}
