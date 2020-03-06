package ed01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadInfoUser {
	public static Image getInfoTxtFromPath(String pathTxt) {
		Image image = new Image();
		String path = "";
		if(pathTxt.toLowerCase().endsWith(".txt")) {
			path = pathTxt;
		}else {
			do {
				System.out.println("Please insert a TXT file ONLY!");
				path = ReadInfoUser.readString("Insert only path that contains a TXT to read");
			} while (!path.toLowerCase().endsWith(".txt"));			
		}
	

		String fileName = path;
		File file = new File(fileName);
		if(!file.exists()) {
			do {
				System.out.println("That file doesnt exists!");
				path = ReadInfoUser.readString("Please: insert a directory that exists in your computer");
				fileName = path;
			} while (!file.exists());	
			file = new File(fileName);
		}
		int initialLength = 0;
		try {

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			short counter = 0;
			while ((line = br.readLine()) != null) {
				if(line.isEmpty()) {
					System.out.println("The file is empty");
				}else if (!line.contains("1") && !line.contains("0")) {
					System.out.println("Invalid characters, the line contains invalid char, only insert 1 and 0");
				}
				else {
					image.addLine(line, counter);
					counter++;
				}
				
				
			}
			br.close();
			fr.close();			

		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return image;

	}

	public static String readString(String message) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		input.close();
		return text;
		

	}
}
