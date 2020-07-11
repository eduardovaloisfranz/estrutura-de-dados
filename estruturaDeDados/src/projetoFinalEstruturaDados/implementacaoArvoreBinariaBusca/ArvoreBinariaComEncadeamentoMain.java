package projetoFinalEstruturaDados.implementacaoArvoreBinariaBusca;

public class ArvoreBinariaComEncadeamentoMain {

	public static void main(String[] args) {		
		ArvoreBinariaComEncadeamento<Integer> arvore = new ArvoreBinariaComEncadeamento<>();
		
		arvore.insereEmOrdem(2);
		arvore.insereEmOrdem(99);
		arvore.insereEmOrdem(1);
		
		
		//System.out.println(arvore.toString());
		
		arvore.toStringPorNivelVetor();		
		arvore.toStringPreOrdemVetor();
		
		
		
		
		
	}

}
