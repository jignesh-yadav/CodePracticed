import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.interviewbit.com/problems/minimum-difference-subsets/
// For negative as well https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
public class Hw {
	public static void main(String args[]) {
		Integer[] arr = new Integer[] {1, 6, 11, 5};
		System.out.println(solve(new ArrayList<Integer>()));
	}
	
	public static int solve(ArrayList<Integer> A) {
		int[] nums = A.stream().mapToInt(i -> i).toArray();
		// nums = new int[] {1, 6, 11, 5};
		if(nums.length == 1)
			return nums[0];
		int totalSum = 0;
		for(int i=0; i<nums.length; i++)
			totalSum += nums[i];
        boolean arr[][] = new boolean[nums.length+1][totalSum+1];
        
    	// populate
        fillMatrix(nums, arr, nums.length, totalSum);
        
        //Extract result
        return Math.abs(getResult(arr, totalSum));
    }
	
	private static boolean fillMatrix(int[] nums, boolean[][] arr, int length, int totalSum) {
		// Initialization
		for(int i=0 ; i<totalSum+1; i++)
			arr[0][i] = false; 
		for(int i=0 ; i<nums.length +1; i++)
			arr[i][0] = true;
		
		// Calculate 
		for(int i=1 ; i<nums.length+1; i++){
			for(int j=1; j<totalSum+1; j++) {
				if(nums[i-1] <= j) {
					arr[i][j] = arr[i-1][j] || arr[i-1][j-nums[i-1]];
				}
				else {
					arr[i][j] = arr[i-1][j];
				}
			}
		}
		
		
		return arr[length][totalSum];
	}

	private static int getResult(boolean[][] arr, int totalSum) {
        /*for(int i=0; i < arr.length; i++) {
        	for(int j=0; j < arr[0].length; j++)
        		System.out.print(arr[i][j]);
        	System.out.println();
        }*/
        int foundPart1Val = -1; 
        for(int i=(arr[0].length/2); i>0; i--) {
        	if(arr[arr.length-1][i] == true) {
        		foundPart1Val = i;
        		break;
        	}
        }
        
		return (2 * foundPart1Val - totalSum);
	}

}
