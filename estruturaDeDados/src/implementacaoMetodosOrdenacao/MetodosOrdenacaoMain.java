package implementacaoMetodosOrdenacao;

public class MetodosOrdenacaoMain {

	public static Integer[] vet = { 5, 4, 5, 2};
	public static void main(String[] args) {
		//exibirTesteBubbleSort();
		exibirTesteMergeSort();
	}
	public static void exibirTesteBubbleSort() {
		BubbleSort bb = new BubbleSort(vet);
		
		//bb.exibirVetor();
		//bb.ordenarVetorIterativo();
		bb.ordenarVetorRecursivo();	
		
		bb.exibirVetor();
	}
	
	public static void exibirTesteMergeSort() {
		MergeSort ms = new MergeSort(vet);
		
		ms.ordenarVetorRecursivo();
		
		ms.exibirVetor();
	}

}
