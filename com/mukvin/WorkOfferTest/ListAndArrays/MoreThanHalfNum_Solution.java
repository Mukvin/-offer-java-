package com.mukvin.WorkOfferTest.ListAndArrays;
/* 题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
*/

import java.util.Scanner;

public class MoreThanHalfNum_Solution {

	public static int MoreThanHalfNum_Solution(int[] array) {
		/*int halfLength = array.length/2;
		int[] count = new int[array.length];
		for(int i = 0 ; i <array.length ;i++) {
			count[i] = 0 ;
		}
		for(int i= 0 ; i <array.length ; i++) {
			++ count[array[i]] ;//这个想法错在了，如果array[i]的值是超出了count的下标的话，也就是容易报出了数组越界的错误
			//如果要修改的话，那么初始的时候就是要将的count[]的初始下标要设置大一些，但是时间复杂度和空间复杂度绝对很高，不是好办法
			
		}
		for(int i = 0 ; i < count.length ; i++) {
			if (count[i] > halfLength) {
				return i;
			}
		}
		*/
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
