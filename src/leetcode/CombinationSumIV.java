package leetcode;

import java.util.ArrayList;
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
        int res = 0;
        
        return res;
    }
	
	private HashSet<ArrayList<Integer>> findComb(int[] nums, int start, int target) {
		HashSet<ArrayList<Integer>> set = new HashSet<>();
		return set;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
