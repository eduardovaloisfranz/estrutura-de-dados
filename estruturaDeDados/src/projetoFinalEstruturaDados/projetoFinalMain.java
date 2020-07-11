package projetoFinalEstruturaDados;

import java.util.Scanner;
import projetoFinalEstruturaDados.implementacaoArvoreBinariaBusca.ArvoreBinariaComEncadeamento;

public class projetoFinalMain {

	public static Scanner input = new Scanner(System.in);
	public static ArvoreBinariaComEncadeamento<Integer> arvore = new ArvoreBinariaComEncadeamento<>();
	public static void main(String[] args) {
		Menu();
	}
	public static void Menu() {
		short opcaoDesejada = 0;
		do {
			System.out.println("O que deseja fazer?");
			System.out.println("\n1- Adicionar numero na Arvore Binaria de Busca\n2- Remover elemento da Arvore Binaria De Busca\n3- Visualizar e ordenar a Arvore");
			opcaoDesejada = input.nextShort();
			while(opcaoDesejada < 0 || opcaoDesejada > 3){
				System.out.println("Opção Invalida, tente outro numero");
				opcaoDesejada = input.nextShort();
			}
			
			switch(opcaoDesejada) {
			case 1:
				AdicionarElemento();
				break;
			case 2: 
				RemoverElemento();
				break;
			case 3:
				VisualizarArvoreBinaria();
				break;
			}
			
			
		}while(opcaoDesejada != 0);
	
	}
	public static void AdicionarElemento() {
		int numeroDesejado = 0;
		byte continuar;
		do {
			System.out.print("Por Favor insira o número desejado: ");
			numeroDesejado = input.nextInt();
			arvore.insereEmOrdem(numeroDesejado);
			System.out.print("Deseja adicionar outro número? [1- Sim] - [2- Não]");
			continuar = input.nextByte();
			while(continuar < 1 || continuar > 2) {
				System.out.println("Numero invalido, informe apenas os números validos");
				System.out.println("Deseja adicionar outro número? [1- Sim] - [2- Não]");
				continuar = input.nextByte();
			}
		}while(continuar == 1);
		Menu();
	}
	public static void RemoverElemento() {
		if(arvore.vazia() == false) {
			System.out.print("Digite o elemento que deseja remover: ");
			Integer elementoARemover = input.nextInt();			
		}else {
			System.out.println("Arvore encontra-se vazia, não possibilitando remover elementos, adicione mais para usar esta função");
		}
		Menu();
		
	}
	public static void VisualizarArvoreBinaria() {
		if(arvore.vazia()) {
			System.out.println("Arvore encontra-se vazia, não possibilitando visualizar-la, tente adicionar elementos para usar esta função");
		}else {
			
			exibirArray(arvore.toStringPorNivelVetor());
			
			System.out.println(arvore.toString());			
			System.out.println("Agora os tempos de ordenação: ");
			//pre,pos,in, nivel
			long tempoInicial = System.nanoTime();
			bubbleSort(arvore.toStringPreOrdemVetor());
			long tempoFinal = System.nanoTime();
			long duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Pré Ordem no Método BubbleSort demorou: " + duracao + " ns");
			QuickSort qs = new QuickSort(arvore.toStringPreOrdemVetor());
			tempoInicial = System.nanoTime();
			qs.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O Tempo de Ordenação da Arvore Pré Ordem no Método QuickSort demorou: " + duracao + " ns");
			MergeSort ms = new MergeSort(arvore.toStringPreOrdemVetor());
			tempoInicial = System.nanoTime();
			ms.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Pré ordem no Método MergeSort demorou: " + duracao + " ns\n");
			
			
			tempoInicial = System.nanoTime();
			bubbleSort(arvore.toStringPosOrdemVetor());
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Pós Ordem no Método BubbleSort demorou: " + duracao + " ns");
			QuickSort qs2 = new QuickSort(arvore.toStringPosOrdemVetor());
			tempoInicial = System.nanoTime();
			qs2.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O Tempo de Ordenação da Arvore Pós Ordem no Método QuickSort demorou: " + duracao + " ns");
			MergeSort ms2 = new MergeSort(arvore.toStringPosOrdemVetor());
			tempoInicial = System.nanoTime();
			ms2.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Pós ordem no Método MergeSort demorou: " + duracao + " ns\n");	
			
			tempoInicial = System.nanoTime();
			bubbleSort(arvore.toStringEmOrdemVetor());
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Em Ordem no Método BubbleSort demorou: " + duracao + " ns");
			QuickSort qs3 = new QuickSort(arvore.toStringEmOrdemVetor());
			tempoInicial = System.nanoTime();
			qs3.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O Tempo de Ordenação da Arvore Em Ordem no Método QuickSort demorou: " + duracao + " ns");
			MergeSort ms3 = new MergeSort(arvore.toStringEmOrdemVetor());
			tempoInicial = System.nanoTime();
			ms3.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Em ordem no Método MergeSort demorou: " + duracao + " ns\n");
			
			tempoInicial = System.nanoTime();
			bubbleSort(arvore.toStringPorNivelVetor());
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Por Nivel no Método BubbleSort demorou: " + duracao + " ns");
			QuickSort qs4 = new QuickSort(arvore.toStringPorNivelVetor());
			tempoInicial = System.nanoTime();
			qs4.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O Tempo de Ordenação da Arvore Por Nivel no Método QuickSort demorou: " + duracao + " ns");
			MergeSort ms4 = new MergeSort(arvore.toStringPorNivelVetor());
			tempoInicial = System.nanoTime();
			ms4.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Por Nivel no Método MergeSort demorou: " + duracao + " ns\n");	
			
			tempoInicial = System.nanoTime();
			bubbleSort(inverterArray(arvore.toStringPorNivelVetor()));
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Por Nivel Invertido no Método BubbleSort demorou: " + duracao + " ns");
			QuickSort qs5 = new QuickSort(inverterArray(arvore.toStringPorNivelVetor()));
			tempoInicial = System.nanoTime();
			qs5.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O Tempo de Ordenação da Arvore Por Nivel Invertida no Método QuickSort demorou: " + duracao + " ns");
			MergeSort ms5 = new MergeSort(inverterArray(arvore.toStringPorNivelVetor()));
			tempoInicial = System.nanoTime();
			ms5.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Por Nivel invertido no Método MergeSort demorou: " + duracao + " ns\n");	
			
			tempoInicial = System.nanoTime();
			bubbleSort(inverterArray(arvore.toStringPosOrdemVetor()));
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Pos Ordem Invertida no Método BubbleSort demorou: " + duracao + " ns");
			QuickSort qs6 = new QuickSort(inverterArray(arvore.toStringPosOrdemVetor()));
			tempoInicial = System.nanoTime();
			qs6.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O Tempo de Ordenação da Arvore Pos Ordem Invertida no Método QuickSort demorou: " + duracao + " ns");
			MergeSort ms6 = new MergeSort(inverterArray(arvore.toStringPosOrdemVetor()));
			tempoInicial = System.nanoTime();
			ms6.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Pos Ordem invertida no Método MergeSort demorou: " + duracao + " ns\n");
			
			tempoInicial = System.nanoTime();
			bubbleSort(inverterArray(arvore.toStringEmOrdemVetor()));
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Em Ordem Invertida no Método BubbleSort demorou: " + duracao + " ns");
			QuickSort qs7 = new QuickSort(inverterArray(arvore.toStringEmOrdemVetor()));
			tempoInicial = System.nanoTime();
			qs7.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O Tempo de Ordenação da Arvore Em Ordem Invertida no Método QuickSort demorou: " + duracao + " ns");
			MergeSort ms7 = new MergeSort(inverterArray(arvore.toStringEmOrdemVetor()));
			tempoInicial = System.nanoTime();
			ms7.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Em Ordem invertida no Método MergeSort demorou: " + duracao + " ns\n");
			
			tempoInicial = System.nanoTime();
			bubbleSort(inverterArray(arvore.toStringPreOrdemVetor()));
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Pre Ordem Invertida no Método BubbleSort demorou: " + duracao + " ns");
			QuickSort qs8 = new QuickSort(inverterArray(arvore.toStringPreOrdemVetor()));
			tempoInicial = System.nanoTime();
			qs8.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O Tempo de Ordenação da Arvore Pre Ordem Invertida no Método QuickSort demorou: " + duracao + " ns");
			MergeSort ms8 = new MergeSort(inverterArray(arvore.toStringPreOrdemVetor()));
			tempoInicial = System.nanoTime();
			ms8.ordenar();
			tempoFinal = System.nanoTime();
			duracao = tempoFinal - tempoInicial;
			System.out.println("O tempo de Ordenação da Arvore Pre Ordem invertida no Método MergeSort demorou: " + duracao + " ns\n");
			
							
			
		}
		Menu();
	}
	
