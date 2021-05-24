package easy;

import java.util.*;

//Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
//
//You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all
//of them with no order requirement. You could assume there always exists an answer.
//
// 
//
//Example 1:
//
//Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse",
//                                                                          "Shogun"]
//Output: ["Shogun"]
//Explanation: The only restaurant they both like is "Shogun".
//Example 2:
//
//Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
//Output: ["Shogun"]
//Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
//Example 3:
//
//Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Burger King","Tapioca Express","Shogun"]
//Output: ["KFC","Burger King","Tapioca Express","Shogun"]
//Example 4:
//
//Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KNN","KFC","Burger King","Tapioca Express","Shogun"]
//Output: ["KFC","Burger King","Tapioca Express","Shogun"]
//Example 5:
//
//Input: list1 = ["KFC"], list2 = ["KFC"]
//Output: ["KFC"]
// 
//
//Constraints:
//
//1 <= list1.length, list2.length <= 1000
//1 <= list1[i].length, list2[i].length <= 30
//list1[i] and list2[i] consist of spaces ' ' and English letters.
//All the stings of list1 are unique.
//All the stings of list2 are unique.

public class MinimumIndexSumOfTwoList {
	
	public String[] solution(String[] list1, String[] list2) {
		
		HashMap<String , Integer> getIndexOfList1 = new HashMap<>(); 
		for(int i = 0 ; i < list1.length ; i ++) {
			getIndexOfList1.put(list1[i], i); 
		}
		
		int minSum = Integer.MAX_VALUE; 
		ArrayList<String> result = new ArrayList<>(); 
		
		for(int i = 0 ; i < list2.length ; i ++) {
			if(getIndexOfList1.containsKey(list2[i])) {
				int sum = getIndexOfList1.get(list2[i]) + i; 
				
				if(sum < minSum) {
					result.clear(); 
					result.add(list2[i]); 
					minSum = sum; 
				}else if(sum == minSum) {
					result.add(list2[i]); 
				}
			}
		}
	
		System.out.println(result.toString());
		return result.toArray(new String[result.size()]); 
	}
	
	
	public static void main(String[] args) {
		MinimumIndexSumOfTwoList test1 = new MinimumIndexSumOfTwoList();
		
		test1.solution(
				new String [] { "Shogun","Tapioca Express","Burger King","KFC" }, 
				new String [] {  "Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"}
				);
		
		test1.solution(
				new String [] { "Shogun","Tapioca Express","Burger King","KFC" }, 
				new String [] {  "KFC","Shogun","Burger King"}
				);
		
		test1.solution(
				new String [] { "Shogun","Tapioca Express","Burger King","KFC" }, 
				new String [] { "KNN","KFC","Burger King","Tapioca Express","Shogun" }
				);
	}
	
	

}


