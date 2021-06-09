package easy;

//Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
//
//		 
//
//Example 1:
//
//Input: nums = [1,2,3]
//Output: 6
//Example 2:
//
//Input: nums = [1,2,3,4]
//Output: 24
//Example 3:
//
//Input: nums = [-1,-2,-3]
//Output: -6
// 
//
//Constraints:
//
//3 <= nums.length <= 104
//-1000 <= nums[i] <= 1000

public class MaximumProductOfThreeNumbers {
	
	public int solution(int [] nums) {
		
		int max1 = Integer.MIN_VALUE , max2 = Integer.MIN_VALUE , max3 = Integer.MIN_VALUE; 
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE; 
		
		for(int n : nums) {
			if(n > max1) {
				max3 = max2; 
				max2 = max1; 
				max1 = n; 
			}else if(n > max2) {
				max3 = max2; 
				max2 = n; 
			}else if(n > max3) {
				max3 = n; 
			}
			
			if(n < min1) {
				min2 = min1; 
				min1 = n; 
			}else if(n < min2) {
				min2 = n; 
			}
		}
		
		return Math.max(min1 * min2 * max1, max1 * max2 * max3); 
	}
	
	public static void main(String [] args) {
		System.out.println(new MaximumProductOfThreeNumbers().solution(new int [] { -100,-98,-1,2,3,4 }));
	}

}
