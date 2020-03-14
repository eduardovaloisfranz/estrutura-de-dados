package implementacaoListaComEncadeamento;

public class ListaComEncadeamento {
	private NoLista first;
	private NoLista last;
	private int counter;
	
	public ListaComEncadeamento() {
		this.counter = 0;
		this.first = null;
		this.last = null;
	}
	
	public void add(Integer info) {
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
	
	public void add(Integer info, int index) {
		int counter = 0;
		NoLista temp = first;
		while(temp.getNext() != null) {
			NoLista novo = new NoLista();		
			if(counter == index) {
				novo.setNext(temp);
			}
			
			counter++;
			temp = temp.getNext();
		}
	}
	
	public int size() {
		return this.counter;
	}
	
	public void exibirLista() {		
		NoLista temp = first;
		do {
			System.out.println("Atual: " + temp + " Proximo: " + temp.getNext());
			temp = temp.getNext();
			
		}while(temp.getNext() != null);
	}
	
	
}
