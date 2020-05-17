package implementacaoTorreHanoi;

import implementacaoPilha.Pilha;

public class PilhaVetor<T> implements Pilha<T> {
	private T[] listOfItems;
	private int tam;
	private int counter;
	private int idxTop = 0;
	
	public PilhaVetor() {
		this(10);
	}
	
	public int getTam() {
		return this.tam;
	}
	
	public PilhaVetor(int tam) {
		this.tam = tam;
		this.listOfItems =  (T[]) new Object[tam];		
	}		
	
	public void push() {		
		//T obj = new T();
		ObjetoTorre objT = new ObjetoTorre((this.tam + 6) - this.counter);
		T obj = (T) objT;
		if(this.idxTop > tam) {
			throw new IndexOutOfBoundsException("You can't add more elements, need remove to add more");
		}		
		this.listOfItems[idxTop] = obj;
		this.idxTop++;
		this.counter++;
	}
	
	@Override
	public void push(T obj) {		
		if(obj == null) {
			throw new NullPointerException("You cant give null object");
		}
		if(!(obj instanceof ObjetoTorre)) {
			throw new ClassCastException("You cant give object that is not represent a tower");
		}
		
		if(elementIsBiggerThanActualElement(obj)) {
			this.listOfItems[idxTop] = obj;
			this.idxTop++;
			this.counter++;				
		}
			
	}
	public boolean elementIsBiggerThanActualElement(T obj) {
		if(counter > 0) {
			if(((ObjetoTorre) obj).getLengthOfInfo() > ((ObjetoTorre) this.listOfItems[this.idxTop - 1]).getLengthOfInfo()) {				
				return false;
			}else {
				return true;
			}
		}
		return true;
		
	}
	@Override
	public T pop() {
		ObjetoTorre el = null;
		if(idxTop >= 1) {
			el = (ObjetoTorre) this.listOfItems[idxTop-1];			
			this.listOfItems[idxTop-1] = null;
			this.idxTop--;	
			this.counter--;
		}else {
			System.out.println("This tower is empty you can remove more elements");
			//throw new IndexOutBoundsException("")
		}
		return (T) el;		
	}
	
	public boolean isEmpty() {		
		return counter == 0 ? true : false;
	}
	
	public boolean isFull() {
		return counter == tam ? true : false;
	}

	public void clear() {
		this.counter = 0;
		this.idxTop = 0;
		this.listOfItems = null;		
	}

	@Override
	public T top() {		
		return this.listOfItems[this.idxTop - 1];
	}
	
	public void showStack() {
		if(!this.isEmpty()) {
			for(int i = counter - 1; i >= 0; i--) {				
				System.out.println(this.listOfItems[i]);
			}
		}else {
			System.out.println("Empty");
		}
	}


}
