package AlgorithmASet;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
	Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of
	elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
	
	If there are multiple solutions, return any subset is fine.
	
	Example 1:
	
	nums: [1,2,3]
	
	Result: [1,2] (of course, [1,3] will also be ok)
	Example 2:
	
	nums: [1,2,4,8]
	
	Result: [1,2,4,8]
 */

public class LargestDivisibleSubset {
	
	public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<Integer>());
        int mx_len = 0;
        int mx_ind = 0;
        for (int i = 0; i < nums.length; i++) {
        	int sz = lists.size();
        	int cur_max = 0;
        	int max_ind = 0;
        	for (int j = 0; j < sz; j++) {
        		ArrayList<Integer> sub_list = lists.get(j);
        		if (sub_list.size() > 0 && nums[i] % sub_list.get(sub_list.size() - 1) == 0) {
        			if (cur_max < sub_list.size()) {
        				cur_max = sub_list.size();
        				max_ind = j;
        			}
        		}
        	}
        	ArrayList<Integer> cur = new ArrayList<>(lists.get(max_ind));
        	cur.add(nums[i]);
        	if (cur.size() > mx_len) {
        		mx_len = cur.size();
        		mx_ind = lists.size();
        	}
        	lists.add(cur);
        }
        return lists.get(mx_ind);
    }

	public static void main(String[] args) {
		LargestDivisibleSubset test = new LargestDivisibleSubset();
		int[] nums = new int[] {1, 2, 3, 4, 7, 8, 6, 9, 27, 243};
		System.out.println(test.largestDivisibleSubset(nums));
	}

}