	public static Integer[] inverterArray(Integer[] vet) {
		 Integer[] newVet = new Integer[vet.length]; 
	        int j = vet.length; 
	        for (int i = 0; i < vet.length; i++) { 
	            newVet[j - 1] = vet[i]; 
	            j = j - 1; 
	        } 
	  
		return newVet;
	}
	
	public static Integer[] bubbleSort(Integer[] vet) {
		 int n = vet.length; 
	        for (int i = 0; i < n-1; i++) 
	            for (int j = 0; j < n-i-1; j++) 
	                if (vet[j] > vet[j+1]){	                     
	                    Integer temp = vet[j]; 
	                    vet[j] = vet[j+1]; 
	                    vet[j+1] = temp; 
	                } 
	       return vet;
	}
	
	public static void exibirArray(Integer[] vetor) {
		for(int i = 0; i < vetor.length; i++) {
			System.out.print("[ " + vetor[i] + " ]");
		}
	}
	public static void exibirArvore(Integer[] arvore) {
		int qtdElementosPorNivel = 1;	
		int qtdElementosVisualizadosInNivel = 0;		
		for(int i = 0; i < arvore.length; i++) {
		if(qtdElementosVisualizadosInNivel == qtdElementosPorNivel) {
			System.out.println("\n");
			qtdElementosPorNivel*=2;	
			qtdElementosVisualizadosInNivel = 0;
		}		
		System.out.println("[ " + arvore[i] + " ]");
		qtdElementosVisualizadosInNivel++;			
		}	
		
		//System.out.println(texto);
		
	}

}

