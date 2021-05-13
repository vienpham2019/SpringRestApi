package com.securewebapp;

//A non-empty array A consisting of N integers is given. 
//The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
//
//For example, array A such that:
//
//  A[0] = -3
//  A[1] = 1
//  A[2] = 2
//  A[3] = -2
//  A[4] = 5
//  A[5] = 6
//contains the following example triplets:
//
//(0, 1, 2), product is −3 * 1 * 2 = −6
//(1, 2, 4), product is 1 * 2 * 5 = 10
//(2, 4, 5), product is 2 * 5 * 6 = 60
//Your goal is to find the maximal product of any triplet.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A, returns the value of the maximal product of any triplet.
//
//For example, given array A such that:
//
//  A[0] = -3
//  A[1] = 1
//  A[2] = 2
//  A[3] = -2
//  A[4] = 5
//  A[5] = 6
//the function should return 60, as the product of triplet (2, 4, 5) is maximal.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [3..100,000];
//each element of array A is an integer within the range [−1,000..1,000].


public class MaxProductOfThree {
	
	int[] smallestA = new int[] { Integer.MAX_VALUE , Integer.MAX_VALUE };  
	int[] largestA = new int[] { Integer.MIN_VALUE , Integer.MIN_VALUE , Integer.MIN_VALUE };  
	
	public int solution(int[] A) {
		
		for(int a : A) {
			consisderLargest(a); 
			consisderSmallest(a); 
		}
		
		int product1 = largestA[0] * largestA[1] * largestA[2]; 
		int product2 = largestA[0] * smallestA[0] * smallestA[1]; 
		
		return Math.max(product1, product2); 
	}
	
	public void consisderLargest(int a) {
		if(a > largestA[0]) {
			largestA[2] = largestA[1];
			largestA[1] = largestA[0]; 
			largestA[0] = a; 
		}else if(a > largestA[1]) {
			largestA[2] = largestA[1];
			largestA[1] = a; 
		}else if(a > largestA[2]) {
			largestA[2] = a; 
		}
	}
	
	public void consisderSmallest(int a) {
		if(a < smallestA[0]) {
			smallestA[1] = smallestA[0]; 
			smallestA[0] = a; 
		}else if(a < smallestA[1]) {
			smallestA[1] = a; 
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new MaxProductOfThree().solution(new int[] { 4,5,0,1 }));
	}

}










