package implementacaoListaComEncadeamento;

public class ListaComEncadeamento{
	private NoLista first;
	private NoLista last;
	private int counter;
	
	public ListaComEncadeamento() {
		this.counter = 0;
		this.first = null;
		this.last = null;
	}
	
	public void add(Integer info) {
		if(info == null) {
			throw new NullPointerException("You cant give null info");
		}else {
			if(counter == 0) {
				this.first = new NoLista(info, null);
				this.last = first;
			}else {
				NoLista novo = new NoLista(info, null);
				this.last.setNext(novo);
				this.last = novo;
			}
			this.counter++;	
		}
		
	}
	
	public void add(Integer info, int index) {
		if(info == null) {
			throw new NullPointerException("You cant give null info");
		}
		if(index < 0 || index > counter) {
			throw new IndexOutOfBoundsException("The position is invalid");
		}
		
		int counter = 0;
		NoLista temp = first;	
			
		NoLista elementByIndexAsc = null;
		NoLista elementByIndex= null;
		while(temp != null) {				
			if(counter == index - 1) {
				elementByIndexAsc = temp;
			}			
			if(counter == index) {
				elementByIndex = temp;
			}
			counter++;
			temp = temp.getNext();
		}
		NoLista novo = new NoLista(info, elementByIndex);
		elementByIndexAsc.setNext(novo);
		this.counter++;
	}
	
	public Integer remove(int index) {
		if(index < 0 || index > counter) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		Integer oldValue = null;
		NoLista temp = first;
		NoLista previousElement = null;
		NoLista nextElement = null; 
		int counter = 0;
		while(temp != null) {				
			if(counter == index - 1) {
				previousElement = temp;
			}
			if(counter == index + 1) {
				nextElement = temp;
			}			
			counter++;
			temp = temp.getNext();
		}
		oldValue = previousElement.getNext().getInfo();
		previousElement.setNext(nextElement);
		this.counter--;		   
		
		return oldValue;
	}
	
	public boolean removeFirst(Integer info) {
		boolean infoExists = false;
		if(info == null) {
			throw new NullPointerException("You cant give null info");
		}
		NoLista temp = first;
		int counter = 0;
		while(temp != null) {
			if(info.equals(temp.getInfo())) {
				remove(counter);
				infoExists = true;
			}
			counter++;
			temp = temp.getNext();
		}	
		return infoExists;	
		
	}
	
	public Integer get(int index) {
		if(index < 0 || index > counter) {
			throw new IndexOutOfBoundsException("Invalid index");
		}		
		Integer info = null;
		NoLista temp = first;
		int counter = 0;
		while(temp != null) {
			if(index == counter) {
				info = temp.getInfo();
			}
			
			counter++;
			temp = temp.getNext();
		}	
		return info;
	}
	
	public Integer set(int index, Integer info) {
		if(index < 0 || index > counter) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}
		if(info == null) {
			throw new NullPointerException("You cant give null info");
		}
		Integer oldInfo = null;
		NoLista temp = first;
		int counter = 0;
		while(temp != null) {
			if(index == counter) {
				oldInfo = temp.getInfo();
				temp.setInfo(info);
			}			
			counter++;
			temp = temp.getNext();			
		}		
		return oldInfo;
	}
	
	public boolean isEmpty() {
		if(counter == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean contains(Integer info) {
		if(info == null) {
			throw new NullPointerException("You cant give null info");
		}
		NoLista temp = first;
		while(temp != null) {
			if(temp.getInfo().equals(info)) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}
	
	public int indexOf(Integer info) {
		if(info == null) {
			throw new NullPointerException("You cant give null info");			
		}
		NoLista temp = first;
		int counter = 0;
		while(temp != null) {
			if(temp.getInfo().equals(info)) {
				return counter;
			}
			counter++;
			temp = temp.getNext();
		}
	
		return -1;
	}
	
	private NoLista getNoListaByIndex (int index) {
		if(index < 0 || index > counter) {
			throw new IndexOutOfBoundsException("Invalid index");
		}		
		NoLista noLista = null;
		NoLista temp = first;
		int counter = 0;
		while(temp != null) {
			if(index == counter) {
				noLista = temp;
			}
			
			counter++;
			temp = temp.getNext();
		}	
		return noLista;
	}
	
	public int lastIndexOf(Integer info) {
		if(info == null) {
			throw new NullPointerException("You cant give null info");			
		}
		if(indexOf(info) == -1) {
			return -1;
		}
		int firstIndex = indexOf(info);
		int lastIndex = 0;		
		NoLista temp = getNoListaByIndex(firstIndex);
		while(temp != null) {
			if(temp.getInfo().equals(info)) {
				lastIndex = firstIndex;
			}
			firstIndex++;
			temp = temp.getNext();			
		}
		if(lastIndex == 0) {
			return -1;	
		}else {
			return lastIndex;
		}
		
		
	}
	
	public Integer[] toArray() {
		Integer[] arr = new Integer[counter];
		NoLista temp = first;
		int counter = 0;
		while(temp != null){
			arr[counter] = temp.getInfo();
			
			counter++;
			temp = temp.getNext();			
		}
		return arr;
	}
	
	
	public int size() {
		return this.counter;
	}
	
	@Override
	public String toString() {		
		String info = " [ ";
		NoLista temp = first;
		do {
			//System.out.println("Atual: " + temp + " Proximo: " + temp.getNext());
			info += "{ Atual: " + temp + " Proximo: " + temp.getNext() + " }";
			temp = temp.getNext();
			
		}while(temp != null);
		
		return info += " ]";
	}
	
	
}
