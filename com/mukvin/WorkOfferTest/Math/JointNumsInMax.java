package com.mukvin.WorkOfferTest.Math;

import java.util.Arrays;
import java.util.Scanner;

class NodeTree {
	int val;
	NodeTree[] clild = new NodeTree[10];

	public NodeTree() {
		this.val = 0;
	}
}

/*
 * 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。 如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
 * 如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
 */
public class JointNumsInMax {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[] number = new int[n];
		for (int i = 0; i < n; i++) {
			number[i] = cin.nextInt();
		}
		int[] indexN = new int[n];
		for (int i = 0; i < n; i++) {
			for (int k = 2; k <= 3; k++) {
				int temp = (int) (number[i] % Math.pow(10, k));
				if(temp < Math.pow(10, k-1)) {
					int m = (int) (number[i]/Math.pow(10, k-2));
					number[i] = (int) (m * Math.pow(10, k-1) + number[i]);
					indexN[i] ++;
				}
			}
			number[i] = number[i] * 10 + indexN[i];
		}
		Arrays.sort(number);
		for(int i=n-1;i>=0;i--) {
			String string = String.valueOf(number[i]);
			int del = string.charAt(string.length()-1) -'0';
			System.out.print(string.substring(del, string.length()-1));
		}
		
	}

}
