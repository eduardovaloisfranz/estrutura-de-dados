package ed01;

import java.util.Arrays;

public class Image {
	public Integer Image[][] = new Integer[100][100];
	

	public void addLine(String line, int column) {
		int index = 0;
		if(this.Image.length - column < 5 || line.length() < 5) {
			this.resizeArray2D();
		}
		for(char c : line.toCharArray()) {
			this.Image[column][index] =  Integer.parseInt(String.valueOf(c));
			index++;
			//image.addNumber(Integer.parseInt(String.valueOf(c)));
			//image.add
		}
		
		
	}
	
	private void resizeArray2D() {
		Integer[][] tempArray = new Integer[this.Image.length + 60][this.Image.length + 60];
		for(int i = 0; i < this.Image.length; i++) {
			for(int j = 0; i < this.Image.length; i++) {
				tempArray[i][j] = Image[i][j];
			}
		}
		this.Image = tempArray;
	}

	public void exibirArray() {
	
		System.out.println(Arrays.deepToString(this.Image).replace("],", "],\n"));
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.deepToString(this.Image).replace("],", "],\n");
	}
	
	public Integer[][] getImage() {
		//return this.lines;
		return this.Image;
	}
	

}
