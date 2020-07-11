package implementacaoMetodosOrdenacao;

public class BubbleSort{
	private Integer[] vet;
	
	public BubbleSort(Integer vet[]) {
		this.vet = vet;
	}	
	
	public void ordenarVetorIterativo() {			
		Integer aux = null;		 
		for(int i = 0; i < this.vet.length; i++) {
			for(int j = 0; j < this.vet.length -1; j++) {
				if(this.vet[j] > vet[j + 1]) {
					aux = vet[j];
					vet[j] = vet[j + 1];
					vet[j + 1] = aux;
				}
			}
		}	
		
	}
	
	public void ordenarVetorRecursivo() {
		this.ordenarVetorRecursivo(this.vet, this.vet.length);
	}
	
	private void ordenarVetorRecursivo(Integer[] vet, int idx) {
        if (idx == 1) {
        	return;        	
        }
        for (int i=0; i<idx-1; i++) 
            if (vet[i] > vet[i+1]) 
            { 
                // swap arr[i], arr[i+1] 
                int temp = vet[i]; 
                vet[i] = vet[i+1]; 
                vet[i+1] = temp; 
            } 
        ordenarVetorRecursivo(vet, idx-1); 
	}
	
	public void exibirVetor() {
		for(int i = 0; i < this.vet.length; i++) {
			System.out.print("[ " + this.vet[i] + " ]");
		}
	}
}
