package implementacaoArrayListGenerics;

public class ListaComArray <T> implements Lista<T>{
	private T[] Array;
	boolean resizable;
	private int initialCapacity;
	private int counter = 0;
	private int resizeRate = 10;
	
	public ListaComArray() {		
		this(10, true);		
	}
	
	public ListaComArray(int initialSize) {
		this(initialSize, true);
	}
	
	@SuppressWarnings("unchecked")
	public ListaComArray(int initialSize, boolean resizable) {
		this.Array = (T[]) new Object[initialSize];
		this.resizable = resizable;
		this.initialCapacity = initialSize;
		this.counter = 0;				
	}	

	public void add(T value) {
		if(this.resizable) {
			if(getFullSizeArray() - this.counter < 10) {
				resizeArrayList();
			}			
		}else {
			if(counter == initialCapacity) {
				//throw new Exception("Limit reached, you can't add more elements, try initialize with resizable proprety");
				throw new ArrayIndexOutOfBoundsException("Limit reached, you can't add more elements, try initialize with resizable proprety");
			}
		} 
		this.Array[counter] = value;		
		counter++;
		
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {
		if(this.resizable) {
			T[] originalArr = (T[]) new Object[this.initialCapacity];
			this.Array = originalArr;
			this.counter = 0;
		}
		for(int i = 0; i < size(); i++) {
			this.Array[i] = null;
		}
	}
	
	public boolean isEmpty() {
		if(size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isFull() {
		if(!this.resizable) {
			if(getFullSizeArray().equals(size())) {
				return true;
			}	
		}
		return false;	
		
	}
	
	public void add(int index, T value){
		if(!this.resizable && isFull()) {			
			throw new ArrayIndexOutOfBoundsException("You can't add no more Elements in your array, because the array reached your max size");			
		}else if(index < 0 || index > size()) {
			throw new NullPointerException("This index is invalid in your Array");
		}else {
			for(int i = size(); i > index; i--) {
				this.Array[i] = this.Array[i - 1];				
			}
			this.set(index, value);
			counter++;
		}
		resizeArrayList();
		
		
	}
	
	public T remove(int index) {
		T originalValue = this.Array[index];		
		removeByIndex(index);		
		return originalValue;
	}
	
	public int size() {
		return this.counter;
	}
	
	public boolean removeFirst(T value) {
		for(int i = 0; i < size(); i++) {
			if(Array[i].equals(value)) {
				remove(i);
				return true;
			}
		}
		return false;
		
	}
	
	private void removeByIndex(Integer index) {
		for(int i = index; i < this.counter - 1; i++) {
			this.Array[i] = this.Array[i + 1];
		}
		this.counter--;
	}
	
	public T get(int index) {
		if(index < 0 || index > counter) {
			throw new NullPointerException("Invalid Index, use index that exists in your Array");
		}else {
			return this.Array[index];	
		}
		
	}

	public T set(int index, T value){
		if(index < 0 || index > counter) {
			throw new NullPointerException("Invalid index, use index that exists in your Array");
		}else {
			T oldValue = this.Array[index];
			this.Array[index] = value;
			return oldValue;	
		}		
	}

	public boolean contains(T value) {
		for(T val : this.Array) {
			if(val.equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public int indexOf(T element) {
		for(int i = 0; i < size(); i++) {
			if(this.Array[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(T element) {
		for(int i = size(); i >= 0; i--) {
			if(this.Array[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	public T[] toArray() {		
		T[] tempArray = (T[]) new Object[size()];
		for(int i = 0; i < size(); i++) {
			tempArray[i] = Array[i];
		}
		return tempArray;
	}
	

	public Integer getFullSizeArray() {
		return this.Array.length;
	}
	
	@SuppressWarnings("unchecked")
	public void resizeArrayList() {
		T[] tempArray = (T[]) new Object[getFullSizeArray() + this.resizeRate];
		
		for(int i = 0; i < getFullSizeArray(); i++) {
			tempArray[i] = this.Array[i];
		}
		this.Array = tempArray;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String text = "[ ";		
		
		for(int i = 0; i < size(); i++) {			
			text+= "{ " + Array[i] + " } ";
		}
		text += " ]";
		return text;
	}

	
}
