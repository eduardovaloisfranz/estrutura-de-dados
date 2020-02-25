package ed01;


public class BuscaPorPadrao {
	public static void main(String[] args) {		
		
		Image imageUser = ReadInfoUser.getInfoTxtFromPath("C:\\Users\\casa\\Documents\\GitHub\\estrutura-de-dados\\estruturaDeDados\\src\\ed01\\vectors.txt");		
		
               System.out.println(ImagemUtil.verificaPadrao(imageUser, 1));
               System.out.println(ImagemUtil.contarPadrao(imageUser, 1));
                
              
               
               
               
                
                ImagemUtil.loadPattern();
                System.out.println(imageUser.toString());
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        System.out.print(ImagemUtil.patterns.get(1).getImage()[i][j]);
                    }
                    System.out.print("\n");
                    
                }
            
                        
		
	}
}
