package com.mukvin.WorkOfferTest.ListAndArrays;

/*题目描述
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
*/
/**
 * 思路:将每一个数都变成了数组来处理，也就是进行了string化，在变成char数组而后进行处理。
 * @author Mukvin
 *
 */

public class NumberOf1Between1AndN {
	
	public int NumberOf1Between1AndN_Solution(int n) {  
        int count = 0;  
        while(n>0){  
            String str = String.valueOf(n);  
            char[] chars = str.toCharArray();  
            for(int i=0;i<chars.length;i++){  
                if(chars[i]=='1'){  
                    count++;  
                }  
            }  
            n--;  
        }  
        return count;  
    }  
	
	public static void main(String[] args) {
		
	}

}
