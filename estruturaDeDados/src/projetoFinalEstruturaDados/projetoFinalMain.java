package projetoFinalEstruturaDados;

import java.util.Scanner;
import projetoFinalEstruturaDados.implementacaoArvoreBinariaBusca.ArvoreBinariaComEncadeamento;

public class projetoFinalMain {

	public static Scanner input = new Scanner(System.in);
	public static ArvoreBinariaComEncadeamento<Integer> arvore = new ArvoreBinariaComEncadeamento<>();
	public static void main(String[] args) {
		//Menu();
		arvore.insereEmOrdem(99);
		arvore.insereEmOrdem(3);
		arvore.insereEmOrdem(4);
		arvore.insereEmOrdem(23);
		arvore.insereEmOrdem(4);
		
		//exibirArray(arvore.toStringPreOrdemVetor());
		exibirArray(bubbleSort(arvore.toStringPreOrdemVetor()));
		System.out.println("\n");
		QuickSort qs = new QuickSort(arvore.toStringEmOrdemVetor());
		exibirArray(qs.ordenar());
		System.out.println("\n");
		MergeSort ms = new MergeSort(arvore.toStringPorNivelVetor());
		exibirArray(ms.ordenar());
	
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
			System.out.println(arvore.toString());			
		}
		Menu();
	}
	
	public Integer[] inverterArray(Integer[] vet) {
		Integer[] newVet = new Integer[vet.length];
		for(int i = vet.length; i > 0; i--) {
			newVet[i] = vet[i];
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

}

