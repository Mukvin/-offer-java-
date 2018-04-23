package com.mukvin.WorkOfferTest.String;

/*题目描述
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。*/

/*思路：
①对字符串中的每个字符进行判断分析
②e（E）后面只能接数字，并且不能出现2次，并且不能放在最后一位
③对于+、-号，只能出现在第一个字符或者是e的后一位
④对于小数点，不能出现2次，e后面不能出现小数点*/

public class isNumeric {

	public boolean isNumeric(char[] str) {
		//标记   符号、小数点、e是否出现过  
        boolean sign = false;  
        boolean decimal = false;  
        boolean hasE = false;  
        for (int i=0;i<str.length;i++) {  
            if (str[i] == 'e' || str[i] == 'E') {  
                if (i == str.length - 1) return false;  //如果 此时str已经扫描完毕，e(E)是最后一个字母，就不是数值
                if (hasE) return false;  //如果 e(E)后面还有 e(E) ,就不是数值
                hasE = true;  //更新标记    有e(E)
            } else if (str[i] == '+' || str[i] == '-') {  
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;  //如果已经出现过了符号，而这个后面的符号前 并不是e(E),则可以立即判断不是数值
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false; //如果没有出现过符号，但是如果不是在e(E)前面一个位置，立即判断不是数值
                sign = true;  //更新标记  符号出现了
            } else if (str[i] == '.') {  
                if(hasE||decimal) return false;  //如果已经出现了e(E)，或者后面还有小数点，判断不是数值
                decimal = true;  //更新标记 小数点出现了
            } else if (str[i] < '0' || str[i] > '9') {  //如果出现字母，立即判断不是数值,但是注意要放在e(E)判断之后，不能放在前面去判断
                return false;  
            }  
        }  
        return true;  
	}

	public static void main(String[] args) {

	}

}
