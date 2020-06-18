package implementacaoArvores.implementacaoArvoresVariaveis;

public class ArvoreVariavelMain {

	public static void main(String[] args) {	
		ArvoreVariavel<String> arvore = new ArvoreVariavel<>();
		//arvore.insere("a", null, arvore.insere("b", null, null));
		arvore.insere("A", arvore.insere("B", null, arvore.insere("C", null, null)), null);
		//info filho irmao
		//arvore.insere("A", null, null);
		//arvore.insere("a", arvore.insere("B", null, null), null);
		
		System.out.println("{A} pertence?" + arvore.pertence("A"));
		System.out.println("Arvore está vazia? "+ arvore.vazia());
		System.out.println(arvore);
		arvore.libera();
		System.out.println("Arvore está vazia? "+ arvore.vazia());
		
	}
	
	
}
