package implementacaoArrayListGenerics;

public class ArrayMainTeste {
	public static void main(String[] args) {
		ListaComArray<Integer> list = new ListaComArray<Integer>(15, true);
		for(int i = 0; i < 15; i++) {
			list.add(i);
		}		
		
		//System.out.println(list.toString());
		System.out.println(list.isFull());
		list.add(10, 99);
		System.out.println(list.toString());
		
		Lista<String> lista = new ListaComArray<String>();
		lista.add("oi");
		lista.add("teste");
		lista.add("tttt");
		lista.add("Lorem Ipsum");
		
		System.out.println(lista);
		
		
	}
}
