package com.mukvin.WorkOfferTest.ListAndArrays;

import java.util.ArrayList;
import java.util.Scanner;

public class FindMinNumInRotateArray {

	public static void rotateArray(int[] array) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		int index = 1;
		for (int i = 0; i < array.length; i++) {
			arrayList.add(array[i]);
		}
		while(index < arrayList.size()) {
			if (arrayList.get(index-1) < arrayList.get(index)) {
				index ++;
			}else {
				break;
			}
		}
		
	}

	/*public int minNumberInRotateArray(int[] array) {
		
		 * if (array.length == 0) { return 0; } int min = array[0]; for(int i = 0 ;i <
		 * array.length ;i ++) { if (array[i] < min) { min= array[i]; } } return min;
		 

	}
*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}

		sc.close();
	}

}
