package implementacaoArvores.implementacaoArvoresBinariasComArray;

public class ArvoreBinariaComArray <T>{
	private int altura = -1;
	private T[] vetor;
	private int counter;
	
	public ArvoreBinariaComArray(int altura) {
		this.altura = altura;
		this.vetor = (T[]) new Object[(int) Math.pow(2, (altura + 1) - 1)];
		//Math.pow(2, (altura + 1) - 1)
	}
	
	public void insere(T info) {
		if(this.counter <= this.vetor.length) {
			this.vetor[this.counter] = info;
			this.counter++;			
		}else {
			throw new IndexOutOfBoundsException("Arvore encontra-se cheia");
		}
	}
	
	public boolean insere(T info, int posPai, boolean sobreescrever) {
		int idxEsquerda = 2 * posPai + 1;
		if(idxEsquerda > this.vetor.length) {
			throw new IndexOutOfBoundsException("não há como adicionar nesta posição pois é maior que a capacidade do array");
		}
		if(this.vetor[posPai] == null) {
			return false;
		}else {		
	   if(this.vetor[idxEsquerda] == null) {
				this.vetor[idxEsquerda] = info;
				return true;
			}else {
				if(sobreescrever) {
					this.vetor[idxEsquerda] = info;
					return true;
				}			
			}			
		}
		
		return false;
	}	
	
	
	public boolean isVazia() {
		return this.counter == 0;
	}
	
	public boolean isCheia() {
		return this.counter == this.vetor.length;
	}
	
	public boolean pertence(T info) {
		for(T i : this.vetor) {
			if(i.equals(i)) {
				return true;
			}
		}
		return false;
	}	
	public void liberaRecursos() {		
		this.vetor = (T[]) new Object[2^(altura + 1) - 1];		
	}
	
	public int getAlturaAtual() {
		int alturaMax = 0;
		if(noIsFolha(getIndexEsquerda(0), getIndexDireita(0))){
			return alturaMax = 1;			
		}
		else {			
			int i = 0;
			int qtdElementosVisualizados = 0;
			i = getIndexEsquerda(i);
			int altura = 0;
			do {				
				if(noIsFolha(getIndexEsquerda(i), getIndexDireita(i))) {
					i = getIndexPai(i);					
					i = getIndexDireita(i);					
					altura = qtdElementosVisualizados;					
					if(noIsFolha(getIndexEsquerda(i), getIndexDireita(i))) {
						i = getIndexPai(i);
						altura = qtdElementosVisualizados;
					}					
					
				}else {
					i = getIndexEsquerda(i);
					
				}						
				qtdElementosVisualizados++;				
			}while(qtdElementosVisualizados < this.counter);
			
		}		
		altura--;					
		return altura;
	}
	
	public int getQuantidadeMaxNos() {			
			int qtdElementosPorNivel = 1;	
			int qtdElementosVisualizadosInNivel = 0;
			int somaElementosPorNivel = 0;
			int maiorQuantidadeNosPorNivel = 0;
			for(int i = 0; i < this.vetor.length; i++) {
			if(this.vetor[i] != null) {					
						
			}
			if(qtdElementosVisualizadosInNivel == qtdElementosPorNivel) {
				qtdElementosPorNivel*=2;	
				qtdElementosVisualizadosInNivel = 0;
				if(somaElementosPorNivel > maiorQuantidadeNosPorNivel) {
					maiorQuantidadeNosPorNivel = somaElementosPorNivel;
				}
				somaElementosPorNivel = 0;
			}
			qtdElementosVisualizadosInNivel++;
			if(this.vetor[i] != null) {
				somaElementosPorNivel++;				
			}
				
		}
			
		return maiorQuantidadeNosPorNivel;
	}
	
	public String toStringPorNivel(){
		String texto = "";
		int qtdElementosPorNivel = 1;	
		int qtdElementosVisualizadosInNivel = 0;		
		
		for(int i = 0; i < this.vetor.length; i++) {
		if(qtdElementosVisualizadosInNivel == qtdElementosPorNivel) {
			texto+= "\n";			
			qtdElementosPorNivel*=2;	
			qtdElementosVisualizadosInNivel = 0;
		}		
		texto+= "[ " + this.vetor[i] + " ]";
		qtdElementosVisualizadosInNivel++;
			
		}	
		
		return texto;
	}
	
	public int getIndexEsquerda(int idxAtual) {
		return (2 * idxAtual) + 1; 
	}
	
	public int getIndexDireita(int idxAtual) {
		return 2 * idxAtual + 2;
	}
	
	public int getIndexPai(int idxFilho) {
		return (int) (idxFilho  - 1) / 2;
	}
	
	public void show() {
		for(T info : this.vetor) {	
			System.out.print(info + " ");
		}
	}
	public boolean noIsFolha (int idxFilhoEsquerda, int idxFilhoDireita) {	
		if(idxFilhoEsquerda >= this.vetor.length || idxFilhoDireita >= this.vetor.length) {		
			return true;
		}else {
			if(this.vetor[idxFilhoEsquerda] == null && this.vetor[idxFilhoDireita] == null) {
				return true;
			}else {
				return false;				
			}
		}
	
	}

}
