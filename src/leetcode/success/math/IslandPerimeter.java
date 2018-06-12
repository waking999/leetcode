package leetcode.success.math;

import leetcode.success.comm.Util;

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

	public static void main(String[] args) {
		IslandPerimeter s = new IslandPerimeter();

		int[][] grid;
		int expect;
		int output;

		grid = new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		expect = 16;
		output = s.islandPerimeter(grid);
		Util.verifyUnsort(expect, output, 1);


		grid = new int[][] { {1} };
		expect = 4;
		output = s.islandPerimeter(grid);
		Util.verifyUnsort(expect, output, 2);
	}

}
