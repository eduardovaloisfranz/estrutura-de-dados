package ed01;

import java.util.ArrayList;
import java.util.Arrays;

public class ImagemUtil {	
	
		
	public static ArrayList<Image> patterns = new ArrayList<>();
	
	 
	public static boolean verificaPadrao(Image imagem, int padrao) {		
		loadPattern();                
		int lineAux = 0;
                int columnAux = 0;
		for(int line = 0; line < imagem.getImage().length; line++) {
			for(int column = 0; column < imagem.getImage().length; column++) {
				if((line < imagem.getImage().length - 3) && (column < imagem.getImage().length - 3)){
                                    if(((imagem.getImage()[line][column]).equals(patterns.get(padrao).getImage()[lineAux][columnAux])) && 
                                            (imagem.getImage()[line][column + 1]).equals(patterns.get(padrao).getImage()[lineAux][columnAux + 1]) && 
                                            (imagem.getImage()[line][column + 2]).equals(patterns.get(padrao).getImage()[lineAux][columnAux + 2]) &&
                                            
                                            (imagem.getImage()[line+ 1][column]).equals(patterns.get(padrao).getImage()[lineAux + 1][columnAux]) && 
                                            (imagem.getImage()[line + 1][column + 1]).equals(patterns.get(padrao).getImage()[lineAux + 1][columnAux + 1]) && 
                                            (imagem.getImage()[line + 1][column + 2]).equals(patterns.get(padrao).getImage()[lineAux + 1][columnAux + 2]) &&
                                            
                                            (imagem.getImage()[line + 2][column]).equals(patterns.get(padrao).getImage()[lineAux + 2][columnAux]) && 
                                            (imagem.getImage()[line + 2][column + 1]).equals(patterns.get(padrao).getImage()[lineAux + 2][columnAux + 1]) && 
                                            (imagem.getImage()[line + 2][column + 2]).equals(patterns.get(padrao).getImage()[lineAux + 2][columnAux + 2])){
                                        return true; 
                                    }                                           
                                                                                    
                                  
                                }			
			}
		}
		
		return false;
	}
	
	public static int contarPadrao(Image imagem, int padrao) {
				loadPattern();
                int counterPattern = 0;
                int lineAux = 0;
                int columnAux = 0;
		for(int line = 0; line < imagem.getImage().length; line++) {
			for(int column = 0; column < imagem.getImage().length; column++) {
				if((line < imagem.getImage().length - 3) && (column < imagem.getImage().length - 3)){
                                    if(((imagem.getImage()[line][column]).equals(patterns.get(padrao).getImage()[lineAux][columnAux])) && 
                                            (imagem.getImage()[line][column + 1]).equals(patterns.get(padrao).getImage()[lineAux][columnAux + 1]) && 
                                            (imagem.getImage()[line][column + 2]).equals(patterns.get(padrao).getImage()[lineAux][columnAux + 2]) &&
                                            
                                            (imagem.getImage()[line+ 1][column]).equals(patterns.get(padrao).getImage()[lineAux + 1][columnAux]) && 
                                            (imagem.getImage()[line + 1][column + 1]).equals(patterns.get(padrao).getImage()[lineAux + 1][columnAux + 1]) && 
                                            (imagem.getImage()[line + 1][column + 2]).equals(patterns.get(padrao).getImage()[lineAux + 1][columnAux + 2]) &&
                                            
                                            (imagem.getImage()[line + 2][column]).equals(patterns.get(padrao).getImage()[lineAux + 2][columnAux]) && 
                                            (imagem.getImage()[line + 2][column + 1]).equals(patterns.get(padrao).getImage()[lineAux + 2][columnAux + 1]) && 
                                            (imagem.getImage()[line + 2][column + 2]).equals(patterns.get(padrao).getImage()[lineAux + 2][columnAux + 2])){
                                        counterPattern++; 
                                    }
                                                                              
                                }			
			}
		}
            return counterPattern;
	}
	
	
	public static void loadPattern() {
		if(patterns.isEmpty()) {
			Image pattern1 = new Image();
			pattern1.addPatternLine("010", 0);
			pattern1.addPatternLine("111", 1);
			pattern1.addPatternLine("010", 2);
			patterns.add(pattern1);
			
			Image pattern2 = new Image();
			pattern2.addPatternLine("111", 0);
			pattern2.addPatternLine("010", 1);
			pattern2.addPatternLine("010", 2);
			patterns.add(pattern2);
			
			Image pattern3 = new Image();
			pattern3.addPatternLine("001", 0);
			pattern3.addPatternLine("010", 1);
			pattern3.addPatternLine("100", 2);
			patterns.add(pattern3);	
		}
		
				
			
	}
	

}
