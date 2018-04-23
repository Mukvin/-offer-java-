package com.mukvin.WorkOfferTest.Recursion;

import java.util.Scanner;

public class JumpFloorII {
	/**
	 * 因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
		跳1级，剩下n-1级，则剩下跳法是f(n-1)
		跳2级，剩下n-2级，则剩下跳法是f(n-2)
		所以f(n)=f(n-1)+f(n-2)+...+f(1)
		因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
		所以f(n)=2*f(n-1)
	 * @param target
	 * @return
	 */
	public static int JumpFloorII(int target) {
       /* if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }*/
        return  1<<--target;
    }
	/**
	 * 理由是：

		当target等于1时，有1种跳法1<<--1
		target=2时，有2种跳法1<<--2
		target=3时，有4种跳法1<<--3
		target=4时，有8中跳法1<<--4
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(JumpFloorII(n));
		scanner.close();
	}

}
