package lab_06;

import lab_06.tasks.MyHashMap.MyHashMap;
import lab_06.tasks.MyHashSet.MyHashSet;

import lab_06.tasks.MyHashMap.Value;
import lab_06.tasks.MyHashMap.Key;

/*
TODO List:
1. implement HashMap: 
2. implement HashSet: 
3. Change: put method: use add or set method based on a condition;
4. Change resize(grow) functionality: use rehashing when ArrayList was grown
 */
public class Main {

	public static void main(String[] args) {

		System.out.println("----HASH MAP----");
		MyHashMap myHashMap = new MyHashMap();

		myHashMap.put(new Key(1), new Value(100));
		myHashMap.put(new Key(2), new Value(200));
		myHashMap.put(new Key(3), new Value(300));

		System.out.println("Key 1: " + myHashMap.get(new Key(1)).getValue()); // 100
		System.out.println("Key 2: " + myHashMap.get(new Key(2)).getValue()); // 200
		System.out.println("Key 3: " + myHashMap.get(new Key(3)).getValue()); // 300

		myHashMap.put(new Key(2), new Value(250));
		System.out.println("Updated key 2: " + myHashMap.get(new Key(2)).getValue()); // 250

		myHashMap.remove(new Key(3));
		System.out.println("Key 3 after deleting: " + myHashMap.get(new Key(3))); // null

		System.out.println("----HASH SET----");
		MyHashSet set = new MyHashSet();
		set.add(new Value(10));
		set.add(new Value(20));
		set.add(new Value(30));
		System.out.println("Contains 20: " + set.contains(new Value(20))); // Ожидается: true
		set.remove(new Value(20));
		System.out.println("Contains 20 after deleting: " + set.contains(new Value(20))); // Ожидается: false
		System.out.println("Размер множества: " + set.size()); // Ожидается: 2
	}
}