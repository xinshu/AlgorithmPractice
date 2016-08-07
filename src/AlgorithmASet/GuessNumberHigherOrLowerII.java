package AlgorithmASet;


/*
	We are playing the Guess Game. The game is as follows:
	
	I pick a number from 1 to n. You have to guess which number I picked.
	
	Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
	
	However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
	
	Example:
	
	n = 10, I pick 8.
	
	First round:  You guess 5, I tell you that it's higher. You pay $5.
	Second round: You guess 7, I tell you that it's higher. You pay $7.
	Third round:  You guess 9, I tell you that it's lower. You pay $9.
	
	Game over. 8 is the number I picked.
	
	You end up paying $5 + $7 + $9 = $21.
	
	Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */

public class GuessNumberHigherOrLowerII {

	public int getMoneyAmount(int n) {
		int[][] mem = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				mem[i][j] = Integer.MAX_VALUE;
			}
		}
		return dpr(1, n, mem);
    }
	
	private int dpr(int i, int j, int[][] mem) {
		if (mem[i][j] != Integer.MAX_VALUE) {
			return mem[i][j];
		}
		if (i == j) {
			mem[i][j] = 0;
		}
		if (j - i == 1) {
			mem[i][j] = i;
		}
		for (int k = i + 1; k < j; k++) {
			int cur = Math.max(dpr(i, k - 1, mem), dpr(k + 1, j, mem)) + k;
			mem[i][j] = Math.min(mem[i][j], cur);
		}
		return mem[i][j];
	}

	public static void main(String[] args) {
		GuessNumberHigherOrLowerII test = new GuessNumberHigherOrLowerII();
		int n = 12;
		int res = test.getMoneyAmount(n);
		System.out.println(res);
	}

}
