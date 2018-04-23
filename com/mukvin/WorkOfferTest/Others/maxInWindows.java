package com.mukvin.WorkOfferTest.Others;

import java.util.ArrayList;
import java.util.LinkedList;

/*题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
他们的最大值分别为{4,4,6,6,6,5}；
针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
{2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， 
{2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。*/

public class maxInWindows {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> res = new ArrayList<>();
		if (num == null || size < 1 || num.length < size) {
			return res;
		}
		
		LinkedList<Integer> qMax = new LinkedList<>();
		int[] resArray = new int[num.length -size +1];
		int index = 0;
		for(int i = 0 ; i < num.length ; i++) {
			while(!qMax.isEmpty() && num[qMax.peekLast()] <= num[i]) {
				qMax.pollLast();
			}
			qMax.addLast(i);
			if (qMax.peekFirst() == i - size) {
				qMax.pollFirst();
			}
			if (i >= size -1) {
				resArray[index++] = num[qMax.peekFirst()];
			}
		}
		for(int i = 0 ; i< resArray.length ;i++) {
			res.add(resArray[i]);
		}
		return res;
	}
}
