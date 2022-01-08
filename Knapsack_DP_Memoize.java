
package Src;
/* IMPORTANT: Multiple classes and nested static classes are supported */

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class mainClass1 {
    public static void main(String args[] ) throws Exception {
        
        // Initialization
        Scanner s = new Scanner(System.in);
        int noOfObj = s.nextInt();
        int capactity = s.nextInt();
        
        int values[] = new int[noOfObj];
        for (int i=0 ; i<noOfObj; i++) {
			values[i] = s.nextInt();
		}

        int weights[] = new int[noOfObj];
        for (int i=0 ; i<noOfObj; i++) {
			weights[i] = s.nextInt();
		}
        
        int solSet[][] = new int[noOfObj][capactity+1];
        for(int i=0; i<noOfObj; i++)
        	for(int j=0 ; j<capactity+1 ; j++) {
        		solSet[i][j] = -1;
        	}
        
        // Write your code here
        System.out.println(performKnapsack(noOfObj-1, capactity, values, weights, solSet));
    }
    
    private static int performKnapsack(int index, int capacity, int[] values, int[] weights, int solSet[][]){
    	if(index < 0 || capacity == 0) {
    		return 0;
    	}
    	//
    	if(solSet[index][capacity] != -1) {
    		return solSet[index][capacity];
    	}
    	
    	if(weights[index] <= capacity) {
    		solSet[index][capacity] = getMax(performKnapsack(index-1, capacity, values, weights, solSet), 
    				values[index] + performKnapsack(index-1, capacity-weights[index], values, weights, solSet));
    		return solSet[index][capacity];
    	}
    	else {
    		solSet[index][capacity] = performKnapsack(index-1, capacity, values, weights, solSet);
    		return solSet[index][capacity];
    	}
    }
    
    private static int getMax(int param1, int param2) {
    	return param1 > param2 ? param1 : param2;
    }
}
