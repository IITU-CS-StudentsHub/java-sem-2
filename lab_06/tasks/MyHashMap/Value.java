package lab_06.tasks.MyHashMap;

public class Value {
	private final int value;

	public Value(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Value value1 = (Value) obj;
		return value == value1.value;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}