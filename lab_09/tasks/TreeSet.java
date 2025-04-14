package lab_09.tasks;

import java.util.TreeSet;

public class TreeSet<E extends Comparable<E>> extends TreeMap<E, Object> {

	private static final Object PRESENT = new Object(); // Заглушка для значений

	public TreeSet() {
		super();
	}

	// Добавление элемента
	public void add(E element) {
		if (!contains(element)) {
			put(element, PRESENT); // Добавляем элемент как ключ с заглушкой
		}
	}

	// Проверка, есть ли элемент в TreeSet
	public boolean contains(E element) {
		return get(element) != null;
	}

	// Удаление элемента
	public void remove(E element) {
		if (contains(element)) {
			super.remove(element); // Удаляем ключ (и его заглушку)
		}
	}

	// Переопределим toString, чтобы вывести элементы в порядке возрастания
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		inorder(root, sb);
		return sb.toString().trim(); // Убираем лишний пробел в конце
	}

	private void inorder(RBNode node, StringBuilder sb) {
		if (node == null)
			return;
		inorder((RBNode) node.left, sb);
		sb.append(node.toString().replace("=" + PRESENT, "")).append(" "); // Убираем =PRESENT из вывода
		inorder((RBNode) node.right, sb);
	}
}
