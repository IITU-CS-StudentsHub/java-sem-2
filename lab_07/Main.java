package lab_07;

import lab_07.tasks.BST;

public class Main {
	public static void main(String[] args) {
		BST<Integer> tree = new BST<>();

		tree.add(10);
		tree.add(5);
		tree.add(15);
		tree.add(3);
		tree.add(7);

		System.out.println("Проверяем наличие элементов:");
		System.out.println("10? " + tree.contains(10)); // true
		System.out.println("5? " + tree.contains(5)); // true
		System.out.println("15? " + tree.contains(15)); // true
		System.out.println("3? " + tree.contains(3)); // true
		System.out.println("7? " + tree.contains(7)); // true
		System.out.println("20? " + tree.contains(20)); // false

		System.out.println("\nOrdering:");
		System.out.print("Inorder (LNR): ");
		tree.inorder();

		System.out.print("Preorder (NLR): ");
		tree.preorder();

		System.out.print("Postorder (LRN): ");
		tree.postorder();

		System.out.println("\nDelete 10");
		tree.delete(10);
		System.out.println("10? " + tree.contains(10)); // false

		System.out.print("Inorder after deleting: ");
		tree.inorder();
	}
}
