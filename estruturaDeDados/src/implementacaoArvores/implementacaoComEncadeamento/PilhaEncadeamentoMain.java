package implementacaoArvores.implementacaoComEncadeamento;

public class PilhaEncadeamentoMain {

	public static void main(String[] args) {
		PilhaLista<String> p1 = new PilhaLista<String>();
		
		p1.push("el01");
		p1.push("el02");
		p1.push("el03");
		
		
		//System.out.println(p1.pop());
		//System.out.println(p1.pop());
		//System.out.println(p1.pop());
		//System.out.println(p1.pop());
		//p1.clear();
		
		System.out.println(p1.isEmpty());
		//System.out.println(p1.top());
		
		p1.showStack();
		
	}

}

