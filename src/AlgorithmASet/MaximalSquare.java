package AlgorithmASet;

import java.util.ArrayList;

/*
	Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
	
	For example, given the following matrix:
	
	1 0 1 0 0
	1 0 1 1 1
	1 1 1 1 1
	1 0 0 1 0
	Return 4.
 */

public class MaximalSquare {
	
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		if (m == 0) {
			return 0;
		}
		int n = matrix[0].length;
		if (n == 0) {
			return 0;
		}
		int[][] mem = new int[m][n];
		int side = 0;
		for (int i = 0; i < m; i++) {
			mem[i][0] = matrix[i][0] - '0';
			side = Math.max(side, mem[i][0]);
		}
		for (int j = 0; j < n; j++) {
			mem[0][j] = matrix[0][j] - '0';
			side = Math.max(side, mem[0][j]);
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					mem[i][j] = Math.min(mem[i - 1][j - 1], Math.min(mem[i - 1][j], mem[i][j - 1])) + 1;
					side = Math.max(side, mem[i][j]);
				}
			}
		}
		return side * side;
	}
	
	public int maximalSquare2(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        if (m == 0) {
        	return res;
        }
        int n = matrix[0].length;
        if (n == 0) {
        	return res;
        }
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == '0') {
        			continue;
        		}
        		int[] newbs = getNewBounds(i ,j , m ,n);
        		int mm = newbs[0], nn = newbs[1];
        		for (int ii = i; ii < mm; ii++) {
        			for (int jj = j; jj < nn; jj++) {
        				if (matrix[ii][jj] == '0') {
        					res = Math.max(res, getBiggerSq(i, j, ii, jj, mm, nn));
        					int[] tmpB = getNewBounds(i, j, mm, jj);
        					mm = tmpB[0];
        					nn = tmpB[1];
        				}
        			}
        		}
        		res = Math.max(res, (nn - j) * (nn - j));
        	}
        }
        return res;
    }
	
	private int getBiggerSq(int i, int j, int iz, int jz, int ib, int jb) {
		int sideT = Math.min(iz - i, jb - j);
		int sideL = Math.min(jz - j, iz - i + 1);
		int side = Math.max(sideT, sideL);
		return side * side;
	}
	
	private int[] getNewBounds(int i, int j, int ib, int jb) {
		if (ib - i < jb - j) {
			jb = j + ib - i;
		}
		else {
			ib = i + jb - j;
		}
		return new int[] {ib, jb};
	}
	
	private char[][] stringToArr(String[] sa) {
		char[][] matrix = new char[sa.length][sa[0].length()];
		int i = 0, j = 0;
		for (String si : sa) {
			j = 0;
			for (char c : si.toCharArray()) {
				matrix[i][j++] = c;
			}
			i++;
		}
		return matrix;
	}

	public static void main(String[] args) {
		MaximalSquare test = new MaximalSquare();
		String[] sa1 = {"10100",
						"10111",
						"00111"};
		String[] sa2 = {"01101",
						"11010",
						"01110",
						"11110",
						"11111",
						"00000"};
		String[] sa3 = {"0010",
						"1111",
						"1111",
						"1110",
						"1100",
						"1111",
						"1110"};
		String[] sa4 = {"101001110",
					   	"111000001",
					   	"001100011",
					   	"011001001",
					   	"110110010",
					   	"011111101",
					   	"101110010",
					   	"111010001",
					   	"011110010",
					   	"100111000"};
		char[][] matrix1 = test.stringToArr(sa1);
		char[][] matrix2 = test.stringToArr(sa2);
		char[][] matrix3 = test.stringToArr(sa3);
		char[][] matrix4 = test.stringToArr(sa4);
		
		ArrayList<char[][]> ms = new ArrayList<>();
		ms.add(matrix1);
		ms.add(matrix2);
		ms.add(matrix3);
		ms.add(matrix4);
		for (int id = 0; id < ms.size(); id++) {
			int res = test.maximalSquare(ms.get(id));
			System.out.println(res);
		}
	}

}
