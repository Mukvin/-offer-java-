package com.mukvin.WorkOfferTest.ListAndArrays;

import java.util.HashMap;
import java.util.Map;

/*题目描述
统计一个数字在排序数组中出现的次数。
*/

public class GetNumberOfK {

	public int GetNumberOfK(int[] array, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i])+1);
			}else {
				map.put(array[i], 1);
			}
		}
		if (map.containsKey(k)) {
			return map.get(k);
		}else {
			return 0;
		}
	}

	public static void main(String[] args) {

	}

}
