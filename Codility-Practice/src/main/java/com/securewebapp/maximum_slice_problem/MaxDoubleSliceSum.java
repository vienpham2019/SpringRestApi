package com.securewebapp.maximum_slice_problem;

//A non-empty array A consisting of N integers is given.
//
//A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
//
//The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
//
//For example, array A such that:
//
//    A[0] = 3
//    A[1] = 2
//    A[2] = 6
//    A[3] = -1
//    A[4] = 4
//    A[5] = 5
//    A[6] = -1
//    A[7] = 2
//contains the following example double slices:
//
//double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
//double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
//double slice (3, 4, 5), sum is 0.
//The goal is to find the maximal sum of any double slice.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
//
//For example, given:
//
//    A[0] = 3
//    A[1] = 2
//    A[2] = 6
//    A[3] = -1
//    A[4] = 4
//    A[5] = 5
//    A[6] = -1
//    A[7] = 2
//the function should return 17, because no double slice of array A has a sum of greater than 17.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [3..100,000];
//each element of array A is an integer within the range [−10,000..10,000].

public class MaxDoubleSliceSum {
	public int solution(int[] A) {
		int[] maxStartingHere = new int[A.length];
        int[] maxEndingHere = new int[A.length];
        int len = A.length;

        for(int i = len - 2; i > 0; --i ) {            
        	maxStartingHere[i] = Math.max(0, A[i] + maxStartingHere[i + 1]);
        }
        
        for(int i = 1; i < len - 1; ++i ) {            
        	maxEndingHere[i] = Math.max(0, A[i] + maxEndingHere[i - 1]);
        }
        
        int maxDoubleSlice = 0;

        for(int i = 0; i < len - 2; ++i) {
            maxDoubleSlice = Math.max(maxDoubleSlice, maxEndingHere[i] + maxStartingHere[i+2]);
        }

        return maxDoubleSlice;

	}
	
	public static void main (String[] args) {
		System.out.println(new MaxDoubleSliceSum().solution(new int[] { 3,2,6,-1,4,5,-1,2 }));
	}
}










