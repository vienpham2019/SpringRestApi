package easy;

//Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit 
//		integer range [-231, 231 - 1], then return 0.
//
//Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//
// 
//
//Example 1:
//
//Input: x = 123
//Output: 321
//Example 2:
//
//Input: x = -123
//Output: -321
//Example 3:
//
//Input: x = 120
//Output: 21
//Example 4:
//
//Input: x = 0
//Output: 0
// 
//
//Constraints:
//
//-231 <= x <= 231 - 1

public class ReverseInteger {
	public int solution(int x) {
		boolean isNegative = x < 0; 
		int result = 0; 
		
		if(isNegative) x *= -1; 
		
		while (x > 0) { 
			if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && x % 10 > 7)) return 0;
            result = (result * 10) + (x % 10);
			x /= 10; 
		}
		
		return isNegative ? result * -1 : result;
	}
	
	public static void main(String[] args) {
		System.out.println(new ReverseInteger().solution(1236469));
	}
}









