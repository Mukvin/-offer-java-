package com.mukvin.WorkOfferTest.Math;
/**
 * 题目描述：返回一个整数的二进制数表示当中的 1的数量。
 * 例如：整数3 ，表示的是011，1的数量有2个，输出结果就是为2,。
 * （负数用补码表示）
 * @author Mukvin
 *
 */
public class NumberOf1 {

	public static int NumberOf1(int n) {
		int count = 0;
		while(n != 0) {
			count ++;
			n = n & (n-1);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(NumberOf1(-3));
	}

}
