package com.mukvin.WorkOfferTest.ListAndArrays;

import java.util.Scanner;

/*题目描述
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。*/

public class multiply {
	//法一：这个是最简单直接的想法，但是也有更好的做法，现在没有想到，而且该方法时间复杂度有些高，可以再进行优化的
	public static int[] multiply(int[] A) {
		int len = A.length;
		int[] B = new int[len];
		int tempRes = 1;
		int index = 0 ;
		while (index < len) {
			for (int i = 0; i < len; i++) {
				if (index == i) {
					//i++;
					continue;
				}
				tempRes *= A[i];
			}
			B[index++] = tempRes;
			tempRes = 1;
		}
		return B; //[1, 2, 3, 4, 5]-->[120,60,40,30,24]
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < array.length; i++) {
			System.out.print(multiply(array) + "");
		}
	}

}
