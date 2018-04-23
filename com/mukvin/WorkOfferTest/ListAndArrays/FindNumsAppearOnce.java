package com.mukvin.WorkOfferTest.ListAndArrays;

import java.util.HashMap;
import java.util.Map;

/*题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
*/
//不甚理解，需要在多遇见这样的题目在进行理解学习
/*
此题用了两次异或运算特点：
（1）第一次使用异或运算，得到了两个只出现一次的数相异或的结果。
（2）因为两个只出现一次的数肯定不同，即他们的异或结果一定不为0，一定有一个位上有1。
另外一个此位上没有1，我们可以根据此位上是否有1，将整个数组重新划分成两部分，一部分此位上一定有1，
另一部分此位上一定没有1，然后分别对每部分求异或，
因为划分后的两部分有这样的特点：其他数都出现两次，只有一个数只出现一次。
因此，我们又可以运用异或运算，分别得到两部分只出现一次的数。
*/

public class FindNumsAppearOnce {
	// num1,num2分别为长度为1的数组。传出参数
	// 将num1[0],num2[0]设置为返回结果
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

		if (array == null || array.length <= 1) {
			num1[0] = num2[0] = 0;
			return;
		}
		int len = array.length, index = 0, sum = 0;
		for (int i = 0; i < len; i++) {
			sum ^= array[i];
		}
		for (index = 0; index < 32; index++) {
			if ((sum & (1 << index)) != 0)
				break;
		}
		for (int i = 0; i < len; i++) {
			if ((array[i] & (1 << index)) != 0) {
				num2[0] ^= array[i];
			} else {
				num1[0] ^= array[i];
			}
		}
	}

	public static void main(String[] args) {

	}

}
