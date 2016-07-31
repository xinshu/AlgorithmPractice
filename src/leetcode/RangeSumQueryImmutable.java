package leetcode;

import java.util.ArrayList;

/*
	Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
	
	Example:
	
	Given nums = [-2, 0, 3, -5, 2, -1]
	
	sumRange(0, 2) -> 1
	sumRange(2, 5) -> -1
	sumRange(0, 5) -> -3
	
	Note:
	
	    You may assume that the array does not change.
	    There are many calls to sumRange function.
 
*/

public class RangeSumQueryImmutable {
	
	private int[] accuNums;
	
	public RangeSumQueryImmutable(int[] nums) {
        accuNums = new int[nums.length];
        if (nums != null && nums.length > 0) {
        	accuNums[0] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
        	accuNums[i] = accuNums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
        	return accuNums[j];
        }
        return accuNums[j] - accuNums[i - 1];
    }
    
 // Your NumArray object will be instantiated and called as such:
 // NumArray numArray = new NumArray(nums);
 // numArray.sumRange(0, 1);
 // numArray.sumRange(1, 2);

	public static void main(String[] args) {
		int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
		RangeSumQueryImmutable test = new RangeSumQueryImmutable(nums);
		ArrayList<Integer> res = new ArrayList<>();
		res.add(test.sumRange(0, 2));
		res.add(test.sumRange(2, 5));
		res.add(test.sumRange(0, 5));
		System.out.println(res);
	}

}
