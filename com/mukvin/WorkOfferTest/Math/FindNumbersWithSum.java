package com.mukvin.WorkOfferTest.Math;

import java.util.ArrayList;

/*题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

输出描述:
对应每个测试案例，输出两个数，小的先输出。
*/



public class FindNumbersWithSum {

	public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		int start = 0;
		int end = array.length - 1;
		while (start < end && start < array.length - 1 && end > 0) {
			if ((array[start] + array[end]) == sum) {
				list.add(array[start]);
				list.add(array[end]);
				return list;
			}else if ((array[start] + array[end]) < sum) {
				start++;
			} else  {
				end--;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int [] array = {1,2,3,4,5,6};
		int sum = 7;
		System.out.println(FindNumbersWithSum(array, sum));
	}

}
