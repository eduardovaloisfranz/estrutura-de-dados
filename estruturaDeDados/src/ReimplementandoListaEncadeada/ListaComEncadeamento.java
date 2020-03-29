package ReimplementandoListaEncadeada;

import implementacaoListaComEncadeamento.NoLista;

public class ListaComEncadeamento {
	private NoLista first;
	private NoLista last;
	private int counter;
	
	public ListaComEncadeamento() {
		this.first = null;
		this.last = null;
		this.counter = 0;
	}
	
	public void add(Integer info) {
		NoLista no = new NoLista(info, null);
		if(counter == 0) {			
			this.first = no;
			this.last = no;				
		}else {
			this.last.setNext(no);
			this.last = no;			
		}		
		counter++;
	}
	
	public void add(Integer info, int index) {
		NoLista temp = first;
		NoLista newElToAdd = new NoLista(info, null);
		NoLista previousEl = null;
		NoLista afterEl = null;
		int counter = 0;
		do {
			if(counter == index - 1) {
				previousEl = temp;
			}
			if(counter == index) {
				afterEl = temp;
			}
			temp = temp.getNext();
			counter++;
		}while(temp != null);
		//NoLista novo = new NoLista(info, afterEl);
		newElToAdd.setNext(afterEl);
		previousEl.setNext(newElToAdd);
		
		//previousEl.setNext(newElToAdd);
		//newElToAdd.setNext(afterEl);
		this.counter++;
	}
	public void remove(int index) {
		NoLista temp = first;
		NoLista elAnterior = null;
		NoLista proxElemento = null;
		int counter = 0;
		do {
			if(counter == index  -1) {
				elAnterior = temp;
			}
			if(counter == index + 1) {
				proxElemento = temp;			
			}			
			counter++;
			temp = temp.getNext();
		}while(temp != null);
		elAnterior.setNext(proxElemento);
		this.counter--;
	}
	public boolean removeFirst(Integer info) {
		NoLista temp = first;				
		int counter = 0;
		do {
			if(temp.getInfo().equals(info)) {
				this.remove(counter);
				return true;
			}						
			counter++;
			temp = temp.getNext();
		}while(temp != null);				
			
		return false;
	}
	
	public Integer get(int index) {
		NoLista temp = first;				
		int counter = 0;
		do {
			if(counter == index) {
				return temp.getInfo();
			}
			counter++;
			temp = temp.getNext();
		}while(temp != null);	
		return 0;
	}
	
	public Integer set(int index, Integer info) {
		NoLista temp = first;		
		Integer oldValue = 0;
		int counter = 0;
		do {
			if(counter == index) {
				oldValue = temp.getInfo();
				temp.setInfo(info);
				return oldValue;
			
				
			}
			counter++;
			temp = temp.getNext();
		}while(temp != null);	
		return 0;
	}
	
	public boolean isEmpty() {
		if(this.counter == 0) {
			return true;
		}else{
			return false;
		}
	}
	
	public Integer indexOf(Integer info) {
		NoLista temp = first;		
		int counter = 0;
		do {
			if(temp.getInfo().equals(info)) {
				return counter;
			}
			counter++;
			temp = temp.getNext();
		}while(temp != null);
		return -1;
	}
	
	public Integer lastIndexOf(Integer info) {
		NoLista temp = first;		
		int posicao = 1;
		int counter = 0;
		do {
			if(temp.getInfo().equals(info)) {
				posicao = counter;
			}
			counter++;
			temp = temp.getNext();
		}while(temp != null);
		if(posicao == 1) {
			return -1;
		}else {
			return posicao;	//
		}
		
	}
	public boolean contains(Integer info) {
        NoLista temp = first;
        int counter = 0;
        Integer lastInfo = 0;

        do {
            if(temp.getInfo().equals(info)) {
                return true;
            }
            counter ++;
            temp = temp.getNext();

        } while (temp != null);
            return false;
    }
	
	public Integer[] toArray() {
		Integer[] arr = new Integer[counter];
		NoLista temp = first;		
		int counter = 0;
		do {
			arr[counter] = temp.getInfo();		
			
			counter++;
			temp = temp.getNext();
		}while(temp != null);
		return arr;
		
	}
	 
	
	@Override
	public String toString() {		
		String info = " [ ";
		NoLista temp = first;
		do {
			//System.out.println("Atual: " + temp + " Proximo: " + temp.getNext());
			//info += "{ Atual: " + temp + " Proximo: " + temp.getNext() + " }";
			info += " [ Info: " + temp.getInfo() + " ] ";
			temp = temp.getNext();
			
		}while(temp != null);
		
		return info += " ]";
	}
}
