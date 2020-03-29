package implementacaoListaComEncadeamento;

import ReimplementandoListaEncadeada.ListaComEncadeamento;

public class ListaComEncadeamentoMain {
	public static void main(String[] args) {
		ListaComEncadeamento lista = new ListaComEncadeamento();
		lista.add(41);
		lista.add(54);		
		lista.add(12);
		
		System.out.println(lista);
		lista.add(99, 1);
		System.out.println(lista.toString());
		
	}
}
