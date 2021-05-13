package com.securewebapp;

//A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
//
//For example, number 9 has binary representation 1001 and contains a binary gap of length 2. 
//The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. 
//The number 20 has binary representation 10100 and contains one binary gap of length 1. 
//The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
//
//Write a function:
//
//class Solution { public int solution(int N); }
//
//that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
//
//For example, given N = 1041 the function should return 5, 
//because N has binary representation 10000010001 and so its longest binary gap is of length 5. 
//Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..2,147,483,647].


// Solution; 
//N = 32 
//= 2  			%= 2
//32 			0
//16			0
//8				0	
//4				0
//2				0 
//1				1
//0 
// if found one than star count 0 until hit one again and than take the largest count
//Binary number = 100000 so is no gaps





public class BinaryGap {
	
	    public int solution(int N) {
	        // write your code in Java SE 8
	    	
	    	// set foundOne variable to false , countZero = 0 and maxZero = 0 
	    	boolean foundOne = false; 
	    	int countZero = 0; 
	    	int maxZero = 0; 
	    	
	    	// loop through if N > 1 
	    	while(N > 1) {
	    	
	    		// if N % 2 == 1 set foundOne to true and set countZero = 0
	    		if(N % 2 == 1) {
	    			foundOne = true; 
	    			countZero = 0; 
	    		// else if foundOne == True increate countZero += 1 and check if maxZero < countZero then set it to countZero
	    		}else if(foundOne) {
	    			countZero ++; 
	    			if(maxZero < countZero) maxZero = countZero; 
	    		}
	    	
	    		// update N = N / 2 
	    		N = (int)(N / 2.0); 
	    	} 
	    	
	    	// return maxZero 
	    	return maxZero; 
	    }
	    
	
	 public static void main(String[] args) {
		 	BinaryGap bg = new BinaryGap(); 
	    	
	    	System.out.println(bg.solution(1041));
	 }


}













