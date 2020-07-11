package projetoFinalEstruturaDados;

import java.util.Scanner;

import projetoFinalEstruturaDados.implementacaoArvoreBinariaBusca.ArvoreBinariaComEncadeamento;

public class projetoFinalMain {

	public static Scanner input = new Scanner(System.in);
	public static ArvoreBinariaComEncadeamento<Integer> arvore = new ArvoreBinariaComEncadeamento<>();
	public static void main(String[] args) {
		//Menu();
		
		arvore.insereEmOrdem(50);
		arvore.insereEmOrdem(30);
		arvore.insereEmOrdem(20);
		arvore.insereEmOrdem(40);
		arvore.insereEmOrdem(70);
		arvore.insereEmOrdem(80);
		
		arvore.removerElemento(110);
		
		//System.out.println(arvore.counter);
		System.out.println(arvore.toString());
		//for(int i = 0; i < arvore.toStringPorNivelVetor().length; i++) {
			//System.out.print("[ " + arvore.toStringEmOrdemVetor()[i] + " ]");
		//}
	
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
		
	}
	public static void VisualizarArvoreBinaria() {
		System.out.println(arvore.toString());
		Menu();
	}

}

