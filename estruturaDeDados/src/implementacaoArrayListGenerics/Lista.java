package implementacaoArrayListGenerics;

public interface Lista < T > {
	void add(T value);
	void add(int index, T value);
	void resizeArrayList();
	T remove(int index);
	boolean removeFirst(T value);
	T get(int index);
	void clear();
	T set(int index, T value);
	int size();
	boolean isEmpty();
	boolean isFull();
	boolean contains(T value);
	int indexOf(T value);
	int lastIndexOf(T value);
	T[] toArray();
	
}
