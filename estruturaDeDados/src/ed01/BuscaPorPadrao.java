package ed01;


public class BuscaPorPadrao {
	public static void main(String[] args) {		
		
		Image imageUser = ReadInfoUser.getInfoTxtFromPath("C:\\Users\\duduf\\Documents\\GitHub\\estrutura-de-dados\\estruturaDeDados\\src\\ed01\\vectors.txt");		
		//ReadInfoUser.getInfoTxtFromPath(pathTxt)
		ImagemUtil.verificaPadrao(imageUser, 1);
		ImagemUtil.contarPadrao(imageUser, 1);
		
		
		System.out.println(imageUser);
		//ImagemUtil.loadPattern();
		//System.out.println(ImagemUtil.patterns.get(1));
		
	}
}
