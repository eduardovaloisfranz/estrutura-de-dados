package projetoFinalEstruturaDados;

public class QuickSort {
	
	private Integer[] vet;
	public QuickSort(Integer[] vet) {
		this.vet = vet;			
	}
	public Integer[] ordenar() {
		ordenar(this.vet, 0, this.vet.length - 1);
		return this.vet;
	}
	
	private void ordenar(Integer[] vetor, int inicio, int fim) {
		   if (inicio < fim) {
               int posicaoPivo = merge(vetor, inicio, fim);
               ordenar(vetor, inicio, posicaoPivo - 1);
               ordenar(vetor, posicaoPivo + 1, fim);
        }
	}
	private int merge(Integer[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
               if (vetor[i] <= pivo)
                      i++;
               else if (pivo < vetor[f])
                      f--;
               else {
                      int troca = vetor[i];
                      vetor[i] = vetor[f];
                      vetor[f] = troca;
                      i++;
                      f--;
               }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
  }
	
}
