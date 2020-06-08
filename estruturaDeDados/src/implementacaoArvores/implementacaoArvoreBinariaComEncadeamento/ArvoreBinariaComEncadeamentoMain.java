package implementacaoArvores.implementacaoArvoreBinariaComEncadeamento;

public class ArvoreBinariaComEncadeamentoMain {

	public static void main(String[] args) {		
		ArvoreBinariaComEncadeamento<Integer> arvore = new ArvoreBinariaComEncadeamento<>();
		
		arvore.insere(1, arvore.insere(2, null, arvore.insere(4, null,null)), arvore.insere(3, arvore.insere(5, null,null), arvore.insere(6, null, null)));
		
		
		//System.out.println(arvore.toStringPorNivel());
		System.out.println(arvore.toString());
		System.out.println("\n");
		//arvore.toStringPreOrdem();
		
		
		//System.out.println(arvore.altura());
		

	}

}
