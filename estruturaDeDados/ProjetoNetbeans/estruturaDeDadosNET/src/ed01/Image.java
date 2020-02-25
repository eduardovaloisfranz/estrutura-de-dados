package ed01;

import java.util.Arrays;

public class Image {
	public Integer Image[][] = new Integer[16][16];
	

	public void addLine(String line, int column) {
		int index = 0;
		for(char c : line.toCharArray()) {
			this.Image[column][index] =  Integer.parseInt(String.valueOf(c));
			index++;
			//image.addNumber(Integer.parseInt(String.valueOf(c)));
			//image.add
		}
		
		
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
