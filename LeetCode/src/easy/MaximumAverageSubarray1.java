package easy;

//You are given an integer array nums consisting of n elements, and an integer k.
//
//Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a 
//		calculation error less than 10-5 will be accepted.
//
// 
//
//Example 1:
//
//Input: nums = [1,12,-5,-6,50,3], k = 4
// nums : [ 1, 12, -5, -6, 50, 3] 
// sum:   [ 1, 13,  8,  2, 52, 55] 
// res = (nums[k - 1] / k) = 2 / 4 = 0.5 
// res = Math.max(res, sum[i] - sum[i - k] / k) => Math.max(0.5, (52 - 1) / 4) = 12.75 "i = 4" 
// res = Math.max(res, sum[i] - sum[i - k] / k) => Math.max(12.75, (55 - 13) / 4) =  10.5 "i = 5" 
//Output: 12.75000
//Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
//Example 2:
//
//Input: nums = [5], k = 1
//Output: 5.00000
// 
//
//Constraints:
//
//n == nums.length
//1 <= k <= n <= 105
//-104 <= nums[i] <= 104



public class MaximumAverageSubarray1 {
	public double solution(int[] nums, int k) {
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
		sum[i] = sum[i - 1] + nums[i];
		double res = sum[k - 1] * 1.0 / k;
		for (int i = k; i < nums.length; i++) {
			res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
		}
		return res;
	}
	
	public static void main(String [] args ) {
		System.out.println(new MaximumAverageSubarray1().solution(new int [] { 1,12,-5,-6,50,3 }, 4));
	}
}
