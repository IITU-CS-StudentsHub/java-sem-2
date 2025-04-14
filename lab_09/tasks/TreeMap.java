package lab_09.tasks;

public class TreeMap<K extends Comparable<K>, V> extends RedBlackTree<K> {

	// Внутренний класс для хранения пар ключ-значение
	private class Entry extends RBNode {
		private V value;

		public Entry(K key, V value) {
			super(key);
			this.value = value;
		}

		@Override
		public String toString() {
			return (color == RED ? "R" : "B") + data + "=" + value;
		}
	}

	public TreeMap() {
		super();
	}

	// Вставка нового элемента (ключ + значение)
	public void put(K key, V value) {
		Entry newEntry = new Entry(key, value);
		root = insert(root, newEntry);
		fixInsert(newEntry); // Балансировка после вставки
	}

	// Вставка с правильной обработкой типов
	@Override
	@SuppressWarnings("unchecked")
	public RBNode insert(RBNode current, RBNode newNode) {
		if (current == null) {
			return newNode;
		}

		// Сравниваем ключи
		if (newNode.data.compareTo(current.data) < 0) {
			current.left = insert((RBNode) current.left, newNode);
			((RBNode) current.left).parent = current;
		} else if (newNode.data.compareTo(current.data) > 0) {
			current.right = insert((RBNode) current.right, newNode);
			((RBNode) current.right).parent = current;
		} else {
			// Если ключ уже существует, заменяем значение
			Entry currentEntry = (Entry) current;
			Entry newEntry = (Entry) newNode;
			currentEntry.value = newEntry.value;
		}

		return current;
	}

	// Поиск по ключу
	@SuppressWarnings("unchecked")
	public V get(K key) {
		RBNode node = searchNode(key, root);
		if (node == null) {
			return null;
		}
		Entry entry = (Entry) node;
		return entry.value;
	}

	// Вспомогательный метод для поиска узла по ключу
	@SuppressWarnings("unchecked")
	private RBNode searchNode(K key, RBNode node) {
		if (node == null) {
			return null;
		}

		int cmp = key.compareTo((K) node.data);
		if (cmp < 0) {
			return searchNode(key, (RBNode) node.left);
		} else if (cmp > 0) {
			return searchNode(key, (RBNode) node.right);
		} else {
			return node;
		}
	}

	// Удаление элемента по ключу
	public void remove(K key) {
		root = deleteNode(root, key);
	}

	@SuppressWarnings("unchecked")
	public RBNode deleteNode(RBNode node, K key) {
		if (node == null) {
			return null;
		}

		// Ищем ключ
		if (key.compareTo((K) node.data) < 0) {
			node.left = deleteNode((RBNode) node.left, key);
		} else if (key.compareTo((K) node.data) > 0) {
			node.right = deleteNode((RBNode) node.right, key);
		} else {
			// Удаляем узел с ключом
			if (node.left == null) {
				return (RBNode) node.right;
			} else if (node.right == null) {
				return (RBNode) node.left;
			}

			// Находим минимальное значение в правом поддереве
			node.data = minValue(node.right);
			node.right = deleteNode((RBNode) node.right, node.data);
		}

		return node;
	}

	// Переопределим inorder для вывода с ключами и значениями
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		inorder(root, sb);
		return sb.toString();
	}

	private void inorder(RBNode node, StringBuilder sb) {
		if (node == null)
			return;
		inorder((RBNode) node.left, sb);
		sb.append(node.toString()).append(" ");
		inorder((RBNode) node.right, sb);
	}
}
