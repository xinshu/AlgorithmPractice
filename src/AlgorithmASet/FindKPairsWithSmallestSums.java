package AlgorithmASet;
/*
	You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
	
	Define a pair (u,v) which consists of one element from the first array and one element from the second array.
	
	Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
	
	Example 1:
	Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
	
	Return: [1,2],[1,4],[1,6]
	
	The first 3 pairs are returned from the sequence:
	[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
	Example 2:
	Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
	
	Return: [1,1],[1,1]
	
	The first 2 pairs are returned from the sequence:
	[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
	Example 3:
	Given nums1 = [1,2], nums2 = [3],  k = 3 
	
	Return: [1,3],[2,3]
	
	All possible pairs are returned from the sequence:
	[1,3],[2,3]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
	
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<>();
		k = Math.min(k, nums1.length * nums2.length);
        PriorityQueue<Pair> pq = new PriorityQueue<>(1, new Comparator<Pair>() {
        	@Override
        	public int compare(Pair p1, Pair p2) {
        		int sum1 = nums1[p1.first] + nums2[p1.second];
        		int sum2 = nums1[p2.first] + nums2[p2.second];
        		return sum1 - sum2;
        	}
        });
        pq.offer(new Pair(0, 0));
        while (res.size() < k) {
        	Pair cur = pq.poll();
        	res.add(new int[] {nums1[cur.first], nums2[cur.second]});
        	if (cur.first + 1 < nums1.length) {
        		pq.offer(new Pair(cur.first + 1, cur.second));
        	}
        	if (cur.first == 0 && cur.second + 1 < nums2.length) {
        		pq.offer(new Pair(cur.first, cur.second + 1));
        	}
        }
        return res;
    }
	
	class Pair {
		int first;
		int second;
		Pair(int f, int s) {
			first = f;
			second = s;
		}
	}

	public static void main(String[] args) {
		FindKPairsWithSmallestSums test = new FindKPairsWithSmallestSums();
		int[] nums1 = {1, 7, 11}, nums2 = {2, 4, 6};
		int k = 13;
		List<int[]> res = test.kSmallestPairs(nums1, nums2, k);
		for (int[] item : res){
			System.out.println(Arrays.toString(item));
		}
	}

}
