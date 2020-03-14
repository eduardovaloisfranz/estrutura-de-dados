package implementacaoListaComEncadeamento;

public class ListaComEncadeamentoMain {
	public static void main(String[] args) {
		ListaComEncadeamento lista = new ListaComEncadeamento();
		lista.add(23);		
		lista.add(12);
		lista.add(53);
		lista.add(83);
		lista.add(43);
		// dps -> null
		// this.last = 5, this.last.getNext -> null 
		// p/ novo, qualquer dado, ultima posicao o getNext -> null
		// novo = info, null
		// 
		//lista.add(99, 1)
		
		lista.exibirLista();
	}
}
