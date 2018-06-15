package leetcode.success.tree;

import java.util.Arrays;

public class MaxAreaofIsland {
	private void areaSize(int[][] grid, int rowLen, int colLen, int x, int y, boolean[][] gridVisited, int[] areaSize) {

		if (grid[x][y] == 1&&!gridVisited[x][y]) {
			areaSize[0]++;
			gridVisited[x][y] = true;
		} else {
			return;
		}
		// left
		if (y - 1 >= 0 && grid[x][y-1]==1&&!gridVisited[x][y-1] ) {
			areaSize(grid, rowLen, colLen, x, y - 1, gridVisited, areaSize);
		}
		// right
		if (y + 1 < colLen && grid[x][y+1]==1&&!gridVisited[x][y+1]) {
			areaSize(grid, rowLen, colLen, x, y + 1, gridVisited, areaSize);
		}
		// up
		if (x - 1 >= 0 && grid[x-1][y]==1&&!gridVisited[x-1][y]) {
			areaSize(grid, rowLen, colLen, x - 1, y, gridVisited, areaSize);
		}
		// down
		if (x + 1 < rowLen && grid[x+1][y]==1&&!gridVisited[x+1][y]) {
			areaSize(grid, rowLen, colLen, x + 1, y, gridVisited, areaSize);
		}


	}

	public int maxAreaOfIsland(int[][] grid) {
		int rowLen = grid.length;
		int colLen = grid[0].length;
		int maxAreaSize = 0;
		boolean[][] gridVisited = new boolean[rowLen][colLen];
		for (int i = 0; i < rowLen; i++) {
			Arrays.fill(gridVisited[i], false);
		}

		for (int x = 0; x < rowLen; x++) {
			for (int y = 0; y < colLen; y++) {
				if (grid[x][y] == 1 && !gridVisited[x][y]) {
					int[] areaSize = new int[1];
					areaSize[0] = 0;
					areaSize(grid, rowLen, colLen, x, y, gridVisited, areaSize);
					if (maxAreaSize < areaSize[0]) {
						maxAreaSize = areaSize[0];
					}
				}
			}
		}

		return maxAreaSize;
	}


}
