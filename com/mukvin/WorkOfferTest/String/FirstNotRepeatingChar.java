package com.mukvin.WorkOfferTest.String;

import java.util.HashMap;
import java.util.Map;

/*题目描述
在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
*/



public class FirstNotRepeatingChar {
	
	public static int FirstNotRepeatingChar(String str) {
		char[] chars = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0 ; i < chars.length ; i++) {
			if ( !map.containsKey(chars[i])) {
				map.put(chars[i], 1);
			}else {
				map.put(chars[i], map.get(chars[i])+1);
			}
		}
		for(int i = 0 ; i <chars.length;i++) {
			if (map.get(chars[i]) == 1) {
				return i ;
			}
		}
		return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(FirstNotRepeatingChar("google"));
	}

}
