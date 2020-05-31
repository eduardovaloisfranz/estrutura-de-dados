package implementacaoArvores.implementacaoArvoresBinariasComArray;

public class ArvoreBinariaComArrayMain {

	public static void main(String[] args) {		//
		ArvoreBinariaComArray<Integer> arvore = new ArvoreBinariaComArray<>(4);
		//arvore.insere(info)
		arvore.insere(0);
		arvore.insere(1);
		arvore.insere(2);
		arvore.insere(3);
		arvore.insere(4);
		arvore.insere(5);
		arvore.insere(6);
		arvore.insere(7, 5, true);
		int qtd = (int) Math.pow(2, ((3 + 1) - 1));
		System.out.println("Vetor alocado: " + qtd);
		arvore.show();
		System.out.println("\n\n");
		arvore.getAlturaAtual();

	}

}
