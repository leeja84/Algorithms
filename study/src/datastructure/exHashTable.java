package datastructure;

import java.util.LinkedList;

public class exHashTable {
	public static void main(String[] args) {
		HashTable exHashTable = new HashTable(4);
		exHashTable.put("lee", "123");
		exHashTable.put("kim", "fda");
		exHashTable.put("jung", "zxcv");
		exHashTable.put("ju", "zxcxxx");
		
		System.out.println(exHashTable.get("lee"));
		System.out.println(exHashTable.get("kim"));
		System.out.println(exHashTable.get("jung"));
		System.out.println(exHashTable.get("jug"));
		
		
	}
	
	
}

class HashTable {
	class Node {
		String key;
		String value;

		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	LinkedList<Node>[] data;

	HashTable(int size) {
		this.data = new LinkedList[size];
	}

	// 단순히 문자열을 더해서 해쉬코드를 만든다.
	int getHashCode(String key) {
		int hashCode = 0;
		for (char c : key.toCharArray()) {
			hashCode += c;
		}
		return hashCode;
	}

	// 해쉬코드를 배열방의 크기로 나머지 연산으로 인덱스를 만든다.
	int convertToIndex(int hashCode) {
		return hashCode % data.length;
	}

	// 노드의 키값과 같은 노드를 검색해서 찾아서 넘겨준다.
	Node searchKey(LinkedList<Node> list, String key) {
		if (list == null)
			return null;

		for (Node node : list) {
			if (node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}

	public void put(String key, String value) {
		int hashCode = getHashCode(key);
		int index = convertToIndex(hashCode);

		System.out.println(key + " hash : " + hashCode + " index : " + index);
		LinkedList<Node> list = data[index];

		// 아무것도 없으면 새로 생성해서 넣어준다.
		if (list == null) {
			list = new LinkedList<Node>();
			data[index] = list;
		}

		Node node = searchKey(list, key);
		if (node == null) {
			list.addLast(new Node(key, value));
		} else {
			node.setValue(value);
		}
	}

	public String get(String key) {
		int hashCode = getHashCode(key);
		int index = convertToIndex(hashCode);

		LinkedList<Node> list = data[index];

		Node node = searchKey(list, key);

		return node == null ? "not found" : node.getValue();

	}

}
