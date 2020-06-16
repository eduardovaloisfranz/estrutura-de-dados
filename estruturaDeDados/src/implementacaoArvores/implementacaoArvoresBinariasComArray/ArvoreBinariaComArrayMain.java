package implementacaoArvores.implementacaoArvoresBinariasComArray;

public class ArvoreBinariaComArrayMain {

	public static void main(String[] args) {		//
		ArvoreBinariaComArray<Integer> arvore = new ArvoreBinariaComArray<>(3);
		//arvore.insere(info)
		arvore.insere(0);
		arvore.insere(1);
		arvore.insere(2);
		arvore.insere(3);
		arvore.insere(4);
		//arvore.insere(null);
		arvore.insere(5);
		arvore.insere(6);		
		//arvore.insere(99, 3, true);
		//arvore.insere(7, 5, true);
		//arvore.insere(5, 5, true);			
		System.out.println("Altura Total: " + arvore.getAlturaAtual());
		System.out.println("Quantidade Max Nos: " + arvore.getQuantidadeMaxNos());
		//System.out.println(arvore.toStringPorNivel());		
		//System.out.println("Pré ordem ->" + arvore.toStringPreOrdem());
		//System.out.println("Em Ordem -> " + arvore.toStringEmOrdem());	
		//System.out.println("Pos Ordem ->" + arvore.toStringPosOrdem());
		System.out.println("Arvore está cheia: " + arvore.isCheia());
		System.out.println("Arvore está vazia: " + arvore.isVazia());
		System.out.println("Integer 5 pertence a arvore?: " + arvore.pertence(5));
		System.out.println("");
		System.out.println(arvore);
		arvore.liberaRecursos();
		System.out.println("Arvore está cheia? "+ arvore.isCheia());
	}

}
