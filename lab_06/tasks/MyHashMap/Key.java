package lab_06.tasks.MyHashMap;

import java.util.Objects;

public class Key {

	private int key;

	public Key(int k) {
		key = k;
	}

	@Override
	public boolean equals(Object o) {
		if (this.key == 0)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Key key1 = (Key) o;
		return Objects.equals(this.key, key1.key);
	}

	@Override
	public int hashCode() {
		return Objects.hash(key);
	}

}