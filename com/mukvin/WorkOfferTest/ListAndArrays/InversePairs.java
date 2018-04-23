package com.mukvin.WorkOfferTest.ListAndArrays;

public class InversePairs {
	/**
	 * 时间复杂度为O(N)，超出时间限制
	 * 
	 * @param array
	 * @return
	 */
	 /*
	 * public static int InversePairs(int[] array) { int count = 0 ; for(int i = 0 ;
	 * i < array .length ; i++) { for(int j = i+1 ; j< array.length ;j++) if
	 * (compareTo(array[i], array[j])) { count++; } } return (count%1000000007); }
	 */
	
	/*
	 * 新思路就是归并排序的转化题目，只要归并一次，那么就增加一
	 */
	static int cnt;

	public static int InversePairs(int[] array) {
		cnt = 0;
		if (array != null)
			mergeSortUp2Down(array, 0, array.length - 1);
		return cnt;
	}

	/*
	 * 归并排序(从上往下)
	 */
	public static void mergeSortUp2Down(int[] a, int start, int end) {
		if (start >= end)
			return;
		int mid = (start + end) >> 1;

		mergeSortUp2Down(a, start, mid);
		mergeSortUp2Down(a, mid + 1, end);

		merge(a, start, mid, end);
	}

	/*
	 * 将一个数组中的两个相邻有序区间合并成一个
	 */
	public static void merge(int[] a, int start, int mid, int end) {
		int[] tmp = new int[end - start + 1];

		int i = start, j = mid + 1, k = 0;
		while (i <= mid && j <= end) {
			if (a[i] <= a[j])
				tmp[k++] = a[i++];
			else {
				tmp[k++] = a[j++];
				cnt += mid - i + 1;
				cnt %= 1000000007;// core code, calculate InversePairs............
				//当左大于右时，右指针会继续右移一位（所以count为左指针到中间的个数之和的和）
			}
		}

		while (i <= mid)
			tmp[k++] = a[i++];
		while (j <= end)
			tmp[k++] = a[j++];
		for (k = 0; k < tmp.length; k++)
			a[start + k] = tmp[k];
	}



	public static void main(String[] args) {
		int[] arrays = { 1, 2, 3, 4, 5, 6, 7, 0 };
		System.out.println(InversePairs(arrays));
	}

}
