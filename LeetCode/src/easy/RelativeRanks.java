package easy;

import java.util.Arrays;

//You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are 
//guaranteed to be unique.
//
//The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd 
//highest score, and so on. The placement of each athlete determines their rank:
//
//The 1st place athlete's rank is "Gold Medal".
//The 2nd place athlete's rank is "Silver Medal".
//The 3rd place athlete's rank is "Bronze Medal".
//For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
//Return an array answer of size n where answer[i] is the rank of the ith athlete.
//
// 
//
//Example 1:
//
//Input: score = [5,4,3,2,1]
//Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
//Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
//Example 2:
//
//Input: score = [10,3,8,9,4]
//Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
//Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
//
// 
//
//Constraints:
//
//n == score.length
//1 <= n <= 104
//0 <= score[i] <= 106
//All the values in score are unique.

public class RelativeRanks {
	public String[] solution(int[] score) {
		String[] result = new String[score.length]; 
		int [][] rememberElement = new int [score.length][2]; 
		for(int i = 0; i < score.length ; i ++) {
			rememberElement[i][0] = score[i]; 
			rememberElement[i][1] = i; 
		}
		
		Arrays.sort(rememberElement , (a,b) -> b[0] - a[0]);
		
		for(int i = 0; i < score.length ; i ++) {
			String rank = ""; 
			if(i == 0)  rank = "Gold Medal"; 
			else if(i == 1) rank = "Silver Medal"; 
			else if(i == 2) rank = "Bronze Medal"; 
			else rank = "" + (i + 1) ; 
				
			result[rememberElement[i][1]] = rank; 
		}
	
		return result;
	}
	
	public static void main(String [] args) {
		int [] score = new int [] { 10,3,8,9,4 }; 
		String [] result = new RelativeRanks().solution(score); 
		
		for(String rank : result) {
			System.out.println(rank);
		}
	}
}







