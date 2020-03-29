package ReimplementandoListaEncadeada;

public class ListaEncadeadaMain {
	
	public static void main(String[] args) {
		ListaComEncadeamento lista = new ListaComEncadeamento();
		lista.add(41);
		lista.add(54);		
		lista.add(99);
		lista.add(12);				
		lista.add(99);
		System.out.println(lista.toString());
		//lista.remove(3);
		System.out.println(lista.toString());
		System.out.println(lista.get(2));
		System.out.println(lista.indexOf(99));
		System.out.println(lista.lastIndexOf(99));
		System.out.println(lista.contains(1232131));
		
		
	}

}
