package com.mukvin.CodeTest;

import java.util.HashMap;
import java.util.Map;

public class FindInArrays {
	
	public boolean Find1(int target, int [][] array) {
        
        for(int i = 0 ; i < array.length ; i ++ ) {
        	for(int j = 0 ;j <array[i].length ;j++) {
        		if (target == array[i][j]) {
					return true;
				}
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		
	}

}
