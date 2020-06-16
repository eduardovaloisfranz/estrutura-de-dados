package implementacaoFilaEncadeada;

import implementacaoFila.Fila;

public class FilaListaEncadeada <T> implements Fila<T>{
	private NoLista first;
	private NoLista last;	
	private int counter = 0;
	
	public FilaListaEncadeada() {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void Insere(T obj) {
		NoLista<T> el = new NoLista<T>(obj);
		if(counter == 0) {
			this.first = el;
			this.last = first;
		}else {
			this.last.setNext(el);
			this.last = el;
			
		}
		this.counter++;
	}
	
	public T peek() {
		return (T) first.getInfo();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T Retira() {
		NoLista<T> el = this.first;
		T elRemoved = el.getInfo();
		
		this.first = (NoLista<?>) this.first.getNext();
		
		return elRemoved;
	}

	@Override
	public boolean listaIsVazia() {
		return counter == 0 ? true : false;
	}

	@Override
	public void libera() {
		this.counter = 0;
		this.first = null;
		this.last = null;		
	}


	@SuppressWarnings("unchecked")
	public void exibirLista() {
		NoLista<T> temp = this.first;
		do {
			//System.out.println("Atual: [ " + temp.getInfo() + " ] Apontado para o próximo -> { " + ((NoLista) temp.getNext()).getInfo() + " }");
			System.out.print("[ " + temp.getInfo() + " ] ");
			temp = (NoLista<T>) temp.getNext();
			
		}while(temp != null);
			
	}
}
