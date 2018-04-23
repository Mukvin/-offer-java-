package com.mukvin.WorkOfferTest.Math;

/*题目描述
每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
HF作为牛客的资深元老,自然也准备了一些小游戏。
其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
然后,他随机指定一个数m,让编号为0的小朋友开始报数。
每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....
这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
*/

public class LastRemaining_JosephRing {
	/*思路1:比较普遍的思路是把这n个整数做成一个环，当数到哪个数的时候就把那个数移除，
	并从下一个数重新开始数。所已基本思路是：使用数组模拟环，当当前的元素的值n相等的时候，就回到第一个位置重新遍历，
	每次当前元素的移动都伴随计步器的增加（每次增加1），当步数等于m的时候，则把当前元素的设为-1，表示已被删除，
	并重新设置计步器的值为0，还需要把n的值减小1，表示数组中的元素被移除了一个。*/
	
	public int LastRemaining_Solution1(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		int[] a = new int[n];
		// 当前遇到的对象
		int cur = -1;
		// 计步器
		int count = 0;
		int num = n;
		while (num > 0) {
			// 移动到上次被删除元素的下一个元素
			cur++;
			// 当遇到最后一个数的时候，从开头重新计算
			if (cur == n)
				cur = 0;
			// 如果遇到了上次被删除的对象，则跳过该对象
			if (a[cur] == -1)
				continue;
			// 计步器加1
			count++;
			if (count == m) {
				// 把当前元素标记为已删除
				a[cur] = -1;
				// 计步器重新复位
				count = 0;
				num--;
			}
		}
		return cur;
	}
	//根据每次删除节点的性质处理
	//思路2：找到递归公式。核心在，第一，序列重排，第二，找到映射函数。这个纯考数学。
	//递推公式为：f(N,M)=(f(N−1,M)+M)%N;
	/*f(N,M):表示，N个人报数，每报到M时杀掉那个人，最终胜利者的编号
	f(N−1,M):表示，N-1个人报数，每报到M时杀掉那个人，最终胜利者的编号*/
	public static int LastRemaining_Solution2(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int lastNumber = 0;
        for (int i = 2; i <= n; i++)
            lastNumber = (lastNumber + m) % i;
        return lastNumber;
    }

	public static void main(String[] args) {
		System.out.println(LastRemaining_Solution2(10, 2));
	}

}
