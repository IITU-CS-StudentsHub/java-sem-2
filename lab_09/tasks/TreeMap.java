package lab_09.tasks;

public class TreeMap<K extends Comparable<K>, V> extends RedBlackTree<K> {

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

	public void put(K key, V value) {
		Entry newEntry = new Entry(key, value);
		root = insert(root, newEntry);
		fixInsert(newEntry);
	}

	@Override
	@SuppressWarnings("unchecked")
	public RBNode insert(RBNode current, RBNode newNode) {
		if (current == null) {
			return newNode;
		}

		if (newNode.data.compareTo(current.data) < 0) {
			current.left = insert((RBNode) current.left, newNode);
			((RBNode) current.left).parent = current;
		} else if (newNode.data.compareTo(current.data) > 0) {
			current.right = insert((RBNode) current.right, newNode);
			((RBNode) current.right).parent = current;
		} else {
			Entry currentEntry = (Entry) current;
			Entry newEntry = (Entry) newNode;
			currentEntry.value = newEntry.value;
		}

		return current;
	}

	@SuppressWarnings("unchecked")
	public V get(K key) {
		RBNode node = searchNode(key, root);
		if (node == null) {
			return null;
		}
		Entry entry = (Entry) node;
		return entry.value;
	}

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

	public void remove(K key) {
		root = deleteNode(root, key);
	}

	@SuppressWarnings("unchecked")
	public RBNode deleteNode(RBNode node, K key) {
		if (node == null) {
			return null;
		}

		if (key.compareTo((K) node.data) < 0) {
			node.left = deleteNode((RBNode) node.left, key);
		} else if (key.compareTo((K) node.data) > 0) {
			node.right = deleteNode((RBNode) node.right, key);
		} else {
			if (node.left == null) {
				return (RBNode) node.right;
			} else if (node.right == null) {
				return (RBNode) node.left;
			}

			node.data = minValue(node.right);
			node.right = deleteNode((RBNode) node.right, node.data);
		}

		return node;
	}

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
