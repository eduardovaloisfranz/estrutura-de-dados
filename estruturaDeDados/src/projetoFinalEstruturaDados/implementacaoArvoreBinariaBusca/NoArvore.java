package projetoFinalEstruturaDados.implementacaoArvoreBinariaBusca;

public class NoArvore<T> {
	private T info;
	private NoArvore<?> filhoEsquerda;
	private NoArvore<?> filhoDireita;
	
	public NoArvore(T info) {		
		this.info = info;
		this.filhoEsquerda = null;
		this.filhoDireita = null;
	}
	
	public NoArvore(T info, NoArvore<?> filhoEsquerda, NoArvore<?> filhoDireita) {
		this.info = info;
		this.filhoEsquerda = filhoEsquerda;
		this.filhoDireita = filhoDireita;
	}
	
	public NoArvore<?> getFilhoEsquerda() {
		return this.filhoEsquerda;
	}
	
	public void setFilhoEsquerda(T info) {
		NoArvore<T> no = new NoArvore<T>(info, null, null);
		this.filhoEsquerda = no;
	}
	
	public void setFilhoDireita(T info) {
		this.filhoDireita = new NoArvore<T>(info, null, null);
	}
	public void setInfo(T info) {
		this.info = info;
	}
	
	
	public NoArvore<?> getFilhoDireita(){
		return this.filhoDireita;
	}
	
	public T getInfo() {
		return this.info;
	}
	


}
