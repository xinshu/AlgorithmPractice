package AlgorithmASet;
/*
	Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer
	given in the form of an array.
	
	Example1:
	
	a = 2
	b = [3]
	
	Result: 8
	Example2:
	
	a = 2
	b = [1,0]
	
	Result: 1024
 */

// TODO:
public class SuperPow {
	
	// TODO:
	public int superPow(int a, int[] b) {
        int res = -1;
        
        return res;
    }
	
	// TODO:
	private int[] arrMod(int[] nume, int[] deno) {
		int comp = arrComp(nume, deno);
		if (comp == -1) {
			return nume;
		}
		if (comp == 0) {
			return new int[] {1};
		}
		int[] rem = new int[deno.length];
		
		
		return rem;
	}
	
	private  FirstDigAndMod getFirstDigAndMod(int[] nume, int[] deno) {
		int comp = arrComp(nume, deno);
		FirstDigAndMod res = new FirstDigAndMod();
		// TODO:
		return res;
	}
	
	private int arrComp(int[] num1, int[] num2) {
		if (num1.length < num2.length) {
			return -1;
		}
		if (num1.length == num2.length) {
			for (int i = 0; i < num1.length; i++) {
				if (num1[i] < num2[i]) {
					return -1;
				}
				else if (num1[i] > num2[i]) {
					return 1;
				}
			}
			return 0;
		}
		return 1;
	}
	
	class FirstDigAndMod {
		int FirstDig;
		int[] mod;
		FirstDigAndMod() {
		}
		FirstDigAndMod(int f, int[] m) {
			FirstDig = f;
			mod = m.clone();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
