package implementacaoArrayList;

public class ListaComArray {
	private Integer[] Array;
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
	
	public ListaComArray(int initialSize, boolean resizable) {
		this.Array = new Integer[initialSize];
		this.resizable = resizable;
		this.initialCapacity = initialSize;
		this.counter = 0;				
	}	

	public void add(Integer value) {
		if(getFullSizeArray() - this.counter < 10) {
			resizeArrayList();
		}
		this.Array[counter] = value;		
		counter++;
	}
	
	public Integer remove(Integer index) {
		Integer originalValue = this.Array[index];		
		removeByIndex(index);		
		return originalValue;
	}
	
	public Integer size() {
		return this.counter;
	}
	
	public boolean removeFirst(Integer value) {
		for(int i = 0; i < size(); i++) {
			if(Array[i].equals(value)) {
				remove(i);
				return true;
			}
		}
		return false;
		
	}
	
	public void removeByIndex(Integer index) {
		for(int i = index; i < this.counter - 1; i++) {
			this.Array[i] = this.Array[i + 1];
		}
		this.counter--;
	}
	
	public Integer getFullSizeArray() {
		return this.Array.length;
	}
	
	public void resizeArrayList() {
		Integer[] tempArray = new Integer[getFullSizeArray() + this.resizeRate];
		
		for(int i = 0; i < getFullSizeArray(); i++) {
			tempArray[i] = this.Array[i];
		}
		this.Array = tempArray;
	}
	
	
	
	
	
	
	

}
