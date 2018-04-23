package com.mukvin.WorkOfferTest.Recursion;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 题目描述 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 
 * @author Mukvin
 *
 */
public class Permutation {

	public ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<>();//根据返回类型需要
		if (str.length() == 0 || str == null) {
			return result;
		}
		
		char[] chars = str.toCharArray();
		TreeSet<String> res = new TreeSet<>();//用于排序输出
		getResult(chars ,  0 , str.length() -1 , res);
		result.addAll(res);//添加到ArrayList
		return result;
	}

	private void getResult(char[] chars, int start, int end, TreeSet<String> res) {
		if (start == end) {
			res.add(String.valueOf(chars));
		}else {
			for(int i =  0;i <= end ; i++) {
				swap(chars , start , i);// 换一位
				getResult(chars, start+1, end, res);//递归
				swap(chars,start,i);//换回来，保证下次换位是正确的
			}
		}
	}

	private void swap(char[] chars, int start, int i) {
		if (start == i) {//因为会出现原位置与原位置交换，直接空即可
			
		}else {
			char temp = chars[start];
			chars[start] = chars[i];
			chars[i] = temp;
		}
	}

	public static void main(String[] args) {

	}

}
