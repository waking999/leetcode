package leetcode.success.tree;

public class FloodFill {
	
	private void color(int[][] image,int rowLen, int colLen, int x, int y, int originColor, int newColor) {
		int xyColor=image[x][y];
		if(xyColor==newColor) {
			//it has been colored
			return;
		}
		if(xyColor!=originColor) {
			//it does not belong to original color area
			return;
		}
		//color it
		image[x][y]=newColor;
	 
		//up
		if(y-1>=0) {
			color(image,rowLen,colLen,x,y-1,originColor,newColor);
		}
		//down
		if(y+1<colLen) {
			color(image,rowLen,colLen,x,y+1,originColor,newColor);
		}
		//left
		if(x-1>=0) {
			color(image,rowLen,colLen,x-1,y,originColor,newColor);
		}
		//right
		if(x+1<rowLen) {
			color(image,rowLen,colLen,x+1,y,originColor,newColor);
		}
	}
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int originColor=image[sr][sc];
		if(originColor==newColor) {
			return image;
		}
		int rowLen=image.length;
		int colLen=image[0].length;
		color(image,rowLen,colLen,sr,sc,originColor,newColor);
		
		
		
		return image;
	}



}
