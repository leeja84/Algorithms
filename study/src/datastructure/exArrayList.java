package datastructure;

public class exArrayList {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
//		al.add(5);
		
		System.out.println(al.get(0));
		System.out.println(al.get(1));
		System.out.println(al.get(2));
		al.remove(3);
		System.out.println(al.get(3));
		
		
		al.remove(4);
		System.out.println(al.get(4));
	}
}

class ArrayList {
	Object[] data;
	int size;
	int index;

	public ArrayList() {
		// TODO Auto-generated constructor stub
		size = 1;
		index = 0;
		data = new Object[this.size];
	}

	private void doubling() {
		this.size = this.size * 2;
		Object[] newData = new Object[this.size];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		this.data = newData;
	}

	public Object get(int index) {
		return data[index];
	}

	public void add(Object obj) {
		if (this.index == size - 1) {
			doubling();
		}

		data[this.index] = obj;
		this.index++;
	}

	public void remove(int i) {
		for (int x = i; x < data.length - 1; x++) {
			data[x] = data[x + 1];
		}
		this.index--;
	}
}
