package lab_08;

import lab_08.tasks.AVL;

public class Main {
	public static void main(String[] args) {
		AVL<Integer> tree = new AVL<>();
		tree.add(10);
		tree.add(20);
		tree.add(30);
		tree.add(40);
		tree.add(50);
		tree.add(25);

		System.out.println(tree);
		tree.delete(30);
		System.out.println("After deletion:");
		System.out.println(tree);
	}
}
