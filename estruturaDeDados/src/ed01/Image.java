package ed01;

import java.util.Arrays;

public class Image {
	public Integer Image[][];
	
 
	public void addLine(String line, int column) {
		int index = 0;		
		for(char c : line.toCharArray()) {
			this.Image[column][index] =  Integer.parseInt(String.valueOf(c));
			index++;
			//image.addNumber(Integer.parseInt(String.valueOf(c)));
			//image.add
		}
	}
	public void addPatternLine(String line, int column) {
		if(this.Image == null) {
			this.Image = new Integer[3][3];			
		}		
		this.addLine(line, column);
		
	}
	public void addLine(String line, int column, int quantityLines, int quantityColumns) {
		this.Image = new Integer[quantityLines][quantityColumns];
		addLine(line, column);
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
