package com.mukvin.CodeTest;

import java.util.Scanner;

public class test2 {

	public static  int[] bsearch(int array[], int n, int v) {
		int left, right, middle,count = 0;
		left = 0;
		right = n - 1;
		while (left <= right) {
			count++;
			middle = left + (right - left) / 2;
			if (array[middle] > v) {
				right = middle;
			} else if (array[middle] < v) {
				left = middle;
			} else {
				return new int[] {middle,count};
			}
		}
		return new int[] {-1,count};
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int v = sc.nextInt();
		int[] array = new int[n];
		for(int i = 0 ;i < n ;i++) {
			array[i] = sc.nextInt();
		}
		sc.close();
		for (int i = 0; i < 2; i++) {
			System.out.print(bsearch(array, n, v));
		}
		
	}

}
