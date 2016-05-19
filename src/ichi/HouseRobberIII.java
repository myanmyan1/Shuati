/**
 * 
 */
package ichi;

/**
 * @author kje511
 *
 */
public class HouseRobberIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		int dp;
		TreeNode(int x) { val = x; }
	}

	public int rob(TreeNode root) {
		
		return dp(root);
	}
	

	
	public int dp(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int result;
		
		if (root.left == null && root.right == null) {
			result = root.val;
		}
		else if (root.left == null) {
			result = Math.max(root.val + dp(root.right.left) + dp(root.right.right), 
					dp(root.left) + dp(root.right));
		}
		else if (root.right == null) {
			result = Math.max(root.val + dp(root.left.left) + dp(root.left.right), 
					dp(root.left) + dp(root.right));
		}
		else {
			result = Math.max(root.val + dp(root.left.left) + dp(root.left.right) +
					dp(root.right.left) + dp(root.right.right), 
					dp(root.left) + dp(root.right));
		}
			
			
		return result;
		
	}
}
