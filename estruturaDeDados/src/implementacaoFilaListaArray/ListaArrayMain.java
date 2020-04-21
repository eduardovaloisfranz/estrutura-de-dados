package implementacaoFilaListaArray;

public class ListaArrayMain {

	public static void main(String[] args) {
		FilaLista<Integer> listaComArray = new FilaLista<Integer>(7);
		
		listaComArray.Insere(3);
		listaComArray.Insere(4);
		listaComArray.Insere(33);
		listaComArray.Insere(11);
		listaComArray.Insere(123);
		listaComArray.Insere(23);		
		listaComArray.Insere(99);		
		listaComArray.exibirFila();
		listaComArray.Retira();
		System.out.println("\n");
		listaComArray.Insere(8001);		
		//listaComArray.Insere(8001);	
		listaComArray.libera();
		listaComArray.exibirFila();
		
		//System.out.println(listaComArray.listaIsCheia());
		
		//System.out.println(listaComArray.listaIsCheia());
		
		
		
		

	}

}
