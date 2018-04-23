package com.mukvin.WorkOfferTest.ListAndArrays;
/* 题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MoreThanHalfIInMax_Solution_true {

	public static int MoreThanHalfNum_Solution(int[] array) {
		int halfLength = array.length/2;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ; i < array.length;i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i])+1);
			}else {
				map.put(array[i], 1);
			}
		}
		for(int i = 0 ; i < array.length;i++) {
			if (map.get(array[i]) > halfLength) {
				return array[i];
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for(int i = 0 ;i < n; i ++) {
			array[i] = sc.nextInt();
		}
		System.out.println(MoreThanHalfNum_Solution(array));
		sc.close();
 	}
}
