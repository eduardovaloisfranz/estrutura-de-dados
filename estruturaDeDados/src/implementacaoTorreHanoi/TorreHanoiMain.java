package implementacaoTorreHanoi;

import java.util.Scanner;

import implementacaoTorreHanoi.Pilha.Pilha;
import implementacaoTorreHanoi.Pilha.ObjetoTorre;
import implementacaoTorreHanoi.Pilha.PilhaComVetor.PilhaVetor;
import implementacaoTorreHanoi.Pilha.PilhaComEncadeamento.*;

public class TorreHanoiMain {
	static Pilha<ObjetoTorre> torre1;
	static Pilha<ObjetoTorre> torre2;
	static Pilha<ObjetoTorre> torre3;
	static int quantityOfMoves = 0; 
	static Scanner input = new Scanner(System.in);
	
	//aviso: se a implementacao nao fosse generica, ficaria melhor, mas tive que dar um jeito!				
	public static void main(String[] args) {
		System.out.println("The arguments correctly is: Quantity of items in stack and type of implementation as example bellow");
		System.out.println("5 continua/dinamica |The quantity of items by default is five when you provided minus than five or doesnt provided nothing");
		System.out.println("And type of implementation is by default is continuous");
		int quantityOfItems = 0;
		String typeOfImplementation = "";
		int quantityOfArguments = args.length;
		if(args.length == 0 || args.length == 1) {
			args = new String[] { "5" , "continua" };
		}
		if(args.length > 2) {
			System.out.println("You provided more than necessary arguments, the system only needs 2 and you provided " + quantityOfArguments);
			if(tryParseInt(args[0])) {
				quantityOfItems = Integer.parseInt(args[0]);
					if(quantityOfItems < 5) {
						System.out.println("minus than five is not possible, the elements will have the minimum that is five items by default");
						quantityOfItems = 5;
					}				
				}else {
					System.out.println("You provide something is not a number, thats is" + args[0]);
				}
				if(args[1].equalsIgnoreCase("continua")) {
					typeOfImplementation = "continua";
				}
				else if(args[1].equalsIgnoreCase("dinamica")) {
					typeOfImplementation = "dinamica";
				}else {
					typeOfImplementation = "continua";
					System.out.println("You provided nothing for the type of implementation, the default is gonna be continuous or (continua ptBR)");				
				}
		}else if(args.length == 2) {				
			if(tryParseInt(args[0])) {
				quantityOfItems = Integer.parseInt(args[0]);
					if(quantityOfItems < 5) {
						System.out.println("minus than five is not possible, the elements will have the minimum that is five items by default");
						quantityOfItems = 5;
					}				
				}else {
					System.out.println("You provide something is not a number, thats is" + args[0]);
				}
				if(args[1].equalsIgnoreCase("continua")) {
					typeOfImplementation = "continua";
				}
				else if(args[1].equalsIgnoreCase("dinamica")) {
					typeOfImplementation = "dinamica";
				}else {
					typeOfImplementation = "continua";
					System.out.println("You provided nothing for the type of implementation, the default is gonna be continuous or (continua ptBR)");				
				}		
		}
		
		System.out.println("\nQuantity Of items in each stack " + quantityOfItems);
		System.out.println("\nType of implementation for all those stacks is: : " + typeOfImplementation);
		
		
		setPatternOfGame(quantityOfItems, typeOfImplementation);
		loadFirstTower();			
		Menu();
	}
	public static void setPatternOfGame(int quantityItens, String typeOfImplementation) {
		if(typeOfImplementation.equalsIgnoreCase("continua")) {			
			torre1 = new PilhaVetor<ObjetoTorre>(quantityItens);
			torre2 = new PilhaVetor<ObjetoTorre>(quantityItens);
			torre3 = new PilhaVetor<ObjetoTorre>(quantityItens);
		}
		else if(typeOfImplementation.equalsIgnoreCase("dinamica")) {			
			torre1 = new PilhaLista<ObjetoTorre>(quantityItens);
			torre2 = new PilhaLista<ObjetoTorre>(quantityItens);
			torre3 = new PilhaLista<ObjetoTorre>(quantityItens);
		}
	}
	public static void Menu() {
		
		int selectedTower = 0;
		int destinyTower = 0;
		do {
			System.out.println("\nTower number one");
			torre1.showStack();
			System.out.println("\nTower number two");
			torre2.showStack();
			System.out.println("\nTower number three");
			torre3.showStack();			 
			selectedTower = readInt("Type tower that you want to remove last element: [VALID OPTIONS: 1,2,3]: ");
			
			while((selectedTower < 1 || selectedTower > 3) || towerIsEmpty(selectedTower)) {
				if(towerIsEmpty(selectedTower)) {
					System.out.println("\nThe tower that you selected is empty, please select one which contains items");
				}
				System.out.println("\nPlease digit only numbers 1 to 3 and a tower that contains items");
				selectedTower = readInt("Type tower that you want to remove last element: [VALID OPTIONS: 1,2,3]: ");
			}
			
			destinyTower = readInt("\nType the destiny tower that you want: [VALID OPTIONS: 1,2,3]: ");
			
			while((destinyTower < 1 || destinyTower > 3) || towerIsEmpty(selectedTower)) {
				if(towerIsEmpty(selectedTower)) {
					System.out.println("The tower that you selected is empty, please select one which contains items");
				}
				System.out.println("Please digit only numbers 1 to 3 and a tower that contains items");
				selectedTower = readInt("Type destiny tower that you want: [VALID OPTIONS: 1,2,3]: ");
			}
			quantityOfMoves++;
			play(selectedTower, destinyTower);			
		
		}while(!wonGame());
		
		System.out.println("Congratulations, you won this game with " + quantityOfMoves + " of moves");
		System.out.println("There is final tower");
		torre3.showStack();
		
	}
	public static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	public static void loadFirstTower() {
		for(int i = 0; i < torre1.getTam(); i++) {
			TorreHanoiMain.torre1.push();			
		}
	}
	public static int readInt(String msg) {		
		System.out.print(msg);
		return input.nextInt();		
	}
	
