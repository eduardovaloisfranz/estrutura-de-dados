package implementacaoPilha.implementacaoComEncadeamento;

import implementacaoPilha.Pilha;

public class PilhaLista<T> implements Pilha<T> {
	private NoLista topo;
	private int counter;
	

	@SuppressWarnings("unchecked")
	@Override
	public void push(T el) {	
		if(counter == 0) {
			this.topo = new NoLista<T>(el, null);
		}else {
			NoLista tmp = this.topo;
			this.topo = new NoLista<T>(el, tmp);			
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
			throw new NullPointerException("Your top is doenst have any info, because its null, try push more elements");
		}else {
			return (T) this.topo.getInfo();			
		}
	}
	
	public void showStack() {
		NoLista tmp = this.topo;
		while(tmp != null) {
			System.out.print("[ " + tmp.getInfo() + " ] ");
			tmp = tmp.getLast();
		}
	}
	public int size() {
		return this.counter;
	}

}
