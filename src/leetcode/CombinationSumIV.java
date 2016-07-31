package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
	Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
	
	Example:
	
	nums = [1, 2, 3]
	target = 4
	
	The possible combination ways are:
	(1, 1, 1, 1)
	(1, 1, 2)
	(1, 2, 1)
	(1, 3)
	(2, 1, 1)
	(2, 2)
	(3, 1)
	
	Note that different sequences are counted as different combinations.
	
	Therefore the output is 7.
	
	Follow up:
	What if negative numbers are allowed in the given array?
	How does it change the problem?
	What limitation we need to add to the question to allow negative numbers? 
*/

public class CombinationSumIV {
	
	public int combinationSum4(int[] nums, int target) {
		// mem could be replaced by a HashMap<Integer, Integer>
		int[] mem = new int[target + 1];
		Arrays.fill(mem, -1);
		mem[0] = 1;
		return dpComb(nums, target, mem);
    }
	
	private int dpComb(int[] nums, int target, int[] mem) {
		if (target < 0) {
			return 0;
		}
		if (mem[target] != -1) {
			return mem[target];
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res += dpComb(nums, target - nums[i], mem);
		}
		mem[target] = res;
		return res;
	}
	
	public int combinationSum4B(int[] nums, int target) {
		if (target < 0) {
			return 0;
		}
		if (target == 0) {
			return 1;
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res += combinationSum4(nums, target - nums[i]);
		}
		return res;
    }
	
	public int combinationSum4A(int[] nums, int target) {
		Arrays.sort(nums);
        HashSet<ArrayList<Integer>> res = findComb(nums, 0, target);
        System.out.println(res);
        return res.size();
    }
	
	private HashSet<ArrayList<Integer>> findComb(int[] nums, int start, int target) {
		HashSet<ArrayList<Integer>> res = new HashSet<>();
		if (start >= nums.length || target < nums[start]) {
			ArrayList<Integer> emp = new ArrayList<>();
			if (target == 0) {
				res.add(emp);
			}
			return res;
		}
		for (int i = start; i < nums.length; i++) {
			HashSet<ArrayList<Integer>> subSet = findComb(nums, 0, target - nums[i]);
			for (ArrayList<Integer> sub : subSet) {
				ArrayList<Integer> cur_list = new ArrayList<>();
				cur_list.add(nums[i]);
				cur_list.addAll(sub);
				res.add(cur_list);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		CombinationSumIV test = new CombinationSumIV();
		int[] nums = new int[] {1, 2, 3};
		int target = 4;
		int res = test.combinationSum4(nums, target);
		System.out.println(res);
	}

}

