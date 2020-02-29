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

	public void add(Integer value) throws Throwable {
		if(this.resizable) {
			if(getFullSizeArray() - this.counter < 10) {
				resizeArrayList();
			}			
		}else {
			if(counter == initialCapacity) {
				throw new Exception("Limit reached, you can't add more elements, try initialize with resizable proprety");
			}
		} 
		this.Array[counter] = value;		
		counter++;
		
	}
	
	public void clear() {
		if(this.resizable) {
			Integer[] originalArr = new Integer[this.initialCapacity];
			this.Array = originalArr;
			this.counter = 0;
		}
		for(int i = 0; i < size(); i++) {
			this.Array[i] = null;
		}
	}
	
	public boolean isEmpty() {
		if(size().equals(0)) {
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
	
	public void add(int index, Integer value) throws Exception{
		if(!this.resizable && isFull()) {			
			throw new Exception("You can't add no more Elements in your array, because the array reached your max size");			
		}else if(index < 0 || index > size()) {
			throw new Exception("This index is invalid in your Array");
		}else {
			for(int i = size(); i > index; i--) {
				this.Array[i] = this.Array[i - 1];				
			}
			this.set(index, value);
			counter++;
		}
		resizeArrayList();
		
		
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
	
	private void removeByIndex(Integer index) {
		for(int i = index; i < this.counter - 1; i++) {
			this.Array[i] = this.Array[i + 1];
		}
		this.counter--;
	}
	
	public Integer get(int index) throws Exception {
		if(index < 0 || index > counter) {
			throw new Exception("Invalid Index, use index that exists in your Array");
		}else {
			return this.Array[index];	
		}
		
	}

	public Integer set(int index, Integer value) throws Exception{
		if(index < 0 || index > counter) {
			throw new Exception("Invalid index, use index that exists in your Array");
		}else {
			Integer oldValue = this.Array[index];
			this.Array[index] = value;
			return oldValue;	
		}		
	}

	public boolean contains(Integer value) {
		for(Integer val : this.Array) {
			if(val.equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public int indexOf(Integer element) {
		for(int i = 0; i < size(); i++) {
			if(this.Array[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(Integer element) {
		for(int i = size(); i >= 0; i--) {
			if(this.Array[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	
	public Integer[] toArray() {
		Integer[] tempArray = new Integer[size()];
		for(int i = 0; i < size(); i++) {
			tempArray[i] = Array[i];
		}
		return tempArray;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String text = "[ ";		
		
		for(int i = 0; i < getFullSizeArray(); i++) {			
			text+= "{ " + Array[i] + " } ";
		}
		text += " ]";
		return text;
	}
}
