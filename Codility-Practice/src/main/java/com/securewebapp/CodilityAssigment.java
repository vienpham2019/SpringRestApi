package com.securewebapp;

import java.util.*;

public class CodilityAssigment {
	public int solution(String[] T , String[] R) {
		
		HashMap<String , Integer> countTests = new HashMap<>(); 
		
		String testNum;
		
		for(String t : T) {
			testNum = t.replaceAll("[^0-9]", ""); 
			
			if(countTests.containsKey(testNum)) {
				countTests.replace(testNum, countTests.get(testNum) + 1); 
			}else {
				countTests.put(testNum, 1); 
			}
			
		}
		
		int numTestPass = 0; 
		
		for(int i = 0; i < R.length ; i ++) {
			if(R[i].equals("OK")) {
				testNum = T[i].replaceAll("[^0-9]", ""); 
				
				countTests.replace(testNum, countTests.get(testNum) - 1); 
				if(countTests.get(testNum) == 0) {
					numTestPass ++; 
				}
			}
		}
		
		return numTestPass * 100 / countTests.size(); 
	}
	
	public static void main(String[] args) {
		
		String[] s1 = new String[] { "test1a" , "test2a" , "test1b" , "test1c" ,"test3" , "test2b"};
		String[] s2 = new String[] { "Wrong answer" , "OK" , "OK" , "OK" , "Time limit exceeded", "OK"  };
		
	
		String[] s3 = new String[] { "codility1" , "codility3" , "codility2" , "codility4b" ,"codility4a"  };
		String[] s4 = new String[] { "Wrong answer" , "OK" , "OK" , "Runtime error" , "OK" };
		
		System.out.println(new CodilityAssigment().solution(s1 , s2));
	}
}
