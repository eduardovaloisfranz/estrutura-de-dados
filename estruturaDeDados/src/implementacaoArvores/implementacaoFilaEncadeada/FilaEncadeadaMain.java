package implementacaoArvores.implementacaoFilaEncadeada;

public class FilaEncadeadaMain {

	public static void main(String[] args) {
		FilaListaEncadeada<String> fila = new FilaListaEncadeada<>();
		
		fila.Insere("teste");
		fila.Insere("outraString");
		fila.Insere("IT WORKS!!!");
		System.out.println(fila.Retira());
		
		fila.exibirLista();

	}

}
