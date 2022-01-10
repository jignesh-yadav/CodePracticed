
package Src;
/* IMPORTANT: Multiple classes and nested static classes are supported */

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class mainClass {
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
        
        // Write your code here
        //System.out.println(performKnapsack(capactity, values, weights));

        System.out.println(knapSack(capactity,weights, values, values.length));
    }
    
    private static int performKnapsack(int capacity, int[] values, int[] weights){
    	int dataArr[][] = new int[values.length+1][capacity+1];
    	
    	// Initialization
    	for(int i=0 ; i<values.length+1; i++){
    		for(int j=0 ; j<capacity+1; j++){
    			if(i == 0 || j == 0)	
    				dataArr[i][j] = 0;
    		}
    	}
    	
    	// main logic
    	for(int i=1 ; i<values.length+1; i++){
    		for(int j=1 ; j<capacity+1; j++){
    			if(weights[i-1] <= j) {
    				dataArr[i][j] = getMax(values[i-1] + dataArr[i-1][j-weights[i-1]], dataArr[i-1][j]);
    			}
    			else if(weights[i-1] > j) {
    				dataArr[i][j] = dataArr[i-1][j];
    			}
    		}
    	}
    	
    	return dataArr[values.length][capacity];
    }
    
    static int knapSack(int W, int wt[], int val[], int n)
    {
      // making and initializing dp array
      int []dp = new int[W + 1];
   
   
      for (int i = 1; i < n + 1; i++) {
        for (int w = W; w >= 0; w--) {
   
          if (wt[i - 1] <= w)
             
            // finding the maximum value
            dp[w] = Math.max(dp[w],
                             dp[w - wt[i - 1]] + val[i - 1]);
        }
      }
      return dp[W]; // returning the maximum value of knapsack
    }
    
    private static int getMax(int param1, int param2) {
    	return param1 > param2 ? param1 : param2;
    }
}
