package com.mukvin.WorkOfferTest.Math;

/*题目描述
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。*/

/*【思路】
直觉想到用二进制的位运算。最后写出来是一个迭代的过程。
每次迭代先计算num1 和 num2的和但不处理进位，那么相当于做异或，得到res1
然后处理进位问题，相当于计算与运算，得到res2
那么res2左移1位，再加到res1上，则整个运算的最终结果转化为res1+(res2<<1)
因为res2做左移，总会减小到0，那时候的res1就是最终结果*/

public class Add {

	public static int Add(int num1, int num2) {
		int sum;
        int carry;
        while (true){
            sum = num1^num2;
            carry = (num1&num2) << 1;
            num2 = carry;
            num1 = sum;
            if (num2 == 0){
                break;
            }
        }
        return sum;
    }

	public static void main(String[] args) {
		System.out.println(Add(5, 17));
		System.out.println((4 & 6) << 1);
	}

}
