package com.mukvin.WorkOfferTest.ListAndArrays;

import java.util.Arrays;
import java.util.Comparator;
/*题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
*/

/*其中最重要的就是比较策略：

排序规则如下：
* 若ab > ba 则 a > b，
* 若ab < ba 则 a < b，
* 若ab = ba 则 a = b；

*比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较

以上就是输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

*/

/**
 * 这道题实在值得回味和思考
 * @author Mukvin
 *
 */


public class PrintMinNumber {

	public static String PrintMinNumber(int[] numbers) {
		if (numbers.length == 0 || numbers == null) {
			return "";
		}
		int length = numbers.length;
		String[] str = new String[length];
		String result ="";
		for (int i = 0; i < length; i++) {
			str[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(str,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2 ;
				String s2 = o2 + o1 ;
				return s1.compareTo(s2);
			}
		});
		for(int i = 0 ; i < str.length ;i++) {
			result+=str[i];
		}
		
		return result;
	}

	public static void main(String[] args) {
		String s1 = "13";
		String s2 = "21";
		System.out.println(s2.compareTo(s1));
	}

}
