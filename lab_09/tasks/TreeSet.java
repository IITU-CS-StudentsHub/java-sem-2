package lab_09.tasks;

public class TreeSet<E extends Comparable<E>> extends TreeMap<E, Object> {

	private static final Object PRESENT = new Object();

	public TreeSet() {
		super();
	}

	public void add(E element) {
		if (!contains(element)) {
			put(element, PRESENT);
		}
	}

	public boolean contains(E element) {
		return get(element) != null;
	}

	public void remove(E element) {
		if (contains(element)) {
			super.remove(element);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		inorder(root, sb);
		return sb.toString().trim();
	}

	private void inorder(RBNode node, StringBuilder sb) {
		if (node == null)
			return;
		inorder((RBNode) node.left, sb);
		sb.append(node.toString().replace("=" + PRESENT, "")).append(" ");
		inorder((RBNode) node.right, sb);
	}
}
