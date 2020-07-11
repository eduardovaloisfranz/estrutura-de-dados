package implementacaoMetodosOrdenacao;

public class MergeSort {
	private Integer[] vetor;
	
	public MergeSort(Integer[] vetor) {
		this.vetor = vetor;
	}
	
	
	public void ordenarVetorRecursivo() {
		ordenarVetorRecursivo(this.vetor, this.vetor.length);
	}
	
	private void ordenarVetorRecursivo(Integer vet[], int size) {
        int tamanhoAtual;  
        int esquerdaInicio;              
        for (tamanhoAtual = 1; tamanhoAtual <= size-1;tamanhoAtual = 2*tamanhoAtual){ 
            for (esquerdaInicio = 0; esquerdaInicio < size-1;esquerdaInicio += 2*tamanhoAtual){ 
                int meio = Math.min(esquerdaInicio + tamanhoAtual - 1, size-1);          
                int direitaFim = Math.min(esquerdaInicio+ 2*tamanhoAtual - 1, size-1);       
                merge(vet, esquerdaInicio, meio, direitaFim); 
            } 
        } 
	}
	
	private void merge(Integer vet[], int esquerda, int centro, int direita) { 
        int i, j, k; 
        int n1 = centro - esquerda + 1; 
        int n2 = direita - centro; 
      
        Integer L[] = new Integer[n1]; 
        Integer R[] = new Integer[n2];
      
        for (i = 0; i < n1; i++) {
        	L[i] = vet[direita + i];        	
        }
        for (j = 0; j < n2; j++) {
        	R[j] = vet[centro + 1+ j];        	
        }
        i = 0; 
        j = 0; 
        k = direita; 
        while (i < n1 && j < n2){ 
            if (L[i] <= R[j]){ 
                vet[k] = L[i]; 
                i++; 
            } 
            else{ 
                vet[k] = R[j]; 
                j++; 
            } 
            k++; 
        }      
        while (i < n1){ 
            vet[k] = L[i]; 
            i++; 
            k++; 
        }      
        while (j < n2){ 
            vet[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
	public void exibirVetor() {
		for(int i = 0; i < this.vetor.length; i++) {
			System.out.print("[ " + this.vetor + " ]");			
		}
	}
}

