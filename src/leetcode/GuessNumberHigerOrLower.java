package leetcode;

/*
	We are playing the Guess Game. The game is as follows:
	
	I pick a number from 1 to n. You have to guess which number I picked.
	
	Every time you guess wrong, I'll tell you whether the number is higher or lower.
	
	You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
	
	-1 : My number is lower
	 1 : My number is higher
	 0 : Congrats! You got it!
	Example:
	n = 10, I pick 6.
	
	Return 6.
 */

public class GuessNumberHigerOrLower {
	private int target;
	
	public GuessNumberHigerOrLower(int t) {
		target = t;
	}
	
	public int guessNumber(int n) {
        int s = 1, e = n;
        int res = s;
        int bias = 1;
        while (e - s > 0) {
            res = s + (e - s) / 2;
            bias = guess(res);
            if (bias == 0) {
                return res;
            }
            else if (bias == 1) {
                e = res - 1;
            }
            else {
                s = res + 1;
            }
        }
        return s;
    }
	
	private int guess(int g) {
		if (g == target) {
			return 0;
		}
		else if (g > target) {
			return 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		GuessNumberHigerOrLower test = new GuessNumberHigerOrLower(9);
		int n = 100;
		int res = test.guessNumber(n);
		System.out.println(res);
	}

}
