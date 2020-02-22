package ed01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadInfoUser {
	public static String getInfoTxtFromPath(String pathTxt) {
		String imageArray = "";

		String path = "";
		do {
			System.out.println("Please insert a TXT file ONLY!");
			path = ReadInfoUser.readString("Insert only path that contains a TXT to read");
		} while (path.toLowerCase().endsWith(".txt"));

		String fileName = path;
		File file = new File(fileName);
		try {

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			short counter = 0;
			while ((line = br.readLine()) != null) {
				if(line.isEmpty()) {
					System.out.println("The file is empty");
				}else if(line.length() != 17) {
					System.out.println("The file have invalid format, try put in the right pattern");
				}else if (counter > 1) {
					System.out.println("Your txt contains more than one pattern, the image that will be used is: " + imageArray + " the: " + line + " is ignorated");
				}
				
				counter++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return imageArray;

	}

	public static String readString(String message) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		return text;

	}
}
