/**
 * 
 */
package q101to150;

import java.util.Stack;

import common.TreeNode;

/**
 * @author kje511
 *
 */
public class Q101SymmetricTreeIterative {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(4);
        // root.right.left = new TreeNode(2);

        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> sLeft = new Stack<TreeNode>();
        Stack<TreeNode> sRight = new Stack<TreeNode>();

        TreeNode curLeft = root.left;
        TreeNode curRight = root.right;

        while (true) {
            if (curLeft == null && curRight == null) {
                if (sLeft.isEmpty()) {
                    return true;
                }

                curLeft = sLeft.pop();
                curRight = sRight.pop();
            } else if (curLeft == null || curRight == null) {
                return false;
            }

            if (curLeft.val != curRight.val) {
                return false;
            }

            if (curLeft.right != null && curRight.left != null) {
                sLeft.push(curLeft.right);
                sRight.push(curRight.left);

            } else if (curLeft.right != null || curRight.left != null) {
                return false;
            }
            
            curLeft = curLeft.left;
            curRight = curRight.right;
            
        }

    }
}
