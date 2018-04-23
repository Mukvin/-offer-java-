package com.mukvin.WorkOfferTest.ListAndArrays;

public class reOrderNumsArray {

	public static void reOrderArray(int[] array) {
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			if (isEven(array[i]) && isOdd(array[j])) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;

			} else if (isOdd(array[i]) && isEven(array[j])) {
				i++;
			} else if (isEven(array[i]) && isEven(array[j])) {
				j--;
			} else {
				i++;
				j--;
			}
		}
	}

	private static boolean isOdd(int n) {
		return (n & 1) == 1;
	}

	private static boolean isEven(int n) {
		return (n & 1) == 0;
	}

	public static void reOrderArray1(int[] array) {
		int temp0 = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				for (int j = i - 1; j >= 0; j--) {
					if (array[j] % 2 == 0) {
						temp0 = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp0;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 12, 7, 8, 9, 10 };
		reOrderArray1(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

}
