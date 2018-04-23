package com.mukvin.WorkOfferTest.Math;

/*题目描述
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
*/


public class Sum_Solution {
	//短路法
	public static int Sum_Solution(int n) {
        int answer = n;
        boolean flag = (n>0)&&((answer += Sum_Solution(n-1))>0);  
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(Sum_Solution(5));
	}

}
