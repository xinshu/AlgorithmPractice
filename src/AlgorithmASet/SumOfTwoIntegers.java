package AlgorithmASet;
/*
	Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
	
	Example:
	Given a = 1 and b = 2, return 3.
 */

public class SumOfTwoIntegers {
	
	public int getSum(int a, int b) {
        if (b == 0) {
        	return a;
        }
        if (a == 0) {
        	return b;
        }
        return getSum(a ^ b, (a & b) << 1);
    }

	public static void main(String[] args) {
		SumOfTwoIntegers test = new SumOfTwoIntegers();
		int a = -124, b = -917;
		System.out.println(test.getSum(a, b));
	}

}
