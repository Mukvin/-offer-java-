package com.mukvin.WorkOfferTest.String;

import java.util.Arrays;


/*题目描述
LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
*/

/*
  思路分析：
  这题主要考虑怎么才能形成顺子以及有几个王。首先可以排序，反正就5个数。
然后考虑有几个王，最后计算间隔（如1与3可看做间隔1,1与2看做没有间隔）。
相差的间隔如果小于王的个数，可判断是顺子，否则则不是。*/

public class isContinuous {
	
	public static boolean isContinuous(int [] numbers) {
		if (numbers.length < 5) {
			return false;
		}
		Arrays.sort(numbers);
		int numOfZero = 0;
		int gap = 0;
		for(int i = 0 ; i < numbers.length ; i++ ) {
			if (numbers[i] == 0) {
				numOfZero++;
			}else {
				break;
			}
		}
		
		for(int  i = numOfZero ; i < numbers.length - 1 ; i++) {
			//i < numbers.length - 1 防止了(numbers[i+1] - numbers[i]) == 0 中的numbers[i+1]数组越界
			if ((numbers[i+1] - numbers[i]) == 0) {
				//有数字相同，就绝对不是顺子
				return false;
			}
			gap += numbers[i+1] - numbers[i] -1;
		}
		return (gap <= numOfZero ) ? true :false;
    }
	
	public static void main(String[] args) {
		int[] array= {1,3,2,6,4};
		System.out.println(isContinuous(array));
	}

}
