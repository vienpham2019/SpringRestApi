package easy;

import java.util.ArrayList;
import java.util.List;

//A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59). 
//Each LED represents a zero or one, with the least significant bit on the right.
//
//For example, the below binary watch reads "4:51".
//
//
//Given an integer turnedOn which represents the number of LEDs that are currently on, return all possible times the watch could represent.
//		You may return the answer in any order.
//
//The hour must not contain a leading zero.
//
//For example, "01:00" is not valid. It should be "1:00".
//The minute must be consist of two digits and may contain a leading zero.
//
//For example, "10:2" is not valid. It should be "10:02".
// 
//
//Example 1:
//
//Input: turnedOn = 1
//Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
// 0:01 => hours = 0 , min = 01
// binary of 0 => 0 this contain 0 one-bits
// binary of 1 => 1 this contain 1 one-bits 
// so 0 + 1 = 1 
//Example 2:
//
//Input: turnedOn = 9
//Output: []
// 
//
//Example 3:
//
//Input: turnedOn = 6
//Output: [1:31, 1:47, 1:55, 1:59, 2:31, 2:47, 2:55, 2:59, 3:15, 3:23, 3:27, 3:29, 3:30, 3:39,...,11:13,...]
// 1:31 => hour = 1 , min = 31
// binary of 1 is 1 and this contain 1 one-bits
// binary of 31 is 11111 and this contains 5 one-bits 
// so 1 + 5 = 6
//
// 11:13 => hour = 11 , min = 13; 
// binary of 11 is 1011 => it contains 3 one-bits 
// binary of 13 is 1101 => it contains 3 one-bits 
// so 3 + 3 = 6
//
//Constraints:
//
//0 <= turnedOn <= 10

public class BinaryWatch {
	public List<String> solution(int turnedOn){
		List<String> result = new ArrayList<>(); 
		
		for(int hr = 0; hr < 12 ; hr ++) {
			for(int min = 0; min < 60 ; min ++) {
				if(Integer.bitCount(hr) + Integer.bitCount(min) == turnedOn) {
					String time = hr + ":";
					if(min < 10) time += 0;
					time += min; 
					result.add(time);
				}
			}
		}
		
		return result; 
	}
	
	public static void main(String [] args) {
		System.out.println(new BinaryWatch().solution(6));
		System.out.println(Integer.toBinaryString(11));
	}
}






