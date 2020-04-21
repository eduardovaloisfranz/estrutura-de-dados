package implementacaoFilaListaArray;

import implementacaoFila.Fila;

public class FilaLista<T> implements Fila<T>{

	private int qtdElementos = 0;
	private int ini = 0;
	private int tam;
	private T[] vet;
	
	@SuppressWarnings("unchecked")
	public FilaLista(int tam) {		
		this.vet = (T[]) new Object[tam];
		this.tam = tam;
	}
	
	@Override
	public void Insere(T obj) {			
		if(!this.listaIsCheia() ) {			
			this.ini = 0;			
			this.vet[fim()] = obj;
			this.qtdElementos++;
		}else {
			throw new IndexOutOfBoundsException("A fila encontra-se cheia, remova elementos para continuar usando");
		}
	}
		
	private int fim() {		
		return (this.qtdElementos) % this.tam;
	
	}

	@Override
	public T Retira() {
		if(listaIsVazia()) {
			throw new NullPointerException("Lista está vazia, não pode retirar");
		}else {
			T elementoRetirado = this.vet[this.ini];		
			this.ini++;
			this.qtdElementos--;
			return elementoRetirado;			
		}
		//return null;
	
	}
	
	@Override
	public boolean listaIsVazia() {
		return (this.qtdElementos == 0) ? true : false;				
	}
		
	public boolean listaIsCheia() {	
		return (this.qtdElementos == tam) ? true : false;				
	}

	@SuppressWarnings("unchecked")
	@Override
	public void libera() {
		this.ini = 0;
		this.qtdElementos = 0;
		this.vet = (T[]) new Object[tam];
	}
	
	public void exibirFila() {
		
		for(int idx = this.ini; idx < tam; idx++) {				
			
			System.out.print("[ " + this.vet[idx] + " ] ");
		}
	}
}
