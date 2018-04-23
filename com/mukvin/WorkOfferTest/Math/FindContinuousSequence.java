package com.mukvin.WorkOfferTest.Math;

import java.util.ArrayList;

/*题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

输出描述:

输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
*/

/*思路分析:

根据题目内容分析可知，输出所有和为S的连续正数序列，其实际上就是求出和为S公差为1的等差数列。
由等差数列公式可知S=（a1+an）/2=a1+a2+a3+...+an。故可定义两个变量a1,an,a1的数值为1，an的初值为2(若sum<=2，a1和an不存在)。
若a1到an序列和为S,则将a1...an添加到结合中返回，若a1到an序列和小于S,则an++;
若a1到an序列和大于于S，则将a1++。当a1等于(S+1)/2时停止。
*/

public class FindContinuousSequence {

	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		if (sum <= 2) {
			return lists;
		}
		int start = 1;
		int end = 2;

		int half = (sum+1) / 2;
		while (start < half) {
			int curSum = sumOfList(start, end);
			if (curSum == sum) {
				ArrayList<Integer> list = new ArrayList<>();
				for(int i = start ; i <= end ;i++) {
					list.add(i);
				}
				lists.add(list);
				start++;
				end++;
			}else if(curSum < sum){
				end ++;
			}else {
				start++;
			}
			
		}
		return lists;
	}

	public static int sumOfList(int start, int end) { // 计算当前序列的和
		int sum = start;
		for (int i = start + 1; i <= end; i++) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {

	}

}
