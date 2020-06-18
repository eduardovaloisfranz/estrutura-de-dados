package implementacaoArvores.implementacaoArvoreBinariaComEncadeamento;

public class ArvoreBinariaComEncadeamentoMain {

	public static void main(String[] args) {		
		ArvoreBinariaComEncadeamento<Integer> arvore = new ArvoreBinariaComEncadeamento<>();
		
		arvore.insere(1, arvore.insere(2, null, arvore.insere(4, null,null)), arvore.insere(3, arvore.insere(5, null,null), arvore.insere(6, null, null)));
		
		System.out.println("Arvore está vazia: " + arvore.vazia());
		System.out.println(arvore);
		arvore.insere(99);
		System.out.println(arvore);
		System.out.println("\n");
		//arvore.toStringPreOrdem();
		System.out.println("El 4 pertence na arvore?" + arvore.pertence(4));
		System.out.println("Altura atual da Arvore: " + arvore.altura());
		
		arvore.liberaRecursos();
		System.out.println("Arvore está vazia: " + arvore.vazia());	
		

	}

}
