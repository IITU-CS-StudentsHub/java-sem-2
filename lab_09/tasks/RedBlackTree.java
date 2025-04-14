package lab_09.tasks;

import lab_07.tasks.BST;

public class RedBlackTree<T extends Comparable<T>> extends BST<T> {

	protected final boolean RED = true;
	protected final boolean BLACK = false;

	public class RBNode extends Node {
		boolean color;
		RBNode parent;

		public RBNode(T data) {
			super(data);
			color = RED; // по умолчанию новые узлы — красные
		}

		@Override
		public String toString() {
			return (color == RED ? "R" : "B") + data;
		}
	}

	public RBNode root;

	public RedBlackTree() {
		root = null;
	}

	@Override
	public void add(T data) {
		RBNode newNode = new RBNode(data);
		root = insert(root, newNode);
		fixInsert(newNode);
	}

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
		}

		return current;
	}

	protected void fixInsert(RBNode node) {
		while (node != root && ((RBNode) node.parent).color == RED) {
			RBNode parent = (RBNode) node.parent;
			RBNode grandparent = (RBNode) parent.parent;

			if (parent == grandparent.left) {
				RBNode uncle = (RBNode) grandparent.right;

				if (uncle != null && uncle.color == RED) {
					// case 1: uncle is red -> recolor
					parent.color = BLACK;
					uncle.color = BLACK;
					grandparent.color = RED;
					node = grandparent;
				} else {
					if (node == parent.right) {
						// case 2: node is right child -> rotate left
						node = parent;
						rotateLeft(node);
					}
					// case 3: node is left child -> rotate right
					parent.color = BLACK;
					grandparent.color = RED;
					rotateRight(grandparent);
				}
			} else {
				// mirror of above
				RBNode uncle = (RBNode) grandparent.left;

				if (uncle != null && uncle.color == RED) {
					parent.color = BLACK;
					uncle.color = BLACK;
					grandparent.color = RED;
					node = grandparent;
				} else {
					if (node == parent.left) {
						node = parent;
						rotateRight(node);
					}
					parent.color = BLACK;
					grandparent.color = RED;
					rotateLeft(grandparent);
				}
			}
		}

		root.color = BLACK;
	}

	private void rotateLeft(RBNode node) {
		RBNode r = (RBNode) node.right;
		node.right = r.left;
		if (r.left != null)
			((RBNode) r.left).parent = node;
		r.parent = node.parent;

		if (node.parent == null) {
			root = r;
		} else if (node == ((RBNode) node.parent).left) {
			((RBNode) node.parent).left = r;
		} else {
			((RBNode) node.parent).right = r;
		}

		r.left = node;
		node.parent = r;
	}

	private void rotateRight(RBNode node) {
		RBNode l = (RBNode) node.left;
		node.left = l.right;
		if (l.right != null)
			((RBNode) l.right).parent = node;
		l.parent = node.parent;

		if (node.parent == null) {
			root = l;
		} else if (node == ((RBNode) node.parent).right) {
			((RBNode) node.parent).right = l;
		} else {
			((RBNode) node.parent).left = l;
		}

		l.right = node;
		node.parent = l;
	}

	// Переопределим inorder для вывода с цветом
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		inorder(root, sb);
		return sb.toString();
	}

	private void inorder(Node node, StringBuilder sb) {
		if (node == null)
			return;
		inorder(node.left, sb);
		sb.append(node.toString()).append(" ");
		inorder(node.right, sb);
	}
}