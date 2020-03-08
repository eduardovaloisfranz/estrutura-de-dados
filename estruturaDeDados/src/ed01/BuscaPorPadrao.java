package ed01;


public class BuscaPorPadrao {
	public static void main(String[] args) {		
		
		Image imageUser = ReadInfoUser.getInfoTxtFromPath("C:\\Users\\duduf\\Documents\\GitHub\\estrutura-de-dados\\estruturaDeDados\\src\\ed01\\vectors.txt");		
		//ReadInfoUser.getInfoTxtFromPath(pathTxt)
		System.out.println(imageUser);
		//imageUser.exibirArray();
		System.out.println(ImagemUtil.verificaPadrao(imageUser, 1));
		System.out.println(ImagemUtil.contarPadrao(imageUser, 1));
		System.out.println(ImagemUtil.patterns.get(1));
		 
		//System.out.println(imageUser);
		//ImagemUtil.loadPattern();
		//System.out.println(ImagemUtil.patterns.get(1));
		
	}
}
