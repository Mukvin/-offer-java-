package com.mukvin.WorkOfferTest.ListAndArrays;

import java.util.ArrayList;

/*题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.*/



public class printMatrix {
	
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
	       ArrayList<Integer> res  = new ArrayList<>();
	       int tR = 0;
	       int tC = 0;
	       int dR = matrix.length -1;
	       int dC = matrix[0].length -1;
	       while(tR <= dR && tC <= dC ) {
	    	   printEdge(matrix,tR++,tC++,dR--,dC--,res);
	       }
	       return res;
    }
	
	private static ArrayList<Integer> printEdge(int[][] matrix, int tR, int tC, int dR, int dC,ArrayList<Integer> res) {
		if (tR == dR) { //子矩阵只有一行的时候
			for(int i = tC ; i<= dC ; i++) {
				res.add(matrix[tR][i]);
			}
		}else if (tC == dC) { //子矩阵只有一列时候
			for(int i = tR ; i <= dR ;i++ ) {
				res.add(matrix[i][tC]);
			}
		}else {//一般情况
			int curC = tC;
			int curR = tR;
			while(curC != dC) {//第一步向右扫描
				res.add(matrix[tR][curC]);
				curC ++;
			}
			while(curR != dR) {//第二步向下扫描
				res.add(matrix[curR][dC]);
				curR ++;
			}
			while(curC != tC) {//第三步向左扫描
				res.add(matrix[dR][curC]);
				curC --;
			}
			while(curR != tR) {//第四步向上扫描
				res.add(matrix[curR][tC]);
				curR --;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] matrix= {{1 ,2, 3, 4 },{5 ,6 ,7 ,8} ,{9 ,10 ,11 ,12}, {13 ,14 ,15, 16}};
		ArrayList<Integer> res = printMatrix(matrix);
		for(int i = 0 ;i < res.size() ; i++) {
			System.out.print(res.get(i) + " ");
		}
	}

}
