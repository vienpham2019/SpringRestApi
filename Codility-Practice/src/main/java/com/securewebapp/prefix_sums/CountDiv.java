package com.securewebapp.prefix_sums;

//Write a function:
//
//that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
//
//{ i : A ≤ i ≤ B, i mod K = 0 }
//
//For example, for A = 6, B = 11 and K = 2, your function should return 3, 
//because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
//
//Write an efficient algorithm for the following assumptions:
//
//A and B are integers within the range [0..2,000,000,000];
//K is an integer within the range [1..2,000,000,000];
//A ≤ B.

public class CountDiv {
	public int solution(int A, int B, int K) {
		
		// check if A == B then see one of them can divide by K then return 1 or 0 
		if(A == B) return A % K == 0 ? 1 : 0; 
		
		// get base number the fist number in range A to B that K can divide 
		int baseNum = (int)Math.ceil(A / (double)K) * K; 
		
		// update the B to make range from 1 to B - base number 
		B -= baseNum; 
		
		// get how many number that can divide to K from 1 to B - base 
		// example if A = 1 ; B = 8 ; and K = 2 so  we have 4 number that can divide by 2 or by K 2,4,6,8 
		// base number = A / 2 = 1 * K = 2 so 2 is a first number can divide by 2 
		// new B = B - base = 8 - 2 = 6; 
		// result = 6 / K = 6 / 2 = 3 + one more because get new B 
		int result = (int)(B / (double)K) + 1; 
		
		return result; 
	}
	
	public static void main(String[] args) {
		System.out.println(new CountDiv().solution(10, 10, 12));
	}
}
