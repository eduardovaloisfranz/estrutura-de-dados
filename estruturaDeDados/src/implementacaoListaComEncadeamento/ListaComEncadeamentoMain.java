package implementacaoListaComEncadeamento;

public class ListaComEncadeamentoMain {
	public static void main(String[] args) {
		ListaComEncadeamento lista = new ListaComEncadeamento();
		lista.add(23);
		//99 -> 1
		lista.add(12);
		lista.add(53);
		lista.add(99);
		lista.add(99);
		lista.add(12);
		lista.add(99);
		// dps -> null
		// this.last = 5, this.last.getNext -> null 
		// p/ novo, qualquer dado, ultima posicao o getNext -> null
		// novo = info, null
		//
		System.out.println(lista);
		
		
		//System.out.println(lista.removeFirst(53));
		//System.out.println(lista.get(2));
		//System.out.println(lista.set(2, 99));
		//System.out.println(lista.contains(99));
		//System.out.println(lista.indexOf(99));
		System.out.println(lista.lastIndexOf(99));
		
		System.out.println(lista);
		
		//System.out.println(lista.toArray());
	}
}
