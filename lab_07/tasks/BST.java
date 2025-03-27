package lab_07.tasks;

public class BST<T extends Comparable<T>> {

	private class Node {
		T data;
		Node left, right;

		public Node(T data) {
			this.data = data;
			left = right = null;
		}
	}

	private Node root;

	public BST() {
		root = null;
	}

	private Node insert(T data, Node node) {
		if (node == null) {
			return new Node(data);
		}

		if (data.compareTo(node.data) < 0) {
			node.left = insert(data, node.left);
		} else if (data.compareTo(node.data) > 0) {
			node.right = insert(data, node.right);
		}

		return node;
	}

	public void add(T data) {
		root = insert(data, root);
	}

	private boolean search(T data, Node node) {
		if (node == null) {
			return false;
		}

		if (data.equals(node.data)) {
			return true;
		}

		return data.compareTo(node.data) < 0 ? search(data, node.left) : search(data, node.right);
	}

	public boolean contains(T data) {
		return search(data, root);
	}

	private Node deleteNode(Node node, T data) {
		if (node == null) {
			return null;
		}

		if (data.compareTo(node.data) < 0) {
			node.left = deleteNode(node.left, data);
		} else if (data.compareTo(node.data) > 0) {
			node.right = deleteNode(node.right, data);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}

			node.data = minValue(node.right);
			node.right = deleteNode(node.right, node.data);
		}

		return node;
	}

	private T minValue(Node node) {
		T min = node.data;
		while (node.left != null) {
			min = node.left.data;
			node = node.left;
		}

		return min;
	}

	public void delete(T data) {
		root = deleteNode(root, data);
	}

	@Override
	public String toString() {
		inorder();
		return "";
	}

	public void inorder() {
		inorder(root);
		System.out.println();
	}

	// LNR
	private void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	// NLR
	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	public void postorder() {
		postorder(root);
		System.out.println();
	}

	// LRN
	private void postorder(Node node) {
		if (node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}
}
