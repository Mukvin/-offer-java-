package com.mukvin.WorkOfferTest.String;

/*题目描述
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
输入描述:
输入一个字符串,包括数字字母符号,可以为空
输出描述:
如果是合法的数值表达则返回该数字，否则返回0
示例1

输入
+2147483647
    1a33

输出
2147483647
    0*/

public class StrToInt {
	/*
	 * 思路：1、字符串长度为0 ，表示字符串为空，记住不要用 str == null 2、将字符串转化为字符数组处理，如果字符串为 '+' '*' '/'
	 * 则数组下标后移 3、判断字符数组当中如果有 字母，那么直接跳出，返回0 4、如果字符串只有 '-'，并且长度为1，返回0，这里要将 '-'
	 * 拿出来单独判断，因为有负数的情况 5、经过了while循环的筛选，这时候也要注意了，如果直接返回的字符串转化为数字会报错。空字符串提示不能转换 ""
	 * 6.所以要额外的在进行判断下，resString 长度是否为，因为有 '+' 存在，
	 */
	// 但是要求不能使用库函数，这种思路有误
	public static int StrToInt2(String str) {
		if (str.length() == 0) {
			return 0;
		}
		char[] nums = str.toCharArray();
		int i = 0;
		String reString = "";
		while (i < nums.length) {
			if (nums[i] == '+' || nums[i] == '*' || nums[i] == '/') {
				i++;
				continue;
			}
			if (Character.isAlphabetic(nums[i])) {
				return 0;
			}
			if (nums[i] == '-' && i == nums.length - 1) {
				return 0;
			}
			reString += nums[i];
			i++;
		}
		if (reString.length() == 0) {
			return 0;
		}
		return Integer.parseInt(reString);
	}

	public static int StrToInt(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] chars = str.toCharArray();
		int sign = 1;// 符号
		int from = 0;// 数字开始
		if (chars[0] == '-') {
			sign = -1;
			from = 1;
		}
		if (chars[0] == '+') {
			from = 1;
		}
		int value = 0;
		for (int i = from; i < chars.length; i++) {
			if ('0' <= chars[i] && chars[i] <= '9') {
				value = value * 10 + chars[i] - '0';
			} else {
				sign = 0;
				break;
			}
		}
		return sign * value;
	}

	public static void main(String[] args) {
		String str = "0";
		System.out.println(StrToInt(str));
	}

}
