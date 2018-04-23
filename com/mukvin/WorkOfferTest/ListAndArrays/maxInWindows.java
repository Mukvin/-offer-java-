package com.mukvin.WorkOfferTest.ListAndArrays;

import java.util.ArrayList;
import java.util.LinkedList;

/*题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
{2,3,[4,2,6],2,5,1}，{2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。*/

//使用双端队列

public class maxInWindows {

	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (num == null || size < 1 || num.length < size) {
			return res ;
		}
		LinkedList<Integer> qMax = new LinkedList<Integer>();
		
		for(int i = 0 ; i < num.length ; i++) {
			while(!qMax.isEmpty() && num[qMax.peekLast()] <= num[i]) {
				qMax.pollLast();//如果 qMax非空，而且此时的队尾数值小于此时的num[i],则将队尾下标弹出
			}
			qMax.addLast(i);//添加新下标
			if (qMax.peekFirst() == i - size) {
				qMax.pollFirst(); //如果qMax队首的指针等于 i - size ，表示此时窗口队首下标过期，则弹出去
			}
			if (i >= size -1) { 
				//一旦以上的qmax队尾和队首操作做完了，判断此时窗口是否已经划过了，要登记保存下最大值
				//只要i >= size - 1,说明窗口已经划过了一次窗口大小的位置
				res.add(num[qMax.peekFirst()]);
			}
		}
		return res;
	}

	public static void main(String[] args) {

	}

}
