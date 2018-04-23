package com.mukvin.WorkOfferTest.String;

import java.util.ArrayList;
import java.util.HashMap;

/*题目描述
请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。

*/

/*思路：字符只能一个接一个从字符流中读出来。我们可以定义一个数据容器来保存字符在字符流中的位置。
当一个字符第一次从字符流中读出来时，把它在字符流中的位置保存到数据容器里。
当这个字符再次从字符流中被读出来时，那么它就不是第一次不重复的字符，也就可以被忽略了。
这时把它在数据容器里保存的值更新成一个特殊的值（比如一个负值）。这个数据容器可以用哈希表来实现。
用字符的ASII码作为哈希表的键值，而把字符对应的位置作为哈希表的值.

实现：第一个不重复的字符  两个关键点 不重复也就是出现一次，第一个也就是找到将其返回不再找下面的了

两个辅助空间

（1）HashMap 根据字符放入map中每次将次数加1；

（2）ArrayList 将插入的每个字符放入到list中，list是有顺序地存放。遍历list去map中根据字符找其出现的次数。
*/


public class FirstAppearingOnce {
	
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();// 存放字符和其出现的次数  
    ArrayList<Character> list = new ArrayList<Character>();// 存放字符  
	
    // Insert one char from stringstream  
    public void Insert(char ch) {  
        if (map.containsKey(ch)) {  
            map.put(ch, map.get(ch) + 1);  
        } else {  
            map.put(ch, 1);  
        }  
        list.add(ch);  
    }  
  
    // return the first appearence once char in current stringstream  
    public char FirstAppearingOnce() {  
        for (int i = 0; i < list.size(); i++) {  
            if (map.get(list.get(i)) == 1) {  
                return list.get(i);  
            }  
        }  
        return '#';  
    }  
    
	public static void main(String[] args) {
		
	}

}
