package ed01;

import java.util.ArrayList;
import java.util.Arrays;

public class ImagemUtil {	
	
		
	public static ArrayList<Image> patterns = new ArrayList<>();
	
	
	public static boolean verificaPadrao(Image imagem, int padrao) {
		int counter = 0, counterLine = 0;
		int linesWasFound[] = new int[3];
		loadPattern();
		int lineAUX = 0, columnAUX = 0;
		for(int line = 0; line < imagem.getImage().length; line++) {
			for(int column = 0; column < imagem.getImage().length; column++) {
				
				if(lineAUX > 3) {
					lineAUX = 0;
				}
				if(columnAUX > 3) {
					columnAUX = 0;
				}				
				if(imagem.getImage()[line][column] == patterns.get(1).getImage()[lineAUX][columnAUX]) {					
				
				}
				System.out.println(patterns.get(padrao).getImage()[lineAUX][columnAUX]);
								
				lineAUX++;
				columnAUX++;
				//counter++;
			}
		}
		
		return false;
	}
	
	public static int contarPadrao(Image imagem, int padrao) {
		return 1;
	}
	
	
	public static void loadPattern() {
		if(patterns.isEmpty()) {
			Image pattern1 = new Image();
			pattern1.addLine("010", 0);
			pattern1.addLine("111", 1);
			pattern1.addLine("010", 2);
			patterns.add(pattern1);
			
			Image pattern2 = new Image();
			pattern2.addLine("111", 0);
			pattern2.addLine("010", 1);
			pattern2.addLine("010", 2);
			patterns.add(pattern2);
			
			Image pattern3 = new Image();
			pattern3.addLine("001", 0);
			pattern3.addLine("010", 1);
			pattern3.addLine("100", 2);
			patterns.add(pattern3);	
		}
		
				
			
	}
	

}