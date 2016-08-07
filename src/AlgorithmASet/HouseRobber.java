package AlgorithmASet;
/*
	You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
	the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and 
	it will automatically contact the police if two adjacent houses were broken into on the same night.
	
	Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
	money you can rob tonight without alerting the police.
 */

public class HouseRobber {
	
	public int rob(int[] nums) {
        int len = nums.length;
        if (len < 1) {
        	return 0;
        }
        int[] mem = new int[len + 1];
        mem[0] = 0;
        mem[1] = nums[0];
        for (int i = 1; i < len; i++) {
        	mem[i + 1] = Math.max(mem[i], mem[i - 1] + nums[i]);
        }
        return mem[len];
    }

	public static void main(String[] args) {
		HouseRobber test = new HouseRobber();
		int[] nums = {1, 3, 4, 2, 9, 3, 5, 6, 3};
		System.out.println(test.rob(nums));
	}

}
