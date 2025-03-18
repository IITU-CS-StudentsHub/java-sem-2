package lab_06.tasks.MyHashMap;

import java.util.LinkedList;
import lab_06.tasks.MyHashMap.Entry;
import lab_06.tasks.MyHashMap.Value;
import lab_06.tasks.MyHashMap.Key;
import lab_06.tasks.MyLinkedList.MyLinkedList;

public class MyHashMap {
	@SuppressWarnings("unchecked")
	MyLinkedList<Entry>[] hashMap = new MyLinkedList[2];
	int size = 0;

	public MyHashMap() {
	}

	public void put(Key key, Value value) {
		if (size >= hashMap.length) {
			resize();
		}

		int ix = getIndex(key) % hashMap.length;

		if (hashMap[ix] == null) {
			hashMap[ix] = new MyLinkedList<>();
			hashMap[ix].add(new Entry(key, value));
			size++;
			return;
		} else {
			for (Entry entry : hashMap[ix]) {
				if (entry.key.equals(key)) {
					entry.value = value;
					size++;
					return;
				}
			}

			hashMap[ix].add(new Entry(key, value));
			size++;
			return;
		}
	}

	public Value get(Key key) {
		int ix = getIndex(key) % hashMap.length;

		if (hashMap[ix] == null)
			return null;

		for (Entry entry : hashMap[ix]) {
			if (entry.key.equals(key)) {
				return entry.value;
			}
		}

		return null;
	}

	public void remove(Key key) {
		if (key == null)
			return;

		int ix = getIndex(key) % hashMap.length;

		if (hashMap[ix] == null)
			return;

		Entry toRemove = null;

		for (Entry entry : hashMap[ix]) {
			if (entry.key.equals(key)) {
				toRemove = entry;
				break;
			}
		}

		if (toRemove == null)
			return;

		hashMap[ix].remove(toRemove);
		size--;
	}

	public boolean containsKey(Key key) {
		if (key == null)
			return false;

		int ix = getIndex(key) % hashMap.length;

		if (hashMap[ix] == null)
			return false;

		for (Entry entry : hashMap[ix]) {
			if (entry.key.equals(key)) {
				return true;
			}
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	public void resize() {
		MyLinkedList<Entry>[] oldHashMap = hashMap;
		hashMap = new MyLinkedList[oldHashMap.length * 2];
		size = 0;

		for (int i = 0; i < oldHashMap.length; i++) {
			if (oldHashMap[i] == null)
				continue;
			for (Entry entry : oldHashMap[i]) {
				put(entry.key, entry.value);
			}
		}
	}

	public int getIndex(Key key) {
		return key.hashCode();
	}

	public int size() {
		return size;
	}
}