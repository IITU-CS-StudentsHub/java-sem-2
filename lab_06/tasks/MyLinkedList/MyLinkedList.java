package lab_06.tasks.MyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T>, Iterable<T> {
	private int size;
	private Node head;

	private class Node {
		T value;
		Node next;

		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	public MyLinkedList() {
		size = 0;
		head = null;
	}

	public int getSize() {
		return this.size;
	}

	public void push_back(T data) {
		size++;
		if (head == null) {
			head = new Node(data, null);
			return;
		}
		Node cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = new Node(data, null);
	}

	public void push_front(T data) {
		size++;
		if (head == null) {
			head = new Node(data, null);
			return;
		}
		Node temp = new Node(data, head);
		head = temp;
	}

	public void pop_back() {
		if (head == null)
			return;
		size--;
		if (head.next == null) {
			head = null;
			return;
		}

		Node cur = head;
		while (cur.next.next != null) {
			cur = cur.next;
		}
		cur.next = null;
	}

	public void pop_front() {
		if (head == null)
			return;
		head = head.next;
		size--;
	}

	@Override
	public void add(T data) {
		push_back(data);
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException("out of bounds");
		Node cur = head;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur.value;
	}

	@Override
	public void add(T data, int index) {
		if (index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException("Index out of bounds");
		if (index == 0) {
			push_front(data);
			return;
		}
		Node cur = head;
		for (int i = 0; i < index - 1; i++) {
			cur = cur.next;
		}
		cur.next = new Node(data, cur.next);
		size++;
	}

	@Override
	public void remove(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException("Index out of bounds");
		if (index == 0) {
			pop_front();
			return;
		}
		Node cur = head;
		for (int i = 0; i < index - 1; i++) {
			cur = cur.next;
		}
		cur.next = cur.next.next;
		size--;
	}

	@Override
	public void remove(T data) {
		if (head == null)
			return;

		if (head.value.equals(data)) {
			pop_front();
			return;
		}

		Node cur = head;
		while (cur.next != null) {
			if (cur.next.value.equals(data)) {
				cur.next = cur.next.next;
				size--;
				return;
			}
			cur = cur.next;
		}
	}

	// Реализация Iterable<T>
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node current = head;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public T next() {
				if (!hasNext())
					throw new NoSuchElementException();
				T data = current.value;
				current = current.next;
				return data;
			}
		};
	}
}