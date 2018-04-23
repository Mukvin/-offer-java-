package com.mukvin.WorkOfferTest.Recursion;

import java.util.Scanner;

public class FibonacciNum {
	public static int Fibonacci(int n) {
		/*
		if(n == 0 ) return 0;
		if (n == 1 || n == 2) {
			return 1;
		}else  {
			return Fibonacci(n-1) + Fibonacci(n-2);
		}*/
		if (n <= 0) {  
	        return -1;  
	    } else if (n == 1 || n == 2) {  
	        return 1;  
	    } else {  
	        int start = 3;  
	        int f = 1;//第1位  
	        int b = 1;//第2位  
	        while (start++ <= n) {  
	            //每次循环都把b和f右移一位，最终b就是我们要的值  
	            //当n=3时，只需要执行1次  
	            //当n=4时，移动1次以后要再移动1次  
	            //当n=5时，在上面的基础上再移动1次  
	            b = b + f;//b 变成它右边那一位  
	            f = b - f;//f 变成b之前的值  
	        }  
	        return b;  
	    } 
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  n = sc.nextInt();
		int fibonacci = Fibonacci(n);
		System.out.println(fibonacci);
		sc.close();
	}

}
