package implementacaoListaComEncadeamento;

public class NoLista {
	
	private Integer info;
	private NoLista next;
	
	public NoLista() {
		this(null, null);		
	}
	public NoLista(Integer info, NoLista next) {		
		this.info = info;
		this.next = next;
	}
	
	public Integer getInfo() {
		return this.info;
	}
	public void setInfo(Integer info) {
		this.info = info;
	}
	public NoLista getNext() {
		return this.next;
	}
	
	public void setNext(NoLista next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Info: " + this.info;
	}
	
}
