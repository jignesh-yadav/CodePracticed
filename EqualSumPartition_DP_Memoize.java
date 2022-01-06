import java.util.*;
public class Hw {
	public static void main(String args[]) {
		System.out.println(canPartition(new int[] {1,5,11,5}));
	}
	
	 
	public static boolean canPartition(int[] nums) {
		int total = 0;
		for(int i=0; i<nums.length; i++)	
			total += nums[i];
		
		int partitionVal = total/2;
		if(total % 2 != 0 || partitionVal == 0)
			 return false;
		
		int dp[][] = new int[nums.length][partitionVal+1];
		for(int i=0; i<nums.length; i++)
			for(int j=0; j<partitionVal+1; j++)
				dp[i][j] = -1;
			
		return isSubsetEqual(nums, nums.length, partitionVal, dp);
    }


	private static boolean isSubsetEqual(int[] arr, int index, int partitionVal, int mem[][]) {
		if(partitionVal == 0)
			return true;
		else if(index == 0)
			return false;
		
		if(mem[index-1][partitionVal] != -1)
			return mem[index-1][partitionVal] == 1 ? true : false;
		
		if(arr[index-1] <= partitionVal)
		{
			Boolean temp = (isSubsetEqual(arr, index-1, partitionVal-arr[index-1], mem) ||
					isSubsetEqual(arr, index-1, partitionVal, mem));
			mem[index-1][partitionVal] = temp == true ? 1: 0;
			return temp;
		}
		else {
			Boolean temp = isSubsetEqual(arr, index-1, partitionVal, mem);
			mem[index-1][partitionVal] = temp == true ? 1: 0;
			return temp;
		}
	}

}
