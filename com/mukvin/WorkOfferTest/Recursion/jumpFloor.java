package com.mukvin.WorkOfferTest.Recursion;

public class jumpFloor {

    public int jumpFloor1(int target){  
        if(target <= 0) return 0;  
        if(target == 1) return 1;  
        if(target == 2) return 2;  
        return jumpFloor1(target-1)+jumpFloor1(target-2);  
    }  
    public int jumpFloor2(int target) {  
        if(target <= 0) return 0;  
        if(target == 1) return 1;  
        if(target == 2) return 2;  
        int one = 1;  
        int two = 2;  
        int result =  0;  
        for(int i=2; i<target; i++){  
            result = one + two;  
            one = two;  
            two = result;  
        }  
        return result;  
   }  
    
	
	public static void main(String[] args) {
		
	}

}
