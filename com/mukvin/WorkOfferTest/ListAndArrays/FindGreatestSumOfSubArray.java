package com.mukvin.WorkOfferTest.ListAndArrays;

import java.util.Scanner;

/*题目描述
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
当向量全为正数的时候,问题很好解决。
但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
你会不会被他忽悠住？(子向量的长度至少是1)
*/

/*一种思路，使用两个循环，分别计算从开始s到结束e的和，找出最大的数，但是这种解法的时间复杂度为n*n，不建议。
另一种思路，遍历一次，当前的和小于0时抛弃，因为负数不管加什么数，都是变小的，因此重新计算就可以了
*/
public class FindGreatestSumOfSubArray {

	public static int FindGreatestSumOfSubArray(int[] array) {
		int max=Integer.MIN_VALUE,sum=max;
        for(int i=0;i<array.length;i++){
            if(sum<0){
                sum=0;
            }
            sum+=array[i];
            if(sum>max){
                max=sum;
            }
        }
        return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for(int i = 0 ;i < n; i ++) {
			array[i] = sc.nextInt();
		}
		System.out.println(FindGreatestSumOfSubArray(array));
		sc.close();
	}
}
