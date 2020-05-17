package implementacaoTorreHanoi;

import java.util.Scanner;

public class TorreHanoiMain {
	static PilhaVetor torre1 = new PilhaVetor(3);
	static PilhaVetor torre2 = new PilhaVetor(3);
	static PilhaVetor torre3 = new PilhaVetor(3);
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		loadFirstTower();			
		Menu();
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
			
			play(selectedTower, destinyTower);
		
		}while(!wonGame());
		
		System.out.println("Congratulations, you won this game!");
		
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
			System.out.println("You can't add because the line is bigger than its predecessor");
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
			last = torre3.pop();
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
