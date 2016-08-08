package AlgorithmASet;
/*
	Given a positive integer num, write a function which returns True if num is a perfect square else False.
	
	Note: Do not use any built-in library function such as sqrt.
	
	Example 1:
	
	Input: 16
	Returns: True
	Example 2:
	
	Input: 14
	Returns: False
 */

public class IsPerfectSquare {
	
	public boolean isPerfectSquare(int num) {
        int start = 1, end = num;
        while (start < end) {
        	int sr = start + (end - start) / 2;
        	int rem = num / sr;
        	if (rem == sr) {
        		return sr * sr == num;
        	}
        	else if (rem > sr) {
        		start = sr + 1;
        	}
        	else {
        		end = sr;
        	}
        }
        if (start == end) {
        	return start * start == num;
        }
        return false;
    }

	public static void main(String[] args) {
		IsPerfectSquare test = new IsPerfectSquare();
		int[] nums = new int[] {1, 2, 4, 8, 9, 11, 14, 16, 25, 81, 79, 808201};
//		int[] nums = new int[] {808201};
		for (int i : nums) {
			System.out.println(test.isPerfectSquare(i));
		}
	}

}
