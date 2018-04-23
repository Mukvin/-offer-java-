package com.mukvin.WorkOfferTest.Math;
/**
 * 题目描述：求解一个数的幂次方!
 * @author Mukvin
 *
 */
public class BaseExpont {

	public double Power(double base, int exponent) {
		//方法一
		//1.使用库函数
		//return Math.pow(base, exponent);
		
		//方法二
		//1. 按照幂的定义。循环累乘。
		//2. 注意，若给定的指数为负数，则返回累乘的倒数。
		//3. 若给定的指数为零，则返回1。
		//4. 底数若为零的情况。
		/*double result = 1.000;
        int ex = Math.abs(exponent);
        boolean flag = true;
        if(exponent<0){
            flag = false;
        }
        while(ex > 0){
            result *= base;
            ex--;
        }
        if(flag == false){
            result = 1/result;
        }
        return result;*/
		
		//方法三
		////1.递归：n为偶数，a^n=a^n/2*a^n/2;n为奇数，a^n=（a^（n-1）/2）*（a^（n-1/2））*a
		//不是很理解！！！！
		int n=Math.abs(exponent);
        if(n==0)
            return 1;
        if(n==1)
            return base;
        double  result=Power(base,n>>1);
        result*=result;
        if((n&1)==1)
            result*=base; 
        if(exponent<0)
            result=1/result;
        return result;     
	}

	public static void main(String[] args) {

	}

}
