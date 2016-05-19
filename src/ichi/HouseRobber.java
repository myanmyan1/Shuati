/**
 * 
 */
package ichi;

/**
 * @author kje511
 *
 */
public class HouseRobber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[] = {1, 2, 5, 6, 7};
		
		System.out.println(rob(nums));

	}

	//	dp[i] = max(dp[i-2] + num[i], dp[i-1])
    public static int rob(int[] nums) {
    	int dp[] = new int[nums.length];
    	
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i=2; i<nums.length; i++) {
        	dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[nums.length-1];

    	
    }
}
