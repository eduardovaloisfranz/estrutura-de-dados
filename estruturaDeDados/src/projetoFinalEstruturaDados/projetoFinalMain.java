package projetoFinalEstruturaDados;

import java.util.Scanner;

public class projetoFinalMain {

	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Menu();
	
	}
	public static void Menu() {
		short opcaoDesejada = 0;
		do {
			System.out.println("O que deseja fazer?");
			System.out.println("\n1- Adicionar numero na Arvore Binaria de Busca\n2- Remover elemento da Arvore Binaria De Busca\n3-Visualizar e ordenar a Arvore");
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
		
		Menu();
	}
	public static void RemoverElemento() {
		
	}
	public static void VisualizarArvoreBinaria() {
		
	}

}
