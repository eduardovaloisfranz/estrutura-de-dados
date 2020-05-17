package implementacaoTorreHanoi.Pilha.PilhaComEncadeamento;

import implementacaoTorreHanoi.Pilha.ObjetoTorre;
import implementacaoTorreHanoi.Pilha.Pilha;

public class PilhaLista<T> implements Pilha<T> {
	private NoLista topo;
	private int counter;
	private int tam;
	public PilhaLista(int tam){
		this.tam = tam;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void push(T el) {	
		if(counter == 0) {
			this.topo = new NoLista<T>(el, null);
			this.counter++;
		}else {
			if(elementIsBiggerThanActualElement(el)) {
				NoLista tmp = this.topo;
				this.topo = new NoLista<T>(el, tmp);	
				this.counter++;
			}
		}
		//this.counter++;
	}
	//aviso: se nao fosse generico, nao teria tantos problemas, apenas o ObjetoTorre ja resolveria
	@Override
	public void push() {
		ObjetoTorre el = new ObjetoTorre((this.tam + 6) - this.counter);
		if(counter == 0) {
			this.topo = new NoLista<T>((T) el, null);
		}else {
			NoLista tmp = this.topo;
			this.topo = new NoLista<T>((T) el, tmp);			
		}
		this.counter++;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		if(this.counter == 0) {
			throw new IndexOutOfBoundsException("You cant remove more elements because your stack is empty");
		}else {
			NoLista tmp = this.topo;				
			this.topo = this.topo.getLast();			
			this.counter--;
			return (T) tmp.getInfo();
		}
		
	}

	@Override
	public boolean isEmpty() {
		return this.counter == 0 ? true : false;
	}

	@Override
	public void clear() {
		this.counter = 0;
		this.topo = null;		
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		if(this.topo == null) {
			//throw new NullPointerException("Your top is doenst have any info, because its null, try push more elements");
		}else {
		}
		return (T) this.topo.getInfo();			
	}
	
	@Override
	public void showStack() {
		NoLista tmp = this.topo;
		while(tmp != null) {
			System.out.println(tmp.getInfo());
			tmp = tmp.getLast();
		}
		if(counter == 0) {
			System.out.println("Empty Stack");
		}
	}

	@Override
	public boolean elementIsBiggerThanActualElement(T obj) {
		NoLista tmp = this.topo;
		if(counter > 0) {
			if(((ObjetoTorre) obj).getLengthOfInfo() > ((ObjetoTorre) this.topo.getInfo()).getLengthOfInfo()) {
				return false;
			}else {
				return true;
			}			
		}
		return true;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return this.tam == this.counter ? true : false;
	}

	@Override
	public int getTam() {
		// TODO Auto-generated method stub
		return this.tam;
	}

	

}
