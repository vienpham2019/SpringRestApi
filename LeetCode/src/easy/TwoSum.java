package easy;

import java.util.HashMap;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
// 
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
//Constraints:
//
//2 <= nums.length <= 104
//-109 <= nums[i] <= 109
//-109 <= target <= 109
//Only one valid answer exists.
// 
//
//Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

public class TwoSum {
	
	public int[] solution(int[] nums, int target) {
		int[] result = new int [2]; 
		HashMap<Integer , Integer> counter = new HashMap<>(); 
		
		for(int i = 0; i < nums.length ; i++) {
			int num2 = target - nums[i]; 
			if(counter.containsKey(num2)) {
				result[0] = counter.get(num2);
				result[1] = i; 
				break; 
			}
			else counter.put(nums[i], i); 
		}
		return result; 
    }
	
	
	public static void main(String [] args) {
		System.out.println(new TwoSum().solution(new int [] { 2,7,11,5 }, 9));
	}

}







