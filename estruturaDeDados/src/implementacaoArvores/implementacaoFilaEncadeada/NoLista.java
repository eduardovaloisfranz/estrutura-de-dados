package implementacaoArvores.implementacaoFilaEncadeada;

public class NoLista<T> {
	private T info;
	private T next;
	
	public NoLista() {
		this(null);
	}	
	public NoLista(T info) {
		this.info = info;
		this.next = null;
	}
	
	public T getInfo() {
		 return this.info;
	 }
	 
	 public void setInfo(T info) {
		 this.info = info;
	 }
	 
	 public T getNext() {
		 return this.next;
	 }
	 
	 public void setNext(T obj) {
		 this.next = obj;
	 }
	 
	 
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.info.toString();
	}
		
	
}
