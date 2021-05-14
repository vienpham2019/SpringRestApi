package com.securewebapp.leader;

import java.util.HashMap;

//An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
//
//For example, consider array A such that
//
// A[0] = 3    A[1] = 4    A[2] =  3
// A[3] = 2    A[4] = 3    A[5] = -1
// A[6] = 3    A[7] = 3
//The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is 
//more than a half of 8.
//
//Write a function
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. 
//The function should return −1 if array A does not have a dominator.
//
//For example, given array A such that
//
// A[0] = 3    A[1] = 4    A[2] =  3
// A[3] = 2    A[4] = 3    A[5] = -1
// A[6] = 3    A[7] = 3
//the function may return 0, 2, 4, 6 or 7, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [0..100,000];
//each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

public class Dominator {
	
    public int solution(int[] A) { 
    	
    	if(A.length == 1) return 0; // this because only one value in array 
    	
    	HashMap<Integer, Integer> counter = new HashMap<>(); 
    	
    	int maxCount = 0; 
    	int result = -1; 
    	
    	for(int i = 0 ; i < A.length ; i ++) {
    		if(!counter.containsKey(A[i])) counter.put(A[i], 1); 
    		else {
    			counter.replace(A[i], counter.get(A[i]) + 1); 
    			if(counter.get(A[i]) > maxCount) {
    				maxCount = counter.get(A[i]);
    				if(maxCount > A.length / 2)
    					result = i; 
    			}
    		}
    	}
    	
    	return result; 
    }
	
	public static void main (String[] args) {
		System.out.println(new Dominator().solution(new int[] { 3,4,3,2,3,-1,2,2147483647 }));
	}

}
