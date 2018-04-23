package com.mukvin.WorkOfferTest.String;

/*题目描述
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配。*/

//本题题意还未能理解清楚，需要继续啃一啃理解才好，并且理解思路，所有的的ac题目意思是类似的。

/*分析：
递归实现
每次分别在str 和pattern中取一个字符进行匹配，如果匹配，则匹配下一个字符，否则，返回不匹配。
设匹配递归函数 match(str, pattern)。
1.如果模式匹配字符的下一个字符是‘*’:
•如果pattern当前字符和str的当前字符匹配，：有以下三种可能情况
（1）pattern当前字符能匹配 str 中的 0 个字符：match(str, pattern+2).比如 str = "aaa" pattern ="b*a" .
	接下来去匹配str[2] 与 pattert[2]
（2）pattern当前字符能匹配 str 中的 1 个字符：match(str+1, pattern+2).比如 str = "aaa" pattern ="ab*a".
	接下来匹配str[2] 与 pattert[2]
（3）pattern当前字符能匹配 str 中的 多 个字符：match(str+1, pattern){!? 这里是递归的去进行了前面的（1）（2）步骤}.
	比如 str = "aaa" pattern ="aaab*".接下来匹配str[1] 与 pattert[2]
• 如果pattern当前字符和和str的当前字符不匹配
	pattern当前字符能匹配 str 中的 0 个字符：match(str, pattern+2)
2.如果模式匹配字符的下一个字符不是‘*’，进行逐字符匹配。
3.对于 ‘.’ 的情况比较简单，’.’ 和一个字符匹配 match(str+1, pattern+1)
4.另外需要注意的是：空字符串”” 和 “.*” 是匹配的*/

public class Match {
	public static boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		return matchCore(str, 0, pattern, 0);
	}

	public static boolean matchCore(char[] str, int s, char[] pattern, int p) {
		if (str.length <= s && pattern.length <= p)
			return true;// 都匹配完了
		if (str.length > s && pattern.length <= p)
			return false;// 模式完了，字符串还有
		
		if (p + 1 < pattern.length && pattern[p + 1] == '*') {// 当前pattern的下一个是*号时
			// 字符串完了
			if (str.length <= s )
				return matchCore(str, s, pattern, p + 2);
			else {
				if (pattern[p] == str[s] || pattern[p] == '.') {
					// 当前位置匹配完成，移动到下一个模式串
					//1.pattern[p] == str[s] 有匹配一个字符也就是matchCore(str, s + 1, pattern, p + 2)
					//2.pattern[p] == str[s] 有匹配多个字符也就是matchCore(str, s + 1, pattern, p)
					//3.pattern[p] == '.' ，表示可以代替任意的字符，又因为此时是在pattern[p + 1] == '*'条件下也就是 
					//	{!? pattern 是这样的形式“~~~ .* ~~~~”，那么就形同 直接跳转后面的去比较去，比较是否有pattern后面的字符和str中不同
					//	pattern当前字符能匹配 str 中的 0 个字符：match(str, pattern+2)，这个地方是最值得注意的 }
					return matchCore(str, s + 1, pattern, p + 2) || matchCore(str, s + 1, pattern, p)
							|| matchCore(str, s, pattern, p + 2);
				} else {
					return matchCore(str, s, pattern, p + 2);
				}
			}
		}
		// 当前pattern的下一个不是*时候
		if (str.length <= s)
			return false;
		else {
			if (str[s] == pattern[p] || pattern[p] == '.')
				return matchCore(str, s + 1, pattern, p + 1);
		}
		return false;
	}

	public static void main(String[] args) {
		String string = "aaaaaaaa";
		String pattern = "a.*a";
		char[] str = string.toCharArray();
		char[] pat = pattern.toCharArray();
		System.out.println(match(str, pat));
	}

}
