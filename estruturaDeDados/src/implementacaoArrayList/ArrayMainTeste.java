package implementacaoArrayList;

public class ArrayMainTeste {
	public static void main(String[] args) throws Throwable {
		ListaComArray list = new ListaComArray(15, true);
		for(int i = 0; i < 15; i++) {
			list.add(i);
		}
		
		System.out.println("oi");
		System.out.println(list.toString());
		System.out.println(list.isFull());
		//list.add(10, 99);
		//System.out.println(list.toString());
		
		
		
	}
}
