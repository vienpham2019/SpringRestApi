package com.securewebapp;

//A non-empty array A consisting of N integers is given. 
//A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements).
//The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. 
//To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
//
//For example, array A such that:
//
//    A[0] = 4
//    A[1] = 2
//    A[2] = 2
//    A[3] = 5
//    A[4] = 1
//    A[5] = 5
//    A[6] = 8
//contains the following example slices:
//
//slice (1, 2), whose average is (2 + 2) / 2 = 2;
//slice (3, 4), whose average is (5 + 1) / 2 = 3;
//slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
//The goal is to find the starting position of a slice whose average is minimal.
//
//Write a function:
//
//that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. 
//If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
//
//For example, given array A such that:
//
//    A[0] = 4
//    A[1] = 2
//    A[2] = 2
//    A[3] = 5
//    A[4] = 1
//    A[5] = 5
//    A[6] = 8
//the function should return 1, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [2..100,000];
//each element of array A is an integer within the range [−10,000..10,000].

// Solution: 
// only calculate 2 slice element or 3 slice element bc 4 slice = 2 slice + 2 slice or as the same 5 slice = 2 slice + 3 slice 
// so calculate smallest 2 slice vs 3 slice and return them index 

public class MinAvgTwoSlice {

	public int solution(int[] A) {
		
		int startIndex2 = -1; 
		int minSumOf2 = Integer.MAX_VALUE; 
		
		int startIndex3 = -1; 
		int minSumOf3 = Integer.MAX_VALUE; 
		
		for(int i = 0; i < A.length - 1 ; i ++) {
			int num1 = A[i]; 
			int num2 = A[i + 1]; 
			int sum2 = num1 + num2; 
			
			if(minSumOf2 > sum2) {
				minSumOf2 = sum2; 
				startIndex2 = i; 
			}
			
			if(i < A.length - 2) {
				if(minSumOf3 > (sum2 + A[i + 2])) {
					minSumOf3 = sum2 + A[i + 2]; 
					startIndex3 = i; 
				}
			}
		}
		
		// if not found start index of sum of 3 then return start index 2 
		if(startIndex3 == -1) return startIndex2; 
		
		// compare avg value of min sum of 2 and min sum of 3 then return the index of smallest average 
		if((minSumOf2 / 2.0) < (minSumOf3 / 3.0)) return startIndex2;
		if((minSumOf3 / 3.0) < (minSumOf2 / 2.0)) return startIndex3;
		
		// if avg of min sum 2 and avg of min sum 3 are the same then return smallest index 
		return Math.min(startIndex3, startIndex2); 
	}
	
	public static void main(String [] args) {
		System.out.println(new MinAvgTwoSlice().solution(new int[] { 4,2,2,5,1,5,8 }));
	}
	
}


















