package lab_06.tasks.MyHashSet;

import lab_06.tasks.MyHashMap.Value;
import lab_06.tasks.MyLinkedList.MyLinkedList;

public class MyHashSet {
	@SuppressWarnings("unchecked")
	MyLinkedList<Value>[] hashSet = new MyLinkedList[2];
	int size = 0;

	public MyHashSet() {
	}

	public boolean add(Value element) {
		if (size >= hashSet.length) {
			resize();
		}
		int ix = getIndex(element) % hashSet.length;
		if (hashSet[ix] == null) {
			hashSet[ix] = new MyLinkedList<>();
			hashSet[ix].add(element);
			size++;
			return true;
		} else {
			for (Value e : hashSet[ix]) {
				if ((e == null && element == null) || (e != null && e.equals(element))) {
					return false;
				}
			}
			hashSet[ix].add(element);
			size++;
			return true;
		}
	}

	public boolean contains(Value element) {
		int ix = getIndex(element) % hashSet.length;

		if (hashSet[ix] == null)
			return false;

		for (Value e : hashSet[ix]) {
			if ((e == null && element == null) || (e != null && e.equals(element))) {
				return true;
			}
		}

		return false;
	}

	public boolean remove(Value element) {
		if (element == null)
			return false;

		int ix = getIndex(element) % hashSet.length;
		if (hashSet[ix] == null)
			return false;

		Value toRemove = null;
		for (Value e : hashSet[ix]) {
			if ((e == null && element == null) || (e != null && e.equals(element))) {
				toRemove = e;
				break;
			}
		}
		if (toRemove == null)
			return false;

		hashSet[ix].remove(toRemove);
		size--;
		return true;
	}

	@SuppressWarnings("unchecked")
	public void resize() {
		MyLinkedList<Value>[] oldHashSet = hashSet;
		hashSet = new MyLinkedList[oldHashSet.length * 2];
		int oldSize = size;
		size = 0;
		for (int i = 0; i < oldHashSet.length; i++) {
			if (oldHashSet[i] == null)
				continue;
			for (Value element : oldHashSet[i]) {
				add(element);
			}
		}
	}

	public int getIndex(Value element) {
		return element.hashCode();
	}

	public int size() {
		return size;
	}
}