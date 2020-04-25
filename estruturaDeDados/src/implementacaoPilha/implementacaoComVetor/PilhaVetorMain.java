package implementacaoPilha.implementacaoComVetor;

public class PilhaVetorMain {

	public static void main(String[] args) {
		PilhaVetor<String> p1 = new PilhaVetor<String>(15);
		p1.push("El1");
		p1.push("el02");
		p1.push("el03");
		p1.push("el04");
		
		p1.showStack();
		
		System.out.println(p1.pop());
		System.out.println(p1.top());
		//p1.clear();
		System.out.println(p1.isEmpty());
		p1.showStack();
		
	}

}
