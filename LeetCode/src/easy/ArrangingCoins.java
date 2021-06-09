package easy;

//You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly 
//i coins. The last row of the staircase may be incomplete.
//
//Given the integer n, return the number of complete rows of the staircase you will build.
//
// 
//
//Example 1:
//	o
//	o o
//	o o _
//Input: n = 5
//Output: 2
//Explanation: Because the 3rd row is incomplete, we return 2.
//		
//Example 2:
//	o
//	o o
//	o o o
//	o o o - -
//Input: n = 8
//Output: 3
//Explanation: Because the 4th row is incomplete, we return 3.
// 
//
//Constraints:
//
//1 <= n <= 231 - 1

//solution: 
//If we look deeper into the formula of the problem, we could actually solve it with the help of mathematics, without using any iteration.
//
//As a reminder, the constraint of the problem can be expressed as follows:
//k(k + 1) < or = 2N; 
//
//This could be solved by completing the square technique,
//(k + 1/2)^2 - 1/4 < or = 2N; 
//
//
//that results in the following answer:
//k = sqrt(2n + 1/4) - 1/2; 





public class ArrangingCoins {
	public int solution(int n) {
		return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5); 
	}
	
	public static void main(String [] args) {
		System.out.println(new ArrangingCoins().solution(8));
	}
}




