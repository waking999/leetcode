package leetcode.success.math;

import org.junit.Test;

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		if (grid == null) {
			return 0;
		}
		int r = grid.length;
		if (r == 0) {
			return 0;
		}
		int c = grid[0].length;
		if (c == 0) {
			return 0;
		}
		 
		
		
		int oneCount = 0;
		int conCount = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1) {
					oneCount++;
					if (i == 0 && j == 0) {
						// left top corner
						if (j+1<c&&grid[i][j + 1] == 1) {
							conCount++;
						}
						if (i+1<r&&grid[i + 1][j] == 1) {
							conCount++;
						}
					} else if (i == 0 && j == c - 1) {
						// right top corner
						if (j-1>=0&&grid[i][j - 1] == 1) {
							conCount++;
						}
						if (i+1<r&&grid[i + 1][j] == 1) {
							conCount++;
						}
					} else if (i == r - 1 && j == 0) {
						// left bottom corner
						if (j+1<c&&grid[i][j + 1] == 1) {
							conCount++;
						}
						if (i-1>=0&&grid[i - 1][j] == 1) {
							conCount++;
						}
					} else if (i == r - 1 && j == c - 1) {
						// right bottom corner
						if (i-1>=0&&grid[i - 1][j] == 1) {
							conCount++;
						}
						if (j-1>=0&&grid[i][j - 1] == 1) {
							conCount++;
						}
					} else if (i == 0) {
						// top edge
						if (j+1<c&&grid[i][j + 1] == 1) {
							conCount++;
						}
						if (i+1<r&&grid[i + 1][j] == 1) {
							conCount++;
						}
						if (j-1>=0&&grid[i][j - 1] == 1) {
							conCount++;
						}
					} else if (i == r - 1) {
						// bottom edge
						if (j+1<c&&grid[i][j + 1] == 1) {
							conCount++;
						}
						if (j-1>=0&&grid[i][j - 1] == 1) {
							conCount++;
						}
						if (i-1>=0&&grid[i - 1][j] == 1) {
							conCount++;
						}
					} else if (j == 0) {
						// left edge
						if (j+1<c&&grid[i][j + 1] == 1) {
							conCount++;
						}
						if (i-1>=0&&grid[i - 1][j] == 1) {
							conCount++;
						}
						if (i+1<r&&grid[i + 1][j] == 1) {
							conCount++;
						}
					} else if (j == c - 1) {
						// right edge
						if (i+1<r&&grid[i + 1][j] == 1) {
							conCount++;
						}
						if (i-1>=0&&grid[i - 1][j] == 1) {
							conCount++;
						}
						if (j-1>=0&&grid[i][j - 1] == 1) {
							conCount++;
						}
					} else {
						// middle
						if (i+1<r&&grid[i + 1][j] == 1) {
							conCount++;
						}
						if (i-1>=0&&grid[i - 1][j] == 1) {
							conCount++;
						}
						if (j-1>=0&&grid[i][j - 1] == 1) {
							conCount++;
						}
						if (j+1<c&&grid[i][j + 1] == 1) {
							conCount++;
						}
					}
				}
			}
		}

		return 4 * oneCount - conCount;
	}



}