	public static void play(int selectedTower, int destinyTower) {		
		if(!isPossibleAddObject(getTopOfSelectedTower(selectedTower), destinyTower)){
			System.out.println("You cant put this item to the selected tower because");
			System.out.println("The line is bigger than its predecessor");
			System.out.println("Try again!");
			return;
		}else {
			ObjetoTorre selectedCornerstone = popCornerstoneBySelectedTower(selectedTower);		
			pushToTower(selectedCornerstone, destinyTower);
	    };
	}
	
	public static ObjetoTorre popCornerstoneBySelectedTower(int selectedTower) {
		ObjetoTorre cornestoneSelected = null;
		switch(selectedTower) {
		case 1:
			cornestoneSelected = torre1.pop();
			break;
		case 2:
			cornestoneSelected = torre2.pop();
			break;
		case 3:
			cornestoneSelected = torre3.pop();
			break;
		}
		return cornestoneSelected;
		
	}
	public static ObjetoTorre getTopOfSelectedTower(int selectedTower) {
		ObjetoTorre last = null;
		switch(selectedTower) {
		case 1: 
			last = torre1.top();
			break;
		case 2: 
			last = torre2.top();
			break;
		case 3: 
			last = torre3.top();
			break;	
		}
		
		return last;
	}
	
	public static boolean isPossibleAddObject(ObjetoTorre obj, int selectedTower) {
		boolean isPossible = false;
		switch(selectedTower) {
		case 1: 
			isPossible = torre1.elementIsBiggerThanActualElement(obj);
			break;
		
		case 2: 
			isPossible = torre2.elementIsBiggerThanActualElement(obj);
			break;
		case 3: 
			isPossible = torre3.elementIsBiggerThanActualElement(obj);
			break;
		}
		return isPossible;
	}
	
	public static void pushToTower(ObjetoTorre el, int selectedTower) {
		switch(selectedTower) {
		case 1:
			torre1.push(el);
			break;
		case 2:
			torre2.push(el);
			break;
		case 3:
			torre3.push(el);
			break;
		}
	}
	public static boolean towerIsEmpty(int selectedTower) {
		boolean isEmpty = true;
		switch(selectedTower) {
		case 1:
			isEmpty = torre1.isEmpty();
			break;
		case 2: 
			isEmpty = torre2.isEmpty();
			break;
		case 3: isEmpty = torre3.isEmpty();
				break;
		}
		return isEmpty;
	};
	public static boolean wonGame() {
		return torre3.isFull();
	}	

}
