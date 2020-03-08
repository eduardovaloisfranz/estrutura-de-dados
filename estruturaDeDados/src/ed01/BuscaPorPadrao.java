package ed01;


public class BuscaPorPadrao {
	public static void main(String[] args) {			
		short counterElements = 0;			
		for(int i = 0; i < args.length; i++) {
			counterElements++;
		}	
			
		ImagemUtil.loadPattern();
		String path = "";		
		if(counterElements != 2 && counterElements != 4) {
			System.out.println("Invalid parameters, try again");
		}else if(counterElements == 2) {			
			if(args[0].equalsIgnoreCase("-location") && ((args[1].startsWith("C:")) && (args[1].endsWith(".txt")))){
				path = args[1];
				Image image = ReadInfoUser.getInfoTxtFromPath(path);				
				System.out.println("Your image is:\n " + image + "\nThe pattern to find in image is\n: " + ImagemUtil.patterns.get(0));
				boolean imageContainsPattern = ImagemUtil.verificaPadrao(image, 1);
				System.out.println("Image above contains the pattern? " + imageContainsPattern);
				if(!imageContainsPattern) {
					System.out.println("The image Above doenst contains the pattern");
				}else {
					System.out.println("Quantity of patterns was found in your image is: " + ImagemUtil.contarPadrao(image, 0));	
				}				
			}else {
				System.out.println("You provided invalid arguments that is necessary in this application");
			}
		}else if(counterElements == 4) {
			if(args[0].equalsIgnoreCase("-location") && 
					((args[1].startsWith("C:")) && (args[1].endsWith(".txt"))) && 
					args[2].equalsIgnoreCase("[-pattern") && 
					((args[3].endsWith("]") && isNumeric(args[3].substring(0, 1))))
					){
				path = args[1];				
				int patternNumber = Integer.parseInt(args[3].substring(0, 1));
				if(patternNumber < 1 || patternNumber > 3) {
					patternNumber = 0;
				}else {
					patternNumber--;	
				}				
				Image image = ReadInfoUser.getInfoTxtFromPath(path);				
				System.out.println("Your image is:\n " + image + "\nThe pattern to find in image is:\n " + ImagemUtil.patterns.get(patternNumber));
				boolean imageContainsPattern = ImagemUtil.verificaPadrao(image, patternNumber);
				System.out.println("Image above contains the pattern? " + imageContainsPattern);
				if(!imageContainsPattern) {
					System.out.println("The image Above doenst contains the pattern");
				}else {
					System.out.println("Quantity of patterns was found in your image is: " + ImagemUtil.contarPadrao(image, patternNumber));	
				}
				
			}else {
				System.out.println("You provided invalid arguments that is necessary in this application");
				//System.out.println(args[2] +" " + args[3]);
				System.out.println(((args[3].endsWith("]") && isNumeric(args[3].substring(0, 1)))));
				System.out.println(args[1].startsWith("C:") && args[1].endsWith(".txt"));
				System.out.println(args[2].equalsIgnoreCase("[-pattern"));
			}
		}else {
			System.out.println("You provided invalid quantity of arguments for this application");
		}
	}
	private static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

}
