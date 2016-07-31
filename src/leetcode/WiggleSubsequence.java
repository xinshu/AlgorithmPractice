package leetcode;

/*
	A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
	
	For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
	
	Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
	
	Examples:
	
	Input: [1,7,4,9,2,5]
	Output: 6
	The entire sequence is a wiggle sequence.
	
	Input: [1,17,5,10,13,15,10,5,16,8]
	Output: 7
	There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
	
	Input: [1,2,3,4,5,6,7,8,9]
	Output: 2
	
	Follow up:
	Can you do it in O(n) time? 
*/

public class WiggleSubsequence {
	
	public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end && nums[start + 1] == nums[start]) {
            ++start;
        }
        if (start == end) {
            return 1;
        }
        int peakValleyCnt = 0;
        int preDiff = nums[start + 1] - nums[start];
        for (int i = start + 1; i < end; i++) {
        	if (i + 1 < end && nums[i + 1] == nums[i]) {
        		continue;
        	}
            int curDiff = nums[i] - nums[i + 1];
            if ((preDiff > 0 && curDiff > 0) || (preDiff < 0 && curDiff < 0)) {
                ++peakValleyCnt;
            }
            preDiff = -curDiff;
        }
        return peakValleyCnt + 2;
    }
	
	public int wiggleMaxLength2(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
		int k = 0;
		while (k < nums.length - 1 && nums[k] == nums[k + 1]) {  //Skips all the same numbers from series beginning eg 5, 5, 5, 1
			k++;
		}
		if (k == nums.length - 1) {
			return 1;
		}
		int result = 2;     // This will track the result of result array
		boolean smallReq = nums[k] < nums[k + 1];       //To check series starting pattern
		for (int i = k + 1; i < nums.length - 1; i++) {
			if (smallReq && nums[i + 1] < nums[i]) {
				nums[result] = nums[i + 1];
				result++;
				smallReq = !smallReq;    //Toggle the requirement from small to big number
			} else {
				if (!smallReq && nums[i + 1] > nums[i]) {
					nums[result] = nums[i + 1];
					result++;
					smallReq = !smallReq;    //Toggle the requirement from big to small number
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		WiggleSubsequence test = new WiggleSubsequence();
		int[] nums = new int[] {51,226,208,165,202,286,190,212,219,271,36,245,20,238,238,89,105,66,73,9,254,206,221,237,203,33,249,253,150,102,57,249,203,10,123,178,85,203,35,276,129,116,37,163,99,142,187,249,134,77,217,298,29,127,174,115,122,178,12,80,122,76,16,41,115,84,104,121,127,40,287,129,9,172,112,51,40,135,205,53,259,196,248,5,123,184,209,130,271,42,18,143,24,101,10,273,252,50,173,80,119,129,45,257,299,78,278,78,190,215,284,129,200,232,103,97,167,120,49,298,141,146,154,233,214,196,244,50,110,48,152,82,226,26,254,276,292,286,215,56,128,122,82,241,222,12,272,192,224,136,116,70,39,207,295,49,194,90,210,123,271,18,276,87,177,240,276,33,155,200,51,6,212,36,149,202,48,114,58,91,83,221,175,148,278,300,284,86,191,95,77,215,113,257,153,135,217,76,85,269,126,194,199,195,20,204,194,50,220,228,90,221,256,87,157,246,74,156,9,196,16,259,234,79,31,206,148,12,223,151,96,229,165,9,144,26,255,201,33,89,145,155,1,204,37,107,80,212,88,186,254,9,158,180,24,45,158,100,52,131,71,174,229,236,296,299,184,168,41,45,76,68,122,85,292,238,293,179,143,128,47,87,267,53,187,76,292,0,160,70,172,292,9,64,156,153,26,145,196,222};
		System.out.println(test.wiggleMaxLength(nums));
		System.out.println(test.wiggleMaxLength2(nums));
	}

}
