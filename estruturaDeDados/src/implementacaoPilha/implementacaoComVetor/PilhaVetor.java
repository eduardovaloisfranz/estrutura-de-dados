package implementacaoPilha.implementacaoComVetor;

import implementacaoPilha.Pilha;

public class PilhaVetor<T> implements Pilha<T> {
	private T[] listOfItems;
	private int tam;
	private int counter;
	private int idxTop = 0;
	
	public PilhaVetor() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public PilhaVetor(int tam) {
		this.tam = tam;
		this.listOfItems = (T[]) new Object[tam];		
	}
	
	@Override
	public void push(T el) {
		if(el == null) {
			throw new NullPointerException("You can provide null data for this list");
		}
		if(this.idxTop > tam) {
			throw new IndexOutOfBoundsException("You can't add more elements, need remove to add more");
		}
		this.listOfItems[idxTop] = el;
		this.idxTop++;
		this.counter++;
	}

	@Override
	public T pop() {
		T el = this.listOfItems[idxTop-1];
		this.listOfItems[idxTop-1] = null;
		this.idxTop--;	
		this.counter--;
		return el;		
	}

	@Override
	public boolean isEmpty() {		
		return counter == 0 ? true : false;
	}

	@Override
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
			for(T obj : this.listOfItems) {
				if(obj != null) {
					System.out.print("[ " + obj + " ] ");				
				}
			}
		}else {
			System.out.println("Empty Stack");
		}
	}
	 
}
