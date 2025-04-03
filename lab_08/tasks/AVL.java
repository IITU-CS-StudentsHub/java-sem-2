package lab_08.tasks;

import lab_07.tasks.BST;

public class AVL<T extends Comparable<T>> extends BST<T> {
	private class Node extends BST<T>.Node {
		int height;

		public Node(T data) {
			super(data);
			this.height = 1;
		}
	}

	private int height(Node node) {
		return node == null ? 0 : node.height;
	}

	private int getBalanceFactor(Node node) {
		return node == null ? 0 : height((Node) node.left) - height((Node) node.right);
	}

	private Node leftRotation(Node node) {
		Node y = (Node) node.right;
		node.right = y.left;
		y.left = node;
		node.height = 1 + Math.max(height((Node) node.left), height((Node) node.right));
		y.height = 1 + Math.max(height((Node) y.left), height((Node) y.right));
		return y;
	}

	private Node rightRotation(Node node) {
		Node y = (Node) node.left;
		node.left = y.right;
		y.right = node;
		node.height = 1 + Math.max(height((Node) node.left), height((Node) node.right));
		y.height = 1 + Math.max(height((Node) y.left), height((Node) y.right));
		return y;
	}

	@Override
	public BST<T>.Node insert(T data, BST<T>.Node node) {
		if (node == null) {
			return new Node(data);
		}

		if (data.compareTo(node.data) < 0) {
			node.left = insert(data, node.left);
		} else if (data.compareTo(node.data) > 0) {
			node.right = insert(data, node.right);
		} else {
			return node;
		}

		((Node) node).height = 1 + Math.max(height((Node) node.left), height((Node) node.right));
		return balance((Node) node);
	}

	public Node balance(Node node) {
		int bf = getBalanceFactor(node);
		if (bf > 1) {
			if (getBalanceFactor((Node) node.left) < 0)
				node.left = leftRotation((Node) node.left);
			return rightRotation(node);
		}
		if (bf < -1) {
			if (getBalanceFactor((Node) node.right) > 0)
				node.right = rightRotation((Node) node.right);
			return leftRotation(node);
		}
		return node;
	}

	@Override
	public BST<T>.Node deleteNode(BST<T>.Node node, T data) {
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

		((Node) node).height = 1 + Math.max(height((Node) node.left), height((Node) node.right));
		return balance((Node) node);
	}
}
