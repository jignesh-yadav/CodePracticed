import java.util.*;
public class Hw {
	public static void main(String args[]) {
		System.out.println(solve(new ArrayList<>(Arrays.asList(3, 34, 4, 12, 5, 2)), 30));
	}
	
	// Recursive
	public static int solve(ArrayList<Integer> A, int B) {
        int[] arr = A.stream().mapToInt(i -> i).toArray();
        
        return getSubsetResult(arr, B, arr.length);
    }
	
	public static int getSubsetResult(int[] arr, int sum, int n) {
		int[][] outArr = new int[n+1][sum+1]; 
		
		// Initialization
		//for(int i=0; i<1; i++)
			for(int j=0; j<sum+1; j++) 
				outArr[0][j]=0;
		
		for(int i=0; i<n+1; i++)
			//for(int j=0; j<1; j++)
				outArr[i][0]=1;
			
		
		// logic
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(arr[i-1] > j) {
					outArr[i][j] = outArr[i-1][j];
				}
				else {
					outArr[i][j]  = (outArr[i-1][j-arr[i-1]] == 1 || outArr[i-1][j] == 1) ? 1 : 0;
				}
				
			}
		}
		
		/*
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<sum+1; j++) {
				System.out.print(outArr[i][j] + "  ");
			}
			System.out.println("");
		}
		*/
		return outArr[n][sum];
	}
}
