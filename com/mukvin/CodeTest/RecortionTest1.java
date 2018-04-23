package com.mukvin.CodeTest;

public class RecortionTest1 {
	private static int count = 0 ;
	public static  int fun(int n) {
		 
		if (n <= 3) {
			count++;
			return 1;
		}else {
			count++;
			return fun(n-2) + fun(n - 4 ) + 1 ;
		}
	}
	
	public static void main(String[] args) {

		int  n = fun(fun(8));
		System.out.println(count);
	}

}
